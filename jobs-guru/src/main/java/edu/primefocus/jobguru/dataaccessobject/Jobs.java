package edu.primefocus.jobguru.dataaccessobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tbl_job")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Jobs {

    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long jobId;

    @NonNull
    @Column(name = "job_role", nullable = false)
    String joRole;

    @Column(name = "description", nullable = false)
    String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id",
                referencedColumnName = "profile_id")
    Profile profile;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "tbl_user_jobs",
            joinColumns = @JoinColumn(
                    name = "job_id",
                    referencedColumnName = "job_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "profile_id",
                    referencedColumnName = "profile_id"
            )
    )
    List<Profile> profileList;
}
