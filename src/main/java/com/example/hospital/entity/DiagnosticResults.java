package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "DiagnosticResults")
public class DiagnosticResults {
    @Column(name = "Id",updatable = false)
    @Id
    private UUID id;

    @Column(name = "results",length = 300)
    private String results;

    @Column(name = "prescription",length = 300)
    private String prescription;

    @OneToOne
    @JoinColumn(name = "medical_records_id")
    private MedicalRecords medicalRecords;


}
