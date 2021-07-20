package cyh.adyb.web.validator;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserModifyForm {

    String beforeId;
    String beforePassword;

    @NotNull
    @NotBlank
    @Size(max = 15)
    String userId;

    @NotNull
    @NotBlank
    String password;
};

