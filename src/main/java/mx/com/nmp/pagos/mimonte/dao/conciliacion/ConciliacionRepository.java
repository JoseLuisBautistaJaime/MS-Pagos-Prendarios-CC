package mx.com.nmp.pagos.mimonte.dao.conciliacion;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.nmp.pagos.mimonte.dto.conciliacion.DevolucionEntidadDetalleDTO;
import mx.com.nmp.pagos.mimonte.model.Cuenta;
import mx.com.nmp.pagos.mimonte.model.Entidad;
import mx.com.nmp.pagos.mimonte.model.conciliacion.Conciliacion;
import mx.com.nmp.pagos.mimonte.model.conciliacion.EstatusConciliacion;
import mx.com.nmp.pagos.mimonte.model.conciliacion.SubEstatusConciliacion;

/**
 * @author Quarksoft
 * @version 1.0
 * @created 31-Mar-2019 6:33:59 PM
 */
@Repository("conciliacionRepository")
public interface ConciliacionRepository extends PagingAndSortingRepository<Conciliacion, Integer> {

	/**
	 * Búsquda de la conciliación a partir del folio.
	 * 
	 * @param folio
	 * @return
	 */
	@Query("FROM Conciliacion c WHERE c.id = :folio")
	public Conciliacion findByFolio(@Param("folio") final Integer folio);

	/**
	 * Búsqueda de la conciliación a partir de del id.
	 */
	public Optional<Conciliacion> findById(Integer id);

	/**
	 * Búsqueda de la conciliacíon a partir de la entidad.
	 * 
	 * @param entidad
	 * @return
	 */
	public List<Conciliacion> findByEntidad(Entidad entidad);

	/**
	 * Búsqueda de la conciliación a partir del estatus de la conciliación.
	 * 
	 * @param estatus
	 * @return
	 */
	public List<Conciliacion> findByEstatus(EstatusConciliacion estatus);

	/**
	 * Búsqueda de la conciliación a partir de la cuenta.
	 * 
	 * @param cuenta
	 * @return
	 */
	public List<Conciliacion> findByCuenta(Cuenta cuenta);

	/**
	 * Búsqueda de la conciliacion a partir del folio, id entidad, id estatus de la
	 * conciliación, fecha desde y fecha hasta.
	 * 
	 * @param folio
	 * @param idEntidad
	 * @param idEstatus
	 * @param fechaDesde
	 * @param fechaHasta
	 * @return
	 */
	@Query("FROM Conciliacion c WHERE ( :folio IS NULL OR c.id = :folio ) AND ( :idEntidad IS NULL OR c.entidad.id = :idEntidad ) AND ( :idEstatus IS NULL OR c.estatus.id = :idEstatus) AND c.createdDate BETWEEN :fechaDesde AND :fechaHasta")
	public List<Conciliacion> findByFolioAndIdEntidadAndIdEstatusAndFecha(@Param("folio") final Integer folio,
			@Param("idEntidad") final Long idEntidad, @Param("idEstatus") final Integer idEstatus,
			@Param("fechaDesde") final Date fechaDesde, @Param("fechaHasta") final Date fechaHasta);
	
	/**
	 * 
	 * @param idEstatus
	 * @param idEntidad
	 * @param identificadorCuenta
	 * @param sucursal
	 * @param fechaDesde
	 * @param fechaHasta
	 * @return
	 */
	@Query("SELECT new mx.com.nmp.pagos.mimonte.dto.conciliacion.DevolucionEntidadDetalleDTO (md.id, c.entidad.id, c.entidad.nombre, c.entidad.description, md.fecha, c.estatus.id, c.estatus.descripcion, c.estatus.estatus, md.sucursal,  md.identificadorCuenta, md.monto, md.esquemaTarjeta, md.titular, md.codigoAutorizacion, md.fechaLiquidacion ) FROM Conciliacion c INNER JOIN MovimientoConciliacion mc ON c.id = mc.idConciliacion INNER JOIN MovimientoDevolucion md ON mc.id = md.id "
			+ " WHERE ( :idEstatus IS NULL OR c.estatus.id = :idEstatus ) AND "
			+ "( :idEntidad IS NULL OR c.entidad.id = :idEntidad ) AND "
			+ "( :identificadorCuenta IS NULL OR md.identificadorCuenta = :identificadorCuenta ) AND "
			+ "( :sucursal IS NULL OR md.sucursal = :sucursal ) AND "
			+ " c.createdDate BETWEEN :fechaDesde AND :fechaHasta ")
	public List<DevolucionEntidadDetalleDTO> findByIdEstatusOrIdEntidadOrIdentificadorCuentaOrSucursal(
			@Param("idEstatus") final Integer idEstatus, 
			@Param("idEntidad") final Long idEntidad, 
			@Param("identificadorCuenta") final String identificadorCuenta,
			@Param("sucursal") final Integer sucursal,
			@Param("fechaDesde") final Date fechaDesde,
			@Param("fechaHasta") final Date fechaHasta);
	
