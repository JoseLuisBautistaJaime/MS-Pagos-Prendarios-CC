package mx.com.nmp.pagos.mimonte.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nombre: Contacto
 * Descripcion: Entidad que representa al contacto dentro del sistema.
 *
 * @author José Rodríguez jgrodriguez@quarksoft.net Fecha: 05/03/2019 12:04 Hrs.
 * @version 0.1
 */
@Entity
@Table(name = "tk_contactos")
public class Contactos extends AbstractCatalogoAdm implements Serializable{

	private static final long serialVersionUID = -2473378930460136183L;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "tipo_contacto")
	private TipoContacto tipoContacto;

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

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, email, tipoContacto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contactos other = (Contactos) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipoContacto == null) {
			if (other.tipoContacto != null)
				return false;
		} else if (!tipoContacto.equals(other.tipoContacto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contactos [nombre=" + nombre + ", email=" + email + ", tipoContacto=" + tipoContacto + "]";
	}

}