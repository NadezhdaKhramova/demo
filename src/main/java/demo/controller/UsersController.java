package demo.controller;

import demo.models.entity.securty.Users;
import demo.service.security.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.GeneralSecurityException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsersController {

    private static final String USER_URL_REGISTER = "/register";
    private final UsersService usersService;


    @PostMapping(USER_URL_REGISTER)
    public ResponseEntity registrationUser(@Valid @RequestBody final Users newUser) throws GeneralSecurityException {
        usersService.register(newUser);
        return null;
    }

}
