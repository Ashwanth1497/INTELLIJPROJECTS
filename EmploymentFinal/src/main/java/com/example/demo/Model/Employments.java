package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employments {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int emp_id;
    private String title;
    private String key_skill;
}
