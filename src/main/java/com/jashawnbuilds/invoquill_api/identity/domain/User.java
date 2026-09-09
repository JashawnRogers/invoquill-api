package com.jashawnbuilds.invoquill_api.identity.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private User() {}

    private User(
            String firstName,
            String lastName,
            String email,
            String passwordHash,
            UserStatus userStatus,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            LocalDateTime deletedAt
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.userStatus = userStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    @Nonnull
    public static User create(
            String firstName,
            String lastName,
            String email,
            String passwordHash
    ) {
        if (firstName == null || firstName.isBlank())
            throw new RuntimeException("");

        if (lastName == null || lastName.isBlank())
            throw new RuntimeException("");

        if (email == null || email.isBlank())
            throw new RuntimeException("");

        if (passwordHash == null || passwordHash.isBlank())
            throw new RuntimeException("");

        LocalDateTime createdAt = LocalDateTime.now();
        UserStatus status = UserStatus.ACTIVE;

        return new User(
                firstName,
                lastName,
                email,
                passwordHash,
                status,
                createdAt,
                null,
                null
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName=%s, lastName=%s, email=%s, status=%s, updated=%s]",
                id, firstName, lastName, email, userStatus, updatedAt.toString()
        );
    }
}

