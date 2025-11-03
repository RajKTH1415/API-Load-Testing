package com.API_Load._esting.repository;

import com.API_Load._esting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
}
