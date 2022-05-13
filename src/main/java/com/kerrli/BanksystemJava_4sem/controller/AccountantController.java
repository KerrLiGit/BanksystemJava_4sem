package com.kerrli.BanksystemJava_4sem.controller;

import com.kerrli.BanksystemJava_4sem.service.AccountantService;
import com.kerrli.BanksystemJava_4sem.util.Lib;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AccountantController {
    AccountantService accountantService;

    public AccountantController() {
        accountantService = new AccountantService();
    }

    @PostMapping("/change_currency_cost")
    public String changeCurrencyCost(@RequestParam String currency, @RequestParam double buy,
                              @RequestParam double cost, @RequestParam double sell,
                              HttpSession httpSession) {
        try {
            accountantService.setCourse(currency, buy, cost, sell);
            Lib.setAttribute(httpSession, "report_change_currency_cost", "Курс валюты обновлен. ");
        }
        catch (Exception e) {
            Lib.setAttribute(httpSession, "error_change_currency_cost", "Курс валюты не обновлен. " +
                    e.getMessage());
        }
        return "redirect:/acc#change_currency_cost";
    }
}
