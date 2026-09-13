package com.jashawnbuilds.invoquill_api.identity.adapters.out.persistence;

import com.jashawnbuilds.invoquill_api.identity.application.ports.out.UserRepository;
import com.jashawnbuilds.invoquill_api.identity.domain.User;
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
        return Optional.of(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.of(repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("")));
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }
}
