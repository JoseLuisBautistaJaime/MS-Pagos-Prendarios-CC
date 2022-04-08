/*
 * Proyecto:        NMP - HABILITAR COBRANZA 24/7 -  CONCILIACION AUTOMATICA.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.scheduling;

import mx.com.nmp.pagos.mimonte.dto.conciliacion.CalendarioEjecucionProcesoDTO;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.ProcesoDTO;
import mx.com.nmp.pagos.mimonte.model.Cuenta;
import mx.com.nmp.pagos.mimonte.model.Entidad;
import mx.com.nmp.pagos.mimonte.model.conciliacion.*;
import mx.com.nmp.pagos.mimonte.services.conciliacion.ConciliacionLayoutsService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @name ConciliacionLayoutsSchedulerTest
 * @description Clase de pruebas automatizadas para el proyecto Conciliacion
 *              correspondiente al scheduler  ConciliacionLayoutsScheduler
 *
 * @author Juan Manuel Reveles jmreveles@quarksoft.net
 * @creationDate 28/03/2022 15:35 hrs.
 * @version 0.1
 *
 */
@RunWith(SpringRunner.class)
public class ConciliacionLayoutsSchedulerTest {


	@InjectMocks
	private ConciliacionLayoutsScheduler conciliacionLayoutsScheduler;
	
	@Mock
	private ConciliacionLayoutsService conciliacionLayouts;

	private Conciliacion conciliacion;

	private CalendarioEjecucionProceso calendarioEjecucionProceso;

	private CalendarioEjecucionProcesoDTO calendarioEjecucionProcesoDTO;

	private EjecucionConciliacion ejecucionConciliacion;


	@Test
	public void t1_createSchedulers(){

		calendarioEjecucionProceso = crearCalendarioEjecucionProceso();
		calendarioEjecucionProcesoDTO = this.crearCalendarioEjecucionProcesoDTO(calendarioEjecucionProceso);

		List<CalendarioEjecucionProcesoDTO> listaConfiguraciones = new ArrayList<>();
		when(conciliacionLayouts.obtenerCalendarizacionConciliacion(any(), any())).thenReturn(listaConfiguraciones);
		Assertions.assertDoesNotThrow(() -> conciliacionLayoutsScheduler.createSchedulers());

		listaConfiguraciones.add(calendarioEjecucionProcesoDTO);
		when(conciliacionLayouts.obtenerCalendarizacionConciliacion(any(), any())).thenReturn(listaConfiguraciones);
		Assertions.assertDoesNotThrow(() -> conciliacionLayoutsScheduler.createSchedulers());

		listaConfiguraciones.get(0).setConfiguracionAutomatizacion("");
		when(conciliacionLayouts.obtenerCalendarizacionConciliacion(any(), any())).thenReturn(listaConfiguraciones);
		Assertions.assertDoesNotThrow(() -> conciliacionLayoutsScheduler.createSchedulers());


		verify(conciliacionLayouts, times(3)).obtenerCalendarizacionConciliacion(any(), any());

	}

	@Test
	public void t2_lanzarConciliacionEtapa2(){

		calendarioEjecucionProceso = crearCalendarioEjecucionProceso();
		calendarioEjecucionProcesoDTO = this.crearCalendarioEjecucionProcesoDTO(calendarioEjecucionProceso);
		conciliacion = this.crearConciliacion();
		ejecucionConciliacion = this.crearEjecucionConciliacion(conciliacion);

		List<Conciliacion> listaConciliaciones = new ArrayList<Conciliacion>(){{add(conciliacion);}};
		when(conciliacionLayouts.buscarConciliacionSinLayouts(any())).thenReturn(listaConciliaciones);
		when(conciliacionLayouts.buscarEjecucionConciliacion(any())).thenReturn(ejecucionConciliacion);
		doNothing().when(conciliacionLayouts).ejecutarProcesoConciliacionE3(any());

		Assertions.assertDoesNotThrow(() -> conciliacionLayoutsScheduler.lanzarConciliacionEtapa3(calendarioEjecucionProcesoDTO));

		verify(conciliacionLayouts, times(1)).buscarConciliacionSinLayouts(any());
		verify(conciliacionLayouts, times(1)).buscarEjecucionConciliacion(any());
		verify(conciliacionLayouts, times(1)).ejecutarProcesoConciliacionE3(any());

	}

