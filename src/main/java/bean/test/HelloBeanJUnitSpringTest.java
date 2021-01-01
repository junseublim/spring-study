package bean.test;

import bean.Hello;
import bean.Printer;
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
@ContextConfiguration(locations = "classpath:beans.xml")
public class HelloBeanJUnitSpringTest {
    @Autowired
    ApplicationContext context;
    @Test @Ignore
    public void test2() {
        //싱글톤임을 알 수 있.
        Hello hello = (Hello) context.getBean("hello");
        Hello hello2 = (Hello) context.getBean("hello");
        Assert.assertSame(hello, hello2);
    }


    @Test
    public void test1() {

        Hello hello = (Hello) context.getBean("hello3");
        Assert.assertEquals("Hello Spring", hello.sayHello());
        hello.print();
        Assert.assertEquals(3, hello.getNames().size());
        List<String> list = hello.getNames();
        for (String value: list) {
            System.out.println(value);
        }
        //StringPrinter 가져오기
        Printer printer = context.getBean("printer", Printer.class);
        Assert.assertEquals("Hello Spring", printer.toString());

        //싱글톤으로 관리한다.
        Hello hello2 = context.getBean("hello", Hello.class);
        System.out.println(hello == hello2);
    }
}
