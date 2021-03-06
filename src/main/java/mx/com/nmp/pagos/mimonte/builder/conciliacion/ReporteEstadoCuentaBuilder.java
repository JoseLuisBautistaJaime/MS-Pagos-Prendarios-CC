/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.builder.conciliacion;

import java.util.List;

import mx.com.nmp.pagos.mimonte.dto.conciliacion.ReporteEstadoCuentaDTO;
import mx.com.nmp.pagos.mimonte.model.conciliacion.Reporte;
import mx.com.nmp.pagos.mimonte.model.conciliacion.TipoReporteEnum;

/**
 * Nombre: ReporteEstadoCuentaDTO Descripcion: Clase de capa de builder que se
 * encarga de convertir difrentes tipos de objetos y entidades relacionadas con
 * la ReporteEstadoCuentaDTO
 *
 * @author José Rodríguez jgrodriguez@qaurksoft.net
 * @creationDate 14/05/2019 13:28 hrs.
 * @version 0.1
 */
public abstract class ReporteEstadoCuentaBuilder {

	public ReporteEstadoCuentaBuilder() {
		super();
	}

	/**
	 * Construye un set de objetos de tipo ReporteEstadoCuentaDTO a partir de una lista
	 * de entities de tipo Reporte.
	 * 
	 * @param reporteSet
	 * @return reporteEstadoCuentaDTOSet
	 */
	public static ReporteEstadoCuentaDTO buildReporteEstadoCuentaDTOFromReporteList(List<Reporte> reporteList) {
		ReporteEstadoCuentaDTO reporteEstadoCuentaDTO = new ReporteEstadoCuentaDTO();
		reporteEstadoCuentaDTO.setDisponible(false);

		if (reporteList != null && !reporteList.isEmpty()) {
			for (Reporte reporte : reporteList) {
				if (reporte.getTipo() == TipoReporteEnum.ESTADO_CUENTA) {
					reporteEstadoCuentaDTO.setFechaDesde(reporte.getFechaDesde());
					reporteEstadoCuentaDTO.setFechaHasta(reporte.getFechaHasta());
					reporteEstadoCuentaDTO.setDisponible(reporte.getDisponible());
					break;
				}
			}
		}
		return reporteEstadoCuentaDTO;
	}

}