	@Test
	public void t3_lanzarConciliacionEtapa2(){

		calendarioEjecucionProceso = crearCalendarioEjecucionProceso();
		calendarioEjecucionProcesoDTO = this.crearCalendarioEjecucionProcesoDTO(calendarioEjecucionProceso);

		List<Conciliacion> listaConciliaciones = new ArrayList<>();
		when(conciliacionLayouts.buscarConciliacionSinLayouts(any())).thenReturn(listaConciliaciones);

		Assertions.assertDoesNotThrow(() -> conciliacionLayoutsScheduler.lanzarConciliacionEtapa3(calendarioEjecucionProcesoDTO));

		verify(conciliacionLayouts, times(1)).buscarConciliacionSinLayouts(any());

	}

	@Test
	public void t4_lanzarConciliacionEtapa2(){

		calendarioEjecucionProceso = crearCalendarioEjecucionProceso();
		calendarioEjecucionProcesoDTO = this.crearCalendarioEjecucionProcesoDTO(calendarioEjecucionProceso);
		conciliacion = this.crearConciliacion();

		List<Conciliacion> listaConciliaciones = new ArrayList<Conciliacion>(){{add(conciliacion);}};
		when(conciliacionLayouts.buscarConciliacionSinLayouts(any())).thenReturn(listaConciliaciones);
		when(conciliacionLayouts.buscarEjecucionConciliacion(any())).thenReturn(null);

		Assertions.assertDoesNotThrow(() -> conciliacionLayoutsScheduler.lanzarConciliacionEtapa3(calendarioEjecucionProcesoDTO));

		verify(conciliacionLayouts, times(1)).buscarConciliacionSinLayouts(any());
		verify(conciliacionLayouts, times(1)).buscarEjecucionConciliacion(any());

	}

	private CalendarioEjecucionProcesoDTO crearCalendarioEjecucionProcesoDTO(CalendarioEjecucionProceso elemento) {
		CalendarioEjecucionProcesoDTO elementoDTO = new CalendarioEjecucionProcesoDTO();
		elementoDTO.setId(elemento.getId());
		elementoDTO.setCorresponsal(elemento.getProveedor().getNombre());
		elementoDTO.setProceso(new ProcesoDTO(elemento.getProceso().getId()));
		elementoDTO.setRangoDiasCoberturaMax(elemento.getRangoDiasCoberturaMax());
		elementoDTO.setRangoDiasCoberturaMin(elemento.getRangoDiasCoberturaMin());
		elementoDTO.setActivo(elemento.getActivo());
		elementoDTO.setReintentos(elemento.getReintentos());
		elementoDTO.setConfiguracionAutomatizacion(elemento.getConfiguracion());
		return  elementoDTO;
	}

	private CalendarioEjecucionProceso crearCalendarioEjecucionProceso() {
		CalendarioEjecucionProceso elemento = new CalendarioEjecucionProceso();
		elemento.setId(1l);
		elemento.setProveedor(new Proveedor(CorresponsalEnum.OPENPAY));
		elemento.setProceso(new CatalogoProceso(ProcesoEnum.CONCILIACION_ETAPA_1.getIdProceso()));
		elemento.setRangoDiasCoberturaMax(1);
		elemento.setRangoDiasCoberturaMin(1);
		elemento.setActivo(true);
		elemento.setReintentos(1);
		elemento.setConfiguracion("0 0 0 31 DEC ?");
		return elemento;
	}

	private Conciliacion crearConciliacion() {
		Conciliacion elemento = new Conciliacion();
		elemento.setId(1L);
		elemento.setCreatedDate(new Date());
		elemento.setEntidad(new Entidad(11L,""));
		elemento.setCuenta(new Cuenta(1L, ""));
		elemento.setProveedor(new Proveedor(CorresponsalEnum.OPENPAY));
		elemento.setEstatus(new EstatusConciliacion(1));
		elemento.setSubEstatus(new SubEstatusConciliacion(1L));
		elemento.setSubEstatusDescripcion("Test");
		return elemento;
	}

	private EjecucionConciliacion crearEjecucionConciliacion(Conciliacion proceso) {
		EjecucionConciliacion elemento = new EjecucionConciliacion();
		elemento.setId(1l);
		elemento.setFechaEjecucion(new Date());
		elemento.setFechaPeriodoInicio(new Date());
		elemento.setFechaPeriodoFin(new Date());
		elemento.setProveedor(new Proveedor(CorresponsalEnum.OPENPAY));
		elemento.setEstatus(new EstatusEjecucionConciliacion(EstatusEjecucionConciliacionEnum.CREADA.getIdEstadoEjecucion(), EstatusEjecucionConciliacionEnum.CREADA.getEstadoEjecucion()));
		elemento.setConciliacion(proceso);
		return elemento;
	}

}