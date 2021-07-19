package cyh.adyb.web.validator;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserSignUpForm {

    @NotNull
    @NotBlank
    @Size(max=10)
    String userId;

    @NotNull
    @NotBlank
    String password;
};