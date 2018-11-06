package com.mmi.review.service;

import org.springframework.stereotype.Component;

@Component
@FunctionalInterface
public interface LoginService {
	public boolean validate(String userId, String userPw);
}
