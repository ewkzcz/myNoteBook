package ewk.code16.controller;

import ewk.code16.data.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
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