package by.itacademy.user.controller;

import by.itacademy.user.controller.dto.LoginDto;
import by.itacademy.user.controller.utils.JwtTokenHandler;
import by.itacademy.user.service.api.IAuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cabinet")
public class CabinetController {

    private final IAuthService authService;
    private final JwtTokenHandler jwtHandler;

    public CabinetController(IAuthService authService, JwtTokenHandler jwtHandler) {
        this.authService = authService;
        this.jwtHandler = jwtHandler;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody LoginDto loginDto){
        UserDetails details = this.authService.login(loginDto);

        return jwtHandler.generateAccessToken(details);
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public UserDetails me(){
        return authService.me();
    }


    @RequestMapping(value = "/anon", method = RequestMethod.GET)
    public String anon(){
        return "anon";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(){
        return "admin";
    }

}
