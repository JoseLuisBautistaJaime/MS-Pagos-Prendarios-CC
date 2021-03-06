package mx.com.nmp.pagos.mimonte.services;

import java.util.List;

import mx.com.nmp.pagos.mimonte.dto.TarjeDTO;
import mx.com.nmp.pagos.mimonte.dto.TarjetaDTO;
import mx.com.nmp.pagos.mimonte.exception.TarjetaException;
import mx.com.nmp.pagos.mimonte.model.Tarjetas;

/**
 * Nombre: TarjetasService
 * Descripcion: Interface que define la operacion encargada de obtener los registros de las tarjetas.
 *
 * @author José Rodríguez jgrodriguez@quarksoft.net
 * Fecha: 30/11/2018 12:30 Hrs.
 * @version 0.1
 */
public interface TarjetasService {
	
	/**
	 * Método que obtiene información de las tarjetas.
	 * 
	 * @param idCliente.
	 * @return List<TarjeDTO>.
	 */
	public List<TarjeDTO> getTarjetasIdCliente(Long idCliente);
	
	/**
	 * Método que obtiene información de la tarjeta.
	 * 
	 * @param idCliente.
	 * @param token.
	 * @return TarjeDTO.
	 */
	public TarjeDTO getTarjetasTokenIdCliente(Long idCliente ,String id_openpay);
	
	/**
	 * Método que obttiene información de la tarjeta.
	 * 
	 * @param token.
	 * @return TarjeDTO.
	 */
	public TarjeDTO getTarjetasToken(String id_openpay);

	/**
	 * Método que registra una tarjeta.
	 * 
	 * @param tarjeta
	 * @return Tarjetas.
	 */
	public Tarjetas addTarjetas(TarjetaDTO tarjeta)throws TarjetaException;
	
	/**
	 * Método que actualiza el alias de una tarjeta.
	 * 
	 * @param token.
	 * @param alias.
	 * @return Tarjetas.
	 */
	public Tarjetas updateTarjeta(String id_openpay, String alias);
	
	/**
	 * Método que actualiza el alias de una tarjeta.
	 * 
	 * @param id_openpay.
	 * @param token.
	 * @return Tarjetas.
	 */
	public Tarjetas updateToken(String id_openpay, String token);


	
	/**
	 * Método que elimina la tarjeta.
	 * 
	 * @param token.
	 * @return Tarjetas.
	 */
	public Tarjetas deleteTarjeta(String id_openpay);
	
	/**
	 * 
	 * Metodo que cuenta la cantidad de tarjetas que tiene un cliente determinado
	 * 
	 * @param idCliente
	 * @return
	 */
	public Integer countTarjetasByIdcliente(Long idcliente);

}
