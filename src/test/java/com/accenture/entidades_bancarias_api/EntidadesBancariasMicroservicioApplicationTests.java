package com.accenture.entidades_bancarias_api;

import com.accenture.entidades_bancarias_api.model.entity.EntidadBancaria;
import com.accenture.entidades_bancarias_api.model.entity.TipoEntidad;
import com.accenture.entidades_bancarias_api.model.repository.EntidadBancariaRepository;
import com.accenture.entidades_bancarias_api.service.EntidadBancariaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class EntidadesBancariasMicroservicioApplicationTests {

	@Mock
	private EntidadBancariaRepository repository;

	@InjectMocks
	private EntidadBancariaService service;
	EntidadBancaria entidad= null;
	@BeforeEach
	void setUp() {
		 entidad = EntidadBancaria.builder()
				.id(1L)
				.codigoEntidad("01301")
				.nombre("Banco Comercio")
				.cuit("30546746862")
				.direccion("Av. Corrientes 345")
				.tipoEntidad(TipoEntidad.BANCO)
				.activa(true)
				.build();

	}

		@Test
		public void findAllListaDeEntidades() {
			// Given
			List<EntidadBancaria> entidades = Arrays.asList(entidad);
			when(repository.findAll()).thenReturn(entidades);
			

			// When
			List<EntidadBancaria> resultado = service.listEntidad();

			// Then
			assertNotNull(resultado);
			assertEquals(1, resultado.size());
			verify(repository, times(1)).findAll();
		}


}
