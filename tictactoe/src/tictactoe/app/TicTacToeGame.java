package tictactoe.app;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	private static char[][] board = new char[3][3];
	private static char currentPlayer = 'O';
	private static boolean gameOver = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initalizeBoard();
		printBoard();
		
		Scanner scanner = new Scanner(System.in);
		
		while (!gameOver) {
			if (currentPlayer == 'X') {
				System.out.println("Player " + currentPlayer + ", enter your move from (1-9):");
			int move = scanner.nextInt();
			
			if(setAndValidateMove(move)) {
				printBoard();
				if(checkWin()) {
					System.out.println("Player "+currentPlayer+" Wins! ");
					gameOver = true;
				} else if (checkTie()){
					System.out.println("It's a Tie!");
					gameOver = true;
				} else {
					switchPlayer();
				}
				
			} else {
				System.out.println("Invalid move. Try again.");
			}
			} else {
				cpuPlayer();
			}
			
			
		}
		scanner.close();
	}
	
	private static boolean setAndValidateMove(int move) {
		if (move > 0 || move < 9) {
			if(move == 1 && board[0][0] == '-') {
				board[0][0] = currentPlayer;
				return true;
			}
			if(move == 2 && board[0][1] == '-') {
				board[0][1] = currentPlayer;
				return true;
			}
			if(move == 3 && board[0][2] == '-') {
				board[0][2] = currentPlayer;
				return true;
			}
			if(move == 4 && board[1][0] == '-') {
				board[1][0] = currentPlayer;
				return true;
			}
			if(move == 5 && board[1][1] == '-') {
				board[1][1] = currentPlayer;
				return true;
			}
			if(move == 6 && board[1][2] == '-') {
				board[1][2] = currentPlayer;
				return true;
			}
			if(move == 7 && board[2][0] == '-') {
				board[2][0] = currentPlayer;
				return true;
			}
			if(move == 8 && board[2][1] == '-') {
				board[2][1] = currentPlayer;
				return true;
			}
			if(move == 9 && board[2][2] == '-') {
				board[2][2] = currentPlayer;
				return true;
			}
			
		}
		return false;
		
	}
	
	
	private static void initalizeBoard() {
		for(int i= 0; i<3; i++) {
			for (int j= 0; j<3; j++) {
				board[i][j] = '-';
				
			}
		}
	}
	
	private static void printBoard() {
		System.out.println("-------------");
		for(int i= 0; i<3; i++) {
			System.out.print("| ");
			for (int j= 0; j<3; j++) {
				System.out.print(board[i][j] + " | ");
				
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	private static void switchPlayer() {
		currentPlayer = (currentPlayer == 'X')? 'O':'X';
		
//		if(currentPlayer == 'X') {
//			currentPlayer = 'O';
//		}else {
//			currentPlayer = 'X';
//		}
		cpuPlayer();
	}
	
	private static boolean checkRow() {
		for(int row = 0; row <3; row++) {
			if(board[row][0] != '-' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
				return true;
			}
		}
		return false;
	}

	
	private static boolean checkColumn() {
		for(int col = 0; col <3; col++) {
			if(board[0][col] != '-' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean checkDiagonals() {
	
			if(board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
				return true;
			}
			if(board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
				return true;
			}
		return false;
	}
	
	private static boolean checkWin() {
		return (checkRow() || checkColumn() || checkDiagonals());
	}
	
	private static boolean checkTie() {
		
		for(int i= 0; i<3; i++) {
			for (int j= 0; j<3; j++) {
				
				if (board[i][j] == '-') {
					return false;
				}
				
			}
		}
		return true;
		
	}
	
	private static void cpuPlayer() {
	
		    while (currentPlayer == 'O') {
		    	Random rand = new Random();
		    	
		    	int position = rand.nextInt(9) +1;
		    	if(setAndValidateMove(position)) {
		    		printBoard();
		    		if(checkWin()) {
						System.out.println("Player "+currentPlayer+" Wins! ");
						gameOver = true;
					} else if (checkTie()){
						System.out.println("It's a Tie!");
						gameOver = true;
					} else {
						switchPlayer();
					}
		    	}	
		    }
	}
	
}
