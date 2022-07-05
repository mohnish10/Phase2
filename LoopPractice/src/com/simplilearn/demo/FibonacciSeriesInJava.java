package com.simplilearn.demo;

import java.util.Scanner;

public class FibonacciSeriesInJava {
public static void main(String[] args)
{
int i,firstTerm=0,secondTerm=1,thirdTerm,number;
Scanner sc = new Scanner(System.in);
System.out.println("Please enter the number till which you want the fibonacci series");
number = sc.nextInt();
System.out.print(firstTerm+ " " +secondTerm+ " ");
for(i = 3;i<=number;i++)
{
thirdTerm = firstTerm+secondTerm;
System.out.print(thirdTerm+" ");
firstTerm = secondTerm;
secondTerm = thirdTerm;
}
}
}
