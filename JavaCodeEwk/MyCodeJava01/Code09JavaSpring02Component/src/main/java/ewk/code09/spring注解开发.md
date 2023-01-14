1.spring注解开发步骤
步骤1-设置扫描路径
```
<bean:component-scan base-package="ewk.code09.book"/>
```
步骤2-配置注解
- @Component
- @Component("xxx")

2.衍生注解
- @Controller: 表现层bean定义
- @Service: 业务层bean定义
- @Repository: 数据层bean定义

3.纯注解开发

spring3.0升级了纯注解开发模式,使用Java类代替配置文件

步骤1-定义配置类
- 标记类代替配置文件 @Configuration
- 扫描包 @ComponentScan("ewk.code09.book")
  - ComponentScan只能出现一次
  - ComponentScan支持使用{"","",...}添加多个路径
步骤2-加载配置类初始化容器
```
ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
```

4.注解开发Scope&bean生命周期

单例控制
- @Scope()
- @Scope("single")
- @Scope("prototype")

初始化/销毁(已弃用)
- @PostConstruct
- @PreDestroy

生命周期补充
- 单例模式(spring singleton的缺省是饿汉模式)
  - 由Spring IoC容器托管
  - 生命周期完全由容器控制
- 多例模式
  - 实例只会随着getBean而创建,不会随着容器初始化而创建,即多例模式只有懒汉
  - spring不负责销毁,没有调用destroy方法
  - 创建的对象最后交给gc(垃圾回收机制)管理

5.依赖注入/自动装配

- @Autowired 自动装配(按类型)/此时set方法可以不提供
- @Qualifier("bookDao") 按名称装配/引用类型的装配 
- @Value("ewk") 简单类型的装配 

6.加载properties文件

- @PropertySource("jdbc.properties")
- @PropertySource可以使用{"","",...},不支持通配符
- @Value("${password}") 使用配置文件里的信息
- 不要使用@Value("${username}"),会与系统属性冲突

7.配置第三方bean&配置类导入
- @Bean("dataSource") 配置第三方bean
- @Import({JdbcConfig.class}) 导入一个类作为配置类
- @Import的作用: 将不同类别的配置信息放入不同的配置类中,再用import整合在一起方便统一管理

为第三方bean注入资源,会按类型自动装配资源
```
public DataSource dataSource(BookDao bookDao) {
  System.out.println(bookDao);
}
```