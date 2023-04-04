package com.ppfurtado.jgcrud.repository;

import com.ppfurtado.jgcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}