package jdbc.test;

import jdbc.dao.UserDao;
import jdbc.service.UserService;
import jdbc.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class UserClient {
    @Autowired
    ApplicationContext context;

    @Autowired
    UserService service;


    @Test @Ignore
    public void configTest() {
        SqlSession session = context.getBean("sqlSession", SqlSession.class);
        System.out.println(session.getClass().getName());

        UserVO user = session.selectOne("userNS.selectUserByAccount", "TestUser3");
        System.out.println(user);
    }

    @Test
    public void daoTest() {
        UserDao dao = context.getBean("userDao", UserDao.class);
        UserVO userVO = dao.read("TestUser5");
        System.out.println(userVO);
    }

    @Test @Ignore
    public void dataSourceTest() {
        DataSource ds = (DataSource) context.getBean("dataSource");
        try {
            System.out.println(ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Test @Ignore
    public void getAllUserTest() {

        List<UserVO> user = service.getUserList();
        user.stream().forEach(userVO -> {System.out.println(userVO);});
    }
    @Test  @Ignore
    public void getUserTest() {

        UserVO user = service.getUser("TestUser3");
        System.out.println(user);
    }
}
