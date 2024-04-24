package com.example.OutPatientAppointment.Controllers;

import com.example.OutPatientAppointment.Models.Doctor;
import com.example.OutPatientAppointment.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return  doctorService.addDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getDoctors(){
        return doctorService.getAllDoctors();
    }
    @GetMapping({"/{doctorId}"})
    public Doctor getDoctor(@PathVariable Long doctorId){
        return doctorService.getDoctorById(doctorId);

    }

    @GetMapping("/{doctorId}/availabiity")
    public List<LocalDateTime> getDoctorAvailability(@PathVariable Long doctorId){
        return doctorService.getDoctorAvailability(doctorId);
    }


}
