package by.itacademy.user.service.api;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
    UserDetails  getByLogin(String login);
}
