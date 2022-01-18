package edu.primefocus.jobguru.dataaccessobject;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.hibernate.boot.model.source.spi.IdentifierSource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_profile")
@Builder(toBuilder = true)
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
}
