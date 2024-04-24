package com.example.OutPatientAppointment.Repository;

import com.example.OutPatientAppointment.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
