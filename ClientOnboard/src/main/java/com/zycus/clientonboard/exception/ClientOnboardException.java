package com.zycus.clientonboard.exception;

public class ClientOnboardException extends RuntimeException {

	private static final long serialVersionUID = -7843014002713940108L;

	public ClientOnboardException(String msg) {
		super(msg);

	}

	public ClientOnboardException(String msg, Throwable e) {
		super(msg, e);
	}

}
