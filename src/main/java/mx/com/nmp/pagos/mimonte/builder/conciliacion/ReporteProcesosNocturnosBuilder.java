/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.builder.conciliacion;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import mx.com.nmp.pagos.mimonte.dto.conciliacion.ConciliacionDTOList;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.ReporteProcesosNocturnosDTO;
import mx.com.nmp.pagos.mimonte.model.conciliacion.Reporte;
import mx.com.nmp.pagos.mimonte.model.conciliacion.TipoReporteEnum;

/**
 * Nombre: ReporteProcesosNocturnosBuilder Descripcion: Clase de capa de builder que se
 * encarga de convertir difrentes tipos de objetos y entidades relacionadas con
 * ReporteProcesosNocturnosBuilder
 *
 * @author José Rodríguez jgrodriguez@qaurksoft.net
 * @creationDate 06/05/2019 13:21 hrs.
 * @version 0.1
 */
public abstract class ReporteProcesosNocturnosBuilder {
	
	
	public ReporteProcesosNocturnosBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construye un set de objetos de tipo ReporteProcesosNocturnosDTO a partir de un set de entities de tipo Reporte.
	 * @param reporteSet
	 * @return
	 */              
	@SuppressWarnings("unlikely-arg-type")
	public static ReporteProcesosNocturnosDTO buildReporteProcesosNocturnosDTOSetFromReporteSet(List<Reporte> reporteSet){
		ReporteProcesosNocturnosDTO reporteProcesosNocturnosDTO = null;
		if(reporteSet != null && !reporteSet.isEmpty()) {
			reporteProcesosNocturnosDTO = new ReporteProcesosNocturnosDTO();
			for(Reporte reporte : reporteSet) {
				if(reporte.getTipo().equals(TipoReporteEnum.MIDAS.name())) {
					reporteProcesosNocturnosDTO.setFechaDesde(reporte.getFechaDesde());
					reporteProcesosNocturnosDTO.setFechaHasta(reporte.getFechaHasta());
					reporteProcesosNocturnosDTO.setDisponible(reporte.getDisponible());
					break;
				}
			}
		}
		return reporteProcesosNocturnosDTO;
	}

}
