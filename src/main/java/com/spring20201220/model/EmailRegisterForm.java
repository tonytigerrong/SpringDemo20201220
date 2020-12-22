package com.spring20201220.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring20201220.annotation.ICombinationValidator;

@ICombinationValidator.List({
        @ICombinationValidator(
                field = "email",
                fieldMatch = "emailConfirm",
                message = "email do not match!"
        )
})
public class EmailRegisterForm{
    @JsonProperty("email")
    private String email;
    @JsonProperty("emailConfirm")
    private String emailConfirm;

    public EmailRegisterForm() {
    }

    public EmailRegisterForm(String email, String emailConfirm) {
        this.email = email;
        this.emailConfirm = emailConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailConfirm() {
        return emailConfirm;
    }

    public void setEmailConfirm(String emailConfirm) {
        this.emailConfirm = emailConfirm;
    }

    @Override
    public String toString() {
        return "EmailRegisterForm{" +
                "email='" + email + '\'' +
                ", emailConfirm='" + emailConfirm + '\'' +
                '}';
    }
}
