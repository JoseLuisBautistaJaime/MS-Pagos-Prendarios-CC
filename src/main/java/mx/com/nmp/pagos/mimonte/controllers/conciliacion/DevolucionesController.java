/*
 * Proyecto:        NMP - MI MONTE FASE 2 - CONCILIACION.
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.pagos.mimonte.controllers.conciliacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.nmp.pagos.mimonte.constans.CatalogConstants;
import mx.com.nmp.pagos.mimonte.constans.CodigoError;
import mx.com.nmp.pagos.mimonte.constans.ConciliacionConstants;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.DevolucionEntidadDTO;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.DevolucionRequestDTO;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.DevolucionUpdtDTO;
import mx.com.nmp.pagos.mimonte.dto.conciliacion.DevolucionesIdsMovimientosDTO;
import mx.com.nmp.pagos.mimonte.exception.ConciliacionException;
import mx.com.nmp.pagos.mimonte.services.conciliacion.DevolucionesService;
import mx.com.nmp.pagos.mimonte.util.Response;
import mx.com.nmp.pagos.mimonte.util.validacion.ValidadorConciliacion;

/**
 * @name DevolucionesController
 * @description Clase de tipo Controlador spring que expone los servicios
 *              relacionados con Devoluciones
 *
 * @author Ismael Flores iaguilar@quarksoft.net
 * @creationDate 03/04/2019 11:21 hrs.
 * @version 0.1
 */
@RestController
@RequestMapping(value = "/mimonte")
@Api(value = "Servicio que permite realizar operaciones relacionadas con Devoluciones.", description = "REST API para Devoluciones", produces = MediaType.APPLICATION_JSON_VALUE, protocols = "http", tags = {
		"Devoluciones" })
public class DevolucionesController {

	/**
	 * Fabrica de beans
	 */
	@Autowired
	private BeanFactory beanFactory;

	/**
	 * Imprime logs de la aplicacion
	 */
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(DevolucionesController.class);

	/**
	 * Service para Devoluciones
	 */
	@Autowired
	private DevolucionesService devolucionesServiceImpl;

