package ewk.code02;

import ewk.code02.mapper.StudentSheet1Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 1.MyBatis管理项目流程
    1.Mapper接口及方法(接口文件)
    2.sql语句(xml文件)
    3.实现方法(Java文件)
 */
/* 2.一个页面的功能清单
    1.增
    2.删: 部分,全部
    3.查询: 部分,全部,查看详情
    4.改: 部分,全部
 */
/* 3.MyBatis增删查改思路
    1.sql语句怎么写?
    2.接口方法是否需要参数?
    3.接口方法返回什么类型?
 */
/* 4.MyBatis开发的两种方式
    1.配置文件开发(xml文件): 完成复杂功能
    2.注解开发(@Select,@Insert,@Update,@Delete): 完成简单功能
    @Select("select stu_age,stu_name,stu_id,stu_bir from  sheet1;")
 */

public class Main05MyBatis增删查改 {
    public static void main(String[] args) throws IOException {
        testSelectAll();  // 查询全部
        testSelectById();  // 查看详情
        testSelectByCondition();  // 多条件查询
        testSelectByConditionSingle();  // 单条件查询
        testAdd();  // 添加数据
        testSelectAll();  // 再次查询全部
        testAddReturnId();  // 添加数据,返回id
        testSelectAll();  // 再次查询全部
        testDeleteById();  // 删除单个数据
        testSelectAll();  // 再次查询全部
        testDeleteByIds();  // 批量删除数据
        testSelectAll();  // 再次查询全部
        testUpdate();  // 更新数据
        testSelectAll();  // 再次查询全部
    }

    public static void testSelectAll() throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        List<Data> users = studentSheet1Mapper.selectAll();
        System.out.println(users);

        // 释放资源
        sqlSession.close();
    }

    public static void testSelectById() throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        Integer id = 1001;
        List<Data> data = studentSheet1Mapper.selectById(id);
        System.out.println(data);

        // 释放资源
        sqlSession.close();
    }

    public static void testSelectByCondition() throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        Integer id = 1001;
        String name = "z";
        Integer age = 20;
        String bir = "2002";
        name = "%" + name +"%";
        bir = "%" +bir +"%";

        Data data = new Data(id,name,age,bir);

        Map map = new HashMap();
        map.put("id",id);
        map.put("name",name);
        map.put("age",age);
        map.put("bir",bir);

        List<Data> data1 = studentSheet1Mapper.selectByCondition(id,name,age,bir); // %表示任意字符
        System.out.println(data1);
        List<Data> data2 = studentSheet1Mapper.selectByCondition(data);
        System.out.println(data2);
        List<Data> data3 = studentSheet1Mapper.selectByCondition(map);
        System.out.println(data3);

        // 释放资源
        sqlSession.close();
    }

    public static void testSelectByConditionSingle() throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        Integer id = 1001;
        String name = "z";
        Integer age = 20;
        String bir = "2002";
        name = "%" + name +"%";
        bir = "%" +bir +"%";

        Data data = new Data();
        // data.setId(id);
        // data.setName(name);
        // data.setAge(age);
        data.setBir(bir);

        List<Data> users = studentSheet1Mapper.selectByConditionSingle(data);
        System.out.println(users);

        // 释放资源
        sqlSession.close();
    }

    public static void testAdd() throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();  // 默认不自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        Integer id = 1004;
        String name = "qqq";
        Integer age = 21;
        String bir = "2002-01-01";

        Data data = new Data();
        data.setId(id);
        data.setName(name);
        data.setAge(age);
        data.setBir(bir);

        studentSheet1Mapper.add(data);

        // sqlSessionFactory.openSession(true): 自动提交事务
        // 否则需要手动提交事务
        // sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    public static void testAddReturnId() throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        Integer id = 1005;
        String name = "www";
        Integer age = 21;
        String bir = "2002-01-01";

        Data data = new Data();
        data.setId(id);
        data.setName(name);
        data.setAge(age);
        data.setBir(bir);

        int returnId = studentSheet1Mapper.addReturnId(data);
        System.out.println(returnId);

        // 释放资源
        sqlSession.close();
    }

    public static void testDeleteById() throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        Integer id1 = 1004;
        Integer id2 = 1005;
        studentSheet1Mapper.deleteById(id1);
        studentSheet1Mapper.deleteById(id2);

        // 释放资源
        sqlSession.close();
    }

    public static void testDeleteByIds() throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        int[] ids = {1002,1003};
        studentSheet1Mapper.deleteByIds(ids);

        // 释放资源
        sqlSession.close();
    }

    public static void testUpdate() throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        int id = 1001;
        String name = "zcz";
        Integer age = 21;
        String bir = "2002-01-01";
        Data data = new Data();
        data.setId(id);
        data.setName(name);
        data.setAge(age);
        data.setBir(bir);
        int count = studentSheet1Mapper.update(data);
        System.out.println("Change Line "+count);

        // 释放资源
        sqlSession.close();
    }
}