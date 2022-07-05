package com.simplilearn.demo;

import java.util.Scanner;

public class LargestAndSmallestNumbers {
public static void main(String[] args)
{
int number;	
int max= Integer.MIN_VALUE;
int min = Integer.MAX_VALUE;
char choice;
Scanner sc = new Scanner(System.in);
do
{
System.out.println("Please enter the number");
number = sc.nextInt();
if(number>max)
{
max = number;	
}
if(number<min)
{
min = number;	
}
System.out.println("Do you want to continue y/n");
choice=sc.next().charAt(0);
}
while(choice=='y'||choice=='Y');
System.out.println("The largest number is:-"+max);
System.out.println("The smallest number is:-"+min);
}
}
