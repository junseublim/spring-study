package bean.test;

import bean.Hello;
import bean.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.junit.*;

public class HelloBeanJUnitTest {
    private ApplicationContext context;

    @Before
    public void init() {
        context = new GenericXmlApplicationContext("beans.xml");
    }

    @Test
    public void test2() {
        //싱글톤임을 알 수 있.
        Hello hello = (Hello) context.getBean("hello");
        Hello hello2 = (Hello) context.getBean("hello");
        Assert.assertSame(hello, hello2);
    }


    @Test
    public void test1() {

        Hello hello = (Hello) context.getBean("hello");
        Assert.assertEquals("Hello Spring", hello.sayHello());
        hello.print();

        //StringPrinter 가져오기
        Printer printer = context.getBean("printer", Printer.class);
        Assert.assertEquals("Hello Spring", printer.toString());

        //싱글톤으로 관리한다.
        Hello hello2 = context.getBean("hello", Hello.class);
        System.out.println(hello == hello2);
    }
}
