### 一.SpringMvcREST风格
1.REST简介
- 表现形式状态转换
- 分格,不是规范
- 模块名通常使用复数,表示此类资源

优点
- 隐藏资源的访问行为,无法通过地址得知资源是何种操作
- 书写简化

2.REST具体规则: 使用行为动作区分对资源进行了何种操作
- 查询全部用户GET(/users)
- 添加用户POST(/users)
- 修改用户PUT(/users)
- 查询指定用户GET(/users/1)
- 删除用户DELETE(/users/1)
```
@RequestMapping(value = "/users", method = RequestMethod.POST)
@ResponseBody
public String save() {
    System.out.println("save...");
    return "{'users': 'save'}";
}

@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
@ResponseBody
public String delete(@PathVariable Integer id) {
    System.out.println("delete " + id);
    return "{'users':'delete'}";
}

@RequestMapping(value = "/users", method = RequestMethod.PUT)
@ResponseBody
public String delete(@RequestBody ewk.code16.data.User user) {
    System.out.println("user update " + user);
    return "{'users':'update'}";
}

@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
@ResponseBody
public String getById(@PathVariable Integer id) {
    System.out.println("user getById " + id);
    return "{'users':'getById'}";
}

@RequestMapping(value = "/users", method = RequestMethod.GET)
@ResponseBody
public String getAll() {
    System.out.println("user getAll ");
    return "{'users':'getAll'}";
}
```

3.REST快速开发
- PostMapping
- DeleteMapping
- PutMapping
- GetMapping

@Controller及@ResponseBody合并为: @RestController

@RequestMapping("/users"): 公共路径
```
@PostMapping
public String save() {
    System.out.println("save...");
    return "{'users': 'save'}";
}

@DeleteMapping("/{id}")
public String delete(@PathVariable Integer id) {
    System.out.println("delete " + id);
    return "{'users':'delete'}";
}

@PutMapping
public String update(@RequestBody ewk.code16.data.User user) {
    System.out.println("user update " + user);
    return "{'users':'update'}";
}

@GetMapping("/{id}")
public String getById(@PathVariable Integer id) {
    System.out.println("user getById " + id);
    return "{'users':'getById'}";
}

@GetMapping()
public String getAll() {
    System.out.println("user getAll ");
    return "{'users':'getAll'}";
}
```

