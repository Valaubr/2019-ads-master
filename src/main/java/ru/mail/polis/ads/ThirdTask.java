package ru.mail.polis.ads;

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len1 = scanner.nextInt();
        int[] first = new int[len1];
        for (int i = 0; i < len1; i++) {
            int a = scanner.nextInt();
            first[i] = a;
        }
        int len2 = scanner.nextInt();
        int[] twelve = new int[len2];
        for (int i = 0; i < len2; i++) {
            int b = scanner.nextInt();
            twelve[i] = b;
        }

        if (first.length > twelve.length) {
            logic(first, twelve);
        } else {
            logic(twelve, first);
        }

    }

    static void logic(int[] a, int[] b) {
        int[][] trueTablet = new int[a.length + 1][b.length + 1];

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                if (a[i] == b[j]) {
                    trueTablet[i][j] = 1 + trueTablet[i + 1][j + 1];
                } else {
                    trueTablet[i][j] = Math.max(trueTablet[i + 1][j], trueTablet[i][j + 1]);
                }
            }
        }
        System.out.println(trueTablet[0][0]);
    }
}