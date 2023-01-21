package ewk.code14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
    // @RequestMapping("/save")
    // @RequestMapping("/admin/save")
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("save...");
        return "{'admin': 'save'}";
    }

    // @RequestMapping("/delete")
    // @RequestMapping("/admin/delete")
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        System.out.println("delete");
        return "{'admin':'delete'}";
    }
}
