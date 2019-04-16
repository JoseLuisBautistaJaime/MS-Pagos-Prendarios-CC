/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.nmp.pagos.mimonte.builder.AfiliacionBuilder;
import mx.com.nmp.pagos.mimonte.constans.CatalogConstants;
import mx.com.nmp.pagos.mimonte.dao.AfiliacionRepository;
import mx.com.nmp.pagos.mimonte.dto.AbstractCatalogoDTO;
import mx.com.nmp.pagos.mimonte.dto.AfiliacionDTO;
import mx.com.nmp.pagos.mimonte.exception.CatalogoException;
import mx.com.nmp.pagos.mimonte.exception.CatalogoNotFoundException;
import mx.com.nmp.pagos.mimonte.model.Afiliacion;
import mx.com.nmp.pagos.mimonte.services.CatalogoAdmService;

/**
 * @name AfiliacionServiceImpl
 * @description Clase de capa de servicio para el catalogo de afiliaciones que
 *              sirve para realizar operaciones de logica de negocios para el
 *              catalogo de afiliaciones
 *
 * @author Ismael Flores iaguilar@quarksoft.net
 * @creationDate 13/03/2019 20:58 hrs.
 * @version 0.1
 */
@Service("afiliacionServiceImpl")
public class AfiliacionServiceImpl implements CatalogoAdmService<AfiliacionDTO> {

	/**
	 * Repository para Afiliacion
	 */
	@Autowired
	@Qualifier("afiliacionRepository")
	private AfiliacionRepository afiliacionRepository;

	/**
	 * Guarda una Afiliacion
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractCatalogoDTO> T save(AfiliacionDTO e, String createdBy) {
		Afiliacion afiliacion = null;
		afiliacion = afiliacionRepository.findByNumero(e.getNumero());
		if (null != afiliacion)
			throw new CatalogoException(CatalogConstants.NUMERO_AFILIACION_ALREADY_EXISTS);
		if (null != e)
			e.setCreatedBy(createdBy);
		return (T) AfiliacionBuilder.buildAfiliacionDTOFromAfiliacion(
				afiliacionRepository.save(AfiliacionBuilder.buildAfiliacionFromAfiliacionDTO(e, null, null)));
	}

	/**
	 * Actualiza una afilicacion
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractCatalogoDTO> T update(AfiliacionDTO e, String lastModifiedBy) {
		Afiliacion afiliacion = afiliacionRepository.findById(e.getId()).isPresent()
				? afiliacionRepository.findById(e.getId()).get()
				: null;
		if (null == afiliacion)
			throw new CatalogoNotFoundException(CatalogConstants.CATALOG_NOT_FOUND);
		if (null != e)
			e.setLastModifiedBy(lastModifiedBy);
		return (T) AfiliacionBuilder.buildAfiliacionDTOFromAfiliacion(
				afiliacionRepository.save(AfiliacionBuilder.buildAfiliacionFromAfiliacionDTO(e, null, null)));
	}

	/**
	 * Regresa una afiliacion por id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractCatalogoDTO> T findById(Long id) throws EmptyResultDataAccessException {
		return afiliacionRepository.findById(id).isPresent()
				? (T) AfiliacionBuilder.buildAfiliacionDTOFromAfiliacion(afiliacionRepository.findById(id).get())
				: null;
	}

	/**
	 * Regresa un objeto de tipo AfiliacionDTO a partir de un id de Cuenta asociada
	 * 
	 * @param idCuenta
	 * @return
	 * @throws EmptyResultDataAccessException
	 */
	public Set<AfiliacionDTO> findByCuentasId(final Long idCuenta) throws EmptyResultDataAccessException {
		Set<Afiliacion> afiliaciones = null;
		afiliaciones = afiliacionRepository.findByCuentas_Id(idCuenta);
		return AfiliacionBuilder.buildAfiliacionDTOSetFromAfiliacionSet(afiliaciones);
	}

	/**
	 * Regresa todas las afiliaciones
	 */
	@Override
	public List<? extends AbstractCatalogoDTO> findAll() {
		return (List<AfiliacionDTO>) AfiliacionBuilder
				.buildAfiliacionDTOListFromAfiliacionList(afiliacionRepository.findAll());
	}

	/**
	 * Elimina una afiliacion por id
	 */
	@Override
	public void deleteById(Long id) throws EmptyResultDataAccessException, DataIntegrityViolationException {
		Afiliacion afiliacion = afiliacionRepository.findById(id).isPresent() ? afiliacionRepository.findById(id).get()
				: null;
		if (null == afiliacion)
			throw new CatalogoNotFoundException(CatalogConstants.CATALOG_NOT_FOUND);
		afiliacionRepository.deleteById(id);
	}

	/**
	 * Encuentra una afiliacion por numero
	 * 
	 * @param numeroAfiliacion
	 * @return
	 * @throws EmptyResultDataAccessException
	 */
	public AfiliacionDTO findByNumero(final String numeroAfiliacion) throws EmptyResultDataAccessException {
		Afiliacion afiliacion = null;
		afiliacion = afiliacionRepository.findByNumero(numeroAfiliacion);
		return AfiliacionBuilder.buildAfiliacionDTOFromAfiliacion(afiliacion);
	}

}
