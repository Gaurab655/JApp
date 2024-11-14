package V2.JApp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AccountDto {
    @NotNull
    private String fullName;
    @NotNull
    private String email;
    private Double balance;
    @Min(value = 1000,message = "pin must be 4 digits long")
    @Max(value = 9999,message = "pin must be 4 digits long")
    private int pin;

    @Min(value = 1000, message = "pin must be 4 digits long")
    @Max(value = 9999, message = "pin must be 4 digits long")
    public int getPin() {
        return pin;
    }

    public void setPin(@Min(value = 1000, message = "pin must be 4 digits long") @Max(value = 9999, message = "pin must be 4 digits long") int pin) {
        this.pin = pin;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NotNull String getFullName() {
        return fullName;
    }

    public void setFullName(@NotNull String fullName) {
        this.fullName = fullName;
    }

}
