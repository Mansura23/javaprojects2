package javaproject;

import java.util.Scanner;

public class turing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("================================");
        for(int i=0;i<3;i++){
            String str1=scanner.next();
            int num1=scanner.nextInt();
            System.out.printf("%-15s%03d\n",  str1, num1);
        }

        System.out.println("================================");
    }
}
