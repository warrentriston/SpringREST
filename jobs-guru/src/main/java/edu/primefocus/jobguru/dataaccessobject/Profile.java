package edu.primefocus.jobguru.dataaccessobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.hibernate.boot.model.source.spi.IdentifierSource;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tbl_profile")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Profile {

    @Id
    @Column(name = "profile_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long profileId;

    @NonNull
    @Column(name = "name")
    String name;

    @Column(name = "description", nullable = false)
    String description;

    @OneToOne
    @JoinColumn(name = "login_id",
                referencedColumnName = "login_id")
    Login login;

    @OneToMany(
            mappedBy = "profile"
    )
    List<Jobs> job;

    @ManyToMany(
            mappedBy = "profileList"
    )
    List<Jobs> jobsList;
}
