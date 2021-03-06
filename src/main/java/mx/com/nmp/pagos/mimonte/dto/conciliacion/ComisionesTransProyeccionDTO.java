/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dto.conciliacion;

import java.math.BigDecimal;
import java.util.List;

/**
 * @name ComisionesTransProyeccionDTO
 * @description Clase que encapsula la información de las proyecciones.
 *
 * @author José Rodríguez jgrodriguez@quarksoft.net
 * @creationDate 12/04/2019 23:02 hrs.
 * @version 0.1
 */
public class ComisionesTransProyeccionDTO implements Comparable<ComisionesTransProyeccionDTO> {

	private List<ComisionesTransaccionesOperacionDTO> operaciones;

	private BigDecimal totalOperaciones;

	public ComisionesTransProyeccionDTO() {
		super();
	}

	public ComisionesTransProyeccionDTO(List<ComisionesTransaccionesOperacionDTO> operaciones,
			BigDecimal totalOperaciones) {
		super();
		this.operaciones = operaciones;
		this.totalOperaciones = totalOperaciones;
	}

	public List<ComisionesTransaccionesOperacionDTO> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<ComisionesTransaccionesOperacionDTO> operaciones) {
		this.operaciones = operaciones;
	}

	public BigDecimal getTotalOperaciones() {
		return totalOperaciones;
	}

	public void setTotalOperaciones(BigDecimal totalOperaciones) {
		this.totalOperaciones = totalOperaciones;
	}

	@Override
	public String toString() {
		return "ComisionesTransProyeccionDTO [operaciones=" + operaciones + ", totalOperaciones=" + totalOperaciones
				+ "]";
	}

	@Override
	public int compareTo(ComisionesTransProyeccionDTO o) {
		return 0;
	}

}
