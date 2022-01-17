package edu.primefocus.jobguru.service;

import edu.primefocus.jobguru.dataaccessobject.Login;
import org.springframework.stereotype.Service;


public interface LoginService {

    /**
     * This method is to call the save service call to create login credentials
     * @param login Object that contains login details, cannot be duplicate
     * @return {@link Login} object if inserted successfully
     */
    public Login create(Login login);
}
