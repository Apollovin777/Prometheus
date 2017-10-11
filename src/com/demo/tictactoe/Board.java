package com.demo.tictactoe;

public class Board {
	private ActionFigure[][] boardArray = new ActionFigure[3][3];

	public void setField(int x, int y, ActionFigure figure){
		boardArray[x][y] = figure;
	}

	public boolean isFree(int x, int y){
		if(boardArray[x][y]==null)
			return true;
		else
			return false;
	}

	public boolean hasMoreSpace() {
		for (int i=0;i<boardArray.length;i++){
			for(int j=0;j<boardArray[i].length;j++){
				if(boardArray[i][j]==null)
					return true;
			}
		}
		return false;
	}

	public void print() {
		for (int i=0;i<boardArray.length;i++){
			for(int j=0;j<boardArray[i].length;j++){
				if(boardArray[i][j]==null)
					System.out.print("-");
				else {
					switch (boardArray[i][j]) {
						case CROSS:
							System.out.print("X");
							break;
						case NOUGHT:
							System.out.print("O");
							break;
					}
				}
			}
			System.out.println();
		}
		System.out.println("*******************");
	}

}
