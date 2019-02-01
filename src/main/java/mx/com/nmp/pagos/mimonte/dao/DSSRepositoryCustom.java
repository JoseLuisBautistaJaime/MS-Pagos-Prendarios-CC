package mx.com.nmp.pagos.mimonte.dao;

import org.springframework.stereotype.Repository;

/**
 * Nombre: DSSRepositoryCustom
 * Descripcion: Interfaz que define las operaciones
 * encargadas de consultar informacion referente a DSS de la aplicacion en consultas nativas dinamicas
 *
 * @author Ismael Flores iaguilar@quarksoft.net
 * @creationDate: 18/12/2018 14:54 hrs.
 * @version 0.1
 */
@Repository("dSSRepositoryCustom")
public interface DSSRepositoryCustom {
	
	/**
	 * 
	 * Metodo que ejecuta una consulta contenida en un tipo de dato String
	 * 
	 * @param query
	 * @return
	 */
	<S extends Object> S execQuery(String query);
	
}