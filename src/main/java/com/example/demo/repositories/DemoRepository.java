package com.example.demo.repositories;

import com.example.demo.entities.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemoRepository extends JpaRepository<DemoEntity, Long> {
    Boolean existsByLogin(String login);
    Optional<DemoEntity> findByLogin(String login);
}
