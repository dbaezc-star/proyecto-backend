package com.donavida.donavida.service;

import com.donavida.donavida.entity.Donor;
import com.donavida.donavida.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonorService {

    private final DonorRepository donorRepository;

    public List<Donor> getAll() {
        return donorRepository.findAll();
    }

    public Donor getById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donante no encontrado"));
    }

    public Donor update(Long id, Donor updated) {
        Donor donor = getById(id);
        donor.setFullName(updated.getFullName());
        donor.setPhone(updated.getPhone());
        donor.setCity(updated.getCity());
        donor.setHairLength(updated.getHairLength());
        donor.setHairType(updated.getHairType());
        return donorRepository.save(donor);
    }

    public void delete(Long id) {
        donorRepository.deleteById(id);
    }
}