# 스프링 Study

T Academy Spring Framework 강의 기반 스프링 프레임워크 학습

## About Spring

Spring Framework : Java 엔터프라이즈 개발을 편하게 해주는 오픈소스 경량급 애플리케이션 프레임워크.<br>
Spring Framework 전략: Portable Service Abstraction, DI, AOP, POJO

- Portable Service Abstraction: 서비스 추상화. 트랜잭션, OXM, 데이터 액세스의 Exception 변환기능 등 기술적인 복잡함을 추상화를 통해 구현 부분과 인터페이스로 분리한다.
- DI: 의존성 주입. 유연한게 확장 가능한 객체를 만들어 두고 관계는 외부에서 다이내믹하게 설정해주는 것.
- AOP: 관점 지향 프로그래밍. 애플리케이션 로직을 담당하는 코드에 남아있는 기술 관련 코드를 분리해서 별도의 모듈로 관리하게 해주는 기술
- POJO: 객체지향 원리에 충실하면서, 특정 환경이나 규약에 종속되지 않고 필요에 따라 재활용될 수 있는 방식으로 설계된 객체이다.

## Maven과 Library 관리

Maven 이란 라이브러리 관리, 빌드를 해주는 툴이다. Maven을 사용하는 이유는

1. 편리한 Dependency management
2. 여러 프로젝트에서 프로젝트 정보나 jar 파일들을 공유하기 쉽다.
3. 모든 프로젝트의 빌드 프로세스를 일관되게 가져갈 수 있다.

### pom.xml

Maven 프로젝트 생성시 생성된다. Project Object Model 정보를 담고 있다. 이곳에 의존과계를 추가할 수 있다.


## IoC 컨테이너와 DI
- Ioc: 객체의 생성, 생명주기의 관리까지 모든 객체에 대한 제어권이 프레임워크에게 있는것을 말한다.
이는 컴포넌트 의존관계 결정, 설정 및 생명주기를 해결하기 위한 디자인 패턴인다.
- Ioc 컨테이너: 객체의 생성을 책임지고 의존성을 관리한다.
- DI: 각 클래스간의 의존관계를 빈 설정 정보를 바탕으로 컨테이너가 자동으로 연결해주는 것. Setter, Constructor, 
  Method Injection이 존재한다.
    - 빈 설정파일에서 의존관계를 정의하면 된다.
    - 실행 시 동적으로 의존관계 생성된다.
- Bean: Spring DI 컨테이너가 관리하는 객체.
- Bean Factory: 이 빈들을 관리하는 컨테이너. Bean을 등록, 생성, 조회, 반환 관리한다.

## JUnit
JUnit이란 단위 테스트 프레임워크이다. 단위테스트는 소스 코드의 특정 모듈이 의도된 대로 정확히 작동하는지 검증하는
절차, 즉 모든 함수와 메소드에 대한 테스트 케이스(Test case)를
작성하는 절차를 말한다.

### JUnit 특징
1. 단정(assert) 메서드로 테스트 케이스의 수행 결과를 판별한다.
2. 어노테이션을 제공한다. 
3. 각 @Test 메서드가 호출할 때 마다 새로운 인스턴스를 생성하여
   독립적인 테스트가 이루어지도록 한다.
   
#### Annotations
1. @Test: 테스트를 수행하는 메소드가 된다.
2. @Ignore:  테스트를 실행하지 않게 한다
3. @Before: @Test 메소드가 실행되기 전에 반드시 실행되어 진다.
4. @After: @Test 메소드가 실행된 후 실행된다.
5. @BeforeClass: @Test 메소드 보다 먼저 한번만 수행된다.
6. @AfterClass: @Test 메소드 후에 한번만 수행된다.

### Assertions
1. assertEquals(a,b): 객체 a, b가 일치함을 확인.
2. assertArrayEquals(a,b): 배열 a, b가 일치함을 확인.
3. assertSame(a,b): 객체 a, b가 같은 객체임을 확인.
4. assertTrue(a): 조건 a가 참임을 확인.
5. assertNotNull(a): 객체 a가 null이 아님을 확인.

## Spring-Test
JUnit을 확장한 프레임워크. <br>

