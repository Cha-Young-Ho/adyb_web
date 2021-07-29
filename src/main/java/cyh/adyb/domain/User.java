package cyh.adyb.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sequenceId;


    @NotNull
    @NotBlank
    @Column(length = 25, nullable = false)
    private String userId;

    @NotNull
    @NotBlank
    @Column(nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList;

    @OneToMany(mappedBy = "user")
    private List<Reply> replyList;

    @OneToMany(mappedBy = "user")
    private List<UserFile> userFileList;


};