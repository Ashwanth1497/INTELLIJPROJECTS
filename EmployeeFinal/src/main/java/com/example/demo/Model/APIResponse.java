package com.example.demo.Model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class APIResponse {
    private Employee employee;
    private Employments employments;
}
