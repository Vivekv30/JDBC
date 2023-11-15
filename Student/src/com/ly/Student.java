package com.ly;

import java.util.Scanner;

public class Student {	

	public static void main(String[] args) {
		boolean flag=true;
		Scanner ip=new Scanner(System.in);
		StudentInterface si=new StudentImplementation();
		while(flag)
		{
			System.out.println("1:save student details\n2:delete student\n3:update student\n4:get All Student\n5:get Student By Marks\n6:exit");
			System.out.println("enter your choice in b/w 1 to 6");
			int ch=ip.nextInt();
			switch (ch){
				case 1: si.saveStudent();break;
				case 2: si.deleteStudent();break;
				case 3: si.updateStudent();break;
				case 4: si.getAllStudent();break;
				case 5: si.getStudentByMarks();break;
				case 6:flag=false;
					System.out.println("student portal closed");
					break;
			default:System.out.println("invalid choice ");
			}	
		}
		ip.close();
	}

}
