### 一.SpringMVC简介
1.概念&作用
- SpringMVC是一种表现层框架技术
- SpringMVC用于进行表现层功能开发
- SpringMVC技术与tomcat技术相当

2.SpringMVC开发步骤
- 导入Servlet与SpringMVC坐标(注意: provided)
- 创建SpringMVC控制器类controller(等同于Servlet功能)
- 创建SpringMVC配置文件,加载controller对应的bean
- 初始化Servlet容器,加载SpringMVC环境,并设置SpringMVC技术处理的请求
(定义一个servlet容器启动的配置类,在里面加载spring配置)
- tomcat插件/本地部署

**特別注意: **
- 版本不能太新,tomcat不超过tomcat9
- 依赖坐标版本问题会导致错误

解释
- @Controller 类注解,设定SpringMVC的核心控制器bean
- @RequestMapping 方法注解,设置当前控制器方法请求访问路径
- @ResponseBody 设置当前控制器方法响应内容为当前返回值,无需解析
```
<dependencies>
  <!-- spring -->
  <!-- spring-webmvc里面已包含spring-context,但是此处不添加会报错,可能是因为版本问题 -->
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.0.3</version>
    <scope>compile</scope>
  </dependency>
  <!-- spring-webmvc -->
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.10.RELEASE</version>
  </dependency>
  <!-- spring操作数据库 -->
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>6.0.3</version>
  </dependency>

  <!-- spring整合mybatis -->
  <!-- mybatis-spring -->
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>3.0.1</version>
  </dependency>
  <!--mysql-->
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
  </dependency>
  <!-- druid -->
  <dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.15</version>
  </dependency>
  <!--mybatis-->
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.11</version>
  </dependency>

  <!-- junit -->
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
  </dependency>

  <!-- servlet,用于web容器 -->
  <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```
```
@Controller
public class MyController {
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("save...");
        return "{'info': 'springmvc'}";
    }
}
```
```
@Configuration
@ComponentScan("ewk.code13.controller")
public class SpringConfig {
}
```
```
// 定义一个servlet容器启动的配置类,在里面加载spring配置
public class ewk.code16.config.ServletConfig extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ewk.code16.config.SpringMvcConfig.class);
        return context;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
```
```
<plugin>
  <groupId>org.apache.tomcat.maven</groupId>
  <artifactId>tomcat7-maven-plugin</artifactId>
  <version>2.2</version>
  <configuration>
    <port>4444</port>
    <path>/</path>
  </configuration>
</plugin>
```

3.SpringMVC工作流程
- 启动服务器初始化
  - 服务器启动,初始化Web容器
  - 创建WebApplicationContext
  - 加载SpringMvcConfig
  - 执行@ComponmentScan加载对应的bean
  - 加载控制器
  - 执行getServletMappings方法
- 单次请求过程
  - 发送请求
  - Web容器将请求交给SpringMVC处理
  - 解析请求路径
  - 匹配执行对应的方法
  - 执行方法
  - 检测到有@ResponseBody,将方法返回值作为响应体返回给请求方

4.Controller加载控制与业务bean加载控制

如何避免Spring错误的加载到SpringMVC的bean?

加载Spring控制的bean时排除SpringMVC控制的bean

Spring加载时排除SpringMVC的方式
- Spring加载bean时设定精确扫描范围
- 排除SpringMVC的扫描范围
- 不区分Spring与SpringMVC的环境,加载到同一个环境中

```
//@ComponentScan(value = "ewk.code13",
//        excludeFilters = @ComponentScan.Filter(
//                type = FilterType.ANNOTATION,
//                classes = MyController.class
//        )
//)
```
加载Spring容器
```
//    // 加载Spring容器
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(SpringConfig.class);
//        return context;
//    }
```

5.简化开发servlet容器启动的配置类
```
public class ewk.code16.config.ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ewk.code16.config.SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```