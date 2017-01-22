package com.questions.objectives;

import java.util.ArrayList;

public class RomveDuplicatesFromSortedArray {

	
	
	public static void main(String args[]){

		int sortedArr[]  = {1,4,8,0,6,7,2,3,3,5,2};
		ArrayList<Integer> dupArr = new ArrayList<Integer>();
		
		for(int i : sortedArr){
			
			if(!dupArr.contains(i)){
				dupArr.add(i);
			}
		}
		System.out.println(dupArr);
	}
}
