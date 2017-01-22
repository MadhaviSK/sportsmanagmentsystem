package com.sports.event.algorithms;

import com.sports.event.generics.DataBaseCalls;

public class DrawTeamMatches {

	public static void main(String args[]){
		DeriveNoOfMatches(1,"1");
	}
	
	public static void DeriveNoOfMatches(int gameId,String round_Type){

		DataBaseCalls dbCalls = new DataBaseCalls();
		
		// ## Go in games table and search for respective Game Type
		//String gameType = database call;
		//String gameType = "TEAM";
		String gameType = "IND";
		int lhs = 2;
		int rhs = 0;
		int participatsCount = 0;
		int lowerLimit = 0;
		int extraParticipant = 0;
		int totalMatches = 0;
		
		if(gameType.equalsIgnoreCase("IND")){
			// ## Go in PART_GAME Table and get 
			participatsCount = dbCalls.getCount();
		}else if(gameType.equalsIgnoreCase("TEAM")){
			// ## Go in PART_GAME Table and get 
			participatsCount = dbCalls.getCount();
		}
		
		System.out.println("Toatal Participant :" + participatsCount);
		while(participatsCount > rhs){
			rhs = lhs * 2;				
			if(participatsCount >= lhs && participatsCount < rhs){
				lowerLimit = lhs;
				System.out.println("Lower Limit is :" + lowerLimit);
				break;
			}		
			lhs = rhs;
		}

		if(participatsCount>lowerLimit){
			extraParticipant = participatsCount - lowerLimit;
		}
		
		System.out.println("extraParticipant :" + extraParticipant);
		
		totalMatches = lowerLimit / 2;
		
		System.out.println("totalMatches :" + totalMatches);

	}
	
}
