package jdbc.dao;

import jdbc.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
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
public class UserDaoImplSession implements UserDao{

    @Autowired
    private SqlSession session;

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
    public void insert(UserVO user) {
        return;
    }

    @Override
    public List<UserVO> readAll() {
        return null;
    }

    @Override
    public void update(UserVO user) {
        return;
    }

    @Override
    public void delete(String id) {
        return;
    }

    @Override
    public UserVO read(String account) {
        UserVO userVO = session.selectOne("userNS.selectUserByAccount", account);
        return userVO;
    }

}
