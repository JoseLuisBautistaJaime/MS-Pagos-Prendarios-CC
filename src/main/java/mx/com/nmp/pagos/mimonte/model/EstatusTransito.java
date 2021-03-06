package mx.com.nmp.pagos.mimonte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.com.nmp.pagos.mimonte.model.conciliacion.MovimientoTransito;

/**
 * @name EstatusOperacion
 * @description Clase que mapea el catalogo de EstatusTransito
 * @date: 31/01/2018 14:49 hrs.
 * @version 0.1
 */
@Entity
@Table(name = "tk_estatus_movimientos_en_transito")
public class EstatusTransito extends AbstractCatalogo implements Serializable{

	/**
	 * Serial id.
	 */
	private static final long serialVersionUID = 7869588361293186039L;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "estatus")
	private Boolean estatus;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "last_modified_by")
	private String lastModifiedBy;
	
	@OneToMany(mappedBy = "estatus")
	private Set<MovimientoTransito> movimientoTransitoSet;

	public EstatusTransito() {
		super();
	}

	public EstatusTransito(Integer id, String descripcionCorta, String descripcion) {
		super(id, descripcionCorta, descripcion);
	}

	public EstatusTransito(Integer id) {
		super(id);
	}

	public EstatusTransito(String nombre, Boolean estatus, Date createdDate, Date lastModifiedDate, String createdBy,
			String lastModifiedBy) {
		super();
		this.nombre = nombre;
		this.estatus = estatus;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Set<MovimientoTransito> getMovimientoTransitoSet() {
		return movimientoTransitoSet;
	}

	public void setMovimientoTransitoSet(Set<MovimientoTransito> movimientoTransitoSet) {
		this.movimientoTransitoSet = movimientoTransitoSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((estatus == null) ? 0 : estatus.hashCode());
		result = prime * result + ((lastModifiedBy == null) ? 0 : lastModifiedBy.hashCode());
		result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstatusTransito other = (EstatusTransito) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (estatus == null) {
			if (other.estatus != null)
				return false;
		} else if (!estatus.equals(other.estatus))
			return false;
		if (lastModifiedBy == null) {
			if (other.lastModifiedBy != null)
				return false;
		} else if (!lastModifiedBy.equals(other.lastModifiedBy))
			return false;
		if (lastModifiedDate == null) {
			if (other.lastModifiedDate != null)
				return false;
		} else if (!lastModifiedDate.equals(other.lastModifiedDate))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstatusTransito [nombre=" + nombre + ", estatus=" + estatus + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", createdBy=" + createdBy + ", lastModifiedBy="
				+ lastModifiedBy + "]";
	}
	
}
