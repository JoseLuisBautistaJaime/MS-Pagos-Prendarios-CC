/*
 * Proyecto:        NMP - HABILITAR COBRANZA 24/7 -  CONCILIACION AUTOMATICA.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dto.conciliacion;

import java.util.Date;

/**
 * @author Quarksoft
 * @version 1.0
 * @created 03-Nov-2021 11:33:55 AM
 */
public class FiltroEjecucionConciliacionDTO  {

	private Integer idEstatus;
	private Long idEntidad;
	private Long idCuenta;
	private Long idConciliacion;
	private Date fechaPeriodoInicio;
	private Date fechaPeriodoFin;
	private Date fechaEjecucionDesde;
	private Date fechaEjecucionHasta;
	private String corresponsal;

	public FiltroEjecucionConciliacionDTO() {
		super();
	}

	public FiltroEjecucionConciliacionDTO(Integer idEstatus, Long idEntidad, Long idCuenta, Long idConciliacion, Date fechaPeriodoInicio, Date fechaPeriodoFin, Date fechaEjecucionDesde, Date fechaEjecucionHasta, String corresponsal) {
		super();
		this.idEstatus = idEstatus;
		this.idEntidad = idEntidad;
		this.idCuenta = idCuenta;
		this.idConciliacion = idConciliacion;
		this.fechaPeriodoInicio = fechaPeriodoInicio;
		this.fechaPeriodoFin = fechaPeriodoFin;
		this.fechaEjecucionDesde = fechaEjecucionDesde;
		this.fechaEjecucionHasta = fechaEjecucionHasta;
		this.corresponsal = corresponsal;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public Long getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Long getIdConciliacion() {
		return idConciliacion;
	}

	public void setIdConciliacion(Long idConciliacion) {
		this.idConciliacion = idConciliacion;
	}

	public Date getFechaPeriodoInicio() {
		return fechaPeriodoInicio;
	}

	public void setFechaPeriodoInicio(Date fechaPeriodoInicio) {
		this.fechaPeriodoInicio = fechaPeriodoInicio;
	}

	public Date getFechaPeriodoFin() {
		return fechaPeriodoFin;
	}

	public void setFechaPeriodoFin(Date fechaPeriodoFin) {
		this.fechaPeriodoFin = fechaPeriodoFin;
	}

	public Date getFechaEjecucionDesde() {
		return fechaEjecucionDesde;
	}

	public void setFechaEjecucionDesde(Date fechaEjecucionDesde) {
		this.fechaEjecucionDesde = fechaEjecucionDesde;
	}

	public Date getFechaEjecucionHasta() {
		return fechaEjecucionHasta;
	}

	public void setFechaEjecucionHasta(Date fechaEjecucionHasta) {
		this.fechaEjecucionHasta = fechaEjecucionHasta;
	}

	public String getCorresponsal() {
		return corresponsal;
	}

	public void setCorresponsal(String corresponsal) {
		this.corresponsal = corresponsal;
	}

	@Override
	public String toString() {
		return "FiltroEjecucionConciliacionDTO [idEstatus=" + idEstatus + ", idEntidad=" + idEntidad + ", idCuenta="+ idCuenta
				+ ", idConciliacion=" + idConciliacion + ", fechaPeriodoInicio=" + fechaPeriodoInicio + ", fechaPeriodoFin=" + fechaPeriodoFin
				+ ", fechaEjecucionDesde=" + fechaEjecucionDesde + ", fechaEjecucionHasta=" + fechaEjecucionHasta + ", corresponsal=" + corresponsal + "]";
	}

}