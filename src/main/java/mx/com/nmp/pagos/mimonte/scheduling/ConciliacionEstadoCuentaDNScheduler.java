/*
 * Proyecto:        NMP - HABILITAR COBRANZA 24/7 -  CONCILIACION AUTOMATICA.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.scheduling;

import mx.com.nmp.pagos.mimonte.dto.conciliacion.*;
import mx.com.nmp.pagos.mimonte.model.conciliacion.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import java.util.*;



/**
 * @name ConciliacionEstadoCuentaScheduler
 * @description Componente para la calendarización de la ejecución automática del proceso de conciliación Etapa 2 (Carga de Movimientos Estado de Cuenta)(configuración días naturales).
 *
 * @author Juan Manuel Reveles jmreveles@quarksoft.net
 * @creationDate 14/01/2022 10:48 hrs.
 * @version 0.1
 */

@Configuration
@EnableScheduling
public class ConciliacionEstadoCuentaDNScheduler implements SchedulingConfigurer {


	/**
	 * Los métodos para consultar y cargar los movimientos del estado de cuenta.
	 */
	@Autowired
	private ConciliacionEstadoCuenta conciliacionEstadoCuenta;


	/**
	 Ejecuta tareas de programadas.
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

		Runnable runnableTask = () ->  lanzarConciliacionEtapa2DN();

		Trigger trigger = new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				String cronExpressions = obtenerCalendarizacionConciliacionEtapa2DN().getConfiguracionAutomatizacion();
				if (StringUtils.isEmpty(cronExpressions)) {
					return null;
				}
				CronTrigger crontrigger = new CronTrigger(cronExpressions);
				return crontrigger.nextExecutionTime(triggerContext);
			}
		};

		taskRegistrar.addTriggerTask(runnableTask , trigger);

	}

	/**
	 * Método encargado de lanzar la ejecución del proceso de conciliación etapa 2.
	 *
	 */
	public void lanzarConciliacionEtapa2DN() {
        CalendarioEjecucionProcesoDTO calendarizacion = this.obtenerCalendarizacionConciliacionEtapa2DN();
		Conciliacion conciliacionSEC  = conciliacionEstadoCuenta.buscarConciliacionSinEstadoCuenta(calendarizacion);
        if(conciliacionSEC != null && conciliacionSEC.getId() != 0) {
			EjecucionConciliacion ejecucionConciliacion = conciliacionEstadoCuenta.buscarEjecucionConciliacion(conciliacionSEC);
			if(ejecucionConciliacion != null && ejecucionConciliacion.getId() != 0 ) {
				conciliacionEstadoCuenta.ejecutarProcesoConciliacionE2(ejecucionConciliacion);
			}
		}

	}

	/**
	 * Método encargado de consultar la configuracion de la calendarizacion del proceso de conciliación etapa 2.
	 *
	 * @return
	 */
	public CalendarioEjecucionProcesoDTO obtenerCalendarizacionConciliacionEtapa2DN() {
		return conciliacionEstadoCuenta.obtenerCalendarizacionConciliacion(ProcesoEnum.CONCILIACION_ETAPA_2_DN.getIdProceso(), CorresponsalEnum.OPENPAY.getNombre());
	}

}