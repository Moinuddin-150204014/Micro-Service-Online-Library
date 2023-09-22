package com.moin.UserService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String role;

    @Transient
    private List<ReviewEntity> review = new ArrayList<>();

}
