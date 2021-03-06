package mx.com.nmp.pagos.mimonte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import mx.com.nmp.pagos.mimonte.config.Constants;

/**
 * Nombre: Cliente Descripcion: Entidad que representa al cliente dentro del
 * sistema.
 *
 * @author José Rodríguez jgrodriguez@quarksoft.net Fecha: 21/11/2018 17:15 Hrs.
 * @version 0.1
 */
@Entity
@Table(name = "tk_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 7528374533024645790L;

	@Id
	@Column(name = "id_cliente", unique = true, nullable = false)
	private Long idcliente;

	@Size(max = 100)
	@Column(name = "nombre_titular", length = Constants.LONGITUD_NOMBRE_TITULAR)
	private String nombreTitular;

	@Column(name = "fecha_alta")
	private Date fechaAlta;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente", targetEntity = Pago.class)
	private Set<Pago> pagos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientes")
	private List<Tarjetas> tarjetas;

	public Cliente() {
		super();
	}

	public Cliente(Long idcliente, String nombreTitular, Date fechaAlta) {
		super();
		this.idcliente = idcliente;
		this.nombreTitular = nombreTitular;
		this.fechaAlta = fechaAlta;
	}

	public Cliente(Long idcliente, String nombreTitular, Date fechaAlta, Set<Pago> pagos, List<Tarjetas> tarjetas) {
		super();
		this.idcliente = idcliente;
		this.nombreTitular = nombreTitular;
		this.fechaAlta = fechaAlta;
		this.pagos = pagos;
		this.tarjetas = tarjetas;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idcliente, nombreTitular, fechaAlta, fechaAlta);
	}

	public Set<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public List<Tarjetas> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjetas> tarjetas) {
		this.tarjetas = tarjetas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (idcliente == null) {
			if (other.idcliente != null)
				return false;
		} else if (!idcliente.equals(other.idcliente))
			return false;
		if (nombreTitular == null) {
			if (other.nombreTitular != null)
				return false;
		} else if (!nombreTitular.equals(other.nombreTitular))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", nombreTitular=" + nombreTitular + ", fechaAlta=" + fechaAlta
				+ ", pagos=" + pagos + ", tarjetas=" + tarjetas + "]";
	}

}
