package ewk.code02;

/*
environments: 配置数据库连接环境信息,通过default属性赋值不同id切换不同的environment
transactionManager: 事务类型,不常用
typeAliases: 别名
mapper: sql映射文件

<!-- 配置别名 -->
<typeAliases>  <!-- 默认情况下,仅仅支持不区分大小写 -->
    <package name="ewk.code02.mapper"/>
</typeAliases>

注意: xml配置需要考虑标签的先后顺序
 */

/*
MyBatisX插件: 实现sql映射文件和同名接口之间的快速跳转及内容检查
 */

import ewk.code02.mapper.StudentSheet1Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main04配置及MyBatisX插件 {
    public static void main(String[] args) throws IOException {
        // 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取Mapper接口的代理对象
        StudentSheet1Mapper studentSheet1Mapper = sqlSession.getMapper(StudentSheet1Mapper.class);

        // 执行方法(唯一需要编写代码的部分)
        List<Data> data = studentSheet1Mapper.selectById(1001);
        System.out.println(data);

        // 释放资源
        sqlSession.close();
    }
}
