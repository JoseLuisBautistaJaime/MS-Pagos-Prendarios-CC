/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dto.conciliacion;

import java.util.List;

/**
 * @name MovimientoTransaccionalListDTO
 * @description Clase que encapsula la informacion relacionada con un respuetsa
 *              a el alta de MovimientosProveedor en una lista
 *
 * @author Ismael Flores iaguilar@quarksoft.net
 * @creationDate 15/04/2019 10:34 hrs.
 * @version 0.1
 */
public class MovimientoTransaccionalListDTO {

	private Long total;
	private List<MovimientoProveedorDTO> movimientos;

	public MovimientoTransaccionalListDTO() {
		super();
	}

	public MovimientoTransaccionalListDTO(Long total, List<MovimientoProveedorDTO> movimientos) {
		super();
		this.total = total;
		this.movimientos = movimientos;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<MovimientoProveedorDTO> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoProveedorDTO> movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public String toString() {
		return "MovimientoTransaccionalListDTO [total=" + total + ", movimientos=" + movimientos + " ]";
	}

}
