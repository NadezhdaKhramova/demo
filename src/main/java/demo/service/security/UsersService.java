package demo.service.security;

import demo.models.entity.securty.Role;
import demo.models.entity.securty.Users;
import demo.repository.security.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Component
@RequiredArgsConstructor
@Slf4j
public class UsersService implements UserDetailsService {

    private UserRepository usersRepository;
    private Set<Role> roles;
    Collection authorities = new ArrayList();

    private static final String MSG_USER_NOT_FOUND = "Пользователь с логином %s не найден в системе";

//  Метод для авторизации пользователя по логину (spring security)

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Users users = usersRepository.findByLogin(login);
        if(users == null) {
            throw new UsernameNotFoundException(String.format(MSG_USER_NOT_FOUND,login));
        }
       // List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(roles.getRoles()));
        return new User(users.getLogin(), users.getPassword(),listAuthority(users.getRoles()));
    }

    private Collection<? extends GrantedAuthority> listAuthority(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
    }
}
