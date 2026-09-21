package com.jashawnbuilds.invoquill_api.identity.domain;

import com.jashawnbuilds.invoquill_api.shared.domain.EmailAddress;
import com.jashawnbuilds.invoquill_api.shared.domain.exception.InvalidDomainValueException;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Table("users")
public class User {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private EmailAddress email;
    private String passwordHash;
    private UserStatus userStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private User() {}

    private User(
            String firstName,
            String lastName,
            EmailAddress email,
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
            EmailAddress email,
            String passwordHash
    ) {
        if (firstName == null || firstName.isBlank())
            throw new InvalidDomainValueException(
                    "INVALID_FIRST_NAME",
                    "First name cannot be empty."
                    );

        if (lastName == null || lastName.isBlank())
            throw new InvalidDomainValueException(
                    "INVALID_LAST_NAME",
                    "Last name cannot be empty."
                    );

        if (passwordHash == null || passwordHash.isBlank())
            throw new InvalidDomainValueException(
                    "INVALID_PASSWORD",
                    "Password cannot be empty"
            );

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

    public void updateFirstName(String firstName) {
        if (this.deletedAt != null)
            throw new DeletedAccountException(
                    "INVALID_ACCOUNT_STATE",
                    "Account has been deleted and can no longer be updated."
            );

        String normalizedFirstName = firstName.trim();

        if (this.firstName.equals(normalizedFirstName)) return;

        this.updatedAt = LocalDateTime.now();
        this.firstName = normalizedFirstName;
    }

    public void updateLastName(String lastName) {
        if (this.deletedAt != null)
            throw new DeletedAccountException(
                    "INVALID_ACCOUNT_STATE",
                    "Account has been deleted and can no longer be updated."
            );

        String normalizedLastName = lastName.trim();

        if (this.lastName.equals(normalizedLastName)) return;

        this.updatedAt = LocalDateTime.now();
        this.lastName = normalizedLastName;
    }

    public void updateEmail(String email) {
        if (this.deletedAt != null)
            throw new DeletedAccountException(
                    "INVALID_ACCOUNT_STATE",
                    "Account has been deleted and can no longer be updated."
            );

        this.email = EmailAddress.of(email);
        this.updatedAt = LocalDateTime.now();
    }

    public void updatePassword(String passwordHash) {
        if (this.deletedAt != null)
            throw new DeletedAccountException(
                    "INVALID_ACCOUNT_STATE",
                    "Account has been deleted and can no longer be updated."
            );

        if (this.passwordHash.equals(passwordHash)) return;

        this.updatedAt = LocalDateTime.now();
        this.passwordHash = passwordHash;
    }

    @Nonnull
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void deactivate() {
        if (this.deletedAt != null) return;
        if (this.userStatus.equals(UserStatus.DEACTIVATED)) return;
        this.userStatus = UserStatus.DEACTIVATED;
    }

    public void activate() {
        if (this.deletedAt != null)
            throw new DeletedAccountException(
                    "INVALID_ACCOUNT_STATE",
                    "Account has been deleted and can no longer be updated."
            );

        if (this.userStatus.equals(UserStatus.ACTIVE)) return;
        this.userStatus = UserStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName=%s, lastName=%s, email=%s, status=%s]",
                id, firstName, lastName, email, userStatus
        );
    }
}