	/**
	 * Permite agregar y modificar comisiones al listado de comisiones del estado de
	 * cuenta
	 * 
	 * @param comisionSaveDTO
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/devoluciones/consulta", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST", value = "Realiza la administración de devoluciones a nivel entidad - Consulta de devoluciones para todas las entidades bancarias.", tags = {
			"Devoluciones" })
	@ApiResponses({ @ApiResponse(code = 200, response = Response.class, message = "Consulta Devoluciones Exitosa."),
			@ApiResponse(code = 400, response = Response.class, message = "El o los parametros especificados son invalidos."),
			@ApiResponse(code = 403, response = Response.class, message = "No cuenta con permisos para acceder a el recurso"),
			@ApiResponse(code = 404, response = Response.class, message = "El recurso que desea no fue encontrado"),
			@ApiResponse(code = 500, response = Response.class, message = "Error no esperado") })
	public Response consultar(@RequestBody DevolucionRequestDTO devolucionDTO) {
		
		LOG.info(">>>URL: POST /devoluciones/consulta > REQUEST ENTRANTE: {}", devolucionDTO);
		
		List<DevolucionEntidadDTO> respuesta = null;
		ValidadorConciliacion.validateFechasPrimary(devolucionDTO.getFechaDesde(), devolucionDTO.getFechaHasta());
		respuesta = devolucionesServiceImpl.consulta(devolucionDTO);

		if (null == respuesta)
			respuesta = new ArrayList<>();
			
		return beanFactory.getBean(Response.class, HttpStatus.OK.toString(),
				ConciliacionConstants.SUCCESSFUL_RETURNS_CONSULTATION, respuesta);
	}

	/**
	 * Realiza la administración de devoluciones a nivel entidad - Actualización de
	 * la fecha y liquidación para las devoluciones.
	 * 
	 * @param devolucionUpdtDTOList
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/devoluciones/actualizacion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "PUT", value = "Realiza la administración de devoluciones a nivel entidad - Actualización de la fecha y liquidación para las devoluciones.", tags = {
			"Devoluciones" })
	@ApiResponses({
			@ApiResponse(code = 200, response = Response.class, message = "Actualización Devoluciones Exitosa."),
			@ApiResponse(code = 400, response = Response.class, message = "El o los parametros especificados son invalidos."),
			@ApiResponse(code = 403, response = Response.class, message = "No cuenta con permisos para acceder a el recurso"),
			@ApiResponse(code = 404, response = Response.class, message = "El recurso que desea no fue encontrado"),
			@ApiResponse(code = 500, response = Response.class, message = "Error no esperado") })
	public Response actualizar(@RequestBody List<DevolucionUpdtDTO> devolucionUpdtDTOList,
			@RequestHeader(required = true, value = CatalogConstants.REQUEST_USER_HEADER) String userRequest) {
		
		LOG.info(">>>URL: PUT /devoluciones/actualizacion > REQUEST ENTRANTE: {}", devolucionUpdtDTOList.toString());
		
		// Validacion de objeto y atributos
		if (!ValidadorConciliacion.validateActualizarDevolucionRequest(devolucionUpdtDTOList) || userRequest == null
				|| "".equals(userRequest))
			throw new ConciliacionException(ConciliacionConstants.Validation.VALIDATION_PARAM_ERROR,
					CodigoError.NMP_PMIMONTE_0008);
		// Validacion de fechas de movimientos
		for (DevolucionUpdtDTO devolucionUpdtDTO : devolucionUpdtDTOList)
			if (!ValidadorConciliacion.validateFecha(devolucionUpdtDTO.getFecha()))
				throw new ConciliacionException(ConciliacionConstants.FECHA_IS_WRONG,
						CodigoError.NMP_PMIMONTE_BUSINESS_088);

		// Actualizacion
		List<DevolucionEntidadDTO> devolucionEntidadDTOList = devolucionesServiceImpl.actualizar(devolucionUpdtDTOList,
				userRequest);
		// Respuesta
		return beanFactory.getBean(Response.class, HttpStatus.OK.toString(), "Actualización devoluciones exitosa.",
				devolucionEntidadDTOList);
	}

	/**
	 * Realiza la administración de devoluciones a nivel entidad - Enviar solicitud
	 * de devoluciones.
	 * 
	 * @param devolucionesIdsMovimientosDTO
	 * @param userRequest
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/devoluciones/solicitar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "POST", value = "Realiza la administración de devoluciones a nivel entidad - Enviar solicitud de devoluciones.", tags = {
			"Devoluciones" })
	@ApiResponses({ @ApiResponse(code = 200, response = Response.class, message = "Solicitud Devoluciones Exitosa."),
			@ApiResponse(code = 400, response = Response.class, message = "El o los parametros especificados son invalidos."),
			@ApiResponse(code = 403, response = Response.class, message = "No cuenta con permisos para acceder a el recurso"),
			@ApiResponse(code = 404, response = Response.class, message = "El recurso que desea no fue encontrado"),
			@ApiResponse(code = 500, response = Response.class, message = "Error no esperado") })
	public Response solicitar(@RequestBody DevolucionesIdsMovimientosDTO devolucionesIdsMovimientosDTO,
			@RequestHeader(CatalogConstants.REQUEST_USER_HEADER) String userRequest) {
		
		LOG.info(">>>URL: POST /devoluciones/solicitar > REQUEST ENTRANTE: {}", devolucionesIdsMovimientosDTO.toString());
		
		if (!ValidadorConciliacion.validateDevolucionesIdsMovimientosDTO(devolucionesIdsMovimientosDTO))
			throw new ConciliacionException(ConciliacionConstants.Validation.VALIDATION_PARAM_ERROR,
					CodigoError.NMP_PMIMONTE_0008);
		List<DevolucionEntidadDTO> devolucionEntidadDTOList = null;
		try {
			devolucionEntidadDTOList = devolucionesServiceImpl.solicitarDevoluciones(devolucionesIdsMovimientosDTO,
					userRequest);
		} catch (ConciliacionException ex) {
			LOG.error(ConciliacionConstants.GENERIC_EXCEPTION_INITIAL_MESSAGE, ex);
			throw ex;
		} catch (Exception ex) {
			LOG.error(ConciliacionConstants.GENERIC_EXCEPTION_INITIAL_MESSAGE, ex);
			throw new ConciliacionException(CodigoError.NMP_PMIMONTE_BUSINESS_104.getDescripcion(),
					CodigoError.NMP_PMIMONTE_BUSINESS_104);
		}
		return beanFactory.getBean(Response.class, HttpStatus.OK.toString(), "Solicitud devoluciones exitosa.",
				devolucionEntidadDTOList);
	}

}
