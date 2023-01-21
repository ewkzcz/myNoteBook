1.依赖坐标
```xml
<!-- druid -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.15</version>
</dependency>
```
```xml
<!-- MybatisPlus -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.3.1</version>
</dependency>
```

2.单元测试乱码解决
```xml
<!-- 单元测试乱码 -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.12.4</version>
    <configuration>
        <argLine>-Dfile.encoding=GBK</argLine>
    </configuration>
</plugin>
```

3.MybatisPlus连接数据库驼峰命名法和_命名法
```yml
mybatis-plus:
  configuration:
    # 修改为驼峰命名法
    map-underscore-to-camel-case: false
```

4.lombok工具: 快速开发实体类
```xml
<!-- lombok,快速开发实体类 -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
</dependency>
```
```java
//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
@Data  // 等价于上四条
@NoArgsConstructor  // 无参构造
@AllArgsConstructor  // 构造
public class Brand {
    private Integer id;
    private String brandName;
    private String enterpriseName;
    private String introduce;
}
```

5.分页查询
```java
@Configuration //分页查询配置类
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        // 1.定义MybatisPlus拦截器
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 2.添加具体的拦截器
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
```

分页查询测试
```
@Test
void testSelectByPage() {
    IPage page = new Page(1, 5);
    brandMapper.selectPage(page, null);
    System.out.println("当前页码值:" + page.getCurrent());
    System.out.println("每页显示数:" + page.getSize());
    System.out.println("一共多少页:" + page.getCurrent());
    System.out.println("一共多少条数据:" + page.getTotal());
    System.out.println("数据:" + page.getRecords());
}
```

6.开启MybatisPlus日志
```yml
mybatis-plus:
  configuration:
    map-underscore-to-camel-case: false
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

7.清除控制台输出的额外内容
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

</configuration>
```

```yaml
mybatis-plus:
  configuration:
    map-underscore-to-camel-case: false
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    banner: false
```

````yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql://localhost:3306/brand?useUnicode=true&useServerPrepStmts=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8
    username: root  # username can't write name
    password: 123456
    initialSize: 5
    maxActive: 10
    maxWait: 3000
  main:
    banner-mode: off
````

8.条件查询
```
    @Test
    void testSelectByCondition(){
        // 方法1
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.lt("id",1005);
//        List<Brand> brandList = brandMapper.selectList(queryWrapper);
//        System.out.println(brandList);

        // 方法2
//        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
//        queryWrapper.lambda().lt(Brand::getId,1005);
//        List<Brand> brandList = brandMapper.selectList(queryWrapper);
//        System.out.println(brandList);

        // 方法3:
        // 链式编程,and逻辑
        LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper.lt(Brand::getId,1005).gt(Brand::getId,1003);
        List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
        System.out.println(brandList);
        // 链式编程,or逻辑
        LambdaQueryWrapper<Brand> lambdaQueryWrapper1 = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper1.lt(Brand::getId,1005).or().gt(Brand::getId,1003);
        List<Brand> brandList1 = brandMapper.selectList(lambdaQueryWrapper1);
        System.out.println(brandList1);
        // lt小于,le小于等于,gt大于,ge大于等于,eq等于
        LambdaQueryWrapper<Brand> lambdaQueryWrapper2 = new LambdaQueryWrapper<Brand>();
        lambdaQueryWrapper2.eq(Brand::getId,1005);
        List<Brand> brandList2 = brandMapper.selectList(lambdaQueryWrapper2);
        System.out.println(brandList2);
    }
```

9.多条件查询null值的处理
```java
@Data
public class BrandQuery extends Brand{
    public Integer idMin;
    public Integer idMax;
}
```
```
// 多条件查询处理null值
@Test
void testSelectByConditionWithNull() {
    BrandQuery brandQuery = new BrandQuery();
    brandQuery.setIdMin(1001);
    brandQuery.setIdMax(1005);
    LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
    lambdaQueryWrapper.gt(brandQuery.getIdMin() != null, Brand::getId, brandQuery.getIdMin());
    lambdaQueryWrapper.lt(brandQuery.getIdMax() != null, Brand::getId, brandQuery.getIdMax());
    List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
    System.out.println(brandList);
}
```

