package mx.com.nmp.pagos.mimonte.util.validacion;

import java.util.regex.PatternSyntaxException;

import mx.com.nmp.pagos.mimonte.constans.RegexConstants;

/**
 * Nombre: ValidadorGenerico Descripcion: Clase abstracta que contiene metodos
 * estaticos para relaizar validaciones genericas sobre diversos tipos de
 * objetos, principalmente evalua cadenas de caracteres y patrones qu se desea
 * existan en estas
 *
 *
 * @author Ismael Flores iaguilar@qaurksoft.net
 * @creationDate 07/03/2019 16:42 hrs.
 * @version 0.1
 */
public abstract class ValidadorGenerico {

	private ValidadorGenerico() {
		/**
		 * hidden constructor
		 */
	}

	/**
	 * Evalua si una direccion de email es correcta en base a un patron y regresa un
	 * valor booleano indicando el resultado
	 * 
	 * @param email
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static boolean validateEmail(final String email) throws PatternSyntaxException {
		return null != email ? email.matches(RegexConstants.REGEX_EMAIL) : false;
	}

	/**
	 * Evalua si un numero telfonico es correcto en base a un patron y regresa un
	 * valor booleano indicando el resultado
	 * 
	 * @param phoneNumber
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static boolean validatePhoneNumber(final String phoneNumber) throws PatternSyntaxException {
		return null != phoneNumber ? phoneNumber.matches(RegexConstants.REGEX_PHONE_NUMBER) : false;
	}

	/**
	 * Evalua si una cadena de caracteres no contiene caracteres especiales en base
	 * a un patron y regresa un valor booleano indicando el resultado
	 * 
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static boolean validateNoSpecialChars(final String str) throws PatternSyntaxException {
		return null != str ? str.matches(RegexConstants.REGEX_NO_SPECIAL_CHARACTERS) : false;
	}

}