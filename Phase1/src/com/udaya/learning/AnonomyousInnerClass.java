package com.udaya.constructor;

public class AnonomyousInnerClass {
	public void display() {
	}
	} 
public class InnerClassAssisted3 {
	public static void main(String[] args) { 
		AnonomyousInnerClass i = new AnonomyousInnerClass() {
	public void display() { 
		System.out.println("Anonymous Inner Class");
	}
	};
	i.display();
	}


}
