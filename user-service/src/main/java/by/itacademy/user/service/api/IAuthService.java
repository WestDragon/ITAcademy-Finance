package by.itacademy.user.service.api;

import by.itacademy.user.controller.dto.LoginDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface IAuthService {
    UserDetails login(LoginDto loginDto);
    UserDetails me();
}
