package ewk.code01.c05JDBC;
import java.sql.*;

/* 2.Connection数据库连接对象
2.1 获取执行sql的对象
Statement statement = connection.createStatement();  // 普通执行sql的对象
PreparedStatement preparedStatement = connection.prepareStatement(sql); // 预编译SQL对象并执行,防止sql注入问题
CallableStatement callableStatement = connection.prepareCall(sql);  // 执行储存过程的对象
2.2 管理事务(结合try-catch块)
开启事务: connection.setAutoCommit(false);  // true为自动提交,false为手动提交
提交事务: connection.commit();
回滚事务: connection.rollback();
 */

public class Main03Connection {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql:///student" + "?useUnicode=true" +
                "&characterEncoding=UTF-8" + "&userSSL=false" + "&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String sql1 = "UPDATE sheet1 SET stu_name='Tom' WHERE stu_id=1002";
        String sql2 = "UPDATE sheet1 SET stu_name='张三' WHERE stu_id=1003";
        try {
            // 开启事务
            connection.setAutoCommit(false);
            int count1 = statement.executeUpdate(sql1);
            int count2 = statement.executeUpdate(sql2);
            System.out.println("change line "+count1);
            System.out.println("change line "+count2);
            // 提交事务
            connection.commit();
        } catch (Exception e) {
            // 回滚事务
            connection.rollback();
            throw new RuntimeException(e);
        }

        statement.close();
        connection.close();
    }
}
