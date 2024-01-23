package com.example.demo.Model;

import lombok.*;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.Serializable;
import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EnableCaching
@EnableSwagger2
public class Employee implements Serializable {



    private int emp_id;
    private String uid;
    private String password;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String avatar;
    private String gender;
    private String phone_number;
    private String social_insurance_number;
    private Date date_of_birth;
}
