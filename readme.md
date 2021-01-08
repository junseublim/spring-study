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
  
## JDBC

### DAO 패턴
데이터 액세스 계층은 DAO 패턴을 적용하여 비즈니스 로직과 데이터 액세스 로직을 분리하는 것이 원칙이다.
이렇게 함으로써 서비스계층에 영향을 주지 않고 데이터 액세스 기술을 변경할 수 있는 장점을 가지고 있다. 

### Connection Pooling
미리 정해진 개수만큼의 DB Connection을 Pool에 준비 해두고 요청할 떄마다 꺼내서 하나씩 할당해주고 다시 돌려받아서 Pooldp
넣는 식의 기법이다. 다중 사용자를 갖는 엔터프라이즈 시스템에서는 반드시 Connection pooling을 지원하는 DataSource를 사용해야 한다.

### DataSource 구현 클래스 종류

1. SimpleDriverDataSource : Spring이 제공하는 가장 단순한 DataSource 구현 클래스. 따로 pool을 관리하지 않으므로
단순한 테스트용으로만 사용.
2. SingleConnectionDriverDataSource: 순차적으로 진행되는 통합테스트에서는 사용 가능. 매번 DB 커넥션을 생성하지 않기 때문에
SimpleDriverDataSource보다는 빠르게 동작.
3. Apache Commons DBCP: 가장 유명한 오픈소스 DB 커넥션 Pool 라이브러리.
4. c3p0 JDBC/DataSource Resource Pool: Connection과 Statement Pool을 제공하는 라이브러리.

### JDBC란?
모든 자바의 데이터 액세스 기술의 근간이 된다. ORM 기술도 내부적으로는 DB와의 연동을 위해 이용한다.
안정적이고 유욘하지만 로우 레벨 기술로 인식된다.

### Spring JDBC란?
JDBC의 장점과 단순성을 유지하면서도 기존 JDBC의 단점을 극복할 수 있게 해주고, 간결한 형태의 API 사용법을
제공하며, JDBC API에서 지원되지 않는 편리한 기능을 제공한다.
- 반복적으로 해야하는 많은 작업들을 대신 해준다.
- 실행할 SQL과 바인딩 할 파라미터만 넘겨주고 실행결과를 받을 객체만 지정하면 된다.
- 먼저 DB 커넥션을 가져오는 DataSource를 Bean으로 등록해야 한다. 

### Spring JDBC가 대신 해주는 작업
1. Connection 열기와 닫기
2. Statement 준비와 닫기
3. Statement 실행
4. ResultSet Loop 처리
5. Exception 처리와 반환
6. Transaction(커밋, 롤백) 처리

### JdbcTemplate 클래스
Spring JDBC가 제공하는 클래스 중 모든 기능을 최대한 활용할 수 있는 유연성을 제공하는 클래스이다. 
JdbcTemplate이 제공하는 기능은 실행, 조회, 배치의 세가지 작업이다.
- 실행: DB에 변경이 일어나는 작업
- 조회: 데이터를 조회하는 작업
- 배치: 여러 개의 쿼리를 한 번에 수행해야 하는 작업

#### JdbcTemplate 클래스 생성
JdbcTemplate은 DataSource를 파라미터로 받아서 아래와 같이 생성할 수 있다.
```java
JdbcTemplate template = new JdbcTemplate(dataSource);
```
- DataSource는 보통 빈으로 등록해서 사용하므로 DI 받아서 사용하면 된다.
- JdbcTemplate은 멀티스레트 환경에서도 안전하게 공유해서 쓸 수 있기 때문에 DAO클래스의 인스턴스 변수에 저장해 두고 사용할 수 있다.

#### JdbcTemplate의 update() 메서드
```java
int update(String sql, [SQL 파라미터])
```
- INSERT, UPDATE, DELETE와 같은 SQL을 실행할 때는 JdbcTemplate의 update() 사용
- update() 메서드 호출할 때는 SQL과 함께 바인딩 할 파라미터는 Object타입 가변인자를 사용할 수 있다.
- 리턴값은 영향받은 레코드의 개수.

