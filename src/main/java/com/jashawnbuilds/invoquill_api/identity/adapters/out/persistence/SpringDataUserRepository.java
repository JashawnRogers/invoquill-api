package com.jashawnbuilds.invoquill_api.identity.adapters.out.persistence;

import com.jashawnbuilds.invoquill_api.identity.domain.User;
import com.jashawnbuilds.invoquill_api.shared.domain.EmailAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataUserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByEmail(EmailAddress email);
    boolean existsByEmail(EmailAddress email);
    List<User> findAll();
}
