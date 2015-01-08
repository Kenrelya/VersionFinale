/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeujava;

/**
 *
 * @author Kenrelya
 */
public class Printer {
    public static String getStringColored(String str, String color){
        return color+str+Color.RESET;
    }
}