#### JdbcTemplate 클래스의 queryForObject() 메서드
Select SQL을 실행하여 하나의 Row를 가져올 때는 JdbcTemplate의 queryForObject() 메서드를 사용.
```java
<T> T queryForObject(String sql, [SQL 파라미터], RowMapper<T> rm)
```
- SQL 실행 결과는 여러개의 칼럼을 가진 하나의 Row
- T는 VO(value object) 객체의 타입에 해당된다.
- SQL 실행 결과로 돌아온 여러 개의 column을 가진 한 개의 Row를 RowMapper 콜백을 이용해 VO 객체로 매핑해준다.
- query와 다른점: 
   1. queryForObject: 여러개의 칼럼, 한개의 Row를 반환
   2. query: 여러개의 칼럼, 여러개의 Row

#### JdbcTemplate 클래스의 query() 메서드
Select SQL을 실행하여 여러개 Row를 가져올 때는 JdbcTemplate의 query() 메서드를 사용.
```java
<T> List<T> queryForObject(String sql, [SQL 파라미터], RowMapper<T> rm)
```
- SQL 실행 결과는 여러개의 칼럼을 가진 여러개의 Row
- T는 VO(value object) 객체의 타입에 해당된다.
- SQL 실행 결과로 돌아온 여러 개의 column을 가진 여 개의 Row를 RowMapper 콜백을 이용해 VO 객체로 매핑해준다.

## AOP

### 핵심기능과 부가기능
1. 핵심기능: 업무 로직을 포함하는 기능
2. 부가기능: 핵심기능을 도와주는 부가적인 기능(로깅, 보안)

### AOP의 개요
AOP는 애플리케이션에서의 관심사의 분리 이다. 분리한 부가 기능은 애스팩트라는 독특한 모듈형태로 만들어서
설계하고 개발하는 방법이다.
- OOP를 적용하야도 핵심기능에서 부가기능을 쉽게 분리된 모듈로 작성하기 어려운 문제점을 해결
- 핵심기능에서 부가기능을 분리함으로써 객체지향적인 가치를 지킬 수 있도록 도와줌.

### Aspect
Aspect는 부가기능을 정의한 코드인 **어드바이스** 와 어드바이스를 어디에 적용할지를 결정하는
**포인트컷**을 합친 개념이다.

### AOP 용어
- Target: 핵심기능을 담고 있는 모듈. 부가기능을 부여할 대상이 된다.
- Advice: 타겟에 제공할 부가기능을 담고 있는 모듈
- Join Point: 어드바이스가 적용될 수 있는 위치. 타겟 객체가 구현한 인터페이스의 모든 메서드는
조인 포인트가 된다.
- PointCut: Advice를 적용할 타겟의 메서드를 선별하는 정규표현식. execution으로 시작하고, 메서듸 Signature를 비교하는 방법을 주로 이용한다.
- Aspect: AOP의 기본 모듈. 싱글톤 형태의 객체로 존재한다.
- Adviser: Spring AOP에서만 사용되는 특별한 용어로, 애스팩트와 동일하다.
- Weaving: 포인트컷에 의해서 결정된 타겟의 조인 포인트에 부가기능을 삽입하는 과정을 의미.

### Spring AOP 특징
1. 스프링은 프록시 기반 AOP를 지원한다.
   - 타겟 객체에 대한 프록시를 만들어 제공한다.
   - 타겟을 감싸는 프록시는 실행시간에 생성된다.
   - 프록시는 어드바이스를 타겟 객체에 적용하면서 생성되는 객체이다.
