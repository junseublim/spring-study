package jdbc.dao;

import jdbc.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    class UserMapper implements RowMapper<UserVO> {
        public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserVO user = new UserVO();
            user.setAccount(rs.getString("account"));
            user.setEmail(rs.getString("email"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setStatus(rs.getString("status"));
            return user;
        }
    }

    @Override
    public UserVO read(String account) {
        String SQL = "select * from user where account = ?";
        try {
            UserVO user = jdbcTemplate.queryForObject(SQL,
                    new Object[] { account }, new UserMapper());
            return user;
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
    public void insert(UserVO user) {
        String SQL = "insert into user (account, email, phone_number, status) values (?, ?, ?, ?)";
        jdbcTemplate.update(SQL, user.getAccount(), user.getEmail(), user.getPhoneNumber(), user.getStatus());

        System.out.println("��ϵ� Record account=" + user.getAccount());
    }

    public List<UserVO> readAll() {
        String SQL = "select * from user";
        List<UserVO>  userList = jdbcTemplate.query(SQL, new UserMapper());
        return userList;
    }

    //@Override
    public void delete(String account) {
        String SQL = "delete from user where account = ?";
        jdbcTemplate.update(SQL, account);
        System.out.println("������ Record with account = " + account );
    }

    //@Override
    public void update(UserVO user) {
        String SQL = "update user  set name = ?, gender = ?, city = ? where userid = ?";
        jdbcTemplate.update(SQL, user.getAccount(), user.getEmail(), user.getPhoneNumber(), user.getStatus());
        System.out.println("���ŵ� Record with account = " + user.getAccount() );
    }
}
