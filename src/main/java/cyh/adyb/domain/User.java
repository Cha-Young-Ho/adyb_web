package cyh.adyb.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class User {


    @GeneratedValue(strategy = GenerationType.AUTO)
    Long sequenceId;


    String id;
    String password;

};