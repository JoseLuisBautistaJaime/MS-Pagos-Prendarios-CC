/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dto.conciliacion;

import java.util.Date;
import java.util.List;

import mx.com.nmp.pagos.mimonte.model.conciliacion.CorresponsalEnum;

/**
 * @name ConciliacionDTOList
 * @description Clase que encapsula el request de ConciliacionDTOList para la
 *              conciliación.
 *
 * @author José Rodríguez jgrodriguez@quarksoft.net
 * @creationDate 05/04/2019 14:31 hrs.
 * @version 0.1
 */
public class ConciliacionDTOList extends AbstractConciliacionDTO implements Comparable<ConciliacionDTOList> {
	
	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 1087675429120495856L;
	
	private Long folio;
	private Long folioConciliacion;
	private EstatusConciliacionDTO estatus;
	private SubEstatusConciliacionDTO subEstatus;
	private String subEstatusDescripcion;
	private String idTesoreria;
	private String idAsientoContable;
	private EntidadDTO entidad;
	private CuentaDTO cuenta;
	private ReporteProcesosNocturnosDTO reporteProcesosNocturnos;
	private ReporteProveedorTransaccionalDTO reporteProveedorTransaccional;
	private ReporteEstadoCuentaDTO reporteEstadoCuenta;
	private GlobalDTO global;
	private List<DevolucionConDTO> devoluciones;
	private List<MovTransitoDTO> movimientosTransito;
	private List<ComisionesDTO> comisiones;
	private ComisionesTransDTO comisionesTransacciones;
	private CorresponsalEnum idCorresponsal;


	public ConciliacionDTOList() {
		super();
	}

	public ConciliacionDTOList(Date createdDate, Date lastModifiedDate, String createdBy, String lastModifiedBy) {
		super(createdDate, lastModifiedDate, createdBy, lastModifiedBy);
	}

	public ConciliacionDTOList(Long folio, EstatusConciliacionDTO estatus, SubEstatusConciliacionDTO subEstatus,
			String subEstatusDescripcion, String idTesoreria, String idAsientoContable, EntidadDTO entidad,
			CuentaDTO cuenta, ReporteProcesosNocturnosDTO reporteProcesosNocturnos,
			ReporteProveedorTransaccionalDTO reporteProveedorTransaccional, ReporteEstadoCuentaDTO reporteEstadoCuenta,
			GlobalDTO global, List<DevolucionConDTO> devoluciones, List<MovTransitoDTO> movimientosTransito,
			List<ComisionesDTO> comisiones) {
		super();
		this.folio = folio;
		this.estatus = estatus;
		this.subEstatus = subEstatus;
		this.subEstatusDescripcion = subEstatusDescripcion;
		this.idTesoreria = idTesoreria;
		this.idAsientoContable = idAsientoContable;
		this.entidad = entidad;
		this.cuenta = cuenta;
		this.reporteProcesosNocturnos = reporteProcesosNocturnos;
		this.reporteProveedorTransaccional = reporteProveedorTransaccional;
		this.reporteEstadoCuenta = reporteEstadoCuenta;
		this.global = global;
		this.devoluciones = devoluciones;
		this.movimientosTransito = movimientosTransito;
		this.comisiones = comisiones;
	}

	public Long getFolio() {
		return this.folio;
	}

	public void setFolio(Long folio) {
		this.folio = folio;
	}

