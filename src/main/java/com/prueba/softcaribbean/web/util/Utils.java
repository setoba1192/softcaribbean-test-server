package com.prueba.softcaribbean.web.util;

import com.prueba.softcaribbean.exception.ValidacionDominioException;

public class Utils {

	public static boolean emptyString(final String s) {

		return s == null || s.trim().isEmpty();
	}

	public static void validateEmptyStringAndLength(final String s, int length, String field) {

		if (s == null || s.trim().isEmpty()) {

			throw new ValidacionDominioException("Complete el campo " + field);
		}
		if (s.length() > length) {

			throw new ValidacionDominioException(
					"El campo " + field + " supera el máximo de carácteres permitidos: " + length);

		}

	}

}
