package com.example.dateanu.domain.client_img;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientImageRepository extends JpaRepository<ClientImage, Long> {
}
