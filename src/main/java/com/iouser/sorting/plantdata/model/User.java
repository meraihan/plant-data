package com.iouser.sorting.plantdata.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "first_name")
    private String firstName;
    @JoinColumn(name = "last_name")
    private String lastName;
    @JoinColumn(name = "email")
    private String email;
    @JoinColumn(name = "username")
    private String userName;
    @JoinColumn(name = "password")
    private String password;
    @JoinColumn(name = "role")
    private String role;
    @JoinColumn(name = "created_at")
    private LocalDateTime createdAt;
}
