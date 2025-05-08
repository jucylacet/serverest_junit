package dto.response;

public class LoginResponseDTO {
    private String email;
    private String password;
    private String message;
    private String authorization;

    public LoginResponseDTO(String message, String authorization) {
        this.message = message;
        this.authorization = authorization;
    }

    public LoginResponseDTO() {

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthorization() {
        return authorization;
    }
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", message='" + message + '\'' +
                ", authorization='" + authorization + '\'' +
                '}';
    }
}
