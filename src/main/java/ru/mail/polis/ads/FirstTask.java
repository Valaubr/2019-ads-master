package ru.mail.polis.ads;


import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem solution template.
 */
public final class FirstTask {
    public static void main(final String[] arg) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = a % 10;

        System.out.println((a / 10) + " " + b);
    }
}
