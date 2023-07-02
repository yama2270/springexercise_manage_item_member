package hello.springexercise02.domain;

import lombok.Data;

@Data
public class Member {

    private Long id;
    private String loginId;
    private String name;
    private String password;

    public Member(){

    }

    public Member(String name,String password){
        this.name = name;
        this.password=password;
    }

    public Member(Long id,String loginId,String name,String password){
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }

}
