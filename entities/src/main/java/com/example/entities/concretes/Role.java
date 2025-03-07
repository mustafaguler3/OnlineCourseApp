package com.example.entities.concretes;

import com.example.core.abstracts.BaseEntity;
import com.example.entities.enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "roles")
@Entity
public class Role extends BaseEntity<Long> {

    @Enumerated(EnumType.STRING)
    @Column(name = "name",nullable = false,unique = true)
    private RoleType name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
