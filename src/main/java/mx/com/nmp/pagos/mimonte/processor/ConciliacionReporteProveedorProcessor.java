/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.processor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.ReportesWrapper;
import mx.com.nmp.pagos.mimonte.exception.ConciliacionException;
import mx.com.nmp.pagos.mimonte.model.conciliacion.TipoReporteEnum;
import mx.com.nmp.pagos.mimonte.observer.MergeReporteHandler;

/**
 * Nombre: ConciliacionProcessor
 * Descripcion: Clase que se encarga de procesar el reporte open pay y generar los movimientos correspondientes (merge)
 *
 * @author JGALVEZ
 * Fecha: 04/06/2019 9:44 PM
 * @version 0.1
 */
@Component
@Service("conciliacionReporteProveedorProcessor")
public class ConciliacionReporteProveedorProcessor extends ConciliacionProcessorChain {

	public ConciliacionReporteProveedorProcessor(MergeReporteHandler mergeReporteHandler) {
		super(mergeReporteHandler);
	}


	/* (non-Javadoc)
	 * @see mx.com.nmp.pagos.mimonte.processor.ConciliacionProcessorChain#process(mx.com.nmp.pagos.mimonte.dto.conciliacion.ReportesWrapper)
	 */
	public void process(ReportesWrapper reportesWrapper) throws ConciliacionException {
	
		if (reportesWrapper.contains(TipoReporteEnum.PROVEEDOR)) {
			// Comisiones
		}
		processNext(reportesWrapper);
	}

}
