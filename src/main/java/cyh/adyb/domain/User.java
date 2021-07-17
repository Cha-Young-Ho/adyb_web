package cyh.adyb.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long sequenceId;


    @Column(length = 25, nullable = false)
    String id;

    @Column(nullable = false)
    String password;

};