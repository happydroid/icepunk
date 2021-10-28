package io.threatrix.app.entities;

import lombok.Data;
/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;*/
import java.util.Objects;

@Data
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private char[] password;
    private String role;
    private String avatorImageUrl;

}
