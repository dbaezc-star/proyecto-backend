package com.donavida.donavida.controller;

import com.donavida.donavida.entity.AestheticCenter;
import com.donavida.donavida.service.AestheticCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aesthetic-centers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AestheticCenterController {

    private final AestheticCenterService aestheticCenterService;

    @GetMapping
    public ResponseEntity<List<AestheticCenter>> getAll() {
        return ResponseEntity.ok(aestheticCenterService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AestheticCenter> getById(@PathVariable Long id) {
        return ResponseEntity.ok(aestheticCenterService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AestheticCenter> update(@PathVariable Long id, @RequestBody AestheticCenter center) {
        return ResponseEntity.ok(aestheticCenterService.update(id, center));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        aestheticCenterService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<AestheticCenter> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(aestheticCenterService.getByEmail(email));
    }
}