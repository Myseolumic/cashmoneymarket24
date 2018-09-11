package com.bestteam.CashMoneyMarket.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {
    @RequestMapping(name = "/login", method = RequestMethod.GET)
    public String getTestPage() {
        return ("/login");
    }
}
