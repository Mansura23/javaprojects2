package az.edu.turing.module2.lesson02;

import java.util.Scanner;

public class Method {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        array(arr);

    }

    public static void array(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("index: " + i + "value: " + arr[i]);

        }


    }

}
