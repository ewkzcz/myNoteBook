package ewk.code01.c05JDBC;
import java.sql.*;

/* 4.PreparedStatement(接口,实现了Statement): 预编译SQL对象并执行,防止sql注入问题
SQL注入: 通过操作输入来修改事先定义好的SQL语句,用以达到执行代码对服务器进行攻击的方法
1.预编译sql,性能更高
2.防止sql注入,将敏感字符转义
String sql2 = "select * from sheet1 where stu_id = ? and stu_name = ?";
// 此句完成检查sql语法和预编译sql语句,之后不会重复预编译
 */

/*
    String sql2 = "select * from sheet1 where stu_id = ? and stu_name = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql2);
    preparedStatement.setInt(1,idUser2);
    preparedStatement.setString(2,nameUser2);
    ResultSet resultSet2 = preparedStatement.executeQuery();
 */

/*
1.PreparedStatement开启预编译功能: useServerPrepStmts=true
2.配置MySQL执行日志: my.ini文件写入配置下列消息->重启MySQL服务(管理员权限打开cmd窗口->services.msc->重启MySQL服务)
    log-output=FILE
    general-log=1
    general_log_file="D:\MysqlLog\mysql.log"
    slow-query-log=1
    slow_query_log_file="D:\MysqlLog\mysql_slow.log"
    long_query_time=2
 */

/* mysql无法重启如何获取错误提示信息
1.服务 -> MySQL -> 属性
2.将路径两端的引号删除,给含空格的文件夹添加引号,将最后的MySQL删除,其余内容不变
3.将内容复制到PowerShell运行。
// "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysqld.exe" --defaults-file="C:\ProgramData\MySQL\MySQL Server 8.0\my.ini" MySQL
// 处理后:
// C:\"Program Files"\MySQL\"MySQL Server 8.0"\bin\mysqld.exe --defaults-file="C:\ProgramData\MySQL\MySQL Server 8.0\my.ini"
 */

public class Main05PreparedStatement {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql:///student" + "?useUnicode=true" + "&useServerPrepStmts=true" +
                "&characterEncoding=UTF-8" + "&userSSL=false" + "&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        // 1.模拟查询数据库并登录
        int idUser = 1001;
        String nameUser = "zcz";
        String sql = "select * from sheet1 where stu_id = '" + idUser +
                "' and stu_name = '" + nameUser + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println("good");
        }
        else{
            System.out.println("bad");
        }
        resultSet.close();

        // 2.SQL注入演示
        int idUser1 = 1001;
        String nameUser1 = "' or '1' = '1";  // ' or '1' = '1
        String sql1 = "select * from sheet1 where stu_id = '" + idUser1 +
                "' and stu_name = '" + nameUser1 + "'";
        System.out.println(sql1);
        ResultSet resultSet1 = statement.executeQuery(sql1);
        if(resultSet1.next()){
            System.out.println("good");
        }
        else{
            System.out.println("bad");
        }
        resultSet1.close();

        // 3.SQL注入问题的解决: PreparedStatement,将敏感字符进行转义
        // 模拟获取登录界面传来的数据
        int idUser2 = 1001;
        String nameUser2 = "' or '1' = '1";
        // String nameUser2 = "zcz";
        // 获取对象
        String sql2 = "select * from sheet1 where stu_id = ? and stu_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        // 设置参数值: 传入数据时,会进行转义,'变为\'
        preparedStatement.setInt(1,idUser2);
        preparedStatement.setString(2,nameUser2);
        // 执行sql语句: 特别注意,此时不要再传入sql语句
        ResultSet resultSet2 = preparedStatement.executeQuery();
        // 判断查询/登录是否成功
        if(resultSet2.next()){
            System.out.println("good");
        }
        else{
            System.out.println("bad");
        }
        resultSet2.close();

        // 4.预编译功能的验证
        // 开启预编译功能
        // 配置MySQL执行日志,通过日志观察预编译的情况

        statement.close();
        preparedStatement.close();
        connection.close();
    }
}
