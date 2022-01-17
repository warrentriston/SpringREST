package edu.primefocus.jobguru.controller;

import edu.primefocus.jobguru.dataaccessobject.Login;
import edu.primefocus.jobguru.datatransferobject.LoginDTO;
import edu.primefocus.jobguru.mapper.LoginMapper;
import edu.primefocus.jobguru.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the controller class that contains the entry points for Login Table.
 * @author Warren Triston D'Souza
 * @
 */
@RestController
@RequestMapping(path = "/login")
public class loginController {

    @Autowired
    LoginService loginService;
    /**
     * This is entry point for creating user credentials
     * @param loginDTO {@link LoginDTO} This is a mapper object to convert persistance object {@link Login}
     * @return Response object {@link LoginDTO}
     */
    @PostMapping(path = "/create",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginDTO create(LoginDTO loginDTO){
        return LoginMapper.makeLoginDto(loginService.create(LoginMapper.makeLogin(loginDTO)));
    }
}
