package edu.primefocus.jobguru.datatransferobject;

import edu.primefocus.jobguru.dataaccessobject.Jobs;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

import java.util.List;

@Builder
@Value
public class ProfileDTO {

    @NonNull
    String name;

    @NonNull
    String description;

    @Nullable
    List<Jobs> jobsList;

    @Nullable
    List<Jobs> appliedJobsList;
}
