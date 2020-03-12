/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.services;

import java.sql.SQLDataException;
import java.sql.SQLException;

import org.springframework.dao.DataIntegrityViolationException;

import mx.com.nmp.pagos.mimonte.dto.PagoRequestDTO;
import mx.com.nmp.pagos.mimonte.dto.PagoResponseDTO;

/**
 * Nombre: PagoService Descripcion: Interfaz que define la operacion encargada
 * de realizar un pago de una o mas partidas/contratos
 *
 * @author Ismael Flores iaguilar@quarksoft.net
 * @creationDate: 20/11/2018 13:45 hrs.
 * @version 0.1
 */
public interface PagoService {

	/**
	 * Metodo que se encarga de registrar un pago
	 * 
	 * @param pagoRequestDTO
	 * @return
	 * @throws DataIntegrityViolationException
	 * @throws SQLDataException
	 * @throws SQLException
	 */
	public abstract PagoResponseDTO savePago(PagoRequestDTO pagoRequestDTO)
			throws DataIntegrityViolationException, SQLDataException, SQLException;
}
