import java.util.Scanner;
import java.util.Arrays;
import assignments.Ex1.Ex1;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            System.out.print("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();


            if (num1.equals(quit)) {
                System.out.println("quiting now...");
                break;
            }


            if (!Ex1.isNumber(num1)) {
                System.out.println("num1 is in the wrong format  (" + num1 + ")");
                continue;
            }


            if (Ex1.isNumber(num1)) {
                System.out.println("num1=" + num1 + " is number: " + Ex1.isNumber(num1) + ", value: " + Ex1.number2Int(num1));
            }

            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            num2 = sc.next();

            if (num2.equals(quit)) {
                System.out.println("quiting now...");
                break;
            }


            if (!Ex1.isNumber(num2)) {
                System.out.println("num2 is in the wrong format. (" + num2 + ")");
                continue;
            }

            if (Ex1.isNumber(num2)) {
                System.out.println("num2=" + num2 + " is number: " + Ex1.isNumber(num2) + ", value: " + Ex1.number2Int(num2));
            }

            System.out.print("Enter a base for output (a number [2,16]): ");
            int base = sc.nextInt();

            if (base < 2 || base > 16) {
                System.out.println("Wrong base, should be [2,16]. Got: " + base);
                continue;
            }

            int newnum1 = Ex1.number2Int(num1);
            int newnum2 = Ex1.number2Int(num2);
            int add = newnum1 + newnum2;
            int multip = newnum1 * newnum2;


            String sum = Ex1.int2Number(add, base);
            String kefel = Ex1.int2Number(multip, base);

            System.out.println(num1 + "+" + num2 + "=" + sum);
            System.out.println(num1 + "*" + num2 + "=" + kefel);


            String[] arr = {num1, num2, sum, kefel};
            int maxIdx = Ex1.maxIndex(arr);
            if (maxIdx != -1) {
                System.out.println("Max number over: " + Arrays.toString(arr) + " is" + Ex1.int2Number(maxIdx, base));
            }
        }

        sc.close();
        System.exit(0);
    }
}
