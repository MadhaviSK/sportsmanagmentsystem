package com.questions.objectives;

public class SaticRun {

	
	public static void main(String args[]){

		int a= 5;
		
		// Program will not compile as cube is non static functions
		//System.out.println(cube(a));  
	}
	
	
	int cube(int a){
		
		return a*a*a;
	}
}
