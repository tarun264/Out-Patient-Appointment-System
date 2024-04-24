package com.example.OutPatientAppointment.Models;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private String specialty;

}
