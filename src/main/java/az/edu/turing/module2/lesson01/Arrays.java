package az.edu.turing.module2.lesson01;

import java.util.Scanner;


public class Arrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        System.out.println(num);
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();


        }
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];

            }
        }
        System.out.println(maxNum);


    }


}
