package edu.primefocus.jobguru.controller;

import edu.primefocus.jobguru.dataaccessobject.Login;
import edu.primefocus.jobguru.dataaccessobject.Profile;
import edu.primefocus.jobguru.datatransferobject.LoginDTO;
import edu.primefocus.jobguru.datatransferobject.ProfileDTO;
import edu.primefocus.jobguru.mapper.LoginMapper;
import edu.primefocus.jobguru.mapper.ProfileMapper;
import edu.primefocus.jobguru.service.LoginService;
import edu.primefocus.jobguru.service.ProfileService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the controller class that contains the entry points for Profile Table.
 * @author Warren Triston D'Souza
 * @
 */
@RestController
@RequestMapping(path = "/profile")
public class ProfileController {

    @Autowired
    LoginService loginService;

    @Autowired
    ProfileService profileService;

    /**
     * This is entry point for creating user credentials
     * @param profileDTO {@link ProfileDTO} This is a mapper object to convert persistance object {@link Profile}
     * @return Response object {@link ProfileDTO}
     */
    @PostMapping(path = "/create/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDTO create(@RequestBody @NonNull ProfileDTO profileDTO, @PathVariable("id") @NonNull long id){
        return ProfileMapper.makeProfileDto(profileService.create(ProfileMapper.makeProfile(profileDTO), id));
    }
}
