package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "MedicalExamination")
public class MedicalExamination {
    @Column(name = "Id",insertable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",length = 1000)
    private String name;

    @Column(name = "money",length = 1000)
    private double money;

    @ManyToOne
    @JoinColumn(name = "medical_examination_steps_id")
    private MedicalExaminationSteps medicalExaminationSteps ;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;






}
