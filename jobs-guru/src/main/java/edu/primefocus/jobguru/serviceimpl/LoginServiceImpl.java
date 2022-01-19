package edu.primefocus.jobguru.serviceimpl;

import edu.primefocus.jobguru.dataaccessobject.Login;
import edu.primefocus.jobguru.repository.LoginRepository;
import edu.primefocus.jobguru.service.LoginService;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public Login create(@NonNull final Login login) {
        log.debug("Inside create method");
        return loginRepository.save(login);
    }
}
