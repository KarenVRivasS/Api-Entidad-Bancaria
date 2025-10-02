package com.accenture.entidades_bancarias_api.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "entidades_bancarias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntidadBancaria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 5)
    private String codigoEntidad;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(unique = true, nullable = false, length = 11)
    private String cuit;

    @Size(max = 200)
    @Column(length = 200)
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoEntidad tipoEntidad;

    @Column(nullable = false)
    private Boolean activa = true;

    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

}
