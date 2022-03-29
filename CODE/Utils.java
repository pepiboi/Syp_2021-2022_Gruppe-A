package com.login_signup_screendesign_demo;

public class Utils {
	
	//Email Validation pattern
	public static final String regEx = "^([^\\.@]|[\\w!#$?^_`{|}'*+/=%&~-]" +
			"[\\w!#$%&'*+/!#$%.=?^_`{|}~-]{0,40})([^.]@)([^!\")*+,./:;<=>#$%&'(?@^_`{}|~-]|" +
			"[!\")*+,./:;<=>#$%&'(?@^_`{}|~-]+\\w+|[\\w!\")*+,./:;<=>#$%&'(?@^_`{}|~-]+" +
			"[\\w!\")*+,./:;<=>#$%&'(?@^_`{}|~-]+|\\w+)\\.\\w{2,}$";

	//Date Validation pattern
	public static final String regExDate = "^(0[1-9]|1[0-2])\\/(0[1-9]|1\\d|2\\d|3[01])\\/(19|20)\\d{2}$";

	//Phone Validation pattern
	public static final String regExPhoneNumber = "^(\\+436|06)(44|50|60|64|65|67|70|76|77|78|80|81|86|88|90|99)\\d{7,8}$";

	//Fragments Tags
	public static final String Login_Fragment = "Login_Fragment";
	public static final String SignUp_Fragment = "SignUp_Fragment";
	public static final String ForgotPassword_Fragment = "ForgotPassword_Fragment";
	
}
