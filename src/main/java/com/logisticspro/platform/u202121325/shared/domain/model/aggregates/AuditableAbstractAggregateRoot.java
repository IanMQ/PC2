//Paquete en donde se encuentra la clase
package com.logisticspro.platform.u202121325.shared.domain.model.aggregates;

//Importaciones necesarias para JPA, Lombok y auditoría
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

//Genera los getters automaticamente con Lombok
@Getter
//Activa la auditoria (fechas automáticas de creación y modificación)
@EntityListeners(AuditingEntityListener.class)
//Define esta clase como una superclse sin tabla en la BD
@MappedSuperclass
public class AuditableAbstractAggregateRoot<T extends AbstractAggregateRoot<T>> extends AbstractAggregateRoot<T> {

    //ID autogenerado como clave primaria (autoincrementado)
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Getter
    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;
}