/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dto;

/**
 * Nombre: Contacto Descripcion: Clase que encapsula la informacion
 * perteneciente a un contacto.
 *
 * @author José Rodriguez jgrodriguez@quarksoft.net Fecha: 06/03/2019 21:04 hrs.
 * @version 0.1
 */
public class ContactoReqUpdateDTO {

	private Integer id;

	private Boolean estatus;

	private String nombre;

	private String email;

	private String descripcion;

	private TipoContactoReqDTO tipoContacto;

	public ContactoReqUpdateDTO() {
		super();
	}

	public ContactoReqUpdateDTO(Integer id, Boolean estatus, String nombre, String email, String descripcion,
			TipoContactoReqDTO tipoContacto) {
		super();
		this.id = id;
		this.estatus = estatus;
		this.nombre = nombre;
		this.email = email;
		this.descripcion = descripcion;
		this.tipoContacto = tipoContacto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoContactoReqDTO getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContactoReqDTO tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	@Override
	public String toString() {
		return "ContactoReqUpdateDTO [id=" + id + ", estatus=" + estatus + ", nombre=" + nombre + ", email=" + email
				+ ", descripcion=" + descripcion + ", tipoContactoReqDTO=" + tipoContacto + "]";
	}

}
