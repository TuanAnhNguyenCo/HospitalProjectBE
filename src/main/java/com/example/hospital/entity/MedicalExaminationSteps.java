package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "MedicalExaminationSteps")
public class MedicalExaminationSteps {
    @Column(name = "Id",updatable = false)
    @Id
    private UUID id;

    @Column(name = "payment_status")
    private boolean paymentStatus;

    @Column(name = "results",length = 300)
    private String results;

    @ManyToOne
    @JoinColumn(name = "medical_records_id")
    private MedicalRecords medicalRecords;
}