2. 프록시는 호출을 가로챈다.(Intercept)
   - 프록시는 타겟 객체에 대한 호출을 가로챈 다음 어드바이스의 부가기능 로직을 수행하고 난 후에 타겟의 핵심기능 로직을 호출한다.(전처리 어드바이스)
   - 또는 타겟의 핵심기능 로직 메서드를 호출한 후에 부가기능을 수행하는 경우도 있다.(후처리 어드바이)
3. 스프링은 메서드 조인 포인트만 지원한다.
   - 스프링은 동적 프록시를 기반으로 AOP를 구현하므로 메서드 조인 포인트만 지원한다. 즉 핵심기능의 메서드가 호출되는 런타임 시점에만 부가기능을 적용할 수 있다.
   - 반면에 AspectJ 같은 고급 AOP 프레임워크를 사용하면 객체의 생성, 필드값의 조회와 조작, static 메서드 호출 및 초기화 등의 
   다양한 작업에 부가기능을 적용할 수 있다.
     
### Spring AOP 구현 방식
1. XML 기반의 POJO 클래스를 이용한 AOP 구현
   - 부가기능을 제공하는 Advice 클래스를 작성한다.
   - XML 설정 파일에 \<aop:config>를 이용해서 애스팩트를 설정한다.
2. @Aspect 어노테이션을 이용한 AOP 구현
   - @Aspect 어노테이션으로 부가기능을 제공하는 Aspect 클래스 작성.
   - XML 설정 파일에 \<aop:aspectj-autoproxy/>를 설정한다.
   
### Advice의 종류

1. Around Advice : 타겟의 메서드가 호출되기 이전 시점과 이후 시점에 모두 처리해야 할 필요가 있는 부가기능을 정의
2. Before Advice : 타겟의 메서드가 실행되기 이전 시점에 처리해야 할 필요가 있는 부가기능을 정의
3. After Returning Advice : 타겟의 메서드가 정상적으로 실행된 이후 시점에 처리해야 할 필요가 있는 부가기능을 정의
4. After Throwing Advice : 타겟의 메서드가 예외를 발생된 이후 시점에 처리해야 할 필요가 있는 부가기능을 정의

###  JoinPoint 인터페이스
- JoinPoint는 AOP가 적용되는 지점을 뜻한다.
- 해당 지점을 AspectJ에서 JoinPoint라는 인터페이스로 나타낸다.
- JoinPoint methods
   1. getArgs(): 메서드 argument 반환
   2. getThis(): proxy object 반환
   3. getTarget(): 대상 객체 반환
   4. getSignature(): 메서드의 설명 반환
   5. toString(): 메서드의 설명 출력
- 모든 어드바이스는 org.aspectj.lang.JoinPoint 타입의 파라미터를 어드바이스 메서드에 첫 번째 매개변수로 선언할 수 있다.
- Around 어드바이스는 JoinPoint의 하위 클래스인 ProceedingJoinPoint 타입의 파라미터를 필수적으로 선언해야 한다.

### AOP 설정
- \<aop:aspect> : 태그의 ref 속성은 애즈팩트로서 기능을 제공할 Bean을 설정
- \<aop:around> : 태그의 pointcut 속성의 execution 지시자는 어드바이스를 적용할 패키지, 클래스, 메서드를 표현할 때 사용됨.

### PointCut 표현식 문법
```java
execution([젭근제한자 패턴] 타입패턴 [타입패턴.] 이름패턴 (타입패턴 | "..", ...) [throws 예외패턴])
```
예시
```java
execution (* hello(..)); // 모든 종류의 파라미터를 가진 hello 메서드
execution (* hello()); // hello 메서드중 파라미터 없는 것
execution (* myspring.user.service.UserServiceImpl*(..)); // myspring.user.service.UserServiceImpl 클래스를 직접 지정하여 이 클래스가 가진 모든 메서드
execution (* myspring.user.service.*.*(..)); // 패키지의 모든 클래스. 서브패키지의 클래스는 포함되지 않는다.
execution (* myspring.user.service..*.*(..)); // 패키지의 모든 클래스. 서브패키지의 클래스도 포함된다.
execution(* *..Target.*(..)) //패키지에 상관없이 Target이라는 이름의 모든 클래스에 적용된다.
```

