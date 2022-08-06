package mvc.backend_server.dto;

import mvc.backend_server.config.RegexValidate;
import lombok.Data;
import mvc.backend_server.config.RegexValidate;
import org.aspectj.bridge.Message;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.List;

@Data
public class AccountDTO {
    private String id;
    private String address;
    private Date DOB;

    @NotBlank(message = "Email is require.")
    @Pattern(regexp = RegexValidate.EMAIL_REGEX, message = "Invalid email")
    private String email;

    @NotBlank(message = "Must enter your full name.")
    private String fullName;

    private String gender;

    @NotBlank(message = "Must enter your identity card.")
    private String identityCard;

    private String image;

    @NotBlank(message = "Password is require.")
    @Pattern(regexp = RegexValidate.PASSWORD_REGEX, message = "Invalid password")
    private String password;

    @NotBlank(message = "Must enter your phone number.")
    @Pattern(regexp = RegexValidate.PHONE_REGEX, message = "Invalid phone number")
    private String phoneNumber;

    private Date registerDate;
    private Integer level;
    private Integer levelPoint;
    private int status;
    private int roleId;

    @NotBlank(message = "Username is require.")
    private String username;

}
