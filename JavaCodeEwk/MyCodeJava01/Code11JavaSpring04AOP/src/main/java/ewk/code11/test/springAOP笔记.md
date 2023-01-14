### 一.AOP作用及概念
1.AOP作用
- 无侵入式功能增强

2.AOP核心概念
- 连接点
- 切入点
- 通知
- 通知类
- 切面

### 二.AOP编程步骤
- 导入坐标
- 制作连接点方法
- 定义通知类/切面类
- 制作共性方法
- 定义切入点
- 绑定切入点与通知
- 开启spring对AOP注解驱动支持

1.第一步-导入坐标(pom.xml)
``` 
<!-- spring-AOP依赖坐标
1.spring-context包含的spring-aop坐标
2.aspectjweaver坐标
-->
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>1.9.19</version>
</dependency>
```

2.第二步-制作连接点方法
- 略

3.第三步-定义通知类/切面类,受spring容器管理

首先创建MyAdvice类: @Component,@Aspect表示该类为AOP
```
@Component  // 通知类
@Aspect  // 切面类
public class MyAdvice {}
```

4.第四步-制作共性方法(MyAdvice类中)

```
public void method() {
    System.out.println(System.currentTimeMillis());
}
```

5.第五步-定义切入点(MyAdvice类中)
```
@Pointcut("execution(void ewk.code11.dao.BookDao.update())")
private void pt(){}
```

6.第六步-绑定切入点与通知关系,指定通知添加到原始连接点的具体执行位置(MyAdvice类中)
```
@Before("pt()")
public void method() {
    System.out.println(System.currentTimeMillis());
}
```

7.第七步-开启spring对AOP注解驱动支持(SpringConfig类中)
```
@EnableAspectJAutoProxy
```

### 三.AOP工作流程&工作流程

1.AOP核心概念
- 目标对象: 原始功能去掉共性功能对应的类产生的对象,无法直接完成最终工作
- 代理: 目标对象无法直接完成工作,需要对其进行功能回填,通过原始对象的代理对象实现

2.SpringAOP本质:代理模式

3.AOP工作流程
- Spring容器启动
- 读取所有切面配置中的切入点(没有匹配的切入点不读取)
- 初始化bean
  - 匹配失败,创建对象
  - 匹配成功,创建原始对象(目标对象的代理对象)
- 获取bean执行方法
  - 获取bean,调用方法并执行,完成操作
  - 获取bean为代理对象,根据代理对象的运行模式运行原始方法与增强的内容,完成操作

### 四.切入点表达式

1.标准格式

动作关键字(访问修饰符 返回值 包名.类/接口名.方法名(参数)异常名)

2.两种描述方法
- 切入点描述接口(常用)
  - @Pointcut("execution(void ewk.code11.dao.BookDao.update())")
- 切入点描述实现类
  - @Pointcut("execution(void ewk.code11.dao.BookDaoClass.update())")

3.可以使用通配符描述切入点
- '\*': 单个独立任意符号 
  - execution(public * ewk.code11.dao.BookDao.find*(*))
- '..': 多个连续任意符号
  - execution(public void ewk..BookDao.findById(..))
- '+': 匹配子类类型
  - execution(* * \*..BookDao+.*(..))

4.注意点
- 描述切入点通常描述接口,不描述实现类
- 对接口开发均采用public描述(可省略)
- 不推荐使用异常作为匹配规则

### 五.AOP通知类型
1.五种AOP通知类型
- 前置通知@Before
- 后置通知@After
- 环绕通知@Around(重点)
- 返回后通知@AfterReturning
- 抛出异常通知@AfterThrowing

2.After与AfterReturning的区别
- 当发生异常时,After执行
- 当发生异常时,AfterReturning不执行

3.环绕通知&切入点有返回值时的写法
- ProceedingJoinPoint获取被环绕对象
- proceedingJoinPoint.proceed()调用被环绕对象
- 注意返回值&抛出异常
```
public int show() {
    System.out.println(100);
    return 100;
}
```
```
@Pointcut("execution(int ewk.code11.dao.BookDao.show())")
private void pt1(){}

@Around("pt1()")
public int show(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("around before");
    int num = (int) proceedingJoinPoint.proceed();
    System.out.println("around after");
    return  num;
}
```

### 六.AOP获取/修改参数(通过JoinPoint)
1.AOP获取对象
```
@Pointcut("execution(String ewk.code11.dao.BookDao.test(..))")
private void pt3() { }

@Before("pt3()")
public void test(JoinPoint joinPoint) {
    System.out.println("before");
    Object[] objects = joinPoint.getArgs();
    System.out.println(Arrays.toString(objects));
}
```

2.AOP修改对象

ProceedingJoinPoint为JoinPoint的子类
- 相同点: 也可以调用getArgs方法
- 不同点: ProceedingJoinPoint只能在Around通知中使用
- 不同点: ProceedingJoinPoint有proceed方法 

其中 proceedingJoinPoint.proceed();

相当于 proceedingJoinPoint.proceed(objects);

3.AOP获取返回值

只有@Around和@AfterReturning可以获取返回值
```
@Pointcut("execution(String ewk.code11.dao.BookDao.testAfterReturning(..))")
private void pt4() {
}

@AfterReturning(value = "pt4()",returning = "ret")
public void testAfterReturning(Object ret){
    System.out.println("testAfterReturning "+ret);
}
```

4.一个注意点

共性方法的参数中有JoinPoint时,必须是JoinPoint在前面

5.获取异常
```
@AfterThrowing(value = "pt()",throwing = "t")
// 略
```