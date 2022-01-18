package edu.primefocus.jobguru.serviceimpl;

import edu.primefocus.jobguru.dataaccessobject.Login;
import edu.primefocus.jobguru.dataaccessobject.Profile;
import edu.primefocus.jobguru.repository.LoginRepository;
import edu.primefocus.jobguru.repository.ProfileRepository;
import edu.primefocus.jobguru.service.LoginService;
import edu.primefocus.jobguru.service.ProfileService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    LoginRepository loginRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public Profile create(@NonNull final Profile profile, @NonNull final long id) {
        Profile.ProfileBuilder profileBuilder = profile.toBuilder();
        return profileRepository.save(profileBuilder.login(loginRepository.getById(id)).build());
    }
}


