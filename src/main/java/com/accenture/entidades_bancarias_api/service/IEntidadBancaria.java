package com.accenture.entidades_bancarias_api.service;

import com.accenture.entidades_bancarias_api.model.entity.EntidadBancaria;

import java.util.List;
import java.util.Optional;

public interface IEntidadBancaria {

    List<EntidadBancaria> listEntidad();
    public  EntidadBancaria getBytId(Long id);
}
