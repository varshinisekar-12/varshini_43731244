package net.javaguide.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguide.springBoot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
