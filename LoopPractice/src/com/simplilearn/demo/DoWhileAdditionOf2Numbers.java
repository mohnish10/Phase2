package com.simplilearn.demo;

import java.util.Scanner;

public class DoWhileAdditionOf2Numbers {
public static void main(String[] args)
{
int num1,num2,sum;
Scanner sc = new Scanner(System.in);
char choice;
do
{
System.out.println("Please enter the first number");
num1 = sc.nextInt();
System.out.println("Please enter the second number");
num2 = sc.nextInt();
sum = num1+num2;
System.out.println("Sum of the numbers is :"+sum);
System.out.println("Do you want to continue y/n");
choice = sc.next().charAt(0);
}
while(choice=='y'||choice=='Y');
}
}
