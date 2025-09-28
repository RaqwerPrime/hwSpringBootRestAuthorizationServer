package ru.netology.hwspringbootrestauthorizationserver.service;

import org.springframework.stereotype.Service;
import ru.netology.hwspringbootrestauthorizationserver.domain.User;
import ru.netology.hwspringbootrestauthorizationserver.exception.InvalidCredentials;
import ru.netology.hwspringbootrestauthorizationserver.exception.UnauthorizedUser;
import ru.netology.hwspringbootrestauthorizationserver.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getLogin()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

