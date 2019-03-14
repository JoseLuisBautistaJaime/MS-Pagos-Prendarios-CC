package mx.com.nmp.pagos.mimonte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.nmp.pagos.mimonte.model.Afiliacion;

/**
 * Nombre: AfiliacionRepository Descripcion: Interface de capa DAO que sirve
 * para realizar operaciones de base de datos relacionadas con el catalogo
 * Afiliacion
 *
 * @author Ismael Flores iaguilar@quarksoft.net
 * @creationDate 13/03/2019 21:01 hrs.
 * @version 0.1
 */
@Repository("afiliacionRepository")
public interface AfiliacionRepository extends JpaRepository<Afiliacion, Long> {

	public Afiliacion findByCuentas_Id(final Long idCuenta);

}