/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.dto.conciliacion;

/**
 * @name ComisionesTransDTO
 * @description Clase que encapsula la información de una conciliación.
 *
 * @author José Rodríguez jgrodriguez@quarksoft.net
 * @creationDate 12/04/2019 23:00 hrs.
 * @version 0.1
 */
public class ComisionesTransDTO implements Comparable<ComisionesTransDTO> {

	private ComisionesTransProyeccionDTO proyeccion;
	private ComisionesTransRealDTO real;

	public ComisionesTransDTO() {
		super();
	}

	public ComisionesTransDTO(ComisionesTransProyeccionDTO proyeccion, ComisionesTransRealDTO real) {
		super();
		this.proyeccion = proyeccion;
		this.real = real;
	}

	public ComisionesTransProyeccionDTO getProyeccion() {
		return proyeccion;
	}

	public void setProyeccion(ComisionesTransProyeccionDTO proyeccion) {
		this.proyeccion = proyeccion;
	}

	public ComisionesTransRealDTO getReal() {
		return real;
	}

	public void setReal(ComisionesTransRealDTO real) {
		this.real = real;
	}

	@Override
	public String toString() {
		return "ComisionesTransDTO [proyeccion=" + proyeccion + "real=" + real + "]";
	}

	@Override
	public int compareTo(ComisionesTransDTO o) {
		return 0;
	}

}