package com.examples.spring.web.rest.SpringBootEmpMgntService;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

//@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Validation Error")

public class ValidationException extends Exception {
	private BindingResult valError;

	public ValidationException(BindingResult valError) {
		this.setValError(valError);
	}

	public BindingResult getValError() {
		return valError;
	}

	public void setValError(BindingResult valError) {
		this.valError = valError;
	}

}
