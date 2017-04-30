package co.edu.eam.ingesoft.avanzada.negocio.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ExcepcionNegocio extends RuntimeException {

	/**
	 * Constructor
	 * @param message
	 */
	public ExcepcionNegocio(String message) {
		super(message);

	}

}
