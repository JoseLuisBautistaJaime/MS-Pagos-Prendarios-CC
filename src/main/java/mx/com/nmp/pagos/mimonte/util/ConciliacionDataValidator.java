/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.util;

import mx.com.nmp.pagos.mimonte.constans.CodigoError;
import mx.com.nmp.pagos.mimonte.constans.ConciliacionConstants;
import mx.com.nmp.pagos.mimonte.dao.conciliacion.ConciliacionRepository;
import mx.com.nmp.pagos.mimonte.dao.conciliacion.MovimientoConciliacionRepository;
import mx.com.nmp.pagos.mimonte.exception.ConciliacionException;
import mx.com.nmp.pagos.mimonte.model.conciliacion.MovimientoConciliacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @name ConciliacionDataValidator
 * @description Clase que contiene metodos de verificacion de existencia de
 *              registros de base de datos tal como ids de conciliaicon, ids de
 *              movimientos, etc.
 *
 * @author Ismael Flores iaguilar@quarksoft.net
 * @creationDate 25/07/2019 14:14 hrs.
 * @version 0.1
 */
@SuppressWarnings("JavaDoc")
@Component
public class ConciliacionDataValidator {

	/**
	 * Utilizada para manipular los mensajes informativos y de error.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ConciliacionDataValidator.class);

	/**
	 * Repository de conciliacion
	 */
	@SuppressWarnings({"SpringJavaAutowiringInspection", "SpringAutowiredFieldsWarningInspection"})
	@Autowired
	private ConciliacionRepository conciliacionRepository;

	/**
	 * Repository de Movimientos conciliacion
	 */
	@SuppressWarnings({"SpringJavaAutowiringInspection", "SpringAutowiredFieldsWarningInspection"})
	@Autowired
	private MovimientoConciliacionRepository movimientoConciliacionRepository;



	// METODOS

	/**
	 * Constructor.
	 */
	private ConciliacionDataValidator() {
		super();
	}

	/**
	 * Valida si el folio recibido corresponde a una conciliacion o no.
	 *
	 * @param folio El folio de la conciliacion.
	 */
	public void validateFolioExists(Integer folio) {
		LOG.info(">> validateFolioExists");

		if (folio == null) {
			LOG.debug("El folio recibido es nulo");
			throw new ConciliacionException(ConciliacionConstants.ERROR_WHILE_ID_CONCILIACION_VALIDATION,
					CodigoError.NMP_PMIMONTE_BUSINESS_086);
		}

		boolean exists;

		try {
			exists = conciliacionRepository.existsById(folio);
		} catch (Exception ex) {
			LOG.error("Error al consultar la conciliacion para el folio: [" + folio + "]", ex);
			throw new ConciliacionException(ConciliacionConstants.ERROR_WHILE_ID_CONCILIACION_VALIDATION,
					CodigoError.NMP_PMIMONTE_BUSINESS_086);
		}

		if (!exists)
			throw new ConciliacionException(ConciliacionConstants.CONCILIACION_ID_NOT_FOUND,
					CodigoError.NMP_PMIMONTE_BUSINESS_045);
	}

	/**
	 * Valida si los movimientos corresponden a la conciliacion indicada.
	 *
	 * @param folio El folio de la conciliacion.
	 * @param movimientosConciliacion La lista de movimientos.
	 */
	public void validateIdsMovimientosConciliacionExists(Integer folio, List<Integer> movimientosConciliacion) {
		LOG.info(">> validateIdsMovimientosConciliacionExists");

		if (CollectionUtils.isEmpty(movimientosConciliacion)) {
			LOG.debug("Lista de movimientos nula o vacia");
			throw new ConciliacionException(ConciliacionConstants.ERROR_WHILE_ID_CONCILIACION_VALIDATION,
					CodigoError.NMP_PMIMONTE_BUSINESS_086);
		}

		List<MovimientoConciliacion> movimientos;

		try {
			movimientos = movimientoConciliacionRepository.findByFolioAndIds(folio, movimientosConciliacion);
		} catch (Exception ex) {
			LOG.error("Error al consultar los movimientos para el folio: [" + folio + "]", ex);
			throw new ConciliacionException(ConciliacionConstants.ERROR_WHILE_ID_CONCILIACION_VALIDATION,
					CodigoError.NMP_PMIMONTE_BUSINESS_086);
		}

		if (CollectionUtils.isEmpty(movimientos) || movimientos.size() < movimientosConciliacion.size())
			throw new ConciliacionException(ConciliacionConstants.NO_RELATION_BETWEEN_CONC_AND_MOVS_OR_DONESNT_EXISTS_SUCH_MOVS,
					CodigoError.NMP_PMIMONTE_BUSINESS_087);
	}

}
