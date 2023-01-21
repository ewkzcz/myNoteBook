1.创建SpringBoot项目的Bug

IDEA构建SpringBoot时，MVN报错未找到插件 
'org.springframework.boot:spring-boot-maven-plugin:'

原因: 该插件没有绑定好版本

解决办法(示例)
``` xml
<!-- 父项目依赖处得到版本号 -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.4</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>

<!-- 在对应插件处绑定版本号 -->
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <version>2.4.4</version>
        </plugin>
    </plugins>
</build>
```

2.创建SpringBoot项目的注意点
- 需要联网
- 也可以在官网上创建

3.SpringBoot项目打包jar快速启动
- mvn package打包jar文件
- cmd
- java -jar Code18SpringBoot-0.0.1-SNAPSHOT.jar

4.切换jetty服务器(版本冲突)
``` xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <!-- 排除tomcat服务器 -->
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<!-- 切换jetty服务器 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

``` xml
<!-- jetty版本冲突修复程序 -->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>5.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>3.0.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

5.SpringBoot配置格式
- properties 
- yml(常用)
- yaml

优先级: properties->yml->yaml
``` properties
server.port=80
``` 
 
``` yml
server:
  port: 81
```

``` yaml
server:
  port: 82
```

自动提示功能消失的解决方法: 项目结构->Facet

6.yaml数据格式
- 大小写敏感
- 冒号结束
- 缩进表示层级(只能用空格缩进,数量不限;不允许使用Tab键)
- 属性值前面添加空格
- #表示注释
- -表示数组元素

7.yaml数据读取
- @Value读取单个数据,属性名引用方式: ${一级属性名.二级属性名}
- 封装全部数据到@Environment对象
- 自定义对象封装指定数据(常用)

8.未配置SpringBoot配置注解处理器解决方法
``` xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

9.多环境开发
- 方法1: properties环境分类配置文件(application-pro..)
- 方法2: yaml同一文件内---分隔不同环境配置
``` yaml
# 设置启用的环境
spring:
  profiles:
    active: dev

---
# 开发
spring:
  config:
    activate:
      on-profile: dev
server:
  port: 8080

---
# 生产
spring:
  config:
    activate:
      on-profile: pro
server:
  port: 8081

--- 
# 测试
spring:
  config:
    activate:
      on-profile: test
server:
  port: 8082
```

10.多环境启动命名格式
- clean->package->cmd->启动
- 添加命名行参数在测试环境中启动指令 
``` 
java -jar Code18SpringBoot-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
```
- 可以使用--server.port=80临时指定端口

11.多环境兼容问题(Maven与SpringBoot)
- Maven多环境优先于SpringBoot多环境
- 但是可以将SpringBoot中的设置通过占位符$传递给Maven
- 需要注意的是需要开启对资源文件对默认占位符的解析

统一管理的一定是Maven的多环境

12.配置文件分类

4种配置文件
- 1级(最高): file,config/application.yml
- 2级: file,application.yml
- 3级: classpath,config/application.yml
- 4级: classpath,application.yml

作用
- 1级和2级留做系统打包后设置通用属性
- 3级和4级用于系统开发阶段设置通用属性

13.springBoot整合junit
- 依赖spring-boot-starter,spring-boot-starter-web里面有包含
- 依赖spring-boot-starter-test

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
</dependency>
```

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

``` java
@SpringBootTest
class Code18SpringBootApplicationTests {
    @Autowired(required = false)
    private BrandService brandService;

    @Test
    void contextLoads() {
        brandService.show();
    }
}
```

14.springBoot整合mybatis
- Mysql,Mybatis起步依赖
- yml配置数据库信息(数据库名,用户名,密码,时区,druid驱动)
- @Mapper注解开发dao层

```xml
<!-- druid坐标 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.15</version>
</dependency>
```

