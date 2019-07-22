package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.Product;

@Component // helper, one of the five annotations required for auto-wiring
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Product.class);
	}

	@Override
	public void validate(Object target, Errors errors) { // collection of all the errors
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Name can't be empty"); // name.empty in
																										// property
																										// file(for
																										// internationalization),
																										// else default
																										// value
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "category.empty", "Category cant be empty");
		Product p = (Product) target;
		if (p.getPrice() <= 0) {
			errors.rejectValue("price", "price.invalid", "Price should be positive value");

		}
	}

}
