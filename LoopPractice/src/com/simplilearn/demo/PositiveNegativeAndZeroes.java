package com.simplilearn.demo;

import java.util.Scanner;

public class PositiveNegativeAndZeroes {
public static void main(String[] args)
{
int number, positiveNumber = 0, negativeNumber = 0, zeroNumber = 0;
char choice;
Scanner sc = new Scanner(System.in);
do
{
System.out.println("Please enter the number");
number = sc.nextInt();
if(number>0)
{
positiveNumber++;	
}
else if(number<0)
{
negativeNumber++;	
}
else
{
zeroNumber++;	
}
System.out.println("Do you want to continue y/n");
choice = sc.next().charAt(0);
}
while(choice=='y'||choice=='Y');
System.out.println("Positive numbers are :-"+positiveNumber);
System.out.println("Negative numbers are :-"+negativeNumber);
System.out.println("Zero numbers are :-"+zeroNumber);
}
}
