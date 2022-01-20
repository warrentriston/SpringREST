package edu.primefocus.jobguru.datatransferobject;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class JobsDTO {

    @NonNull
    String jobRole;

    @NonNull
    String description;

}
