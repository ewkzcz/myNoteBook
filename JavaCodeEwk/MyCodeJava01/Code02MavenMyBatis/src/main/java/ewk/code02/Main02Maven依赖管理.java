package ewk.code02;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/*
Fn+Alt+Ins: 快速生成依赖项/坐标

<!--导入MySQL驱动jar包-->
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.30</version>
</dependency>

依赖范围: <scope>test</scope>
默认值为: compile
 */

public class Main02Maven依赖管理 {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        Properties properties = new Properties();
        String str = "Code02/src/main/java/ewk/code02/Maven/druid.properties";
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
