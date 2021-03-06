package mx.com.nmp.pagos.mimonte.constans;

public final class TarjetaConstants {

	private TarjetaConstants() {
		/**
		 * hidden constructor
		 */
	}

	/**
	 * Sublcase de constantes
	 * @author user
	 *
	 */
	public class Constants {
		private Constants() {
			super();
		}
		
		public static final int TITULAR_SIZE = 100;
	}
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_SUCCESS = "Registros recuperados correctamente.";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_PARAMETERS_ALIAS_SHOULD_NOT_BE_NULL_OR_VOID = "El alias no puede ir vacio o nulo";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_PARAMETER = "El parametro esta vacio o nulo";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_PARAMETER_IDCLIENTE = "El parametro idCliente esta vacio o nulo";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_PARAMETERS = "Los parametros no pueden ser vacios o nulos";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_TOKEN_ALREADY_EXISTS = "El id_openpay ya existe";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_PARAMETERS_SHOULD_NOT_BE_NULL_OR_VOID = "Los parametros no deben de ser nulos o vacios";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_ID_CLIENT_SHOULD_NOT_BE_NULL_OR_VOID = "El id del Cliente no puede ir nulo o debe ser mayor a 0";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_STATUS_SHOULD_NOT_BE_NULL_OR_VOID = "El estatus no debe ir vacio o nulo.";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_ID_STATUS_SHOULD_NOT_BE_NULL_OR_VOID = "El id del estatus de la tarjeta no puede ir nulo o debe ser mayor a 0";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_CAN_NOT_FIND_THE_CARD_TYPE_RECORD= "No se encontro registro para el tipo de tarjeta.";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_CAN_NOT_FIND_THE_CARD_STATUS_RECORD = "No se encontro el registro para el estatus de tarjeta.";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_TIPO_SHOULD_NOT_BE_NULL_OR_VOID = "El tipo no debe ir vacio o nulo.";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_ID_TIPO_SHOULD_NOT_BE_NULL_OR_VOID = "El id del tipo de tarjeta no puede ir nulo o debe ser mayor a 0";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_TOKEN = "El id_openpay no existe";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_TOKENS = "El id_openpay ya existe.";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_TOKEN_NULL_OR_VOID = "El id_openpay esta nulo o vacio";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_DATE_NULL_OR_VOID = "La fecha de alta no puede ir nula o vacia";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_CLIENT_NULL_OR_VOID = "El cliente no puede ir nulo o vacio";
	
	/**
	 * Mensaje que sera enviado si se recuperaron los registros correctamente
	 */
	public static final String MSG_FAIL_DIGITS_NULL_OR_VOID = "El campo digitos debe contener 4 car??cteres.";

	/**
	 * Mensaje que sera enviado si no se recuperaron los registros correctamente
	 */
	public static final String MSG_FAILURE = " Usted a??n no tiene tarjetas registradas. ";
	
	/**
	 * Mensaje que sera enviado si no se recuperaron los registros correctamente
	 */
	public static final String MSG_FAILURES = "No hay registros para esos parametros.";
	
	/**
	 * Mensaje que sera enviado si no se recuperaron los registros correctamente
	 */
	public static final String MSG_FAILURE_TOKEN_IDCLIENTE = "El id_openpay o el idCliente estan vacios o nulos ";
	
	/**
	 * Mensaje que sera enviado si no se recuperaron los registros correctamente
	 */
	public static final String MSG_FAILURE_ALIAS = "El alias esta nulo o vacio.";
	
	/**
	 * Mensaje que sera enviado si no se recuperaron los registros correctamente
	 */
	public static final String MSG_FAILURE_ALIAS_EXCEED_DIGITS = "El alias no debe contener mas de 10 digitos.";	 
	
	/**
	 * Mensaje que sera enviado si no se recuperaron los registros correctamente
	 */
	public static final String MSG_FAILURE_UPTOKEN = "El token esta nulo o vacio.";
	
	/**
	 * Mensaje que sera enviado si no se recuperaron los registros correctamente
	 */
	public static final String MSG_FAILURE_TOKEN = "El id_openpay es nulo o vacio";

