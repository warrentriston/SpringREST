package edu.primefocus.jobguru.datatransferobject;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class ProfileDTO {

    @NonNull
    String name;

    @NonNull
    String description;

}
