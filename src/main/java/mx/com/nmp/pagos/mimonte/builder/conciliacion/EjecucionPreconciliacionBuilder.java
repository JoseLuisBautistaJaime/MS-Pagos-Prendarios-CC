/*
 * Proyecto:        NMP - HABILITAR COBRANZA 24/7 -  CONCILIACION AUTOMATICA.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.builder.conciliacion;

import mx.com.nmp.pagos.mimonte.dto.conciliacion.ConsultaEjecucionPreconciliacionDTO;
import mx.com.nmp.pagos.mimonte.model.conciliacion.CorresponsalEnum;
import mx.com.nmp.pagos.mimonte.model.conciliacion.EjecucionPreconciliacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Nombre: ConciliacionBuilder Descripcion: Clase de capa de builder que se
 * encarga de convertir diferentes tipos de objetos y entidades relacionadas con
 * la conciliación
 *
 * @author Juan Manuel Reveles jmreveles@quarksoft.net
 * @creationDate 05/11/2021 11:18 hrs.
 * @version 0.1
 */
public abstract class EjecucionPreconciliacionBuilder {

	private EjecucionPreconciliacionBuilder() {
		super();
	}

	/**
	 * Construye un objeto de tipo List<ConsultaEjecucionPreconciliacionDTO> a partir un entitie
	 * de tipo List<EjecucionConciliacion>.
	 *
	 * @param ejecucionPreconciliacionList
	 * @return
	 */
	public static List<ConsultaEjecucionPreconciliacionDTO> buildConsultaEjecucionPreconciliacionDTOListFromEjecucionPreconciliacionList(List<EjecucionPreconciliacion> ejecucionPreconciliacionList) {
		List<ConsultaEjecucionPreconciliacionDTO> ConsultaEjecucionConciliacionDTOList = null;
		if (ejecucionPreconciliacionList != null && !ejecucionPreconciliacionList.isEmpty()) {
			ConsultaEjecucionConciliacionDTOList = new ArrayList<>();
			for (EjecucionPreconciliacion elemento : ejecucionPreconciliacionList) {
				ConsultaEjecucionConciliacionDTOList.add(buildConsultaEjecucionPreconciliacionDTOFromEjecucionPreconciliacion(elemento));
			}
		}
		return ConsultaEjecucionConciliacionDTOList;
	}

	/**
	 * Construye un objeto de tipo ConsultaEjecucionPreconciliacionDTO a partir de una entidad
	 * EjecucionPreconciliacion
	 *
	 * @param ejecucionPreconciliacion
	 * @return consultaEjecucionPreconciliacionDTO
	 */
	public static ConsultaEjecucionPreconciliacionDTO buildConsultaEjecucionPreconciliacionDTOFromEjecucionPreconciliacion(EjecucionPreconciliacion ejecucionPreconciliacion) {
		ConsultaEjecucionPreconciliacionDTO consultaEjecucionPreconciliacionDTO = null;
		if (ejecucionPreconciliacion != null) {
			consultaEjecucionPreconciliacionDTO = new ConsultaEjecucionPreconciliacionDTO();
			consultaEjecucionPreconciliacionDTO.setId(ejecucionPreconciliacion.getId());
			consultaEjecucionPreconciliacionDTO.setEstatusDescripcion(ejecucionPreconciliacion.getEstatusDescripcion());
			consultaEjecucionPreconciliacionDTO.setEstatus(EstatusEjecucionPreconciliacionBuilder.buildEstatusEjecucionConciliacionDTOFromEstatusEjecucionConciliacion(ejecucionPreconciliacion.getEstatus()));
			consultaEjecucionPreconciliacionDTO.setFechaEjecucion(ejecucionPreconciliacion.getFechaEjecucion());
			consultaEjecucionPreconciliacionDTO.setFechaPeriodoInicio(ejecucionPreconciliacion.getFechaPeriodoInicio());
			consultaEjecucionPreconciliacionDTO.setFechaPeriodoFin(ejecucionPreconciliacion.getFechaPeriodoFin());
			consultaEjecucionPreconciliacionDTO.setCreatedBy(ejecucionPreconciliacion.getCreatedBy());
			consultaEjecucionPreconciliacionDTO.setCreatedDate(ejecucionPreconciliacion.getCreatedDate());
			consultaEjecucionPreconciliacionDTO.setLastModifiedBy(ejecucionPreconciliacion.getLastModifiedBy());
			consultaEjecucionPreconciliacionDTO.setLastModifiedDate(ejecucionPreconciliacion.getLastModifiedDate());
			consultaEjecucionPreconciliacionDTO.setCorresponsal(ejecucionPreconciliacion.getProveedor() != null ? ejecucionPreconciliacion.getProveedor().getNombre() : CorresponsalEnum.OPENPAY);
		}
		return consultaEjecucionPreconciliacionDTO;
	}
	
}
