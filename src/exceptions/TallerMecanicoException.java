package exceptions;

@SuppressWarnings("serial")
public class TallerMecanicoException extends Exception{

	String message;
	
	public TallerMecanicoException(String message) {
		super(message);
	}
	
}
