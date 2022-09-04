/**
 * Util class
 * this class allow me to create some function to simplify the code
 * @author Baye Talla NDIAYE
 */
package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    /**
     * this function have as role to enter string
     * @param chaine is a message for user
     * @return the result
     */
    public static String enterString(String chaine){
        Scanner scanner = new Scanner(System.in);
        System.out.println(chaine);
        String enter =null;
        try{
            enter = scanner.nextLine();
        }catch (InputMismatchException e ){

            System.out.println("Format not support please enter type String ");
        }
        return  enter ;
    }

    /**
     * this function have as role to enter Integer
     * @param chaine is a message for user
     * @return the result
     */
    public static  int enterInt(String chaine){
        Scanner scanner = new Scanner(System.in);
        System.out.println(chaine);
        int enter = 0;
        try{
            enter = scanner.nextInt();
        }catch (InputMismatchException e ){

            System.out.println("Format not support please enter type int ");
        }
        return  enter;
    }



}
