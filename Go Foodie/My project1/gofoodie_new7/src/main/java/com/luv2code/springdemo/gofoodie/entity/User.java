package com.luv2code.springdemo.gofoodie.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "users")
public class User
{
    @Id
    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min=1, message="is required")
    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private int enabled;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Authorities authority;

    public User() {
    }

    public User(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }


}
