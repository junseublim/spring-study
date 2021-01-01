package annotation.test;

import annotation.Hello;
import annotation.Printer;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:annot.xml")
public class HelloBeanJUnitSpringTest {
    @Autowired
    ApplicationContext context;
    @Test
    public void test2() {
        //싱글톤임을 알 수 있.
        Hello hello = (Hello) context.getBean("hello");
        Hello hello2 = (Hello) context.getBean("hello");
        Assert.assertSame(hello, hello2);
    }



}
