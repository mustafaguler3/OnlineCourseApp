package com.example.repository.abstracts;

import com.example.core.abstracts.BaseRepository;
import com.example.entities.concretes.Role;
import com.example.entities.enums.RoleType;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role,Long> {
    Optional<Role> findByName(RoleType name);
}
