package com.adobe.prj.dao;

/**
 * Provides Implementation for a Custom Exception Class
 * for the Product DAO
 * Currently does not do much, calls all methods from its super
 */
public class ProductDaoException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProductDaoException() {
	}

	public ProductDaoException(String message) {
		super(message);
	}

	public ProductDaoException(Throwable cause) {
		super(cause);
	}

	public ProductDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
