package com.simplilearn.demo;

import java.util.Scanner;

public class MultiplicationTable {
public static void main(String[] args)
{
int n;	
Scanner sc = new Scanner(System.in);
System.out.println("Please enter the number for which you want to print the multiplication table");
n = sc.nextInt();
for(int i = 1;i<=20;i++)
{
System.out.println(n + " x " + i  + " = " +n*i);
}
}
}
