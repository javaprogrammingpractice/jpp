package leetcode.ch;

import java.util.ArrayList;

public class PascalTriangle {
	
	
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
   
    	ArrayList<ArrayList<Integer>> list = new  ArrayList<ArrayList<Integer>>();
    	for (int i=0; i<numRows; i++) {
    		ArrayList<Integer> tmp = new ArrayList<Integer>(i+1);
    		list.add(tmp);
    		tmp.add(1);
    		if (i==0) {
    			continue;
    		} 
    		
    		ArrayList<Integer> prev = list.get(i-1);
    		
    		int cur = prev.get(0);
    		for (int j=1; j<=prev.size()-1; j++) {
    			int n = prev.get(j);
    			tmp.add(cur + n);
    			cur = n;
    		}
    		
    		tmp.add(1);
    	}
        return list;
    }
	
    
    public static void main(String[] args) {
    	PascalTriangle ti = new PascalTriangle();
    	System.out.print(ti.generate(3));
    }
	
	

}
