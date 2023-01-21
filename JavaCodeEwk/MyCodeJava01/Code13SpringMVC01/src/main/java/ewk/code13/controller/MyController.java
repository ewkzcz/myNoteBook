package ewk.code13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("save...");
        return "{'info': 'springmvc'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        System.out.println("delete");
        return "{'module':'springmvc delete'}";
    }
}
