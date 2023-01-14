package ewk.code01.c05JDBC;

import java.sql.*;
/* 默认端口
mysql的默认端口是3306，可以编辑用户目录下的 .my.cnf 文件进行修改。
sqlserver默认端口号为：1433
oracle 默认端口号为：1521
DB2 默认端口号为：5000
 */

/* 5.x版本与8.0.x版本的写法差异
1.注册驱动:
// Class.forName: 给定的类如果之前没有被初始化过,那么会被初始化
Class.forName("com.mysql.jdbc.Driver");  // 5.x版本的驱动文件jar包
Class.forName("com.mysql.cj.jdbc.Driver");  // 8.0.x版本的驱动文件jar包,此句可以不写
2.获取连接
String url = "jdbc:mysql://localhost:3306/student";  // 5.x的url写法
String url = "jdbc:mysql://localhost:3306/student" + "?useUnicode=true" +
        "&characterEncoding=UTF-8" + "&userSSL=false" + "&serverTimezone=GMT%2B8";
// 8.0x的url写法: 连接地址+字符集为utf-8+ssl连接关闭+时区设置
// 8.0x不需要建立ssl连接的，需要显示关闭
// localhost:3306: 当连接本机且端口号为默认的3306时,可以省略localhost:3306
 */

/*
    String url = "jdbc:mysql:///student" + "?useUnicode=true" +
            "&characterEncoding=UTF-8" + "&userSSL=false" + "&serverTimezone=GMT%2B8";
    String username = "root";
    String password = "123456";
    Connection connection = DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement();
    String sql = "UPDATE sheet1 SET stu_name='ewk' WHERE stu_id=1003";
    int count = statement.executeUpdate(sql);
    System.out.println("change line: "+count);
    statement.close();
    connection.close();
 */

public class Main01JDBC流程 {
    public static void main(String[] args) throws Exception {
        // 0.创建工程,导入驱动jar包

        // 1.注册驱动(8.0.x自动加载,可以省略)

        // 2.获取连接
        String url = "jdbc:mysql:///student" + "?useUnicode=true" +
                "&characterEncoding=UTF-8" + "&userSSL=false" + "&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3.获取指向sql的对象
        Statement statement = connection.createStatement();

        // 4.定义sql语句
        String sql = "UPDATE sheet1 SET stu_name='ewk' WHERE stu_id=1003";

        // 5.执行sql语句
        int count = statement.executeUpdate(sql);  // 返回受影响的行数

        // 6.处理结果
        System.out.println("change line: "+count);

        // 7.释放资源
        statement.close();
        connection.close();
    }
}