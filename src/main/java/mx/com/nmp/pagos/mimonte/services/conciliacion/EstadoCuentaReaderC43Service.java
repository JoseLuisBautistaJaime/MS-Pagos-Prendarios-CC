/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.services.conciliacion;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import mx.com.nmp.pagos.mimonte.builder.conciliacion.EstadoCuentaFileBuilder;
import mx.com.nmp.pagos.mimonte.builder.conciliacion.EstadoCuentaLineBuilder;
import mx.com.nmp.pagos.mimonte.conector.EstadoCuentaAPI;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.ConciliacionDTO;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.EstadoCuentaFileLayout;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.EstadoCuentaFileLayout43;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.EstadoCuentaImplementacionEnum;
import mx.com.nmp.pagos.mimonte.exception.ConciliacionException;
import mx.com.nmp.pagos.mimonte.services.EstadoCuentaReaderService;

/**
 * @name EstadoCuentaReader43
 * 
 * @description Clase que se encarga de la lectura del archivo de estado de cuenta usando la implementacion cuaderno 43
 * @author Quarksoft
 * @version 1.0
 */
@Component
public class EstadoCuentaReaderC43Service implements EstadoCuentaReaderService {

	@Inject
	private EstadoCuentaAPI estadoCuentaAPI;

	@Inject
	private ConciliacionService conciliacionService;


	/**
	 * Ruta
	 */
	@Value("${estadocuenta.ruta}")
	private String ruta;

	/**
	 * Nombre
	 */
	@Value("${estadocuenta.nombre}")
	private String nombre;



	/* (non-Javadoc)
	 * @see mx.com.nmp.pagos.mimonte.services.EstadoCuentaReader#read(java.util.Date, java.lang.Long)
	 */
	public EstadoCuentaFileLayout read(Date date, Long idConciliacion) {

		// Consulta el numero de cuenta asignado a la conciliacion
		ConciliacionDTO conciliacion = conciliacionService.getById(idConciliacion);
		if (conciliacion == null) {
			throw new ConciliacionException("No existe conciliacion con folio " + idConciliacion);
		}

		// Crea nombre del archivo en base a la fecha
		String nombreArchivo = EstadoCuentaFileBuilder.buildFileName(date, conciliacion.getCuenta().getNumero(), nombre);

		// Consulta el archivo
		List<String> lineasArchivo = estadoCuentaAPI.consulta(ruta, nombreArchivo);
		if (lineasArchivo == null || lineasArchivo.size() == 0) {
			throw new ConciliacionException("No se encontro archivo de estado de cuenta " + nombreArchivo);
		}


		// Crea implementacion cuaderno 43
		EstadoCuentaImplementacionEnum implementacion = EstadoCuentaImplementacionEnum.CUADERNO_43;
		EstadoCuentaFileLayout fileLayout = new EstadoCuentaFileLayout43();
		for (String lineaArchivo : lineasArchivo) {
			fileLayout.addRegistro(new EstadoCuentaLineBuilder(lineaArchivo, implementacion).buildLine());
		}

		return fileLayout;
	}

}
