/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.model.conciliacion;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mx.com.nmp.pagos.mimonte.model.Updatable;

/**
 * @name Reporte
 * @description Encapsula la informacion perteneciente a un reporte
 * 
 * @author Quarksoft
 * @version 1.0
 * @created 31-Mar-2019 5:57:54 PM
 */
@Entity
@Table(name = "to_reporte")
public class Reporte extends Updatable implements Comparable<Reporte> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_conciliacion", nullable = false)
	private Conciliacion conciliacion;

	@Column(name = "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoReporteEnum tipo;

	@Column(name = "disponible", nullable = false)
	private Boolean disponible;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_desde", nullable = false)
	private Date fechaDesde;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_hasta", nullable = false)
	private Date fechaHasta;

	public Reporte() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conciliacion getConciliacion() {
		return conciliacion;
	}

	public void setConciliacion(Conciliacion conciliacion) {
		this.conciliacion = conciliacion;
	}

	public TipoReporteEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoReporteEnum tipo) {
		this.tipo = tipo;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	@Override
	public String toString() {
		return "Reporte [id=" + id + ", conciliacion=" + conciliacion + ", tipo=" + tipo + ", disponible=" + disponible
				+ ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + "]";
	}

	@Override
	public int compareTo(Reporte o) {
		return o.id.compareTo(this.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, conciliacion, tipo, disponible, fechaDesde, fechaHasta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Reporte))
			return false;

		final Reporte other = (Reporte) obj;
		return (this.hashCode() == other.hashCode());

	}

}