	/**
	 * Mensaje que sera enviado si se guarda el registro correctamente
	 */
	public static final String MSG_SUCCESS_ADD = "Registro agregado correctamente.";

	/**
	 * Mensaje que sera enviado si no si hay tres tarjetas registradas
	 */
	public static final String MSG_NO_SUCCESS_ADD_MAX_CARDS = "Usted ha alcanzado la cantidad m??xima de tarjetas registradas. Para poder registrar una nueva tarjeta deber?? eliminar una tarjeta registrada.";

	/**
	 * Mensaje que sera enviado si se actualiza el registro correctamente
	 */
	public static final String MSG_SUCCESS_UPDATE = "Registro actualizado correctamente.";

	/**
	 * Mensaje que sera enviado si se actualiza el registro correctamente
	 */
	public static final String MSG_NO_SUCCESS_UPDATE = "No se encontro el registro a actualizar.";
	
	/**
	 * Mensaje que sera enviado si se actualiza el registro correctamente
	 */
	public static final String MSG_NO_SUCCESS_UPDATE_NULL = "No se encontraron registros con el id_openpay especificado";

	/**
	 * Mensaje que sera enviado si se borra el registro correctamente
	 */
	public static final String MSG_SUCCESS_DELETE = "Registro borrado correctamente.";

	/**
	 * Mensaje que sera enviado si no se borra el registro correctamente
	 */
	public static final String MSG_NO_SUCCESS_DELETE = "No se encontro el registro a eliminar.";

	/**
	 * Mensaje que es mostrado cuando se intenta agrefar una tarjeta con digitos que contienen caracteres que no son numeros
	 */
	public static final String MSG_ONLY_NUMBERS = "Los digitos de la tarjeta deben contener solo numeros";
	
	/**
	 * Mensaje que es mostrado cuando el nombre del titular esta formado por uno o mas caracteres diferentes a letras
	 */
	public static final String MSG_ONLY_LETTERS = "El nombre del titular solo puede contener letras y espacios";
	
	/**
	 * Mensaje que es mostrado cuando el alias contiene simbolos.
	 */
	public static final String MSG_WITHOUT_SYMBOLS = "No se permiten simbolos en el alias";
	
	/**
	 * Valores a evaluar para solo letras
	 */
	public static final String LETTER_VALUES = "ABCDEFGHIJKLMN??OPQRSTUVWXYZ???????????? ";
	
	/**
	 * Valores a evaluar para solo letras y numeros.
	 */
	public static final String SYMBOL = ("([a-z]|[A-Z]|[0-9]|[????????????????????]|\\s)+");
	
	/**
	 * Mensaje que aparece cuando se intenta agregar un alias de tarjeta que ya existe para el cliente en cuestion
	 */
	public static final String ALIAS_ALREADY_EXIST_FOR_CURRENT_CLIENT = "El alias ya existe para una de las tarjetas de este cliente";
	
	/**
	 * Mensaje que es mostrado en el servicio de pago cuando se intenta guardar una tarjeta que ya existe
	 */
	public static final String MSG_TARJETAS_ERROR = "La tarjeta no se guardo ya que el id_openpay de tarjetas ya existe";
	
	/**
	 * Mensaje que es mostrado cuando la longitud del id openpay es mayor a la definida en base de datos
	 */
	public static final String MSG_ID_OPENPAY_VALUE_TOO_LONG = "La longitud del id openpay es muy grande";
	
	/**
	 * Mensaje que es mostrado cuando la longitud del token es mayor a la definida en base de datos
	 */
	public static final String MSG_TOKEN_VALUE_TOO_LONG = "La longitud del token es muy grande";
	
	/**
	 * Mensaje que es mostrado cuando el nombre del titual es vacio
	 */
	public static final String TITULAR_EMPTY = "El nombre del titulas no puede ser vacio";
	
	/**
	 * Mensaje que es mostrado cuando el token de tarjeta es vacio
	 */
	public static final String TOKEN_EMPTY = "El token no puede ser vacio";
	
	/**
	 * Mensaje que es mostrado cuando se intenta ingresar un nombre de tituar con longitud superior a la permitida
	 */
	public static final String TITULAR_TOO_LONG = "El valor del titular excede la longitud permitida";
}
