package demo.controller.security;

import demo.models.entity.securty.Users;
import demo.service.security.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.GeneralSecurityException;

@RestController
//@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UsersService usersService;
    public static final String REGISTRATION_URL = "/registration";

    @PostMapping(REGISTRATION_URL)
    public void registrationUser(@RequestBody final Users newUser) throws GeneralSecurityException {
        usersService.register(newUser);
    }
}
