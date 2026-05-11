package com.donavida.donavida.repository;

import com.donavida.donavida.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DonorRepository extends JpaRepository<Donor, Long> {
    Optional<Donor> findByUserId(long userId);
    Optional<Donor> findByUserEmail(String email);

}
