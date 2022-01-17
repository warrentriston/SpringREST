package edu.primefocus.jobguru.mapper;

import edu.primefocus.jobguru.dataaccessobject.Login;
import edu.primefocus.jobguru.datatransferobject.LoginDTO;
import lombok.NonNull;

public class LoginMapper {

    /**
     * This method converts transfer object {@link LoginDTO} to persistance object {@link Login}
     * @param loginDTO {@link LoginDTO} that needs to be converted to {@link Login}
     * @return converted {@link Login}
     */
    @NonNull
    public static Login makeLogin(@NonNull final LoginDTO loginDTO){
        return Login.builder().userName(loginDTO.getUsername())
                .password(loginDTO.getPassword())
                .role(loginDTO.getRole())
                .build();
    }

    /**
     * This method converts persistance object {@link Login} to transfer object {@link LoginDTO}
     * @param login {@link Login} that needs to be converted to {@link LoginDTO}
     * @return converted {@link LoginDTO}
     */
    @NonNull
    public static LoginDTO makeLoginDto(@NonNull final Login login){
        return LoginDTO.builder().username(login.getUserName())
                .password(login.getPassword())
                .role(login.getRole())
                .build();
    }
}
