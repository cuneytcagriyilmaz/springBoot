package com.cagriyilmaz.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy; // kim oluşturdu

    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate; // ne zaman oluşturdu

    @Column(name = "update_by")
    @LastModifiedBy // kimin tarafından oluşturuldu
    private String updateBy;

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;

    @Column(name = "system_auto_date")
    @Temporal(TemporalType.TIMESTAMP) //yıl ay gün saat dakika saniye olarak eklenir
    @CreationTimestamp
    private Date date;

}
