package com.example.staffProject.repository;

import com.example.staffProject.models.Management;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySQLData extends JpaRepository<Management, Integer> {
}
