package com.donavida.donavida.repository;

import com.donavida.donavida.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByDonorId(Long donorId);
    List<Donation> findByAestheticCenterId(Long aestheticCenterId);
}