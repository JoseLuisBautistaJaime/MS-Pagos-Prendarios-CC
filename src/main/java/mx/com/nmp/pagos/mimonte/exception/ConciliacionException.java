/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.exception;

/**
 * @name ConciliacionException
 * @description Clase de excepcion lanzada cuando se egenra un error de
 *              validaciones relacionados con la conciliacion
 * 
 * @author Ismael Flores iaguilar@quarksoft.net
 * @version 1.0
 * @createdDate 30/04/2019 12:35 hrs.
 */
public class ConciliacionException extends RuntimeException {

	/**
	 * Serial id
	 */
	private static final long serialVersionUID = 1L;

	public ConciliacionException(String message) {
		super(message);
	}

}
