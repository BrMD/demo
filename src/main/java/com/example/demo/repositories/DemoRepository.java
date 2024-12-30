package com.example.demo.repositories;

import com.example.demo.entities.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<DemoEntity, Long> {
    Boolean existsByLogin(String login);
}
