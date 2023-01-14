package ewk.code05;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/* Listener(不常用)
JavaWeb提供了8个监听器: 监听application,session,request三个对象创建,销毁,添加,修改,删除时自动执行代码的功能组件
 */

@WebListener
public class Main06Listener监听器 implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 加载资源
        System.out.println("加载资源...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 释放资源
        System.out.println("释放资源...");
    }
}
