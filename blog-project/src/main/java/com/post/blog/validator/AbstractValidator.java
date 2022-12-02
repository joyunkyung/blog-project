package com.post.blog.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;
//Validator 클래스를 구현한 AbstractValidator 추상 클래스를 생성

@Slf4j//log
public abstract class AbstractValidator<T> implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void validate(Object target, Errors errors) {
		try {
			doValidate((T) target, errors);
		} catch(RuntimeException e) {
			log.error("중복 검증 에러", e);
			throw e;
		}
	}

	protected abstract void doValidate(final T dto, final Errors errors);
}
