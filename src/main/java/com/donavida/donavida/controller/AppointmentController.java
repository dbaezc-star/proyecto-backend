package com.donavida.donavida.controller;

import com.donavida.donavida.entity.Appointment;
import com.donavida.donavida.entity.AppointmentStatus;
import com.donavida.donavida.entity.AestheticCenter;
import com.donavida.donavida.entity.Donor;
import com.donavida.donavida.repository.AppointmentRepository;
import com.donavida.donavida.repository.AestheticCenterRepository;
import com.donavida.donavida.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final DonorRepository donorRepository;
    private final AestheticCenterRepository aestheticCenterRepository;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(
            @RequestParam Long donorId,
            @RequestParam Long aestheticCenterId) {

        Donor donor = donorRepository.findById(donorId)
                .orElseThrow(() -> new RuntimeException("Donante no encontrado"));
        AestheticCenter center = aestheticCenterRepository.findById(aestheticCenterId)
                .orElseThrow(() -> new RuntimeException("Centro no encontrado"));

        Appointment appointment = Appointment.builder()
                .donor(donor)
                .aestheticCenter(center)
                .build();

        return ResponseEntity.ok(appointmentRepository.save(appointment));
    }

    @GetMapping("/donor/{donorId}")
    public ResponseEntity<List<Appointment>> getByDonor(@PathVariable Long donorId) {
        return ResponseEntity.ok(appointmentRepository.findByDonorId(donorId));
    }

    @GetMapping("/aesthetic-center/{centerId}")
    public ResponseEntity<List<Appointment>> getByCenter(@PathVariable Long centerId) {
        return ResponseEntity.ok(appointmentRepository.findByAestheticCenterId(centerId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Appointment> updateStatus(
            @PathVariable Long id,
            @RequestParam AppointmentStatus status) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        appointment.setStatus(status);
        return ResponseEntity.ok(appointmentRepository.save(appointment));
    }
}