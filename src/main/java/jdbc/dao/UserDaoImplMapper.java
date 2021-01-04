package jdbc.dao;

import jdbc.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImplMapper implements UserDao {
    @Autowired
    private UserMap userMap;

    @Override
    public void insert(UserVO user) {

    }

    @Override
    public List<UserVO> readAll() {
        return null;
    }

    @Override
    public void update(UserVO user) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public UserVO read(String account) {
        UserVO user = userMap.selectUserByAccount(account);
        return user;
    }
}