	public EstatusConciliacionDTO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusConciliacionDTO estatus) {
		this.estatus = estatus;
	}

	public SubEstatusConciliacionDTO getSubEstatus() {
		return subEstatus;
	}

	public void setSubEstatus(SubEstatusConciliacionDTO subEstatus) {
		this.subEstatus = subEstatus;
	}

	public String getSubEstatusDescripcion() {
		return subEstatusDescripcion;
	}

	public void setSubEstatusDescripcion(String subEstatusDescripcion) {
		this.subEstatusDescripcion = subEstatusDescripcion;
	}

	public String getIdTesoreria() {
		return idTesoreria;
	}

	public void setIdTesoreria(String idTesoreria) {
		this.idTesoreria = idTesoreria;
	}

	public String getIdAsientoContable() {
		return idAsientoContable;
	}

	public void setIdAsientoContable(String idAsientoContable) {
		this.idAsientoContable = idAsientoContable;
	}

	public EntidadDTO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadDTO entidad) {
		this.entidad = entidad;
	}

	public CuentaDTO getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaDTO cuenta) {
		this.cuenta = cuenta;
	}

	public ReporteProcesosNocturnosDTO getReporteProcesosNocturnos() {
		return reporteProcesosNocturnos;
	}

	public void setReporteProcesosNocturnos(ReporteProcesosNocturnosDTO reporteProcesosNocturnos) {
		this.reporteProcesosNocturnos = reporteProcesosNocturnos;
	}

	public ReporteProveedorTransaccionalDTO getReporteProveedorTransaccional() {
		return reporteProveedorTransaccional;
	}

	public void setReporteProveedorTransaccional(ReporteProveedorTransaccionalDTO reporteProveedorTransaccional) {
		this.reporteProveedorTransaccional = reporteProveedorTransaccional;
	}

	public ReporteEstadoCuentaDTO getReporteEstadoCuenta() {
		return reporteEstadoCuenta;
	}

	public void setReporteEstadoCuenta(ReporteEstadoCuentaDTO reporteEstadoCuenta) {
		this.reporteEstadoCuenta = reporteEstadoCuenta;
	}

	public GlobalDTO getGlobal() {
		return global;
	}

	public void setGlobal(GlobalDTO global) {
		this.global = global;
	}

	public List<DevolucionConDTO> getDevoluciones() {
		return devoluciones;
	}

	public void setDevoluciones(List<DevolucionConDTO> devoluciones) {
		this.devoluciones = devoluciones;
	}

	public List<MovTransitoDTO> getMovimientosTransito() {
		return movimientosTransito;
	}

	public void setMovimientosTransito(List<MovTransitoDTO> movimientosTransito) {
		this.movimientosTransito = movimientosTransito;
	}

	public List<ComisionesDTO> getComisiones() {
		return comisiones;
	}

	public void setComisiones(List<ComisionesDTO> comisiones) {
		this.comisiones = comisiones;
	}

	public ComisionesTransDTO getComisionesTransacciones() {
		return comisionesTransacciones;
	}

	public void setComisionesTransacciones(ComisionesTransDTO comisionesTransacciones) {
		this.comisionesTransacciones = comisionesTransacciones;
	}

	public Long getFolioConciliacion() {
		return folioConciliacion;
	}

	public void setFolioConciliacion(Long folioConciliacion) {
		this.folioConciliacion = folioConciliacion;
	}

	public CorresponsalEnum getIdCorresponsal() {
		return idCorresponsal;
	}

	public void setIdCorresponsal(CorresponsalEnum idCorresponsal) {
		this.idCorresponsal = idCorresponsal;
	}

	@Override
	public String toString() {
		return "ConciliacionDTOList [folio=" + folio + ", folioConciliacion=" + folioConciliacion + ", estatus=" + estatus + ", subEstatus=" + subEstatus
				+ ", subEstatusDescripcion=" + subEstatusDescripcion + ", idTesoreria=" + idTesoreria
				+ ", idAsientoContable=" + idAsientoContable + ", entidad=" + entidad + ", cuenta=" + cuenta
				+ ", reporteProcesosNocturnos=" + reporteProcesosNocturnos + ", reporteProveedorTransaccional="
				+ reporteProveedorTransaccional + ", reporteEstadoCuenta=" + reporteEstadoCuenta + ", global=" + global
				+ ", devoluciones=" + devoluciones + ", movimientosTransito=" + movimientosTransito + ", comisiones="
				+ comisiones + ", comisionesTransacciones=" + comisionesTransacciones + ", idCorresponsal=" + idCorresponsal + "]";
	}

	@Override
	public int compareTo(ConciliacionDTOList arg0) {
		return 0;
	}

}
