package ru.netology.hwspringbootrestauthorizationserver.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Validator;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.hwspringbootrestauthorizationserver.customAnotation.UserParams;
import ru.netology.hwspringbootrestauthorizationserver.domain.User;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    private final Validator validator;

    public UserArgumentResolver(Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserParams.class) &&
                parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        String login = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");

        if (login == null || login.length() < 3 || login.length() > 15) {
            throw new IllegalArgumentException("Логин должен быть не менее 3 и не больше 15 символов!");
        }

        if (password == null || password.length() < 4 || password.length() > 20) {
            throw new IllegalArgumentException("Пароль должен быть не менее 4 и не больше 20 символов!");
        }

        return new User(login, password);
    }
}
