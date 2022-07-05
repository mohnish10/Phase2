package com.simplilearn.demo;

import java.util.Scanner;

public class PrimeNumber {
public static void main(String[] args)
{
int n;	
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number which you want to check if it's prime or not");
n = sc.nextInt();
boolean flag = true;
for(int i = 2;i<n;i++)
{
if(n%i==0)
{
flag = false;
break;
}
}
if(flag && n>1)
{
System.out.println("Number is prime");	
}
else
{
System.out.println("Number is not prime");	
}
}
}
