package edu.primefocus.jobguru.dataaccessobject;

import lombok.Builder;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "tbl_login",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_username",
                columnNames = "username"
        ))
@Builder
@Value
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "login_id")
    long id;
    @Column(name = " username",
            nullable = false)
    String userName;
    @Column(name = "password",
            nullable = false)
    String password;
    @Column(name = "role",
            nullable = false)
    String role;
}
