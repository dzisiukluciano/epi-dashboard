package com.epidataconsulting.metrics.server.domain.exception;

public class InvalidPodConfigurationException extends RuntimeException {

	private static final long serialVersionUID = 9177676233530880482L;

	public InvalidPodConfigurationException(Throwable cause) {
		super("InvalidPodConfigurationException",cause);
	}

}
