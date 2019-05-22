/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dao.conciliacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.nmp.pagos.mimonte.model.conciliacion.MovimientoConciliacion;

/**
 * @name MovimientoConciliacionRepository
 * @description Interface de capa DAO que sirve para realizar operaciones de
 *              base de datos relacionadas con los movimientos de la
 *              conciliacion.
 *
 * @author José Rodríguez jgrodriguez@quarksoft.net
 * @creationDate 08/05/2019 19:04 hrs.
 * @version 0.1
 */
@Repository("MovimientoConciliacionRepository")
public interface MovimientoConciliacionRepository extends JpaRepository<MovimientoConciliacion, Integer> {

	/**
	 * Búsqueda de los movimientos de la conciliación a partir del folio.
	 * 
	 * @param folio
	 * @return
	 */
	@Query("FROM MovimientoConciliacion mc WHERE mc.id = :folio")
	public MovimientoConciliacion findByIdMovimientoConciliacion(@Param("folio") final Integer folio);

}