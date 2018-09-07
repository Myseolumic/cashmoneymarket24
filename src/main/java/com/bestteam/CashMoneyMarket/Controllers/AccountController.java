package com.bestteam.CashMoneyMarket.Controllers;

import com.bestteam.CashMoneyMarket.Models.Account;
import com.bestteam.CashMoneyMarket.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/register")
    public String register() {
        Account account = new Account();
        account.setEmail("test@test.com");
        account.setName("Peeter");
        accountRepository.save(account);
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        Account account = accountRepository.findById(Long.valueOf(1)).get();
        System.out.println(account.getEmail());
        return "index";
    }
}
