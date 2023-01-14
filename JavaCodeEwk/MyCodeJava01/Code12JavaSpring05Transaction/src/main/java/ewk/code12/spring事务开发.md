1.spring事务作用 
- 事务: 在数据层保障一条数据库操作成功或失败
- spring事务: 在数据层/业务层保障一系列数据库操作同成功同失败

2.spring事务开发步骤

步骤1-开启spring事务
```
@Transactional
public void transfer(String out, String in, Double money);
```

步骤2-定义事务管理器,由spring容器管理
```
@Bean
public PlatformTransactionManager transactionManager(DataSource dataSource){
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
    transactionManager.setDataSource(dataSource);
    return transactionManager;
}
```

步骤3-告知spring容器由注解开发事务
```
@EnableTransactionManagement
```

3.spring事务角色
- 事务管理员: 发起事务方,在spring中通常指业务层开启事务的方法
- 事务协调员: 加入事务方,在spring中通常指数据层方法,也可以是业务层方法

开启spring事务后 ,范围内事务(即事务协调员)
会加入该spring事务统一管理(即事务管理员)

4.spring事务相关配置
- readOnly 只读
- timeout 设置事务超时时间
- rollbackFor 设置回滚异常(默认只有部分异常回滚)
- propagation 设置事务传播行为

4.1默认回滚的异常
- 运行时异常
  - NullPointException
  - 算术运算异常
- Error
  - error通常是虚拟机出错,如内存溢出,StackOverFlow

4.2添加回滚异常类型
```
@Transactional(rollbackFor = {IOException.class})
```

设置事务传播行为
- 默认当事务管理员开启事务时,事务协调员不新建只加入事务
- REQUIRES_NEW表示无论事务管理员是否开启事务,都会新建事务
```
@Transactional(propagation = Propagation.REQUIRES_NEW)
```