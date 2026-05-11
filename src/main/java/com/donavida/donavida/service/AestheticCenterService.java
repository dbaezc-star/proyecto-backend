package com.donavida.donavida.service;

import com.donavida.donavida.entity.AestheticCenter;
import com.donavida.donavida.repository.AestheticCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AestheticCenterService {

    private final AestheticCenterRepository aestheticCenterRepository;

    public List<AestheticCenter> getAll() {
        return aestheticCenterRepository.findAll();
    }

    public AestheticCenter getById(Long id) {
        return aestheticCenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Centro estético no encontrado"));
    }

    public AestheticCenter update(Long id, AestheticCenter updated) {
        AestheticCenter center = getById(id);
        center.setName(updated.getName());
        center.setAddress(updated.getAddress());
        center.setPhone(updated.getPhone());
        center.setCity(updated.getCity());
        return aestheticCenterRepository.save(center);
    }

    public void delete(Long id) {
        aestheticCenterRepository.deleteById(id);
    }
    public AestheticCenter getByEmail(String email) {
        return aestheticCenterRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Centro estético no encontrado"));
    }
}