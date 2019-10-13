package ru.mail.polis.ads;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String incoming = scanner.next();
        int n = incoming.length();
        int[][] d = new int[n][n];
        int[][] split = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = i; j >= 0; j--){
                if (j == i){
                    d[j][i] = 1;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                int splitMin = -1;
                if (incoming.charAt(j) == '(' && incoming.charAt(i) == ')' ||
                incoming.charAt(j) == '[' && incoming.charAt(i) == ']'){
                    min = d[i+1][j-1];
                }
                for (int k = j; k < i; k++) {
                    if (d[j][k] + d[k+1][i] < min){
                        min = d[j][k] + d[k+1][i];
                        splitMin = k;
                    }
                }
                d[i][j] = min;
                split[i][j] = splitMin;
            }
        }
        System.out.println(d[0][n-1]);
        restore(0, n-1, incoming, d, split);
    }

    static void restore(int i, int j, String s, int[][] d, int[][] split){
        if (i == j){
            switch (s.charAt(i)){
                case '(':
                case ')':
                    System.out.print("()");
                    break;
                case '[':
                case ']':
                    System.out.println("[]");
                    break;
            }
            return;
        }
        if (d[i][j] == 0){
            System.out.println(s.substring(i, i + j));
            return;
        }
        if (split[i][j] == -1){
            System.out.println(s.charAt(i));
            restore(i+1, j-1, s, d, split);
            System.out.println(s.charAt(j));
            return;
        }
        int k = split[i][j];
        restore(i,k,s,d,split);

    }
}
