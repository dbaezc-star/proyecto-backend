package com.donavida.donavida.dto;
import com.donavida.donavida.entity.Role;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String phone;
    private String fullName;
    private String name;
    private String address;
    private String city;
    private Role role;
    private String password;
}
