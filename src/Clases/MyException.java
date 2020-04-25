package Clases;

@SuppressWarnings("serial")
public class MyException extends Exception{

	String message;
	
	public MyException(String message) {
		super(message);
	}
	
}
