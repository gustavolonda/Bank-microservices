package com.ntt.common.general.infraestructure.entities;
import java.util.Date;


import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.ntt.common.general.applications.model.StatusDomain.ACTIVE;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder(toBuilder = true)
public abstract  class BaseEntity {
    @CreationTimestamp
    @Column(name = "create_date" , columnDefinition = "TIMESTAMP")
    private Date createDate;

    @UpdateTimestamp
    @Column(name = "modify_date" , columnDefinition = "TIMESTAMP")
    private Date modifyDate;
    @Column(columnDefinition = "varchar(2)")
    private String status = ACTIVE.getValue();
}
