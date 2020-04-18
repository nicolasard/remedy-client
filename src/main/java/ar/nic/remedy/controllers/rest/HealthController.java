package ar.nic.remedy.controllers.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/health")
public class HealthController {
    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody String Health() {
        return "UP";
    }
}