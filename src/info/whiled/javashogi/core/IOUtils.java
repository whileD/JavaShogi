package info.whiled.javashogi.core;

import java.util.Scanner;

public class IOUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputNumber(){
        while (true) {
            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }

            return  scanner.nextInt() - 1;
        }
    }

    public static String inputString(){
        return scanner.next();
    }

    public static void prompt(){
        System.out.print(">");
    }

    public static void prompt(String s){
        System.out.println(s);
        prompt();
    }
}
