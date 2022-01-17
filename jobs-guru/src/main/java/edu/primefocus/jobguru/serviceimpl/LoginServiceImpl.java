package edu.primefocus.jobguru.serviceimpl;

import edu.primefocus.jobguru.dataaccessobject.Login;
import edu.primefocus.jobguru.repository.LoginRepository;
import edu.primefocus.jobguru.service.LoginService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public Login create(@NonNull final Login login) {
        return loginRepository.save(login);
    }
}
