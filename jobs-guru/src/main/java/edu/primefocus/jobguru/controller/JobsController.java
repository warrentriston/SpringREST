package edu.primefocus.jobguru.controller;

import edu.primefocus.jobguru.dataaccessobject.Jobs;
import edu.primefocus.jobguru.dataaccessobject.Profile;
import edu.primefocus.jobguru.datatransferobject.JobsDTO;
import edu.primefocus.jobguru.datatransferobject.ProfileDTO;
import edu.primefocus.jobguru.mapper.JobMapper;
import edu.primefocus.jobguru.mapper.ProfileMapper;
import edu.primefocus.jobguru.service.JobsService;
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

import java.util.List;

/**
 * This is the controller class that contains the entry points for Profile Table.
 * @author Warren Triston D'Souza
 * @
 */
@RestController
@RequestMapping(path = "/job")
public class JobsController {

    @Autowired
    JobsService jobsService;

    /**
     * This is entry point for creating user credentials
     * @param jobsDTOList {@link JobsDTO} This is a mapper object to convert persistance object {@link Jobs}
     * @return Response object {@link JobsDTO}
     */
    @PostMapping(path = "/create/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDTO create(@RequestBody @NonNull List<JobsDTO> jobsDTOList, @PathVariable("id") @NonNull long id){
        return ProfileMapper.makeProfileDto(jobsService.create(JobMapper.makeJobsList(jobsDTOList), id));
    }
}
