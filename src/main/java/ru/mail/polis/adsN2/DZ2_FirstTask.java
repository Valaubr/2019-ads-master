package ru.mail.polis.adsN2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DZ2_FirstTask {
    public static void main(final String[] arg) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] matrix = new int[a][b];
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                int d = in.nextInt();
                matrix[i][j] = d;
            }
        }
        search(matrix, a, b);
    }

    static void search(int[][] matrix, int a, int b){
        String path = "";

        for (int i = 1; i < a; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }
        for (int j = 1; j < b; j++) {
            matrix[0][j] += matrix[0][j - 1];
        }

        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                matrix[i][j] += Math.max(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }

        int x = a - 1;
        int y = b - 1;
        while (x != 0 || y != 0) {
            matrix[x][y] = -1;
            if (x > 0 && y > 0) {
                if (matrix[x - 1][y] > matrix[x][y - 1]) x--;
                else y--;
            }
            else if (x == 0) {
                y--;
            }
            else if (y == 0) {
                x--;
            }
        }

        matrix[0][0] = -1;
        x = y;
        y = 0;

        while (x != a-1 || y != b-1) {
            if (x < a - 1 && matrix[x + 1][y] == -1) {
                path += "F";
                x++;
            } else {
                path += "R";
                y++;
            }
        }
        System.out.println(path);
    }
}