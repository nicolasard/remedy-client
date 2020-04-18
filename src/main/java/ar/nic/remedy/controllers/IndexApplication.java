package ar.nic.remedy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexApplication {
    @GetMapping("/")
    public String Index() {
        return "index";
    }
}
