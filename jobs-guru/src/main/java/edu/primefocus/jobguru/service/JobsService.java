package edu.primefocus.jobguru.service;

import edu.primefocus.jobguru.dataaccessobject.Jobs;
import edu.primefocus.jobguru.dataaccessobject.Profile;

import java.util.List;


public interface JobsService {

    /**
     * This method is to call the save service call to create profile of a user
     * @param jobsList List of Objects that contains jobs details
     * @param id id of the company profile to whom the job has to be linked to.
     * @return {@link Profile} object if inserted successfully
     */
    public Profile create(List<Jobs> jobsList, long id);
}
