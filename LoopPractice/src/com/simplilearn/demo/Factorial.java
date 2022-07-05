package com.simplilearn.demo;

import java.math.BigDecimal;
import java.util.Scanner;

public class Factorial {
public static void main(String[] args)
{
int n;
int fact = 1;
Scanner sc = new Scanner(System.in);
System.out.println("Please enter the number for which you want the factorial");
n = sc.nextInt();
for(int i = 1; i<=n;i++)
{
fact = fact * i;	
}
System.out.println("The factorial of "+ n + " is "+fact);
}
}
