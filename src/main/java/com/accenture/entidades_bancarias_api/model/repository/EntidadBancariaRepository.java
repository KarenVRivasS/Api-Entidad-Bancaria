package com.accenture.entidades_bancarias_api.model.repository;

import com.accenture.entidades_bancarias_api.model.entity.EntidadBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntidadBancariaRepository extends JpaRepository<EntidadBancaria, Long> {

    public EntidadBancaria findBycodigoEntidad(String codigo);




}
