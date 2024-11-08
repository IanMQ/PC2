//Paquete que contiene la clase
package com.logisticspro.platform.u202121325.shared.domain.model.entities;

//Importaciones necesarias para JPA, Lombok y auditoría 
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

//Genera getters 
@Getter
//Activa la auditoría para la entidad
@EntityListeners(AuditingEntityListener.class)
//Superclase mapeada 
@MappedSuperclass
public class AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;
}
