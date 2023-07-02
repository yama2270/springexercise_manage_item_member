package hello.springexercise02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("hello.springexercise02.mapper")
public class Springexercise02Application {

	public static void main(String[] args) {
		SpringApplication.run(Springexercise02Application.class, args);
	}

}
