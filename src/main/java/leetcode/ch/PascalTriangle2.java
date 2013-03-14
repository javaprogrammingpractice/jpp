package leetcode.ch;

import java.util.ArrayList;

public class PascalTriangle2 {
	
	
    public ArrayList<Integer> generate(int rowIndex) {
    	
    	ArrayList<Integer> list = new ArrayList<Integer>(rowIndex + 1);
    	list.add(1);
    	if (rowIndex == 0) {
    		return list;
    	} else if (rowIndex == 1) {
    		list.add(1);
    		return list;
    	} 
    	
    	int[] array = new int[rowIndex / 2 + 1];
    	array[0] = array[1] = 1;
    	
    	for (int i=2; i<=rowIndex; i++) {
    		boolean isEven = (i % 2 == 0);
    		int loopMax = i/2;
    		for (int j= loopMax; j>=1; j--) {
    			if (isEven && j==loopMax) {
    				array[j] = array[j-1] * 2;
    			} else {
    				array[j] = array[j] + array[j-1];
    			}
    		}
    	}
    	
    	for (int i=1; i<array.length; i++) {
    		list.add(array[i]);
    	}
    	
    	int offset = ((rowIndex % 2) == 0) ? 1 : 0;
    	
    	for (int i=array.length - 1 - offset; i>=0; i--) {
    		list.add(array[i]);
    	}
    	
    	return list;
    }
	
    
    public static void main(String[] args) {
    	PascalTriangle2 ti = new PascalTriangle2();
    	System.out.println(ti.generate(2));
    	System.out.println(ti.generate(3));
    	System.out.println(ti.generate(4));
    	System.out.println(ti.generate(5));
    	System.out.println(ti.generate(6));
    }
	
	

}
