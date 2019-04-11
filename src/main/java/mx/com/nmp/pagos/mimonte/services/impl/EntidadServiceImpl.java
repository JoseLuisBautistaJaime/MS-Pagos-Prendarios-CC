/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.services.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.com.nmp.pagos.mimonte.builder.ContactosBuilder;
import mx.com.nmp.pagos.mimonte.builder.CuentaBuilder;
import mx.com.nmp.pagos.mimonte.builder.EntidadBuilder;
import mx.com.nmp.pagos.mimonte.constans.CatalogConstants;
import mx.com.nmp.pagos.mimonte.dao.ContactoRespository;
import mx.com.nmp.pagos.mimonte.dao.CuentaRepository;
import mx.com.nmp.pagos.mimonte.dao.EntidadRepository;
import mx.com.nmp.pagos.mimonte.dto.AbstractCatalogoDTO;
import mx.com.nmp.pagos.mimonte.dto.EntidadDTO;
import mx.com.nmp.pagos.mimonte.dto.EntidadResponseDTO;
import mx.com.nmp.pagos.mimonte.exception.CatalogoException;
import mx.com.nmp.pagos.mimonte.model.Contactos;
import mx.com.nmp.pagos.mimonte.model.Cuenta;
import mx.com.nmp.pagos.mimonte.model.Entidad;
import mx.com.nmp.pagos.mimonte.services.EntidadService;
import mx.com.nmp.pagos.mimonte.util.validacion.ValidadorCatalogo;

/**
 * @name EntidadServiceImpl
 * @description Clase de capa de servicio para el catalogo de entidades que
 *              sirve para realizar operaciones de logica de negocios para el
 *              catalogo de entidades
 *
 * @author Ismael Flores iaguilar@quarksoft.net
 * @creationDate 06/03/2019 12:33 hrs.
 * @version 0.1
 */
@Service("entidadServiceImpl")
public class EntidadServiceImpl implements EntidadService {

	/**
	 * Repository del catalogo Entidad
	 */
	@Autowired
	@Qualifier("entidadRepository")
	private EntidadRepository entidadRepository;

	/**
	 * Repository del catalogo Cuenta
	 */
	@Autowired
	@Qualifier("cuentaRepository")
	private CuentaRepository cuentaRepository;

	/**
	 * Repository del catalogo Contacto
	 */
	@Autowired
	@Qualifier("contactoRespository")
	private ContactoRespository contactoRespository;

