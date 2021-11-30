/*
 * Proyecto:        NMP - HABILITAR COBRANZA 24/7 -  CONCILIACION AUTOMATICA.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dao.conciliacion;

import mx.com.nmp.pagos.mimonte.dto.conciliacion.TrazadoEjecucionConciliacionDTO;
import mx.com.nmp.pagos.mimonte.model.conciliacion.TrazadoEjecucionConciliacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name TrazadoEjecucionConciliacionRepository
 * @description Interface de capa DAO que sirve para realizar operaciones de
 *              base de datos relacionadas con el trazado de la ejecución de la conciliación
 *
 * @author Juan Manuel Reveles jmreveles@quarksoft.net
 * @creationDate 29/10/2021 16:56 hrs.
 * @version 0.1
 */
@Repository("trazadoEjecucionConciliacionRepository")
public interface TrazadoEjecucionConciliacionRepository extends JpaRepository<TrazadoEjecucionConciliacion, Integer>{

	/**
	 * Búsqueda de las entidades TrazadoEjecucionConciliacion asociadas a la ejecución de un proceso de conciliación.
	 * @param idEjecucionConciliacion
	 * @return
	 */
	@Query("FROM TrazadoEjecucionConciliacion c WHERE ( c.ejecucionConciliacion.id = :idEjecucionConciliacion )")
	public List<TrazadoEjecucionConciliacion> findByEjecucionConciliacion(@Param("idEjecucionConciliacion") final Long idEjecucionConciliacion);

	/**
	 * Búsqueda del trazado de estatus  de una ejecución del proceso de conciliación.
	 * @param idEjecucionConciliacion
	 * @return
	 */
	@Query("SELECT new mx.com.nmp.pagos.mimonte.dto.conciliacion.TrazadoEjecucionConciliacionDTO(c.id, c.estatus,c.estatusDescripcion, c.fechaInicio, c.fechaFin) FROM TrazadoEjecucionConciliacion c " +
			"WHERE ( c.ejecucionConciliacion.id = :idEjecucionConciliacion )")
	public List<TrazadoEjecucionConciliacionDTO> findTrazadoEstatusEjecucionConciliacion(@Param("idEjecucionConciliacion") final Long idEjecucionConciliacion);


}