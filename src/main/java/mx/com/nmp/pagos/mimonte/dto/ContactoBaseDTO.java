/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dto;

import java.util.Date;
import java.util.Set;

import mx.com.nmp.pagos.mimonte.model.Entidad;

/**
 * Nombre: ContactoBaseDTO Descripcion: DTO que encapsula la información de los contactos.
 *
 * @author José Rodríguez jgrodriguez@quarksoft.net
 * @version 0.1
 */
public class ContactoBaseDTO extends AbstractCatalogoDTO implements Comparable<ContactoBaseDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5434400157313710451L;

	private String nombre;
	private String email;
	private TipoContactoDTO tipoContacto;
	private Set<Entidad> entidades;

	public ContactoBaseDTO() {
		super();
	}

	public ContactoBaseDTO(String nombre, String email, TipoContactoDTO tipoContacto, Set<Entidad> entidades) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.tipoContacto = tipoContacto;
		this.entidades = entidades;
	}

	public ContactoBaseDTO(String nombre, String email, TipoContactoDTO tipoContacto, Set<Entidad> entidades, Long id,
			Boolean estatus, Date createdDate, Date lastModifiedDate, String createdBy, String lastModifiedBy,
			String description, String shortDescription) {
		super(id, estatus, createdDate, lastModifiedDate, createdBy, lastModifiedBy, description, shortDescription);
		this.nombre = nombre;
		this.email = email;
		this.tipoContacto = tipoContacto;
		this.entidades = entidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoContactoDTO getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContactoDTO tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Set<Entidad> getEntidades() {
		return entidades;
	}

	public void setEntidades(Set<Entidad> entidades) {
		this.entidades = entidades;
	}

	@Override
	public String toString() {
		return "ContactoBaseDTO [nombre=" + nombre + ", email=" + email + ", tipoContacto=" + tipoContacto
				+ ", entidades=" + entidades + ", id=" + id + ", estatus=" + estatus + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", createdBy=" + createdBy + ", lastModifiedBy="
				+ lastModifiedBy + ", description=" + description + ", shortDescription=" + shortDescription + "]";
	}

	@Override
	public int compareTo(ContactoBaseDTO o) {
		return o.nombre.compareTo(this.nombre);
	}

}
