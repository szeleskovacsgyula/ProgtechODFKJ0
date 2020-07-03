package view;

import java.util.Scanner;

public abstract class Megjelenites {
    public static Scanner scanner = new Scanner(System.in);

    public static void adatokMegjelenitese(String output) {
        System.out.println(output);
    }

    public static String bevitelOlvasasa(String task) {
        System.out.println(task);
        return scanner.nextLine();
    }
}
