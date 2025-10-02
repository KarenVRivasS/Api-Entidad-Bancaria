package com.accenture.entidades_bancarias_api.controller;


import com.accenture.entidades_bancarias_api.controller.dto.EntidadBancariaDTO;
import com.accenture.entidades_bancarias_api.exception.RecursoNoEncontradoException;
import com.accenture.entidades_bancarias_api.model.entity.EntidadBancaria;
import com.accenture.entidades_bancarias_api.mapper.MapperHelper;
import com.accenture.entidades_bancarias_api.service.EntidadBancariaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("api/bancos")
public class EntidadBancariaCtrl {

    @Autowired
    private EntidadBancariaService entidadBancariaService;

    /**
     * EndPoint para listar la entidad bancarias
     * @return
     */
    @Operation(summary = "Microservicio lista las entidad bancarias", description = "Microservicio lista lsa entidad bancarias")
    @GetMapping("/listar")
    ResponseEntity <List<EntidadBancaria>> findAllBanco(){
        log.info("Obteniendo todas las entidades");
       List<EntidadBancaria> banco = entidadBancariaService.listEntidad();
        return ResponseEntity.ok(banco);

    }

    /**
     * EndPoint para obtener la entidad bancaria por id
     * @return
     */
    @GetMapping("/obtener/{id}")
    public ResponseEntity<EntidadBancaria> getById(@PathVariable Long id)   {
        EntidadBancaria banco = entidadBancariaService.getBytId(id);
       if (banco == null) {
            throw new RecursoNoEncontradoException("Banco con ID " + id + " no encontrado");
        }
        return ResponseEntity.ok(banco);
    }

    /**
     * EndPoint para guardar
     *
     * @return
     */
   // @Operation(summary = "Crear un Usuario", tags = { "PepAccionista" })
    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody EntidadBancariaDTO dto) {
       EntidadBancaria claseEntityP;
       claseEntityP = MapperHelper.instance().convertToEntity(dto, EntidadBancaria.class);
       entidadBancariaService.save(claseEntityP);
       return ok(claseEntityP);
    }

    /**
     * EndPoint para actualizar
     * @return
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EntidadBancaria> update(@PathVariable Long id, @RequestBody EntidadBancaria banco) {
        EntidadBancaria updated = entidadBancariaService.update(id, banco);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    /**
     * EndPoint para eliminar
     * @return
     */
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entidadBancariaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
