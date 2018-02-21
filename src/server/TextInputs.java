package server;

public class TextInputs {
	
	public static void SetInputs(String hvalue, String lvalue, String fvalue){
		if(!hvalue.equals("")){
			try{
			ServerConstants.DEFAULT_MAX = Integer.parseInt(hvalue);}
			catch(NumberFormatException e){
				System.err.println("The entered value is not an integer " + e);
			}
		}
		if(!lvalue.equals("")){
			try{
			ServerConstants.DEFAULT_MIN = Integer.parseInt(lvalue);}
			catch(NumberFormatException e){
				System.err.println("The entered value is not an integer " + e);
			}
		}
		if(!fvalue.equals("")){
			try{
			ServerConstants.DEFAULT_FREQ = Integer.parseInt(fvalue);}
			catch(NumberFormatException e){
				System.err.println("The entered value is not an integer " + e);
			}
		}
	}
}
