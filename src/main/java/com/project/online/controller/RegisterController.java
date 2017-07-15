package com.project.online.controller;

import com.project.online.model.User;
import com.project.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String registerUser(Model model) {

        User user = new User();

        model.addAttribute("user", user);

        return "registerUser";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserPost(@Valid @ModelAttribute("user") User user, BindingResult result, Model
            model) {

        if (result.hasErrors()) {
            return "registerUser";
        }

        List<User> userList = userService.getAllUsers();

        for (User anUserList : userList)
        {
            if (user.getEmail().equals(anUserList.getEmail())) {
               model.addAttribute("emailMsg", "Email already exists.");

               return "registerUser";
            }

            if (user.getUserName().equals(anUserList.getUserName())) {

                model.addAttribute("userNameMsg", "Username already exists.");

                return "registerUser";
            }
        }
        user.setEnabled();
        userService.addUser(user);

        return "registerUserSuccess";
    }


}
