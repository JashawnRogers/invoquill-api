package com.jashawnbuilds.invoquill_api.identity.application.ports.out;

import com.jashawnbuilds.invoquill_api.identity.domain.User;
import com.jashawnbuilds.invoquill_api.shared.domain.EmailAddress;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(EmailAddress email);
    void save(User user);
    boolean existsByEmail(EmailAddress email);

    Iterable<User> findAll();
}
