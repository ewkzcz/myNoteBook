##### 1.文件夹级别注意点
- Java文件夹与resources文件夹位于同级
- 不能把resources放在Java文件夹下

##### 2.maven执行JUnit单元测试时，控制台中文乱码
添加后注意需要刷新
```
<build>
<pluginManagement>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>2.12.4</version>
      <configuration>
        <argLine>-Dfile.encoding=GBK</argLine>
      </configuration>
    </plugin>
  </plugins>
</pluginManagement>
</build>
```