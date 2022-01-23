package demo.repository.security;

import demo.models.entity.securty.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByLogin(final String login);

    boolean existsByLogin(String login);

    @Transactional
    void deleteByLogin(String login);

}
