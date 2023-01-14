package ewk.code02;

/* MyBatis: 持久层框架,用于简化JDBC开发
1.导入坐标
2.编写MyBatis配置文件mybatis-config
修改数据库连接信息,加载sql映射文件(包含sql语句信息)
3.编写sql映射文件,统一管理sql语句,返回结果集用专门的数据类管理,填写数据类地址
4.编写代码
  定义Data类管理数据,
  加载核心配置文件获取SqlSessionFactory对象,
  获取SqlSession对象执行sql语句,
  释放资源
 */

/* 添加坐标: mybatis,mysql
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.5</version>
</dependency>
 */

/* Mapper代理方式
1.定义与SQL映射文件同名的Mapper接口文件
在resources文件夹下使用"包名/包名..."格式创建目录,并将SQL映射文件放入其中,
编译后,sql映射文件将与Mapper接口文件的class文件进入同一目录中
(也可以直接将Mapper接口文件和sql映射文件放在同一目录,但不推荐)
2.在Mapper接口中定义方法
方法名与sql映射文件中的sql语句id应相同,参数类型与sql映射文件中定义的返回值一致
3.编写代码:
  通过SqlSession的getMapper方法获取Mapper接口的代理对象
  调用对应方法完成sql执行
 */

import ewk.code02.mapper.StudentSheet1Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main03MyBatis及Mapper代理开发 {
    public static void main(String[] args) throws IOException {
        // 1.加载mybatis核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取SqlSession对象,用于执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.执行sql语句
        // List<Data> users = sqlSession.selectList("ewk.code02.mapper.StudentSheet1Mapper.selectAll");
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);
        List<Data> users = studentSheet1Mapper.selectAll();

        System.out.println(users);

        // 4.释放资源
        sqlSession.close();
    }
}
