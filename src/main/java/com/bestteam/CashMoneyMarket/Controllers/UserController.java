package com.bestteam.CashMoneyMarket.Controllers;

import com.bestteam.CashMoneyMarket.Models.User;
import com.bestteam.CashMoneyMarket.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String submitUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String description,
                             @RequestParam String eMail,
                             @RequestParam String phoneNumber) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setDescription(description);
        user.seteMail(eMail);
        user.setPhoneNumber(phoneNumber);

        userRepository.save(user);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "submitpost";
    }
}
