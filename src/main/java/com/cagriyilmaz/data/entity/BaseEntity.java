package com.cagriyilmaz.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;


@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @Column(name = "id",nullable = false) // boş geçilemez
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "created_by")
    @CreatedBy
    //kim ne zaman ne yaptı
    private String createdBy; // kim oluşturdu

    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate; // ne zaman oluşturdu


    //update
    @Column(name = "update_by")
    @LastModifiedBy
    private String updateBy; // kim güncelledi

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate; // ne zaman güncelledi

    @Column(name = "system_auto_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
