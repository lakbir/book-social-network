package com.lakbir.book.repository;

import com.lakbir.book.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * lakbir.abderrahim - 15/07/2024
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
