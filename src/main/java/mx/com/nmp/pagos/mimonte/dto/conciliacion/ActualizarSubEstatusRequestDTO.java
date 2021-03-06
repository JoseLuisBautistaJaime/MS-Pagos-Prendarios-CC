/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dto.conciliacion;

import java.util.Objects;

/**
 * @name ActualizarSubEstatusRequestDTO
 * @description Clase que encapsula la información del request de la
 *              actualizacion del usb estatus de una conciliacion
 *
 * @author Ismael Flores iaguilar@quarksoft.net
 * @creationDate 10/06/2019 19:25 hrs.
 * @version 0.1
 */
public class ActualizarSubEstatusRequestDTO {

	private Long folio;
	private Long idSubEstatus;
	private Integer idEstatus;
	private String descripcion;

	public ActualizarSubEstatusRequestDTO() {
		super();
	}

	public ActualizarSubEstatusRequestDTO(Long folio, Long idSubEstatus, String descripcion) {
		super();
		this.folio = folio;
		this.idSubEstatus = idSubEstatus;
		this.descripcion = descripcion;
	}

	public ActualizarSubEstatusRequestDTO(Long folio, Long idSubEstatus, Integer idEstatus, String descripcion) {
		super();
		this.folio = folio;
		this.idSubEstatus = idSubEstatus;
		this.idEstatus = idEstatus;
		this.descripcion = descripcion;
	}

	public Long getFolio() {
		return folio;
	}

	public void setFolio(Long folio) {
		this.folio = folio;
	}

	public Long getIdSubEstatus() {
		return idSubEstatus;
	}

	public void setIdSubEstatus(Long idSubEstatus) {
		this.idSubEstatus = idSubEstatus;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(folio, idSubEstatus, descripcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof ActualizarSubEstatusRequestDTO))
			return false;

		final ActualizarSubEstatusRequestDTO other = (ActualizarSubEstatusRequestDTO) obj;
		return (this.hashCode() == other.hashCode());

	}

	@Override
	public String toString() {
		return "ActualizarSubEstatusRequestDTO [folio=" + folio + ", idSubEstatus=" + idSubEstatus + ", descripcion="
				+ descripcion + "]";
	}

}