## MyBatis

### MyBatis 개요
자바 오브젝트와 SQL문 사이의 자동 Mapping 기능을 지원하는 ORM 프레임워크이다.
SQL을 별도의 파일로 분리해서 관리하게 해주며, 객체와 SQL 사이의 Mapping 작업을 자동으로 해준다.

### MyBatis 특징
1. 쉬운 접근성과 코드의 간결함
    - JDBC의 모든 기능 제공
    - 복잡한 JDBC의 코드를 깔끔하게 유지 가능
2. SQL문과 프로그래밍 코드의 분리
    - SQL에 변경이 있을 때마다 자바 코드를 수정하거나 컴파일 하지 않아도 된다.
    - SQL 작성과 관리 또는 검토를 DBA와 같은 개발자가 아닌 다른사람에게 맡길 수 있다.
3. 다양한 프로그래밍 언어로 구현 가능

### MyBatis의 주요 컴포넌트

1. MyBatis 설정 파일 (SqlMapConfig.xml) : 데이터 베이스의 접속 주소 정보나 Mapping 파일 경로 등의 환경정보 설정
2. SqlSessionFactoryBuilder : MyBatis 설정 파일을 바탕으로 SqlSessionFactory을 생성
3. SqlSessionFactory : SqlSession을 생성
4. SqlSession : 핵심적인 역할을 하는 클래스로서 SQL 실행이나 트랜잭션 관리를 실행한다. SqlSession 오브젝트는 Thread-Safe 하지
않으므로 필요에 따라 생성한다.
5. Mapping 파일(user.xml) : SQL문과 OR Mapping을 설정한다.

### MyBatis-Spring의 주요 컴포넌트
1. MyBatis 설정파일 (sqlMapConfig.xml) : VO 객체의 정보를 설정한다.
2. SqlSessionFactoryBean : MyBatis 설정파일을 바탕으로 SqlSessionFactory 생성
3. SqlSessionTemplate : 핵심적인 역할을 하는 클래스로서 SQL 실행이나 트랜잭션 관리를 실행한다. Thread-safe 하다.

## Mapper Interface
Mapper interface는 Mapping 파일에 기재된 SQL을 호출하기 위한 인터페이스

### MapperScannerConfigurer
Mapper 인터페이스의 객체를 한번에 등록되게 해주는 것
- property value로 패키지 명을 주면 되는데, 이 해당 패키지 하위 모든 인터페이스들을 Mapper 객체로 생성
- 예상하지 않은 다른 객체가 등록되어 오류가 발생할 수 있
    - 이를 해결하기 위해 Marker 인터페이스와 Marker 어노테이션을 사용해야 한다.
    - 검색의 대상이 되는 패키지 아래의 인터페이스들 중에서 Mapper로서 작성한 인터페이스로만 범위를 좁히려면 Marker 인터페이스와 
      Marker 어노테이션을 작성하여 MapperScannerConfigurer에 설정하면 된다.
      

## MVC 패턴

### MVC 패턴의 개념
소프트웨어 공학에서 사용되는 아키텍쳐 패턴으로 MVC패턴의 주 목적은 Business Logic과 Presentation Logic을 분리하기 위함이다.
MVC 패턴을 사용하면, 사용자 인터페이스로부터 비즈니스 로직을 분리하여 애플리케이셔느이 시각적 요소나 그 이면에 실행되는 비즈니스 
로직을 서로 영향 없이 쉽게 고칠 수 있는 애플리케이션을 만들 수 있다.

- Model : 애플리케이션의 정보 (데이터, 비즈니스 로직 포함)
    - 데이터 저장소와 연동하여 데이터를 다룸
    - 여러개의 데이터 변경 작업을 하나의 작업으로 묶는 트랜잭션을 다루는 일도 한다
    - DAO, Service 클래스
