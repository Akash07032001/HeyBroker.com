package com.masai.heybroker.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @NotBlank(message = "admin name can not be null or blank")
    private String adminName;
    @NotNull(message = "admin email can not be null or blank")
    @Email
    private String email;
    @NotBlank(message = "admin password can not be null or blank")
    @Size(min = 3,max = 8)
    private String password;
}
