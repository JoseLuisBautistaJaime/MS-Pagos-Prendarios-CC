/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.services.conciliacion;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.com.nmp.pagos.mimonte.builder.conciliacion.EstadoCuentaFileBuilder;
import mx.com.nmp.pagos.mimonte.builder.conciliacion.EstadoCuentaLineBuilder;
import mx.com.nmp.pagos.mimonte.conector.EstadoCuentaBroker;
import mx.com.nmp.pagos.mimonte.config.ApplicationProperties;
import mx.com.nmp.pagos.mimonte.constans.CodigoError;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.EstadoCuentaFileLayout;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.EstadoCuentaFileLayout43;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.EstadoCuentaImplementacionEnum;
import mx.com.nmp.pagos.mimonte.exception.ConciliacionException;
import mx.com.nmp.pagos.mimonte.helper.ConciliacionHelper;
import mx.com.nmp.pagos.mimonte.model.conciliacion.Conciliacion;
import mx.com.nmp.pagos.mimonte.services.EstadoCuentaReaderService;

/**
 * @name EstadoCuentaReader43
 * 
 * @description Clase que se encarga de la lectura del archivo de estado de cuenta usando la implementacion cuaderno 43
 * @author Quarksoft
 * @version 1.0
 */
@Component
@Service("estadoCuentaReaderC43Service")
public class EstadoCuentaReaderC43Service implements EstadoCuentaReaderService {

	@Inject
	private EstadoCuentaBroker estadoCuentaBrokerBus;

	@Inject
	private ConciliacionHelper conciliacionHelper;

	/**
	 * Contiene las propiedades del sistema
	 */
	@Inject
	private ApplicationProperties applicationProperties;



	/* (non-Javadoc)
	 * @see mx.com.nmp.pagos.mimonte.services.EstadoCuentaReaderService#read(java.util.Date, java.lang.Long, mx.com.nmp.pagos.mimonte.dto.conciliacion.EstadoCuentaImplementacionEnum)
	 */
	public EstadoCuentaFileLayout read(Date date, Long idConciliacion, EstadoCuentaImplementacionEnum implementacion) {

		// Consulta el numero de cuenta asignado a la conciliacion
 		Conciliacion conciliacion = conciliacionHelper.getConciliacionByFolio(idConciliacion, null);

		// Crea nombre y ruta del archivo en base a la fecha
 		String rutaArchivo = EstadoCuentaFileBuilder.buildPath(date, applicationProperties.getMimonte().getVariables().getConsultaEstadoCuenta().getArchivo().getRuta());
		String nombreArchivo = EstadoCuentaFileBuilder.buildFileName(date, conciliacion.getCuenta().getNumeroCuenta(), applicationProperties.getMimonte().getVariables().getConsultaEstadoCuenta().getArchivo().getNombre());

		// Consulta el archivo
		List<String> lineasArchivo = estadoCuentaBrokerBus.consulta(rutaArchivo, nombreArchivo);
		if (lineasArchivo == null || lineasArchivo.size() == 0) {
			throw new ConciliacionException("No se encontro archivo de estado de cuenta " + nombreArchivo, CodigoError.NMP_PMIMONTE_BUSINESS_054);
		}

		if (implementacion != EstadoCuentaImplementacionEnum.CUADERNO_43) {
			throw new ConciliacionException("Implementacion " + implementacion + " no definida", CodigoError.NMP_PMIMONTE_BUSINESS_055);
		}

		// Crea implementacion cuaderno 43
		EstadoCuentaFileLayout fileLayout = new EstadoCuentaFileLayout43();
		for (String lineaArchivo : lineasArchivo) {
			fileLayout.addRegistro(new EstadoCuentaLineBuilder(lineaArchivo, implementacion).buildLine());
		}

		return fileLayout;
	}

}
