package com.example.OutPatientAppointment.Service;

import com.example.OutPatientAppointment.Models.Appointment;
import com.example.OutPatientAppointment.Models.Doctor;
import com.example.OutPatientAppointment.Repository.AppointmentRepository;
import com.example.OutPatientAppointment.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    public Doctor getDoctorById(Long doctorId){
        return doctorRepository.findById(doctorId).orElse(null);
    }
    public List<LocalDateTime> getDoctorAvailability(Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor == null) {
            return Collections.emptyList();
        }

        List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);


        List<LocalDateTime> availableSlots = new ArrayList<>();
        LocalDateTime currentDate = LocalDateTime.now();
        while (currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
            LocalDateTime startSlot = currentDate.withHour(18).withMinute(0).withSecond(0);
            LocalDateTime endSlot = currentDate.withHour(21).withMinute(0).withSecond(0);
            boolean isSlotAvailable = true;
            for (Appointment appointment : appointments) {
                if (appointment.getAppointmentTime().isEqual(startSlot) ||
                        (appointment.getAppointmentTime().isAfter(startSlot) && appointment.getAppointmentTime().isBefore(endSlot))) {
                    isSlotAvailable = false;
                    break;
                }
            }
            if (isSlotAvailable) {
                availableSlots.add(startSlot);
            }
            currentDate = currentDate.plusDays(1);
        }
        return availableSlots;
    }

    public boolean bookAppointment(Long doctorId, String patientName, LocalDateTime appointmentTime){
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor == null) {
            return false;
        }

        //check it doctor is booked or not
        List<Appointment> appointmentList = appointmentRepository.findByDoctorId(doctorId);
        for(Appointment appointment: appointmentList){
            if(appointment.getAppointmentTime().isEqual(appointmentTime)){
                return false;
            }
        }
        // if not
        Appointment newAppointment = new Appointment();
        newAppointment.setPatientName(patientName);
        newAppointment.setDoctorId(doctorId);
        newAppointment.setAppointmentTime(appointmentTime);
        appointmentRepository.save(newAppointment);
        return true;
    }

}
