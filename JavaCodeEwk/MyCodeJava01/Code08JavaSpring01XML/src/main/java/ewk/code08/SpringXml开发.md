### 一.spring开发步骤
1.导入坐标(5.2.10.RELEASE稳定版本)
```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.2.10.RELEASE</version>
</dependency>
```

2.创建xml文件(applicationContext.xml)

生成spring-config.xml文件
- 右键点击“项目名称”=>“Add Framework support”
- 选择“spring”,在spring中勾选“create empty spring.config.xml”

配置bean: id表示名字,class表示bean定义的类型
```
<bean id="bookDao" class="ewk.code08.book.BookDaoClass"/>
<bean id="bookService" class="ewk.code08.book.BookServiceClass"/>
```

3.初始化Ioc容器
```
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
```

4.从Ioc容器中获取bean
```
BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");
BookService bookService = (BookService) applicationContext.getBean("bookService");
```

5.删除业务层中所有new方式创建的dao对象
```
private Bookdao bookDao;
```

6.提供对应的set方法
```
public void setBookDao(BookDao bookDao){
    this.bookDao = bookDao;
}
```

7.配置server和dao的关系
- property表示配置当前bean的属性
- name属性表示配置哪一个具体属性
- ref属性表示参照哪一个具体的属性
```
<bean id="bookDao" class="ewk.code08.book.BookDaoClass"/>
<bean id="bookService" class="ewk.code08.book.BookServiceClass" scope="singleton">
    // name: 将变为setBookBao找到对应的set方法, ref: 当前容器中bean的名称
    <property name="bookDao" ref="bookDao"/>
</bean>
```


### 二.bean配置文件配置
1.bean基本配置
- id
- class

2.bean别名配置
- name: 多个别名用逗号(,)分号(;)空格( )分割
- ref也可以引用name

3.bean作用范围
- scope="singleton": 默认,单例
- scope="prototype": 修改为非单例

4.bean的使用场景
- 适合交给容器进行管理的bean: 表现层对象,业务层对象,数据层对象,工具对象
- 不适合交给容器进行管理的bean: 封装实体的域对象


### 三.bean的示例化
1.使用构造方法实例化bean
```
<!-- 方法1: 构造方法
<bean id="bookDao" class="ewk.code08.book.BookDaoClass" scope="prototype"/>
-->
```

2.使用静态工厂方法实例化bean
```
<!-- 方法2: 静态工厂实例化bean
<bean id="bookDao" class="ewk.code08.book.BookDaoFactory" factory-method="getBookDao" scope="prototype"/>
-->
```

3.使用实例工厂方法实例化bean
```
<!-- 方法3: 实例工厂实例化bean(不常用,省略test)
<bean id="aFactory" class="com.factory.aDaoFactory"/>
<bean id="aDao" factory-method="getDao" factory-bean="aFactory"/>
-->
```

4.使用FactoryBean实例化bean
```
<!-- 方法4: 使用FactoryBean实例化bean
<bean id="bookDao" class="ewk.code08.book.BookDaoFactoryBean"/>
-->
```


### 四.bean生命周期
1.类的init,destroy方法(需要绑定)
```
public void init(){
    System.out.println("init");
}
public void destroy(){
    System.out.println("destroy");
}
```
或者实现接口(不需要绑定)
- InitializingBean
- DisposableBean

2.绑定init,destroy方法
- init-method="init"
- destroy-method="destroy"

3.bean的销毁
```
context.close();
// 设置关闭钩子,标记保证在虚拟机退出之前关闭容器
context.registerShutdownHook();  
```

4.bean的生命周期与执行顺序
- 初始化容器(依次为)
    - 创建对象/内存分配
    - 执行构造方法
    - 执行属性注入set方法
    - 执行bean初始化方法
- 使用bean执行业务操作
- 关闭销毁容器,执行bean的销毁方法

5.bean销毁时机

容器关闭前触发bean的销毁


### 五.依赖注入的方式
1.依赖注入的方式
- setter注入(简单类型,引用类型)
- 构造器注入(简单类型,引用类型)

其中
- 引用类型注入: ref
- 简单类型注入: value

2.setter注入步骤
```
private int connectNum;
private String databaseNum;
public void setConnectNum(int connectNum) {
    this.connectNum = connectNum;
}
public void setDatabaseNum(String databaseNum) {
    this.databaseNum = databaseNum;
}
```
```
<bean id="bookDao" class="ewk.code08.book.BookDaoClass" scope="singleton" init-method="init" destroy-method="destroy">
    <property name="connectNum" value="10"/>
    <property name="databaseNum" value="student"/>
</bean>
```

3.构造器注入步骤
```
public BookServiceClass(BookDao bookDao) {
    this.bookDao = bookDao;
}
```
```
<bean id="bookService" class="ewk.code08.book.BookServiceClass" scope="singleton">
    <!-- name: 通过构造方法的形参名称识别 -->
    <constructor-arg name="bookDao" ref="bookDao"/>
</bean>
```

