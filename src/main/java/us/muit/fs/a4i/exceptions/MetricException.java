package us.muit.fs.a4i.exceptions;

/**
 * @author isa
 *
 */
public class MetricException extends Exception {
	 /**
	 * Excepción que indica que se está intentando recuperar una entidad sin haber establecido su id
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public MetricException(String info){
		message=info;
	}

	@Override
	    public String getMessage(){
		 return message;
    }
}