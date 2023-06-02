package com.ecommerce.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotBlank(message = "User Name should not be blank")
    private String name;

    @NotBlank(message = "Email should be blank")
    @Email()
    private String email;

    private Long phone;

    @NotBlank(message = "Password should not be blank")
    private String password;

    @NotBlank(message = "Address should not be blank")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