	/**
	 * Guarda una entidad
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractCatalogoDTO> T save(EntidadDTO e, String createdBy) {
		List<Entidad> entidades = null;
		// Se valida que el nombre de la entidad no exista
		try {
			entidades = entidadRepository.findByNombreAndDescription(e.getNombre(), e.getDescription());
		} catch (EmptyResultDataAccessException erdaex) {
			// No action required here, application continues normally
		}
		// Se valida que los id's de las cuentas existan
		List<Cuenta> cuentaList = cuentaRepository.findAll();
		if (!ValidadorCatalogo.validateCuentasExists(e.getCuentas(),
				CuentaBuilder.buildCuentaBaseDTOListFromCuentaList(cuentaList)))
			throw new CatalogoException(CatalogConstants.ID_CUENTA_DOES_NOT_EXISTS);
		// Se valida que los id's de los contactos existan
		List<Contactos> contactosList = contactoRespository.findAll();
		if (!ValidadorCatalogo.validateContactosExists(e.getContactos(),
				ContactosBuilder.buildContactoBaseDTOListFromContactosListOnlyIds(contactosList)))
			throw new CatalogoException(CatalogConstants.ID_CONTACTO_DOES_NOT_EXISTS);
		if (null == entidades || !entidades.isEmpty())
			throw new CatalogoException(CatalogConstants.ENTIDAD_ALREADY_EXISTS);
		if (null != e)
			e.setCreatedBy(createdBy);
		Entidad entidad = null;
		Entidad entidadResp = null;
		EntidadDTO entidadDTO = null;
		entidad = EntidadBuilder.buildEntidadFromEntidadDTO(e);
		entidadResp = entidadRepository.save(entidad);
		entidadDTO = EntidadBuilder.buildEntidadDTOFromEntidad(entidadResp);
		return (T) entidadDTO;
	}

	/**
	 * Actualiza una entidad
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractCatalogoDTO> T update(EntidadDTO e, String lastModifiedBy) throws CatalogoException {
		if (null != e)
			e.setLastModifiedBy(lastModifiedBy);
		Entidad entidad = null;
		Entidad entidadResp = null;
		EntidadDTO entidadDTO = null;
		entidad = EntidadBuilder.buildEntidadFromEntidadDTO(e);
		Entidad entidadTest = entidadRepository.findById(e.getId()).isPresent()
				? entidadRepository.findById(e.getId()).get()
				: null;
		if (null == entidadTest)
			throw new CatalogoException(CatalogConstants.NO_ENTIDAD_FOUND);
		// Se valida que los id's de las cuentas existan
		List<Cuenta> cuentaList = cuentaRepository.findAll();
		if (!ValidadorCatalogo.validateCuentasExists(e.getCuentas(),
				CuentaBuilder.buildCuentaBaseDTOListFromCuentaList(cuentaList)))
			throw new CatalogoException(CatalogConstants.ID_CUENTA_DOES_NOT_EXISTS);
		// Se valida que los id's de los contactos existan
		List<Contactos> contactosList = contactoRespository.findAll();
		if (!ValidadorCatalogo.validateContactosExists(e.getContactos(),
				ContactosBuilder.buildContactoBaseDTOListFromContactosListOnlyIds(contactosList)))
			throw new CatalogoException(CatalogConstants.ID_CONTACTO_DOES_NOT_EXISTS);
		try {
			entidadResp = entidadRepository.save(entidad);
		} catch (ConstraintViolationException cve) {
			throw new CatalogoException(CatalogConstants.CONSTRAINT_ERROR_MESSAGE);
		}
		entidadDTO = EntidadBuilder.buildEntidadDTOFromEntidad(entidadResp);
		return (T) entidadDTO;
	}

	/**
	 * Encuentra una entidad por id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends AbstractCatalogoDTO> T findById(Long id) throws EmptyResultDataAccessException {
		Entidad entidadResp = null;
		EntidadDTO entidadDTO = null;
		entidadResp = entidadRepository.findById(id).isPresent() ? entidadRepository.findById(id).get() : null;
		entidadDTO = EntidadBuilder.buildEntidadDTOFromEntidad(entidadResp);
		return (T) entidadDTO;
	}

	/**
	 * Encuentra una entidad por su nombre y estatus
	 * 
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws EmptyResultDataAccessException
	 */
	@Override
	public List<EntidadResponseDTO> findByNombreAndEstatus(final String nombre, final Boolean estatus)
			throws EmptyResultDataAccessException {
		List<Entidad> entidadList = null;
		List<EntidadResponseDTO> entidadResponseDTOList = null;
		entidadList = entidadRepository.findByNombreAndEstatus(nombre, estatus);
		entidadResponseDTOList = EntidadBuilder.buildEntidadResponseDTOListFromEntidadList(entidadList);
		return entidadResponseDTOList;
	}

	/**
	 * Encuentra todas las entidades
	 */
	@Override
	public List<? extends AbstractCatalogoDTO> findAll() {
		List<Entidad> entidadList = null;
		List<EntidadDTO> entidadDTOList = null;
		entidadList = (List<Entidad>) entidadRepository.findAll();
		entidadDTOList = EntidadBuilder.buildEntidadDTOListFromEntidadList(entidadList);
		return (List<EntidadDTO>) entidadDTOList;
	}

	/**
	 * Elimina una entidad por id
	 */
	@Override
	public void deleteById(Long id) throws EmptyResultDataAccessException {
		entidadRepository.deleteById(id);
	}

	/**
	 * Actualiza el estatus de un catalogo Entidad por id
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateEstatusById(final Boolean estatus, final Long id, final String lastModifiedBy,
			final Date lastModifiedDate) throws EmptyResultDataAccessException {
		entidadRepository.setEstatusById(estatus, id, lastModifiedBy, lastModifiedDate);
	}

}
