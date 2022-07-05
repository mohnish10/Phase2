package com.simplilearn.demo;

import java.util.Scanner;

public class PowerOfANumber
{
public static void main(String[] args)
{
int number, powerOf, result = 1;
Scanner sc = new Scanner(System.in);
System.out.println("Please enter the number whose power you want to find");
number = sc.nextInt();
System.out.println("Please enter the power you want to find out for the number mentioned above");
powerOf = sc.nextInt();
for(int i = 1;i<=powerOf;i++)
{
result = result * number;
}
System.out.println("Result is :"+result);
}
}