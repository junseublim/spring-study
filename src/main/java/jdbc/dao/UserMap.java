package jdbc.dao;

import jdbc.vo.UserVO;

@MyMapper
public interface UserMap {
    UserVO selectUserByAccount(String account);
}
