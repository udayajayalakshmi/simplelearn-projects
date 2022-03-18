//using private access specifiers
	

package com.udaya.learning;

public class PrivateAccessSpecifier {
	private void display() {
		System.out.println("You are using private access specifier");
		} 
	}
class accessSpecifiers2 {
		public static void main(String[] args) { 
			//private 
			System.out.println("Private Access Specifier"); 
			PrivateAccessSpecifier obj = new PrivateAccessSpecifier();
		//trying to access private method of another class
			//obj.display();
		}

	

}
