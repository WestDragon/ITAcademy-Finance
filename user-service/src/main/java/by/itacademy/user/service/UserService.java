package by.itacademy.user.service;

import by.itacademy.user.service.api.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserDetailsManager userDetailsManager;

    public UserService(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    @Override
    public UserDetails getByLogin(String login) {
        try{
            return userDetailsManager.loadUserByUsername(login);
        } catch (UsernameNotFoundException ex){
            return null;
        }
    }
}
