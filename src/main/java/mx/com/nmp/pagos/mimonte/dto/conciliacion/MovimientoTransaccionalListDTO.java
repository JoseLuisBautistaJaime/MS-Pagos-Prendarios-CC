/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dto.conciliacion;

import java.math.BigDecimal;
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

	private List<MovimientoTransaccionalDTO> movimientos;
	private BigDecimal total;

	public MovimientoTransaccionalListDTO() {
		super();
	}

	public MovimientoTransaccionalListDTO(List<MovimientoTransaccionalDTO> movimientos, BigDecimal total) {
		super();
		this.movimientos = movimientos;
		this.total = total;
	}

	public List<MovimientoTransaccionalDTO> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoTransaccionalDTO> movimientos) {
		this.movimientos = movimientos;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "MovimientoTransaccionalListDTO [movimientos=" + movimientos + ", total=" + total + "]";
	}

}