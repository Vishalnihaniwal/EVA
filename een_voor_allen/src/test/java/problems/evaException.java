package problems;

public class evaException extends Exception{
	
	static final long serialVersionUID = -3387516993124229948L;
	
	public evaException() {
		
	}

	public evaException(String arg0) {
		super(arg0);
	}

	public evaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public evaException(Throwable arg0) {
		super(arg0);
	}

	public evaException(String arg0, Throwable arg1, boolean arg2, boolean arg3, String screenshots) {
		super(arg0, arg1, arg2, arg3);
	}

}
