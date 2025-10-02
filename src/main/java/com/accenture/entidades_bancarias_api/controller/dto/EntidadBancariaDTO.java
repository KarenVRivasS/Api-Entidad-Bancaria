package com.accenture.entidades_bancarias_api.controller.dto;

import com.accenture.entidades_bancarias_api.model.entity.TipoEntidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntidadBancariaDTO {

    private Long id;

    @NotBlank(message = "El código de entidad es obligatorio")
    @Size(min = 3, max = 5, message = "El código debe tener entre 3 y 5 caracteres")
    private String codigoEntidad;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "El CUIT es obligatorio")
    @Pattern(regexp = "\\d{11}", message = "El CUIT debe tener 11 dígitos")
    private String cuit;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @NotNull(message = "El tipo de entidad es obligatorio")
    private TipoEntidad tipoEntidad;

    private Boolean activa = true;



}
