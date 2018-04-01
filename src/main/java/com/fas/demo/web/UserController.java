package com.fas.demo.web;

import com.fas.demo.entity.User;
import com.fas.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Api
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/user/list";
    }

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size) {

//        List<User> users = userService.getUserList();
        PageRequest request = PageRequest.of(page, size);
        Page<User> users = userService.findList(request);
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        Optional<User> optionalUser = userService.findUserById(id);
        User user = optionalUser.get();
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/user/list";
    }
}