4.(构造器注入配置时)绑定参数的三种方式
```
private int connectNum;
private String databaseNum;
public void setConnectNum(int connectNum) {
    this.connectNum = connectNum;
}
public void setDatabaseNum(String databaseNum) {
    this.databaseNum = databaseNum;
}
```
```
<bean id="bookDao" class="ewk.code08.book.BookDaoClass" scope="singleton" init-method="init" destroy-method="destroy">
    <!--
    <constructor-arg name="connectNum" value="10"/>
    <constructor-arg name="databaseNum" value="student"/>
    <constructor-arg type="int" value="10"/>
    <constructor-arg type="java.lang.String" value="student"/>
    -->
    <constructor-arg index="0" value="10"/>
    <constructor-arg index="1" value="student"/>
</bean>
```


### 六.依赖自动装配
1.依赖自动装配

IoC容器根据bean所依赖的资源, 在容器中自动查找并注入到bean中的过程
- 按类型(常用)
- 按名称(耦合高,不推荐使用)
- 按构造方法
- 不启动自动装配

``` 
<!-- 自动装配: 按类型
<bean id="bookDao" class="ewk.code08.book.BookDaoClass" scope="singleton"/>
<bean id="bookService" class="ewk.code08.book.BookServiceClass" scope="singleton" autowire="byType"/>
-->
```
```
<!-- 自动装配: 按名称
<bean id="bookDao" class="ewk.code08.book.BookDaoClass" scope="singleton"/>
<bean id="bookService" class="ewk.code08.book.BookServiceClass" scope="singleton" autowire="byName"/>
-->
```

2.优先级

自动装配优先级低于setter注入和构造器注入,同时出现时失效


### 七.集合注入
1.集合注入
```
    private int[] array;

    private List<String> list;

    private Set<String> set;

    private Map<String, String> map;

    private Properties properties;

    @Override
    public void save() {
        System.out.println("数组" + Arrays.toString(array));
        System.out.println("List" + list);
        System.out.println("Set" + set);
        System.out.println("Map" + map);
        System.out.println("Properties" + properties);
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
```

```
<!-- 集合注入 -->
<bean id="bookDao1" class="ewk.code08.book.BookDaoClass1" scope="singleton">
    <property name="array">
        <array>
            <value>100</value>
            <value>200</value>
            <value>300</value>
        </array>
    </property>
    <property name="list">
        <list>
            <value>100</value>
            <value>200</value>
            <value>300</value>
        </list>
    </property>
    <property name="set">
        <set>
            <value>A</value>
            <value>B</value>
            <value>C</value>
            <value>D</value>
        </set>
    </property>
    <property name="map">
        <map>
            <entry key="A" value="111"></entry>
            <entry key="B" value="222"></entry>
            <entry key="C" value="333"></entry>
        </map>
    </property>
    <property name="properties">
        <props>
            <prop key="A">111</prop>
            <prop key="B">222</prop>
            <prop key="C">333</prop>
        </props>
    </property>
</bean>
```

2.集合类型及数组的输出

集合类型
```
System.out.println("List" + list);
System.out.println("Set" + set);
System.out.println("Map" + map);
System.out.println("Properties" + properties);
```

数组类型
```
import java.util.Arrays;
System.out.println("数组" + Arrays.toString(array));
```

### 八.加载properties文件
1.开启命名空间context
```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans 
       http://www.springframework.org/schema/beans/spring-beans.xsd">
```
修改为
```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
        ">
```
2.使用context空间加载properties配置文件并使用${}访问
``` 
// 配置文件
driverClassName = com.mysql.cj.jdbc.Driver
url = jdbc:mysql:///student?useUnicode=true&useServerPrepStmts=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8
username = root
password = 123456
initialSize = 5
maxActive = 10
maxWait = 3000
```
```
<!-- 加载配置文件并通过属性占位符使用 -->
<context:property-placeholder location="jdbc.properties"/>
<bean class="com.alibaba.druid.pool.DruidDataSource">
    <property name="driverClassName" value="${driverClassName}"/>
    <property name="url" value="${url}"/>
    <property name="username" value="${username}"/>
    <property name="password" value="${password}"/>
</bean>
```
3.一个可能存在的冲突

若配置文件中存在username,可能与系统属性冲突,可以通过改名或
system-properties-mode="NEVER"不加载系统属性解决
```
<context:property-placeholder location="jdbc.properties" system-properties-mode="NEVER"/>
```
4.加载多个/所有配置文件
```
location="a.properties,b.properties"
location="*.properties"
// 当前配置文件
location="classpath:*.properties"
// 从类路径或jar包中加载配置文件
location="classpath*:*.properties"
```


### 九.创建容器&获取bean方式
1.创建容器的两种方式
```
// 从类路径加载
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
// 从文件系统加载
// ApplicationContext context = new FileSystemXmlApplicationContext(""+
//         "E:\\CodeJava\\MyCodeJava01\\Code08\\src\\main\\resources\\applicationContext.xml");
```
2.获取bean的三种方式
```
BookDao bookDao1 = (BookDao) context.getBean("bookDao");
BookDao bookDao2 = context.getBean("bookDao",BookDao.class);
// BookDao bookDao3 = context.getBean(BookDao.class);  // 不能有同类型bean
```
3.ApplicationContext

BeanFactory为ApplicationContext最顶层接口

两者区别
- ApplicationContext立即加载
- BeanFactory延时加载

4.总结(涉及内容)
- 容器相关
- bean相关
- 依赖注入相关