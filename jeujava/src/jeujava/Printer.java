
package jeujava;

public class Printer {
    public static String getStringColored(String str, String color){
        return color+str+Color.RESET;
    }
}
