package ewk.code14.controller;

import ewk.code14.data.Address;
import ewk.code14.data.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    // 设置请求响应路径
    // @RequestMapping("/save")
    // @RequestMapping("/user/save")

    /* 普通参数: 参数名相同
    @RequestMapping("/save")
    @ResponseBody
    public String save(String name,int age) {
        System.out.println("普通参数传递 "+name);
        System.out.println("普通参数传递 "+age);
        return "{'user': 'save'}";
    }
     */

    // 普通参数: 参数名不同的处理
    // @RequestParam("name"): 将请求中的参数传递给对应的方法形参
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestParam("name") String username, @RequestParam("age") int age) {
        System.out.println("普通参数传递 " + username);
        System.out.println("普通参数传递 " + age);
        return "{'user': 'save'}";
    }

    // POJO参数传递
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("pojo参数传递 " + user);
        return "{'pojo':'good'";
    }

    // POJO嵌套参数传递
    @RequestMapping("/pojoContainPOJOParam")
    @ResponseBody
    public String pojoContainPOJOParam(User user) {
        System.out.println("pojo嵌套参数传递 " + user);
        return "{'pojo-in':'good'";
    }

    // 数组参数传递
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes) {
        System.out.println("数组参数传递 " + Arrays.toString(likes));
        return "{'array':'good'}";
    }

    // 集合参数传递
    @RequestMapping("/listParam")
    @ResponseBody
    public String arrayParam(@RequestParam List<String> likes) {
        System.out.println("集合参数传递 " + likes);
        return "{'set':'good'}";
    }

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
    public String pojoParamJSON(@RequestBody User user) {
        System.out.println("pojo-json参数传递 " + user);
        return "{'pojo-json':'good'}";
    }

    // json格式POJO集合参数
    @RequestMapping("/pojoListParamJSON")
    @ResponseBody
    public String pojoListParamJSON(@RequestBody List<User> list) {
        System.out.println("list(pojo)-json参数传递 " + list);
        return "{'list(pojo)-json':'good'}";
    }

    // 日期参数传递
    @RequestMapping("/date")
    @ResponseBody
    public String pojoListParamJSON(Date date1,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date3) {
        System.out.println("date数据传递"+date1);
        System.out.println("date数据传递"+date2);
        System.out.println("date数据传递"+date3);
        return "{'date':'good'}";
    }

    // 响应jsp页面
    @RequestMapping("/jumpPage")  // user/jumpPage
    public String jumpPage(){
        System.out.println("jump");
        // return "jump.jsp";
        return "../jump.jsp";  // 如果在类上方配置了公共路径,需要到上一层目录寻找jsp文件
    }

    // 响应文本数据
    @RequestMapping("/returnText")  // user/returnText
    @ResponseBody
    public String returnText(){
        System.out.println("纯文本数据");
        return "纯文本数据";
    }

    // 响应json数据
    @RequestMapping("/returnJSON")  // user/returnJSON
    @ResponseBody
    public User returnJSON(){
        System.out.println("json数据");
        User user = new User();
        user.setName("ewk");
        user.setAge(20);
        Address address = new Address();
        address.setProvince("湖南省");
        address.setCity("常德市");
        user.setAddress(address);
        return user;  // ResponseBody声明后,json依赖自动转换为json数据
    }

    // 响应json数据(POJO集合对象)
    @RequestMapping("/returnJSONList")  // user/returnJSONList
    @ResponseBody
    public List<User> returnJSONList(){
        System.out.println("jsonList数据");
        User user1 = new User();
        user1.setName("ewk");
        user1.setAge(20);
        Address address1 = new Address();
        address1.setProvince("湖南省");
        address1.setCity("常德市");
        user1.setAddress(address1);
        User user2 = new User();
        user2.setName("ewk");
        user2.setAge(20);
        Address address2 = new Address();
        address2.setProvince("湖南省");
        address2.setCity("常德市");
        user2.setAddress(address2);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        return userList;  // ResponseBody声明后,json依赖自动转换为json数据
    }
}
