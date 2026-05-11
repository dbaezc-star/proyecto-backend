package com.donavida.donavida.repository;

import com.donavida.donavida.entity.Appointment;
import com.donavida.donavida.entity.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDonorId(Long donorId);
    List<Appointment> findByAestheticCenterId(Long aestheticCenterId);
    List<Appointment> findByStatus(AppointmentStatus status);
}