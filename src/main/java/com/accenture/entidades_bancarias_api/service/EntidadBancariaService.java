package com.accenture.entidades_bancarias_api.service;

import com.accenture.entidades_bancarias_api.model.entity.EntidadBancaria;
import com.accenture.entidades_bancarias_api.model.repository.EntidadBancariaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EntidadBancariaService implements IEntidadBancaria {

    private final EntidadBancariaRepository entidadBancariaRepository;

    public EntidadBancariaService(EntidadBancariaRepository entidadBancariaRepository) {
        this.entidadBancariaRepository = entidadBancariaRepository;
    }

    @Override
    @Transactional
    public List<EntidadBancaria> listEntidad() {
        log.info("Obteniendo todas las entidades");
        return entidadBancariaRepository.findAll();
    }

    public EntidadBancaria getBytId(Long id) {
        log.info("Obteniendo entidades por id");
        return entidadBancariaRepository.findById(id).orElse(null);
    }

    public Optional<EntidadBancaria>getCodigoEntidad(String codigo) {
        EntidadBancaria banco = entidadBancariaRepository.findBycodigoEntidad(codigo);
        if (banco == null) {
            return Optional.empty();
        }
        return Optional.of(banco);

    }

    public EntidadBancaria save(EntidadBancaria banco) {
        return entidadBancariaRepository.save(banco);
    }

    public EntidadBancaria update(Long id, EntidadBancaria banco) {
        return entidadBancariaRepository.findById(id)
                .map(b->{ b.setNombre(banco.getNombre());
                          b.setDireccion(banco.getDireccion());
                          b.setCuit(banco.getCuit());
                 return entidadBancariaRepository.save(b);
                }).orElseThrow(()-> new RuntimeException("Entidad no enontrada con ID:"+ id));
    }

    public void delete(Long id) {
        entidadBancariaRepository.deleteById(id);
    }
}
