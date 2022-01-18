package edu.primefocus.jobguru.service;

import edu.primefocus.jobguru.dataaccessobject.Login;
import edu.primefocus.jobguru.dataaccessobject.Profile;


public interface ProfileService {

    /**
     * This method is to call the save service call to create profile of a user
     * @param profile Object that contains profile details
     * @param id id of the user to whom the profile has to be linked to.
     * @return {@link Profile} object if inserted successfully
     */
    public Profile create(Profile profile, long id);
}
