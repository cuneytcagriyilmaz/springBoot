package com.cagriyilmaz.security.jwt;
import com.cagriyilmaz.data.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

//register (kayıt olma) için kullanacağız

//lombok
@Getter
@Setter

//Jpa
@Entity
@Table(name="user")
public class _02_UserEntity extends BaseEntity {
    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column(name = "system_auto_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;

}
