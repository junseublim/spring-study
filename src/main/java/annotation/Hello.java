package annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component
public class Hello {
    @Value("${myname}")
    private String name;

//    @Autowired
//    @Qualifier("stringPrinter")
    //프로퍼티로 설정시 Autowired 사용불가
    @Resource(name="${printer1}")
    private Printer printer;

    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Hello() {}
    public Hello(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setPrinter(Printer printer) {
//        this.printer = printer;
//    }

    public String sayHello() {
        return "Hello " + name;
    }

    public void print() {
        this.printer.print(sayHello());
    }


}
