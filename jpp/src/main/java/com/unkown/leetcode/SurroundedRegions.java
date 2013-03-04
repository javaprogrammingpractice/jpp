package com.unkown.leetcode;

import java.util.HashSet;


public class SurroundedRegions {
	
	boolean debug = true;

	int rows;
	int cols;
	int maxRows;
	int maxCols;
	
	static final char X = 'X';
	static final char O = 'O';
	

	
	public void solve(char[][] board) {
		
		if (board.length <= 2) {
			return;
		}
		
		this.rows = board.length;
		this.cols = board[0].length;
		this.maxRows = this.rows - 1;
		this.maxCols = this.cols - 1;
		
		if (this.rows <= 2 || this.cols <= 2) {
			return;
		}
		
		HashSet<Integer> excludes = new HashSet<Integer>();
		
		if (debug) {
			printArray(board);
			System.out.println("------");
		}
		
		for (int i=0; i<= this.maxRows; i++) {

			
			char[] tmp = board[i];
			
			if (i==0 || i==this.maxRows) {
				for (int j=0; j<=this.maxCols; j++) {
					if (tmp[j] == O) {
						this.recursive(excludes, i, j, board);
					}
				}
			}
			if (tmp[0] == O) {
				this.recursive(excludes, i, 0, board);
			}
			if (tmp[this.maxCols] == O) {
				this.recursive(excludes, i, maxCols, board);
			}	
		}
		
		this.flipValues(board, excludes);
		
		if (debug) {
			printArray(board);
		}
		
	}
	
	
   void flipValues(char[][] board, HashSet<Integer> values) {
		for (int i=1; i<= this.maxRows - 1; i++) {	
			char[] tmp = board[i];
			for (int j=1; j<=this.maxCols - 1; j++) {
				if (values.contains(this.getIndex(i, j))) {
					continue;
				} else {
					tmp[j] = X;
				}
			}
		}
	}
	
	

	boolean isVaidPos(int row, int col) {
		return row >=0 && row <= maxRows && col >= 0 && col <= maxCols;
	}
	
	int getIndex(int row, int col) {
		return row * cols + col;
	}
	
	
	void recursive(HashSet<Integer> sets, int i, int j, char[][] board) {
		
		if (! this.isVaidPos(i, j)) {
			return;
		} else if (board[i][j] != O) {
			return;
		}
		
		int index =  getIndex(i, j);
		if (sets.contains(index)) {
			return;
		} 
		sets.add(index);
		
		int nextI = -1;
		int nextJ = -1;
		if (i== 0) {
			nextI = 1;
			nextJ = j;
			this.recursive(sets, nextI, nextJ, board);
			return;
		} else if (i==this.maxRows) {
			nextI = this.maxRows - 1;
			nextJ = j;
			this.recursive(sets, nextI, nextJ, board);
			return;
		} else if (j== 0) {
			nextI = i;
			nextJ = j + 1;
			this.recursive(sets, nextI, nextJ, board);
			return;
		} else if (j == this.maxCols) {
			nextI = i;
			nextJ = this.maxCols - 1;
			this.recursive(sets, nextI, nextJ, board);
			return;
		}
		
		
		nextI = i - 1;
		nextJ = j;
		this.recursive(sets, nextI, nextJ, board);
		
		nextI = i + 1;
		nextJ = j;
		this.recursive(sets, nextI, nextJ, board);

		nextI = i;
		nextJ = j-1;
		this.recursive(sets, nextI, nextJ, board);
		
		nextI = i;
		nextJ = j+1;
		this.recursive(sets, nextI, nextJ, board);
	}
	
	
	public static void main(String[] args) {
		
		
		//Logger.getLogger(SurroundingRegions.class).setLevel(Level.DEBUG);
		
		char[][] board = new char[][] {"XOXOXOOOXO".toCharArray(),
				"XOOXXXOOOX".toCharArray(),
				"OOOOOOOOXX".toCharArray(),
				"OOOOOOXOOX".toCharArray(),
				"OOXXOXXOOO".toCharArray(),
				"XOOXXXOXXO".toCharArray(),
				"XOXOOXXOXO".toCharArray(),
				"XXOXXOXOOX".toCharArray(),
				"OOOOXOXOXO".toCharArray(),
				"XXOXXXXOOO".toCharArray()};
		
		SurroundedRegions sr = new SurroundedRegions();
		sr.solve(board);
	}
	
	static void printArray (char[][] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
