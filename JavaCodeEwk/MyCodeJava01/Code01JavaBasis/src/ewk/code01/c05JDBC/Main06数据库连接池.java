package ewk.code01.c05JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.Properties;

/* 数据库连接池(容器): 负责分配管理数据库连接(允许重复,释放空闲)
好处: 资源重用,提升系统响应速度,避免数据库连接遗漏
数据库连接池实现
标准接口: DataSource: Connection getConnection()
常见数据库连接池: DBCP,C3P0,Druid(德鲁伊,阿里巴巴开源项目)
 */
// System.out.println(System.getProperty("user.dir"));  // 获取当前路径

public class Main06数据库连接池 {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        Properties properties = new Properties();
        String str = "Code01/src/ewk/code01/d2/c01JDBC/druid.properties";
        System.out.println(str);
        properties.load(new FileInputStream(str));
        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取数据库连接
        Connection connection = dataSource.getConnection();

        // 查询
        int idUser = 1001;
        String nameUser = "zcz";
        String sql = "select * from sheet1 where stu_id = ? and stu_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idUser);
        preparedStatement.setString(2, nameUser);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String bir = resultSet.getString(4);
            System.out.println("id=" + id + " name=" + name + " age=" + age + " bir=" + bir);
        }

        // 释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}

