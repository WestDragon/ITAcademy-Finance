package by.itacademy.user.service;

import by.itacademy.user.controller.dto.LoginDto;
import by.itacademy.user.service.api.IAuthService;
import by.itacademy.user.service.api.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private final IUserService userService;
    private final PasswordEncoder encoder;
    private final UserHolder holder;

    public AuthService(IUserService userService, PasswordEncoder encoder,
                       UserHolder holder) {
        this.userService = userService;
        this.encoder = encoder;
        this.holder = holder;
    }


    @Override
    public UserDetails login(LoginDto loginDto) {
        UserDetails details = this.userService.getByLogin(loginDto.getLogin());

        if(details == null || !encoder.matches(loginDto.getPassword(), details.getPassword())){
            throw new IllegalArgumentException("Логин или пароль неверный");
        }

        return details;
    }

    @Override
    public UserDetails me() {
        return holder.getUser();
    }
}
