package com.example.first_spring.repo;

import com.example.first_spring.model.RegularUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegularUserRepository extends JpaRepository<RegularUser, Long> {
}
