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
@Table(catalog = "hospital",name = "Notify")
public class Notify {
    @Column(name = "Id",updatable = false)
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Account receiver;

    @Column(name = "title",length = 100,nullable = false)
    private String title;

    @Column(name = "description",length = 10000,nullable = false)
    private String description;

    @Column(name = "created_at",nullable = false,insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date Created_at;
}
