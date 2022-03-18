package com.udaya.constructor;

public class Student {
	int id; 
	String name;
	Student(int i,String n) { 
		id=i; name=n; 
		}
	void display() {
		System.out.println(id+" "+name);
		}
	}
	public class paramConstrDemo {
		public static void main(String[] args) {
	Student std1=new Student(2,"Alex"); 
	Student std2=new Student(10,"Annie");
	std1.display(); 
	std2.display();
	}
	}


