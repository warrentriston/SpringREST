package edu.primefocus.jobguru.mapper;

import edu.primefocus.jobguru.dataaccessobject.Jobs;
import edu.primefocus.jobguru.datatransferobject.JobsDTO;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class JobMapper {

    /**
     * This method converts transfer object {@link JobsDTO} to persistance object {@link Jobs}
     * @param JobsDTO {@link JobsDTO} that needs to be converted to {@link Jobs}
     * @return converted {@link Jobs}
     */
    @NonNull
    public static Jobs makeJobs(@NonNull final JobsDTO JobsDTO){
        return Jobs.builder().joRole(JobsDTO.getJobRole())
                .description(JobsDTO.getDescription())
                .build();
    }

    public static List<Jobs> makeJobsList(List<JobsDTO> jobsDTOList){
        return jobsDTOList.stream().map(JobMapper::makeJobs).collect(Collectors.toList());
    }

    public static List<JobsDTO> makeJobsDTOList(List<Jobs> jobsList){
        return jobsList.stream().map(JobMapper::makeJobsDto).collect(Collectors.toList());
    }

    /**
     * This method converts persistance object {@link Jobs} to transfer object {@link JobsDTO}
     * @param Jobs {@link Jobs} that needs to be converted to {@link JobsDTO}
     * @return converted {@link JobsDTO}
     */
    @NonNull
    public static JobsDTO makeJobsDto(@NonNull final Jobs Jobs){
        return JobsDTO.builder().jobRole(Jobs.getJoRole())
                .description(Jobs.getDescription())
                .build();
    }
}
