package demo.service.security;

import demo.models.entity.securty.Role;
import demo.models.entity.securty.Users;
import demo.repository.security.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Component
@RequiredArgsConstructor
@Slf4j
public class UsersService implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;
    private Set<Role> roles;
    Collection authorities = new ArrayList<>();

    private static final String MSG_USER_NOT_FOUND = "Пользователь с логином %s не найден в системе";

//  Метод для авторизации пользователя по логину (spring security)

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       // Users users = usersRepository.findByLogin(login);
        final Users userEntity = usersRepository.findByLogin(login)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(MSG_USER_NOT_FOUND, login))); //TODO: Создать исключение?
        return new User(userEntity.getLogin(), userEntity.getPassword(), listAuthority(userEntity.getRoles()));
        }

    private Collection<? extends GrantedAuthority> listAuthority(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void register(final Users newUser) throws GeneralSecurityException {
        // Сохраняем нового пользователя
        if (usersRepository.findByLogin(newUser.getLogin()).isPresent()) {
            throw new RuntimeException(String.format("Пользователь с логином  %s уже существует", newUser.getLogin()));
        } else {
            usersRepository.save(newUser);
            log.info("Пользователь с логином : {} успешно зарегистрирован", newUser.getLogin());
        }
    }
    public void delete(String username) {
        usersRepository.deleteByLogin(username);
    }
}