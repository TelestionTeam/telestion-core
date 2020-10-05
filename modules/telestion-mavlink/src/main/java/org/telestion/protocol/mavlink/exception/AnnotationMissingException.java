package org.telestion.protocol.mavlink.exception;

import java.lang.annotation.Annotation;

/**
 * A custom implementation of the {@link RuntimeException}.</br>
 * Indicates that a necessary {@link Annotation} is missing for the parsing-process of MAVLink-Messages.
 *
 * @author Cedric Boes
 * @version 1.0
 * @see RuntimeException
 */
public class AnnotationMissingException extends RuntimeException {

	/**
	 * SerialVersion UID for v1.0 of this {@link AnnotationMissingException}.
	 */
	private static final long serialVersionUID = -5342016963944609412L;

	/**
	 * {@inheritDoc}
	 */
	public AnnotationMissingException() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public AnnotationMissingException(String s) {
		super(s);
	}

	/**
	 * {@inheritDoc}
	 */
	public AnnotationMissingException(Throwable t) {
		super(t);
	}

	/**
	 * {@inheritDoc}
	 */
	public AnnotationMissingException(String s, Throwable t) {
		super(s, t);
	}

	/**
	 * {@inheritDoc}
	 */
	public AnnotationMissingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
