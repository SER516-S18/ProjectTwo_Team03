package server;

/**
 * 
 * @SER516 Project2_Team03
 */
public class TextInputs {
    /**
     * Updates the default max, min and frequency values according to the values entered in the server gui.
     * @param hvalue signifies maximum value
     * @param lvalue signifies minimum value
     * @param fvalue signifies frequency value
     */
    public static void SetInputs(String hvalue, String lvalue, String fvalue){
        if(!hvalue.equals("")){
            try{
            ServerConstants.DEFAULT_MAX = Integer.parseInt(hvalue);}
            catch(NumberFormatException e){
                ServerConsole.getInstance().print("The entered value is not an integer, the default value is sent");
            }
        }
        if(!lvalue.equals("")){
            try{
            ServerConstants.DEFAULT_MIN = Integer.parseInt(lvalue);}
            catch(NumberFormatException e){
                ServerConsole.getInstance().print("The entered value is not an integer, the default value is sent");

            }
        }
        if(!fvalue.equals("")){
            try{
            ServerConstants.DEFAULT_FREQ = Integer.parseInt(fvalue);}
            catch(NumberFormatException e){
                ServerConsole.getInstance().print("The entered value is not an integer, the default value is sent");

            }
        }
    }
}