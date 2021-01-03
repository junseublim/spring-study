package jdbc.dao;

import jdbc.vo.UserVO;

import java.util.List;

public interface UserDao {
    public void insert(UserVO user);

    public List<UserVO> readAll();

    public void update(UserVO user);

    public void delete(String id);

    public UserVO read(String id);
}
