/**
 * 
 */
package us.muit.fs.a4i.model.daos.exceptions;

/**
 * @author isa
 *
 */
public class UnknownEntityException extends Exception {
	 /**
	 * Excepción que indica que se está intentando recuperar una entidad sin haber establecido su id
	 */
	private static final long serialVersionUID = 1L;

	@Override
	    public String getMessage(){
		 return "El identificador de la entidad no se ha establecido";
    }
}
