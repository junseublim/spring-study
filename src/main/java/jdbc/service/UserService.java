package jdbc.service;

import jdbc.vo.UserVO;

import java.util.List;

public interface UserService {
    public void insertUser(UserVO user);

    public List<UserVO> getUserList();

    public void deleteUser(String account);

    public UserVO getUser(String account);

    public void updateUser(UserVO user);
}
