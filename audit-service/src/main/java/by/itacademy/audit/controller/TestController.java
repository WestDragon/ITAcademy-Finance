package by.itacademy.audit.controller;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TestController {


    @PermitAll
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "task";
    }


    //Три аннотации делают одно и тоже
    @Secured("ROLE_ADMIN")
    @RolesAllowed("ADMIN")
    @PreAuthorize("hasRole('ADMIN')")

    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    public String secured(){
        return "secured product";
    }
}
