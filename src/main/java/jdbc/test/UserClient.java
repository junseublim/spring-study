package jdbc.test;

import jdbc.UserService;
import jdbc.UserVO;
import org.junit.Assert;
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

    @Test
    public void dataSourceTest() {
        DataSource ds = (DataSource) context.getBean("dataSource");
        try {
            System.out.println(ds.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void getUserTest() {

        List<UserVO> user = service.getUserList();
        user.stream().forEach(userVO -> {System.out.println(userVO);});
    }
}
