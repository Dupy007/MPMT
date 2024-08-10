package com.dupy.MPMT.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;
    @NotBlank(message = "Username undefined")
    @Size(message = "50 character max", max = 50)
    @Column(unique = true)
    private String username;
    @NotBlank(message = "email undefined")
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank(message = "password undefined")
    @JsonIgnore
    private String password;
    @OneToMany(mappedBy = "user")
    private List<ProjectMember> projectMembers;
    private String token;
    @OneToMany(mappedBy = "assigned")
    private List<Task> tasks;

    public static User parse(Register data) {
        User u = new User();
        u.setUsername(data.getUsername());
        u.setEmail(data.getEmail());
        u.setPassword(data.getPassword());
        return u;
    }
}
