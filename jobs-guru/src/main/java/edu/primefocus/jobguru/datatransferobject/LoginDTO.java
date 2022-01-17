package edu.primefocus.jobguru.datatransferobject;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class LoginDTO {

    @NonNull
    String username;
    @NonNull
    String password;
    @NonNull
    String role;

}
