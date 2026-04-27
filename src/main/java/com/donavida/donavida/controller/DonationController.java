package com.donavida.donavida.controller;

import com.donavida.donavida.entity.Donation;
import com.donavida.donavida.entity.Donor;
import com.donavida.donavida.entity.DonationStatus;
import com.donavida.donavida.repository.DonationRepository;
import com.donavida.donavida.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class DonationController {

    private final DonationRepository donationRepository;
    private final DonorRepository donorRepository;

    @PostMapping
    public ResponseEntity<Donation> createDonation(@RequestParam Long donorId) {
        Donor donor = donorRepository.findById(donorId)
                .orElseThrow(() -> new RuntimeException("Donor not found"));

        Donation donation = Donation.builder()
                .donor(donor)
                .status(DonationStatus.PENDING)
                .build();

        return ResponseEntity.ok(donationRepository.save(donation));
    }

    @GetMapping("/donor/{donorId}")
    public ResponseEntity<List<Donation>> getDonationsByDonor(@PathVariable Long donorId) {
        Donor donor = donorRepository.findById(donorId)
                .orElseThrow(() -> new RuntimeException("Donor not found"));
        return ResponseEntity.ok(donationRepository.findByDonorId(donorId));
    }

}