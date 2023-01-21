package ewk.code14.controller;

import ewk.code14.data.User;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
@Controller
public class UserControllerREST {
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
    public String update(@RequestBody User user) {
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
}
*/

@RestController
@RequestMapping("/users")
public class UserControllerREST {
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
    public String update(@RequestBody User user) {
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
}