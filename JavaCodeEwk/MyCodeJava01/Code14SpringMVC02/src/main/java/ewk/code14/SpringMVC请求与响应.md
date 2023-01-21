### 一.SpringMVC请求与响应

1.设置请求响应路径

当不同控制器出现相同访问路径时,访问会出现错误

解决办法1: 需要给访问路径加上前缀(通常为模块名) <br>
例如: ```@RequestMapping("/save")``` <br>
改为: ```@RequestMapping("/user/save")```

解决办法2: 统一的请求路径前缀 <br>
例如: ```@RequestMapping("/user")``` <br>
```@RequestMapping("/admin")```

2.工具Apifox(相当于postman) <br>
https://www.apifox.cn/ <br>
作用: 方便对网页进行get/post请求,从而测试

3.get和post请求(普通参数) <br>
3.1注意点: 被调用的方法参数名必须与get/post的参数名相同
```
@RequestMapping("/save")
@ResponseBody
public String save(String name,int age) {
    System.out.println("普通参数传递 "+name);
    System.out.println("普通参数传递 "+age);
    return "{'user': 'save'}";
}
```
3.2传参中文乱码问题解决
```
// 中文乱码处理
@Override
protected Filter[] getServletFilters() {
    CharacterEncodingFilter filter = new CharacterEncodingFilter();
    filter.setEncoding("UTF-8");
    return new Filter[]{filter};
}
```
3.3被调用的方法参数名必须与get/post的参数名不同的解决办法 <br>
@RequestParam(""): 将请求中的参数传递给对应的方法形参
```
// 普通参数: 参数名不同
// @RequestParam("name"): 将请求中的参数传递给对应的方法形参
public String save(@RequestParam("name") String username,@RequestParam("age") int age) {
    System.out.println("普通参数传递 "+username);
    System.out.println("普通参数传递 "+age);
    return "{'user': 'save'}";
}
```

4.get和post请求(5种参数)
- 普通参数
- POJO参数(传递对象作为参数)
- 嵌套POJO参数
- 数组参数
- 集合参数

```
// POJO参数
@RequestMapping("/pojoParam")
@ResponseBody
public String pojoParam(ewk.code16.data.User user){
    System.out.println("pojo参数传递 "+user);
    return "{'pojo':'good'";
}
```
```
// POJO嵌套参数
@RequestMapping("/pojoContainPOJOParam")
@ResponseBody
public String pojoContainPOJOParam(ewk.code16.data.User user){
    System.out.println("pojo嵌套参数传递 "+user);
    return "{'pojo-in':'good'";
}
```
```
// 集合参数传递
// @RequestParam绑定参数关系
@RequestMapping("/listParam")
@ResponseBody
public String arrayParam(@RequestParam List<String> likes){
    System.out.println("集合参数传递 "+ likes);
    return "{'set':'good'}";
}
```

5.json数据传递
- json格式集合参数
- json格式POJO参数
- json格式POJO集合参数

5.1步骤一: 首先导入json坐标
```
<!-- json坐标 -->
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.14.0 </version>
</dependency>
```

5.2步骤二: 开启json数据转换为对象的功能
```@EnableWebMvc```

5.3步骤三: @RequestBody将请求体交给形参

注意: json数据中嵌套POJO数据不传值,会发生错误
```
// json格式集合参数
@RequestMapping("/listParamJSON")
@ResponseBody
public String listParamJSON(@RequestBody List<String> list) {
    System.out.println("list-json参数传递 " + list);
    return "{'list-json':'good'}";
}
// json格式POJO参数
@RequestMapping("/pojoParamJSON")
@ResponseBody
public String pojoParamJSON(@RequestBody ewk.code16.data.User user) {
    System.out.println("pojo-json参数传递 " + user);
    return "{'pojo-json':'good'}";
}
// json格式POJO集合参数
@RequestMapping("/pojoListParamJSON")
@ResponseBody
public String pojoListParamJSON(@RequestBody List<ewk.code16.data.User> list) {
    System.out.println("list(pojo)-json参数传递 " + list);
    return "{'list(pojo)-json':'good'}";
}
```

5.日期参数传递
默认情况下,
- 能识别类似: 2022/01/01,2022/1/01
- 不能识别类似: 2022-01-01

特别地,可以通过@DateTimeFormat(pattern = "yyyy-MM-dd")
指定日期格式
```
// 日期参数传递
@RequestMapping("/date")
@ResponseBody
public String pojoListParamJSON(Date date1,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date2) {
    System.out.println("date数据传递"+date1);
    System.out.println("date数据传递"+date2);
    return "{'date':'good'}";
}
```

6.响应 

关于路径
- "./": 代表目前所在的目录
- "../": 代表上一层目录
- "/": 代表根目录

6.1响应页面
```
// 响应jsp页面
@RequestMapping("/jumpPage")  // user/jumpPage
public String jumpPage(){
    System.out.println("jump");  
    // return "jump.jsp";
    return "../jump.jsp";  // 如果在类上方配置了公共路径,需要到上一层目录寻找jsp文件
}
```
6.2响应纯文本
```
// 响应文本数据
@RequestMapping("/returnText")  // user/returnText
@ResponseBody
public String returnText(){
    System.out.println("纯文本数据");
    return "纯文本数据";
}
```
6.3响应json数据
```
// 响应json数据
@RequestMapping("/returnJSON")  // user/returnJSON
@ResponseBody
public ewk.code16.data.User returnJSON(){
    System.out.println("json数据");
    ewk.code16.data.User user = new ewk.code16.data.User();
    user.setName("ewk");
    user.setAge(20);
    ewk.code16.data.Address address = new ewk.code16.data.Address();
    address.setProvince("湖南省");
    address.setCity("常德市");
    user.setAddress(address);
    return user;  // ResponseBody声明后,json依赖自动转换为json数据
}

// 响应json数据(POJO集合对象)
@RequestMapping("/returnJSONList")  // user/returnJSONList
@ResponseBody
public List<ewk.code16.data.User> returnJSONList(){
    System.out.println("jsonList数据");
    ewk.code16.data.User user1 = new ewk.code16.data.User();
    user1.setName("ewk");
    user1.setAge(20);
    ewk.code16.data.Address address1 = new ewk.code16.data.Address();
    address1.setProvince("湖南省");
    address1.setCity("常德市");
    user1.setAddress(address1);
    ewk.code16.data.User user2 = new ewk.code16.data.User();
    user2.setName("ewk");
    user2.setAge(20);
    ewk.code16.data.Address address2 = new ewk.code16.data.Address();
    address2.setProvince("湖南省");
    address2.setCity("常德市");
    user2.setAddress(address2);
    List<ewk.code16.data.User> userList = new ArrayList<>();
    userList.add(user1);
    userList.add(user2);
    return userList;  // ResponseBody声明后,json依赖自动转换为json数据
}
```