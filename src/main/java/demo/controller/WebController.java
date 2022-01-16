package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

        @GetMapping("/login")
        public String loginPage(Model model){
            return "login";
        }

        @GetMapping("/admin")
        public String admin() {
            return "admin";
         }

        @GetMapping("/user")
        public String user() {
            return "user";
        }
}

