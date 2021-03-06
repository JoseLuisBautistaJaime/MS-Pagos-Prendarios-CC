package mx.com.nmp.pagos.mimonte.model.conciliacion;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import mx.com.nmp.pagos.mimonte.model.Updatable;

/**
 * The persistent class for the to_layout_header database table.
 * 
 */
@Entity
@Table(name = "to_layout_header")
public class LayoutHeader extends Updatable implements Serializable, LayoutReporte {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(name = "cabecera")
	private String cabecera;

	@Column(name = "campo1")
	private String campo1;

	@Column(name = "campo2")
	private String campo2;

	@Column(name = "codigo_origen")
	private String codigoOrigen;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "unidad_negocio")
	private String unidadNegocio;

	@OneToOne
	@JoinColumn(name = "id_layout")
	private Layout layout;

	public LayoutHeader() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCabecera() {
		return this.cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public String getCampo1() {
		return this.campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public String getCampo2() {
		return this.campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	public String getCodigoOrigen() {
		return this.codigoOrigen;
	}

	public void setCodigoOrigen(String codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getUnidadNegocio() {
		return this.unidadNegocio;
	}

	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}

	public Layout getLayout() {
		return this.layout;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

}