- View : 사용자에게 제공할 화면(Presentation Logic)
    - 모델이 처리한 데이터나 작업 결과를 사용자에게 출력 화면을 만드는 일을 함
    - 생성된 화면은 웹 브라우저가 출력
    - Html, JSP
- Controller : Model과 View 사이의 상호 작용을 관리
    - 클라이언트의 요청 처리하고 모델 호출
    - 모델에게 보낼 데이터 적절히 가공
    - 모델과 뷰를 연결
    - Servlet, JSP

1. 클라이언트가 Controller에게 요청
2. Controller가 모델을 호출
3. Model이 결과를 Controller에게 반환
4. Controller가 View에게 화면 생성을 요청
5. View가 Model이 처리한 결과 화면을 Controller에게 반환
6. Controller가 클라이언트에게 결과 화면으로 응답.
    
### Model2 Architecture
- Model 1 : Controller 역할을 JSP가 담당함
  - JSP가 복잡해진다는 단점이 있다
- Model 2 : Controller 역할을 Servlet이 담당함

### Front Controller Architecture
- Front Controller는 클라이언트가 보낸 요청을 받아서 공통적인 작업을 먼저 수행
- 적절한 세부 Controlller에게 작업을 위임
- 각각의 애플리케이션 Controller는 클라이언트에게 보낼 뷰를 선택해서 최종 결과를 생성한다
- Front Controller 패턴은 인증이나 권한 체크처럼 모든 요청에 대하여 공통적으로 처리해야 하는 로직이 있을 경우 전체적으로 클라이언트의 
요청을 중앙 집중적으로 관리하고자 할 경우에 사용한다
  
### Spring MVC
1. DispatcherServlet : Front Controller 패턴 적용
    - web.xml에 설정
    - 클라이언트로부터의 모든 요청을 전달 받음
2. HandlerMapping : URL과 요청 정보를 기준으로 어떤 핸들러 객체를 사용할 지 결정
3. Controller: 클라이언트의 요청을 처리한뒤, 모델을 호출하고 그 결과를 DispatherServlet에게 알려준다.
4. ModelAndView : Controller가 처리한 데이터 및 화면에 대한 정보를 보유한 객체
5. View : Controller의 처리 결과 화면에 대한 정보를 보유한 객체
6. ViewResolver : Controller가 리턴한 뷰 이름을 기반으로 Controller 처리 결과를 생성할 뷰를 결정 

## RESTFUL API

HTTP URI 를 통해 제어할 자원을 명시하고, HTTP Method를 통해 해당 자원을 제어하는 명령을 내리는 방식의 아키텍쳐
Get, Post, Put, Delete 만을 사용하며, query string을 사용하지 않는다.

### Jackson

JSON 형태를 Java 객체로, Java 객체를 JSON 형태로 변환해주는 라이브러리이다.

### Ajax

웹 사용자들에게 수준 높은 인터페이스를 제공할 수 있도록 도움을 주는 기술의 묶음이다. 
비동기적이므로 서버로부터 데이터가 로드되는 동안에도 계속해서 페이지를 사용할 수 있다는 뜻이다.

### JQuery

Javascript를 좀 더 쉽게 사용하도록 만들어진 라이브러리이며, 가볍고 빠르다.
적은 코딩량과 동일한 코드로 일반 javascript로 하는 Ajax 코딩보다 쉽게 같은 동작을 할 수 있다.

#### 특징

1. 크로스 브라우저 지원
2. 강력한 css 셀렉터
3. 메서드 체이닝
4. Ajax 지원
5. 풍부한 PlugIn 지원

#### JQuery 기능

1. HTML Element 선택
2. HTML Element의 attribute 값 읽기, 쓰기
3. HTML 엘리먼트 동적으로 조작
4. Loop
5. CSS 조작
6. Event 처리
7. Ajax 처리

