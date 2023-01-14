package ewk.code05;

import com.alibaba.fastjson.JSON;

/*
Fastjson: 阿里巴巴提供Java语言json库,实现Java对象和json字符串的相互转换
使用:
导入坐标(fastjson)
Java对象转json: JSON.toJSONString(obj) 响应数据
JSON字符串转Java对象: JSON.parseObject(jsonStr,DataClass.class) 请求数据
 */
public class Main10JSON {
    public static void main(String[] args) {
        // 1.将Java对象转为JSON字符串
        Data data = new Data();
        data.setId(1001);
        data.setName("zcz");
        data.setAge(20);
        data.setBir("2002-01-01");
        String jsonString = JSON.toJSONString(data);
        System.out.println(jsonString);

        // 2.将JSON字符串转为Java对象
        Data data1 = JSON.parseObject("{\"age\":20,\"bir\":\"2002-01-01\",\"id\":1001,\"name\":\"zcz\"}",
                Data.class);
        System.out.println(data1);
    }
}
