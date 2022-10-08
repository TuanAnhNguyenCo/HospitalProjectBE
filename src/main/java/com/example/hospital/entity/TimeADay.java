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
@Table(catalog = "hospital",name = "TimeADay")
public class TimeADay {
    @Column(name = "Id",updatable = false)
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name="status_by_day_id")
    private StatusByDay statusByDay;

    @Column(name = "examination_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date examinationAt;

    @Column(name = "condition",length = 1000)
    private String condition;
}
