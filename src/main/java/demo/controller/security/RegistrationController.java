package demo.controller.security;

import demo.models.entity.securty.Users;
import demo.service.security.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    /*private final UsersService userService;
    public static final String REGISTRATION_URL = "/registration";

    public void registrationUser(final Users newUser){
        userService.register(newUser);
    }*/
}
