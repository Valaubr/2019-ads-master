package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FIFOStruct {
    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String a;
        MyFIFO myFIFO = new MyFIFO();
        while (true){
            a = br.readLine();
            if (a.startsWith("push")) {
                int param = Integer.parseInt(a.substring(5)); //scan.nextInt();
                myFIFO.push(param);
                System.out.println("ok");
            } else if ("pop".equals(a)) {
                myFIFO.pop();
            } else if ("front".equals(a)) {
                myFIFO.front();
            } else if ("size".equals(a)) {
                myFIFO.size();
            } else if ("clear".equals(a)) {
                myFIFO.clear();
                System.out.println("ok");
            } else if ("exit".equals(a)) {
                System.out.println("bye");
                System.exit(0);
            }
        }
    }
}

class MyFIFO {
    int[] fifo = new int[100];
    private int lenElems;
    MyFIFO(){
        lenElems = 0;
    }
    void push(int num){
        fifo[lenElems] = num;
        lenElems++;
    }

    void pop(){
        System.out.println(fifo[0]);
        if (fifo.length - 1 >= 0) System.arraycopy(fifo, 1, fifo, 0, fifo.length - 1);
        lenElems--;
    }

    void clear(){
//        for (int i: fifo) {
//            i = 0;
//        }
        fifo[0] = 0;
        lenElems = 0;
    }

    void front(){
        System.out.println(fifo[0]);
    }

    void size(){
        System.out.println(lenElems);
    }
}