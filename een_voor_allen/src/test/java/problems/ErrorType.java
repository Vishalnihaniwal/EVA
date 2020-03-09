package problems;


public class ErrorType {


	/* EVA errors*/
	public static final String GENERIC_ERROR = "Oops... there is some thing wrong.";
	public static final String FILE_CREATE = "Unable to create %s file.";
	public static final String READ_FILE = "There is some problem while reading file %s";
	public static final String NO_SUCH_METHOD_FOUND = "Expected method '%s'not found in Business package.";
	public static final String PROBLEM_IN_BUSINESSFUNCTIONS= "Exception     : There is some problem in '%s'. <br /> Stack says %s";
	public static final String ELEMENT_IDENTIFICATION_FAILURE = "'%s' failed to identify object '%s' with property '%s'.";
	public static final String UNSUPPORTED_ACTION = "%s is unsupported action in method '%s'.";
	public static final String NULL_JSONOBJECT = "Problem in %s method. Potentially Json Object return null, desired object is not available in Json file. <br /> Stack says %s";
	
	public static final String COMPARISON_IMAGE_NOT_FOUND = "Image file not found at path: %s";
	public static final String COMPARISON_NOT_POSSIBLE = "Image files are not comparable. Neither one seems to contain the other (size-wise). Left Image: %s. Right Image: %s.";

	public static final String ELEMENT_WAIT_FAILURE = "%s waited for %s seconds, without success for %s element with %sproperties %s.";


}
