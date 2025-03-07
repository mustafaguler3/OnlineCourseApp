package com.example.repository.abstracts;

import com.example.core.abstracts.BaseRepository;
import com.example.entities.concretes.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User,Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
