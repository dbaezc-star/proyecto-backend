package com.donavida.donavida.controller;

import com.donavida.donavida.entity.Donor;
import com.donavida.donavida.service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class DonorController {

    private final DonorService donorService;

    @GetMapping
    public ResponseEntity<List<Donor>> getAll() {
        return ResponseEntity.ok(donorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getById(@PathVariable Long id) {
        return ResponseEntity.ok(donorService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donor> update(@PathVariable Long id, @RequestBody Donor donor) {
        return ResponseEntity.ok(donorService.update(id, donor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        donorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}