package ewk.code21;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class CodeGenerator {
    public static void main(String[] args) {
        // 获取代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();

        // 设置数据库相关配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/brand?useUnicode=true&useServerPrepStmts=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        autoGenerator.setDataSource(dataSourceConfig);

        // 设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/Code21generator/src/main/java");
        globalConfig.setOpen(false);  // 设置完成后是否打开所在目录
        globalConfig.setAuthor("ewk");  // 设置作者
        globalConfig.setFileOverride(true);  // 设置是否覆盖生成文件
        globalConfig.setMapperName("%sMapper");  // 设置数据层接口名,%s为占位符,指模块名称
        globalConfig.setIdType(IdType.ASSIGN_ID);  // 设置ID生成策略
        autoGenerator.setGlobalConfig(globalConfig);

        // 设置包名相关配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("ewk.code21");  // 设置生成包名
        packageConfig.setEntity("data");  // 设置实体类包名
        packageConfig.setMapper("mapper");  // 设置数据层包名
        autoGenerator.setPackageInfo(packageConfig);

        // 策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("sheet");  // 设置当前参与生成的表名(可变参数)
        strategyConfig.setTablePrefix("");  // 设置数据库表的前缀名称,模块名=数据库表名-前缀名
        strategyConfig.setRestControllerStyle(true);  // 设置REST风格
        // strategyConfig.setVersionFieldName("version");  // 乐观锁字段
        // strategyConfig.setLogicDeleteFieldName("deleted");  // 逻辑删除字段
        strategyConfig.setEntityLombokModel(true);  // 是否启用lombok
        autoGenerator.setStrategy(strategyConfig);

        // 执行生成操作
        autoGenerator.execute();
    }
}
