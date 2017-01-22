package com.questions.objectives;

public class PalindromeString {

	
	public static void main(String args[]){
		
		String s ;
		s = "MADAM";
		String reverseS = "";
	
		for(int i = s.length() ; i > 0 ; i--){
			reverseS += s.charAt(i-1);
		}
		
		if(s.equalsIgnoreCase(reverseS)){
			System.out.println("It is palindrome.");
		}else{
			System.out.println("It is not palindrome.");
		}
		//System.out.println(reverseS);
		
	}
}
