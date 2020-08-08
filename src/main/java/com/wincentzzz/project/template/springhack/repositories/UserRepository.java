package com.wincentzzz.project.template.springhack.repositories;

import com.wincentzzz.project.template.springhack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
