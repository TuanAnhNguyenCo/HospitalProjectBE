package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
@Table(catalog = "hospital",name = "StatusByDay")
public class StatusByDay {
    @Column(name = "Id",updatable = false)
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "medical_records_id")
    private MedicalRecords medicalRecords;

    @Column(name = "day",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date day;
}
