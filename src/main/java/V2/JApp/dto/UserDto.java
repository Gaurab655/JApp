package V2.JApp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserDto {
    @NotEmpty
    private String email;
    @Size(min = 4, max = 8)
    @NotNull
    private String password;


    public @Size(min = 4, max = 8) @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 4, max = 8) @NotNull String password) {
        this.password = password;
    }

    public @NotEmpty String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty String email) {
        this.email = email;
    }




}
