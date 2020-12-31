package bean.test;

import bean.Hello;
import bean.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class HelloBeanTest {
    public static void main(String[] args) {
        //IOC 컨테이너 생성
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");

        // Hello Bean 가져오기
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.sayHello());
        hello.print();

        //StringPrinter 가져오기
        Printer printer = context.getBean("printer", Printer.class);
        System.out.println(printer.toString());

        //싱글톤으로 관리한다.
        Hello hello2 = context.getBean("hello", Hello.class);
        System.out.println(hello == hello2);
    }
}
