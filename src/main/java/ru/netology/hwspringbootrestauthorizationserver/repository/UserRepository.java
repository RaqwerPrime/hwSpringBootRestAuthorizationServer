package ru.netology.hwspringbootrestauthorizationserver.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hwspringbootrestauthorizationserver.domain.User;
import ru.netology.hwspringbootrestauthorizationserver.service.Authorities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(User user) {

        String login = user.getLogin();
        String password = user.getPassword();

        if ("admin".equals(login) && "admin123".equals(user.getPassword())) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if ("user".equals(login) && "user123".equals(user.getPassword())) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE);
        } else if ("reader".equals(login) && "reader123".equals(user.getPassword())) {
            return Collections.singletonList(Authorities.READ);
        } else {
            return Collections.emptyList();
        }
    }

}
