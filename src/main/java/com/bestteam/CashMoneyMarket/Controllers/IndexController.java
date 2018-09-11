package com.bestteam.CashMoneyMarket.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
    @RequestMapping(name = "/")
    public String getTestPage() {
        return ("/index");
    }
}
