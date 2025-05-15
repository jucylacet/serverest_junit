package dto;

public class LoginResponseDTO {
    private String message;
    private String authorization;

    public LoginResponseDTO(String message, String authorization) {
        this.message = message;
        this.authorization = authorization;
    }

    public LoginResponseDTO() {

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
}
