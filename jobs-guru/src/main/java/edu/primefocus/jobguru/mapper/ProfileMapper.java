package edu.primefocus.jobguru.mapper;

import edu.primefocus.jobguru.dataaccessobject.Login;
import edu.primefocus.jobguru.dataaccessobject.Profile;
import edu.primefocus.jobguru.datatransferobject.LoginDTO;
import edu.primefocus.jobguru.datatransferobject.ProfileDTO;
import lombok.NonNull;

public class ProfileMapper {

    /**
     * This method converts transfer object {@link ProfileDTO} to persistance object {@link Profile}
     * @param profileDTO {@link ProfileDTO} that needs to be converted to {@link Profile}
     * @return converted {@link Profile}
     */
    @NonNull
    public static Profile makeProfile(@NonNull final ProfileDTO profileDTO){
        return Profile.builder().name(profileDTO.getName())
                .description(profileDTO.getDescription())
                .build();
    }

    /**
     * This method converts persistance object {@link Profile} to transfer object {@link ProfileDTO}
     * @param profile {@link Profile} that needs to be converted to {@link ProfileDTO}
     * @return converted {@link ProfileDTO}
     */
    @NonNull
    public static ProfileDTO makeProfileDto(@NonNull final Profile profile){
        return ProfileDTO.builder().name(profile.getName())
                .description(profile.getDescription())
                .jobsList(profile.getJob())
                .build();
    }
}
