package com.bestteam.CashMoneyMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableJpaAuditing
@RestController
public class CashMoneyMarketApplication {

    @RequestMapping("/user")
    public Principal user(Principal principal, Model model) {
        return principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(CashMoneyMarketApplication.class, args);
    }
}
