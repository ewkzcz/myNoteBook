package ewk.code01.c05JDBC;
import java.sql.*;

/* 1.DriverManager驱动管理类
1.1 注册驱动(5.x)
Class.forName("com.mysql.jdbc.Driver");
DriverManager.registerDriver(new Driver());  // 相当于
1.2 获取数据库连接
Connection connection = DriverManager.getConnection(url, username, password);
// url语法: jdbc:mysql://ip地址(域名):端口号/数据库名称?参数键值对1&参数键值对2...
// 当连接本机且端口号为默认的3306时,可以省略ip地址(域名),或为localhost:3306
 */

public class Main02DriverManager {
    public static void main(String[] args) throws SQLException {

    }
}
