package com.practice.memoryarea;

public class HeapDemo {

	public static void main(String args[]){
		Runtime r = Runtime.getRuntime();
		
		System.out.println( "Memory in Bytes" );
		System.out.println( "maxMemory" + r.maxMemory());
		System.out.println( "Total Memory" + r.totalMemory());
		System.out.println("Free memory" + r.freeMemory());
		System.out.println("Consumed memory" + (r.totalMemory() - r.freeMemory()));
		
		System.out.println( "Memory in MB" );
		
		long mb = 1024 * 1024;
		System.out.println( "Memory in Bytes" );
		System.out.println( "maxMemory" + r.maxMemory()/mb);
		System.out.println( "Total Memory" + r.totalMemory()/mb);
		System.out.println("Free memory" + r.freeMemory()/mb);
		System.out.println("Consumed memory" + (r.totalMemory() - r.freeMemory())/mb);

	}
}