### Annotations
1. @RunWith: 테스트 실행방법을 확장할 때 사용한다.<br>
   @RunWith(SpringJUnit4ClassRunner.class)을 해주면 JUnit이 테스트를 진행하는 중에 ApplicationContext를
   만들고 관리하는 작업을 진행해준다.<br>
   @RunWith는 각각의 테스트 별로 객체가 생성되더라도 싱글톤의 ApplicationContext를 보장한다.
2. @ContextConfiguration: 스프링 빈 설정 파일의 위치를 지정할 때 사용되는 어노테이션.
3. @Autowired: 스프링DI에서 사용되는 특별한 어노테이션. 해당 변수에 자동로 빈 매핑 해준다.

## Bean 의존관계
Bean 의존관계 설정 방법
1. Setter Injection: \<property> 태그 사용.
    - ref 속성 사용하면 Bean 이름을 이용해 주입할 Bean 찾는다.
    - value 속성은 단순 값 또는 Bean이 아닌 객체 주입시 사용.
    
2. Constructor Injection: <constructor-arg> 태그 사용.
    - 한번에 여러개의 객체를 주입할 수 있다.
    - 똑같이 ref, value 사용
    - index, name 으로 파라미터 지정
        - name: 매개변수 명으로 지정
    
컬렉션 타입의 값 주입:
1. List: \<list> , \<value>
2. Set: \<set> , \<value>
3. Map: \<map>, \<entry>

```
<bean id="hello" class="beans.Hello">
    <property name="names">
        <list>
            <value>Spring</value>
            <value>IoC</value>
            <value>DI</value>
        </list>
    <property>
</bean>
```
### 프로퍼티 파일을 이용한 설정 방법
XML의 Bean 설정 메타정보는 애플리케이션 구조가 바뀌지 않으면 자주 변경되지 않는다. 반면에 프로퍼티 값으로 제공되는
일부 설정정보(DB 연결정보 등)는 환경에 따라 자주 바뀔 수 있다. 따라서 자주 변경될 수 있는 내용은 properties 파일로 분리하는 것이 가장 깔끔하다.
<br><br>
프로퍼티 파일로 분리한 정보는 ${}을 이용하여 설정한다.

##  Bean 등록 메타정보 구성 전략
1. XML 단독 사용: 모든 Bean을 명시적으로 XML에 등록하는 방법.
    - Bean이 많아지면 XML 관리 어려움.
    - 운영환경에서 사용하기 좋음.
2. XML, Bean Scanning의 혼용: Annotation을 사용.
    - Bean Scanning: 특정 어노테이션이 붙은 클래스를 자동으로 찾아서 Bean으로 등록해주는 방식
    - Bean들 간의 의존관계 한눈에 파악할 수 없다.
    - 개발환경에서 적합함.
    
### Bean Annotations

#### Bean 등록 어노테이션
1. Component: 컴포넌트를 나타냄. \<Bean> 태그와 동일
2. Repository: 영속성을 가지는 속성(파일, 데이터베이스)을 가진 클래스
3. Service: 서비스 레이어. 비즈니스 로직을 가진 클래스
4. Controller: 웹 어플리케이션에서 웹 요청과 응답을 처리하는 클래스


#### Bean 의존관계 주입 어노테이션
1. @Autowired: 정밀한 의존관계 주입이 필요한 경우
    - 프로퍼티, setter, 생성자, 일반 메서드에 적용 가능.
    - 의존하는 객체를 주입할때 주로 Type을 이용.
    - \<property> , \<constructor-arg> 태그와 동일
2. @Resource: 어플리케이션에서 필요로 하는 자원을 자동 연결할 때 사용된다.
    - 프로퍼티, setter에 적용 가능.
    - 의존하는 객체 주입할 때 주로 Name을 이용.
3. @Value : 단순한 값을 주입할때
4. @Qualifier: @Autowired 어노테이션과 함께 사용.
    - 동일한 타입이 여러개 존재할때 특정 Bean 찾기 위해 사용.
    
##### Component scan
@Component를 통해 자동으로 Bean 등록하고, @Autowired로 주입받는 어노테이션을 클래스에서 선언하여
사용했을 경우 해당 클래스가 위치한 특정 패키지를 Scan하기 위한 설정해주어야 한다.

- \<context:component-scan> 태그로 패키지 위치 설정.
- \<context:include-filter> , \<context:exclude-filter> 태그를 같이 사용 시 자동 스캔 대상에
포함시킬 클래스와 않을 클래스 구체적 명시 가능.