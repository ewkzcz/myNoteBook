package ewk.code02;

/*
1.Maven命令:
mvn compile 编译: 必须先进行编译产生target文件夹(包含class文件),才能运行该文件,否则会报找不到主类错误
mvn clean 清除: 删除编译产生的target文件夹
mvn package 打包jar文件
mvn test 测试
mvn install 安装到本地仓库

2.Maven生命周期(分为3套):
同一生命周期内,执行后面的命令,前面的所有命令会自动执行
清理工作,核心工作,产生报告
 */

public class Main01HelloMaven {
    public static void main(String[] args) {
        System.out.println("Hello Maven");
    }
}