package ewk.code09.test;

import com.alibaba.druid.pool.DruidDataSource;
import ewk.code09.book.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${url}")
    private String url;

    @Value("${name}")
    private String name;

    @Value("${password}")
    private String password;

    @Value("${initialSize}")
    private int initialSize;

    @Value("${maxActive}")
    private String maxActive;

    @Value("${maxWait}")
    private String maxWait;

    @Bean("dataSource")
    public DataSource dataSource(BookDao bookDao){
        // 为第三方bean注入资源,按类型自动装配资源
        System.out.println(bookDao);

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(name);
        dataSource.setPassword(password);
        return dataSource;
    }
}
