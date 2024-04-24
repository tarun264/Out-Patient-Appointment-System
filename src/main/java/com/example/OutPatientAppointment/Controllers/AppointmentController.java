package com.example.OutPatientAppointment.Controllers;

import com.example.OutPatientAppointment.Request.AppointmentRequest;
import com.example.OutPatientAppointment.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentRequest appointmentRequest){
        Long doctorId= appointmentRequest.getDoctorId();
        String patientName= appointmentRequest.getPatientName();
        LocalDateTime appointmentTime = appointmentRequest.getAppointmentTime();

        boolean isBooked= doctorService.bookAppointment(doctorId,patientName,appointmentTime);
        if(isBooked){
            return ResponseEntity.ok("Appointment booked successfully");
        }
        else{
            return ResponseEntity.badRequest().body("Failed to book appointment. Please try again");
        }
    }
}
