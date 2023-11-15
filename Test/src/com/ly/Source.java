package com.ly;

import java.util.Scanner;

class Student
{
	String name;
	String usn;
	String college;
	int cgpa;
	public Student(String name, String usn, String college, int cgpa) {
		this.name = name;
		this.usn = usn;
		this.college = college;
		this.cgpa = cgpa;
	}
	
}

class StudentImplementation {

	public static Student getStudentInfo(String str)
	{
		
		String s1="";
		String usn="";
		String clg="";
		int cgpa=0;
		for(int i=0;i<str.indexOf('@');i++)
		{
				s1+=str.charAt(i);
		}
		for(int i=str.indexOf('@')+1;i<str.indexOf('-');i++)
		{
			usn+=str.charAt(i);
		}
		for(int i=str.indexOf('-')+1;i<str.indexOf('#');i++)
		{
			clg+=str.charAt(i);
		}
		for(int i=str.indexOf('#')+1;i<str.length();i++)
		{
			cgpa*=10+(str.charAt(i)-48);
			
		}
		
		Student s = new Student(s1,usn,clg,cgpa);
		return s;
	}
	public static String getStudentSection(Student s)
	{
		int l3usn = 0;
		for(int i=s.usn.length()-3;i<s.usn.length();i++)
		{
			l3usn=l3usn*10+(s.usn.charAt(i)-48);
		}
		if(l3usn>1&&l3usn<60)
		{
			return "A";
		}
		else if(l3usn>61&&l3usn<120)
		{
			return "B";
		}
		else if(l3usn>121&&l3usn<180)
		{
			return "C";
		}
		else
		{
			return "Z";
		}
		
	}

}
//AmitRai@1PC16CS-ALU#8
public class Source
{
	public static void main(String[] args) {
		Scanner ip=new Scanner(System.in);
		String str1=ip.nextLine();
		Student s=StudentImplementation.getStudentInfo(str1);
		String cgpa=""+s.cgpa;
		String section=StudentImplementation.getStudentSection(s);

		System.out.printf("%-15s%1s%n","name",": "+s.name);
		System.out.printf("%-15s%1s%n","usn",": "+s.usn);
		System.out.printf("%-15s%1s%n","college",": "+s.college);
		System.out.printf("%-15s%1s%n","cgpa",": "+cgpa);
		System.out.printf("%-15s%1s%n","section",": "+section);
	}
}