10.查询投影
```
@Test
void test1() {
    // 写法1
    LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<>();
    lambdaQueryWrapper.select(Brand::getId, Brand::getBrandName, Brand::getEnterpriseName);
    List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
    System.out.println(brandList);
    // 写法2
    QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
    queryWrapper.select("id","brandName","enterpriseName");
    List<Brand> brandList1= brandMapper.selectList(queryWrapper);
    System.out.println(brandList1);
}

// 查询投影用于count统计,groupBy分组
@Test
void test2() {
    QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
    queryWrapper.select("count(*) as count,id");
    queryWrapper.groupBy("id");
    List<Map<String,Object>> list = brandMapper.selectMaps(queryWrapper);
    System.out.println(list);
}
```

11.单查询,范围查询,模糊查询
```
// 单查询
@Test
void testSelectOne() {
    LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
    lambdaQueryWrapper.eq(Brand::getId, 1005);
    Brand brand = brandMapper.selectOne(lambdaQueryWrapper);
    System.out.println(brand);
}

// 范围查询
@Test
void testSelectBetween() {
    LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
    lambdaQueryWrapper.between(Brand::getId, 1001, 1005);
    List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
    System.out.println(brandList);
}

// 模糊匹配: likeLeft左边加%,likeRight右边加%,like左右加空格
@Test
void testSelectLike() {
    LambdaQueryWrapper<Brand> lambdaQueryWrapper = new LambdaQueryWrapper<Brand>();
    lambdaQueryWrapper.like(Brand::getEnterpriseName, "公司");
    List<Brand> brandList = brandMapper.selectList(lambdaQueryWrapper);
    System.out.println(brandList);
}
```

12.映射匹配兼容性
- 问题1: 表字段与编码属性设计不同步
- 问题2: 编码中添加了数据库中未定义的属性
- 问题3: 采用默认查询开发了更多字段的查看权限
- 问题4: 表名与编码开发设计不同步

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
// 问题4的解决: 表名与编码开发设计不同步
@TableName("sheet")
public class Brand {
    // 问题1的解决: 表字段与编码属性设计不同步
    @TableField(value = "id")
    private Integer id;
    @TableField(value = "brandName")
    private String brandName;
    @TableField(value = "enterpriseName")
    private String enterpriseName;
    @TableField(value = "introduce")
    // 问题3的解决: 采用默认查询开发了更多字段的查看权限
    // @TableField(value = "introduce",select = false)  // 不参与查询
    private String introduce;

    // 问题2的解决: 编码中添加了数据库中未定义的属性
    @TableField(exist = false)
    private Integer online;
}
```

13.id(主键生成策略)

@Tableidz(type=IdType.AUTO)
- AUTO: 数据库id自增策略控制id生成
- NONE: 不设置id生成是策略
- INPUT: 用户手工输入id
- ASSIGN_ID: 雪花算法生成id
- ASSIGN_UUID: 自定义算法

方法2: yml文件全局配置
```yaml
mybatis-plus:
  configuration:
    map-underscore-to-camel-case: false
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    banner: false
    db-config:
      id-type: assign_id
```

```
// 自增策略
@Test
public void testIdAdd() {
    Brand brand = new Brand();
    brand.setBrandName("华强北");
    brand.setEnterpriseName("华强北公司");
    brand.setIntroduce("仿造第一");
    brandMapper.insert(brand);
}
```

14.根据主键多数据操作/批量删除查询
```
// 根据主键进行多数据操作
@Test
public void testByIds(){
    // 删除多条数据
    List<Integer> list = new ArrayList<>();
    list.add(1001);
    list.add(1002);
    brandMapper.deleteBatchIds(list);
    // 查询多条数据
    List<Integer> list1 = new ArrayList<>();
    list1.add(1003);
    list1.add(1004);
    brandMapper.selectBatchIds(list1);
}
```

15.逻辑删除

为数据设置是否可用的状态字段,删除时设置为不可用,而不是物理删除

方法1
@TableLogic(value="0",delval="1")
private Integer deleted;

方法2-全局配置
logic-delete-field: deleted
logic-not-delete-value: 0
logic-delete-value: 1

16.乐观锁
- 添加数据库version字段和实体类属性
- 配置乐观锁
  - @Version private Integer version
- 配置乐观锁拦截器实现锁机制对应的动态SQL语句拼装
  - mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
