package ru.netology.hwspringbootrestauthorizationserver.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hwspringbootrestauthorizationserver.Authorities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if ("admin".equals(user) && "admin123".equals(password)) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if ("user".equals(user) && "user123".equals(password)) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE);
        } else if ("reader".equals(user) && "reader123".equals(password)) {
            return Collections.singletonList(Authorities.READ);
        } else {
            return Collections.emptyList();
        }
    }

}
