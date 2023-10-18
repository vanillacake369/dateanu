package com.example.dateanu.domain.exclusion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExclusionRepository extends JpaRepository<Exclusion, Long> {
}
