package com.example.transaction_management.jpa_practice.repository;

import com.example.transaction_management.jpa_practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
