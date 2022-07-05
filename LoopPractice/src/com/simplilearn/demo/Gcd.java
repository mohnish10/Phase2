package com.simplilearn.demo;

import java.util.Scanner;

public class Gcd 
{  
public static void main(String[] args)   
{
Scanner sc = new Scanner(System.in);	
//x and y are the numbers to find the GCF  
int x, y, gcd = 1;
System.out.println("Please enter the first number for which you want to find gcd");
x = sc.nextInt();
System.out.println("Please enter the second number for which you want to find gcd");
y = sc.nextInt();
//running loop form 1 to the smallest of both numbers  
for(int i = 1; i <= x && i <= y; i++)  
{  
//returns true if both conditions are satisfied   
if(x%i==0 && y%i==0)  
//storing the variable i in the variable gcd  
gcd = i;  
}  
//prints the gcd  
System.out.printf("GCD of %d and %d is: %d", x, y, gcd);  
}  
}  