	@Query("FROM Conciliacion c INNER JOIN MovimientoConciliacion mc ON c.id = mc.idConciliacion INNER JOIN MovimientoDevolucion md ON mc.id = md.id WHERE md.id = :ids ")
	public List<Conciliacion> findByIdDevolucion(@Param("ids") final Integer ids);
	
	/**
	 * Regresa un mapa con tres valores, [en_proceso]: Con el total de las conciliaciones en proceso, [dev_liquidadas]: Con el total de las devoluciones liquidadas y [conc_totales]: Con el total de conciliaciones,
	 * esto con un filtro de fecha que se aplica para la fecha y creacion o modificacion de la conciliacion y el campo fecha de el movimiento devolucion
	 * @param fechaIncial
	 * @param fechaFinal
	 * @param estatusConcProcesada
	 * @param estatusDevLiquidada
	 * @return
	 */
	@Query(nativeQuery = true, value= "SELECT " + 
			"(SELECT COUNT(*) " + 
			"FROM to_conciliacion " + 
			"	WHERE id_estatus_conciliacion LIKE '%:estatusConcProcesada%' " + 
			"		AND " + 
			"			CASE " + 
			"				WHEN last_modified_date IS NOT NULL " + 
			"					THEN last_modified_date BETWEEN :fechaIncial AND :fechaFinal " + 
			"				ELSE created_date BETWEEN :fechaIncial AND :fechaFinal END " + 
			"	) AS en_proceso, " + 
			"(SELECT COUNT(*) " + 
			"	FROM to_movimiento_devolucion " + 
			"	WHERE estatus LIKE '%:estatusDevLiquidada%' " + 
			"		AND fecha BETWEEN :fechaIncial AND :fechaFinal " + 
			"    ) AS dev_liquidadas, " + 
			"(SELECT COUNT(*) " + 
			"	FROM to_conciliacion " + 
			"    ) AS conc_totales;")
	public Map<String, Long> resumenConciliaciones(@Param("fechaIncial") Date fechaIncial, @Param("fechaFinal") Date fechaFinal, @Param("estatusConcProcesada") final String estatusConcProcesada, @Param("estatusDevLiquidada") final String estatusDevLiquidada);
	
	/**
	 * Regresa un mapa con tres valores, [en_proceso]: Con el total de las conciliaciones en proceso, [dev_liquidadas]: Con el total de las devoluciones liquidadas y [conc_totales]: Con el total de conciliaciones
	 * @param estatusConcProcesada
	 * @param estatusDevLiquidada
	 * @return
	 */
	@Query(nativeQuery = true, value = "SELECT " + 
			"(SELECT COUNT(*) " + 
			"FROM to_conciliacion " + 
			"	WHERE id_estatus_conciliacion LIKE '%:estatusConcProcesada%' " + 
			"	) AS en_proceso, " + 
			"(SELECT COUNT(*) " + 
			"	FROM to_movimiento_devolucion " + 
			"	WHERE estatus LIKE '%:estatusDevLiquidada%' " + 
			"    ) AS dev_liquidadas, " + 
			"(SELECT COUNT(*) " + 
			"	FROM to_conciliacion " + 
			"    ) AS conc_totales;")
	public Map<String, Long> resumenConciliaciones(@Param("folio") final String estatusConcProcesada, @Param("estatusDevLiquidada") final String estatusDevLiquidada);
	
	/**
	 * Regresa el id de estatus de una conciliacion dependiendo de su id de subestatus
	 * @param idSubEstatus
	 * @return
	 */
	@Query(nativeQuery = true, value = "SELECT DISTINCT id_estatus FROM tr_estatus_conciliacion_sub_estatus_conciliacion WHERE id_sub_estatus = :idSubEstatus ORDER BY id_estatus ASC LIMIT 1")
	public Integer findIdEstatusConciliacion(@Param("idSubEstatus") Long idSubEstatus);
	
	/**
	 * Se actualiza el subestatus de una conciliacion por folio de la misma
	 * @param folio
	 * @param subEstatus
	 * @param usuario
	 * @param fecha
	 */
	@Modifying
	@Query("UPDATE Conciliacion SET subEstatus = :subEstatus, estatus= :estatusConciliacion, lastModifiedBy = :usuario, lastModifiedDate = :fecha WHERE id = :folio")
	public void actualizaSubEstatusConciliacion(@Param("folio") final Integer folio, @Param("subEstatus") SubEstatusConciliacion subEstatus, @Param("usuario") final String usuario, @Param("fecha") Date fecha, @Param("estatusConciliacion") final EstatusConciliacion estatusConciliacion);
	
}