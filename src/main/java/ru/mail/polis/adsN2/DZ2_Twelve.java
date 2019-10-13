package ru.mail.polis.adsN2;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem solution template.
 */
public class DZ2_Twelve {
    ArrayList<Integer> arr = new ArrayList<>();
    public static void main(final String[] arg) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int[] stair = new int[a];
        for (int i = 0; i < a; i++){
            int b = in.nextInt();
            stair[i] = b;
        }
        int step = in.nextInt();

        logic(stair, step);
    }

    private static void logic(int[] stair, int step) {
        int result = 0;
        int[] mass = new int[step];
        for (int i = 0; i < stair.length; i++){
            if (i + step < stair.length){
                for (int j = i; j < i + step; j++){

                }
            }
        }
    }
}