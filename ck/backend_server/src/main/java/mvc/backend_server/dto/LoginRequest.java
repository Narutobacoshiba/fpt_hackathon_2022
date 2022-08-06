package mvc.backend_server.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
}
