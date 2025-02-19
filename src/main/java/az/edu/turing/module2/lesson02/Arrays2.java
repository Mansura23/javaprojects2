package az.edu.turing.module2.lesson02;

import java.util.Scanner;

public class Arrays2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter the number of sub-arrays: ");
        int numberOfSubarrays=scanner.nextInt();
        int jaggedArr[][] = new int[numberOfSubarrays][];

        for (int i = 0; i < numberOfSubarrays; i++) {

            System.out.println("Enter the size of the sub-array: " + (i+1));
            int sizeOfSubarray = scanner.nextInt();
            jaggedArr[i] = new int[sizeOfSubarray];

        }
        for (int i = 0; i < numberOfSubarrays; i++) {
            System.out.println("Enter the elements of the sub-array: ");
            for (int j = 0; j < jaggedArr[i].length; j++) {
                jaggedArr[i][j] = scanner.nextInt();


            }


        }
        int maxNum=jaggedArr[0][0];
        for (int i = 0; i < numberOfSubarrays; i++) {
            for (int j = 0; j < jaggedArr[i].length; j++) {



                if (jaggedArr[i][j] > maxNum){
                    maxNum=jaggedArr[i][j];
                }


            }

        }
        System.out.println(maxNum);






    }
}
