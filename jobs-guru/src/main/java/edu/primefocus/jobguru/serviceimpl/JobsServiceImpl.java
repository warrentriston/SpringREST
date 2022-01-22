package edu.primefocus.jobguru.serviceimpl;

import edu.primefocus.jobguru.dataaccessobject.Jobs;
import edu.primefocus.jobguru.dataaccessobject.Profile;
import edu.primefocus.jobguru.repository.JobsRepository;
import edu.primefocus.jobguru.repository.LoginRepository;
import edu.primefocus.jobguru.repository.ProfileRepository;
import edu.primefocus.jobguru.service.JobsService;
import edu.primefocus.jobguru.service.ProfileService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobsServiceImpl implements JobsService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    JobsRepository jobsRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public Profile create(List<Jobs> jobsList, long id) {
        List<Jobs> jobs = jobsList.stream().map(job -> job.toBuilder().profile(profileRepository.getByProfileId(id)).build()).collect(Collectors.toList());
        jobsRepository.saveAll(jobs);
        return profileRepository.getByProfileId(id);
    }

    @Override
    public Profile applyJob(long profileId, long jobId) {
        Jobs job = jobsRepository.findById(jobId).get();
        jobsRepository.save(job.toBuilder().profileList(Arrays.asList(profileRepository.getById(profileId))).build());
        return profileRepository.getByProfileId(profileId);
    }


}


