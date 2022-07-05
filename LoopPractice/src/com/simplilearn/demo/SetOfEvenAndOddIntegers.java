package com.simplilearn.demo;

import java.util.Scanner;

public class SetOfEvenAndOddIntegers 
{
public static void main(String[] args)
{
int number, even = 0, odd = 0;
char choice;
Scanner sc = new Scanner(System.in);
do
{
System.out.print("Enter any number");
number = sc.nextInt();
if(number%2==0)
{
even+= number;	
}
else
{
odd+= number;	
}
System.out.println("Do you want to continue y/n");
choice = sc.next().charAt(0);
}
while(choice=='y' || choice=='Y');
System.out.println("Sum of even numbers is :"+even);
System.out.println("Sum of odd numbers is :"+odd);
}
}
