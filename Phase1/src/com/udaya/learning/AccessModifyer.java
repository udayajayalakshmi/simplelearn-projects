package com.udaya.learning;

public class AccessModifyer {
	void display() {
		System.out.println("You are using defalut access specifier");
		} 
	} 
class AccessModifyer1 {
		public static void main(String[] args) { 
			//default 
			System.out.println("Dafault Access Specifier");
			AccessModifyer obj = new AccessModifyer();
		obj.display(); 
		}


}
