package ewk.code01.c05JDBC;
import java.sql.*;

/* 3.Statement: 执行sql语句
DDL: 对表和库的增删查改操作
DML: 对数据的增删改操作
DQL: 对数据的查询操作
int count1 = statement.executeUpdate(sql1);  // DDL及DML,返回受影响的行数
ResultSet resultSet = statement.executeQuery(sql4);  // DQL,返回结果集对象
while(resultSet.next()){
    int id = resultSet.getInt(1);
    ......
}
resultSet.close();
 */

public class Main04Statement {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql:///student" + "?useUnicode=true" +
                "&characterEncoding=UTF-8" + "&userSSL=false" + "&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        // DML语句
        String sql1 = "UPDATE sheet1 SET stu_name='ewk' WHERE stu_id=1003";
        int count1 = statement.executeUpdate(sql1);  // DML: 受影响的行数
        if(count1>0){
            System.out.println("good");
        }
        else{
            System.out.println("bad");
        }
        System.out.println("change line "+count1);

        // DDL语句
        String sql2 = "create database db1";
        int count2 = statement.executeUpdate(sql2);
        System.out.println("good");
        System.out.println("change line "+count2);
        String sql3 = "drop database db1";
        int count3 = statement.executeUpdate(sql3);  // DDL语句返回结果可能为0(例如删库操作)
        System.out.println("good");  // 只要不发生异常,则认为修改成功
        System.out.println("change line "+count3);

        // DQL语句
        String sql4 = "select * from sheet1";
        ResultSet resultSet = statement.executeQuery(sql4);
        while (resultSet.next()){  // 将游标从上一行移动到当前行,并返回当前行是否存在
            // 获取数据
            int id = resultSet.getInt(1);  // 注意: 从1开始
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String bir = resultSet.getString(4);
            System.out.println("id="+id+" name="+name+" age="+age+" bir="+bir);
        }
        resultSet.close();

        statement.close();
        connection.close();
    }
}
