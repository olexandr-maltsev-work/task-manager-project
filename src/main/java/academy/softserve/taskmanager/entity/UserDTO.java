package academy.softserve.taskmanager.entity;

public class UserDTO {

    private String email;
    private String password;
    private String confirmPassword;
    private String name;
    private String message;
    private boolean error;

    public UserDTO() {
        this.email = "";
        this.password = "";
        this.confirmPassword = "";
        this.name = "";
        this.message = "";
        this.error = false;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
