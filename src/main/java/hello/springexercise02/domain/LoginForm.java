package hello.springexercise02.domain;

import lombok.Data;

@Data
public class LoginForm {

    private String loginId;
    private String password;

    public LoginForm(){}

}
