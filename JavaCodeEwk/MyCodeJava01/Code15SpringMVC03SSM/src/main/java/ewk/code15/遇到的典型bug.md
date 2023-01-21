### SSM整合中遇到的问题

1.web项目默认首页index.html无法访问问题

- 参考: https://blog.csdn.net/weixin_45746327/article/details/118723836
- 原因: jsp文件自动放行,html文件不会自动放行
- 解决方法
```
  <!-- web项目默认首页 -->
  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.html</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.js</url-pattern>
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.css</url-pattern>
  </servlet-mapping>
```

2.一个特别容易出错的地方: mapper映射文件无法访问的问题

resources/ewk/code15/mapper/BrandMapper.xml
<br>不要写成<br>
resources/ewk/code15/BrandMapper.xml

3.axios请求不到的问题

需要写出全路径,使用"//",可能需要刷新
package,verify可能有效

4.注意事项
- mapper中的路径
- MybatisConfig中的Bean路径!!!

5.一个奇怪的bug

mapper的xml配置文件中namespace似乎会悄悄发生变化,
可能随着模块改名自动变化了,注意检查.