/*
 * Proyecto:        NMP - HABILITAR COBRANZA 24/7 -  CONCILIACION AUTOMATICA.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.conector;

import mx.com.nmp.pagos.mimonte.conector.impl.MergeConciliacionBrokerBus;
import mx.com.nmp.pagos.mimonte.consumer.rest.BusMergeConciliacionRestService;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.MergeConciliacionResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @name MergeConciliacionBrokerTest
 * @description Clase de pruebas automatizadas para el proyecto Conciliacion
 *              correspondiente a el conector MergeConciliacionBrokerBus
 *
 * @author Juan Manuel Reveles jmreveles@quarksoft.net
 * @creationDate 28/03/2022 15:35 hrs.
 * @version 0.1
 *
 */
@RunWith(SpringRunner.class)
public class MergeConciliacionBrokerTest {
	
	@InjectMocks
	private MergeConciliacionBroker mergeConciliacionBrokerBus = new MergeConciliacionBrokerBus();

	@Mock
	private BusMergeConciliacionRestService busMergeConciliacionRestService;

	@Test
	public void t1_generarMergeConciliacion(){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("codigo", "0");
		response.put("descripcion", "Test");
		when(busMergeConciliacionRestService.generarMergeConciliacion(any())).thenReturn(response);
		MergeConciliacionResponseDTO resultado = mergeConciliacionBrokerBus.generarMergeConciliacion(1L);
		verify(busMergeConciliacionRestService, times(1)).generarMergeConciliacion(any());
		assertNotNull(resultado);
	}

	@Test
	public void t2_generarMergeConciliacion(){
		when(busMergeConciliacionRestService.generarMergeConciliacion(any())).thenReturn(null);
		MergeConciliacionResponseDTO resultado = mergeConciliacionBrokerBus.generarMergeConciliacion(1L);
		verify(busMergeConciliacionRestService, times(1)).generarMergeConciliacion(any());
		assertNotNull(resultado);
	}

	@Test
	public void t3_generarMergeConciliacion(){
		Map<String, Object> response = new HashMap<String, Object>();
		when(busMergeConciliacionRestService.generarMergeConciliacion(any())).thenReturn(null);
		MergeConciliacionResponseDTO resultado = mergeConciliacionBrokerBus.generarMergeConciliacion(1L);
		verify(busMergeConciliacionRestService, times(1)).generarMergeConciliacion(any());
		assertNotNull(resultado);
	}

	@Test
	public void t4_generarMergeConciliacion(){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("codigoError", "404");
		response.put("descripcionError", "Test");
		response.put("tipoError", "Test");
		when(busMergeConciliacionRestService.generarMergeConciliacion(any())).thenReturn(response);
		MergeConciliacionResponseDTO resultado = mergeConciliacionBrokerBus.generarMergeConciliacion(1L);
		verify(busMergeConciliacionRestService, times(1)).generarMergeConciliacion(any());
		assertNotNull(resultado);
	}

	@Test
	public void t5_generarMergeConciliacion(){
		doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Test")).when(busMergeConciliacionRestService).generarMergeConciliacion(any());
		MergeConciliacionResponseDTO resultado = mergeConciliacionBrokerBus.generarMergeConciliacion(1L);
		verify(busMergeConciliacionRestService, times(1)).generarMergeConciliacion(any());
		assertNotNull(resultado);
	}

}