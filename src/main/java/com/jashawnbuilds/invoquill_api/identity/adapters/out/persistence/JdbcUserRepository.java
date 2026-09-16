package com.jashawnbuilds.invoquill_api.identity.adapters.out.persistence;

import com.jashawnbuilds.invoquill_api.identity.application.ports.out.UserRepository;
import com.jashawnbuilds.invoquill_api.identity.domain.User;
import com.jashawnbuilds.invoquill_api.shared.domain.EmailAddress;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JdbcUserRepository implements UserRepository {

    private final SpringDataUserRepository repository;
    public JdbcUserRepository(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(EmailAddress email) {
        return repository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public boolean existsByEmail(EmailAddress email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }
}
