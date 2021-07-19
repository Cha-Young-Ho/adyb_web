package cyh.adyb.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long sequenceId;


    @NotNull
    @NotBlank
    @Column(length = 25, nullable = false)
    String userId;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    String password;

};