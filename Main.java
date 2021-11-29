package com.company;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        try{
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите целое число:");
        long k = scan.nextLong();
        long i = 0;
        while (k>0){
            if (k%10==0){
                i++;
            }
            k=k/10;
        }







            System.out.println(i);


    }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

}