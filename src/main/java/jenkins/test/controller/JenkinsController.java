package jenkins.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JenkinsController {

    @GetMapping("/")
    public String main(){
        return "main";
    }
}
