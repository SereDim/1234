package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double ans = 0;
        while ( true) {
            try {
                double num1;
                double num2;
                char op;
                Scanner reader = new Scanner(System.in);
                System.out.print("\nВведите пример: ");
                if (reader.hasNextDouble()) {
                    num1 = reader.nextDouble();
                } else {
                    num1 = ans;
                }
                op = reader.next().charAt(0);
                num2 = reader.nextDouble();
                switch (op) {
                    case '+':
                        ans = num1 + num2;
                        break;
                    case '-':
                        ans = num1 - num2;
                        break;
                    case '*':
                        ans = num1 * num2;
                        break;
                    case '/':
                        ans = num1 / num2;
                        break;
                    case '^':
                        ans = Math.pow(num1, num2);
                        break;
                    default:
                        System.out.printf("Ошибка");
                        return;

                }
                System.out.print("\nОтвет:\n");
                System.out.printf(num1 + " " + op + " " + num2 + " = " + ans);
            }
            catch(Exception ex){

                System.out.println(ex.getMessage());
            }


        }
    }
}