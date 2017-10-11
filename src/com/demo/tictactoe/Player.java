package com.demo.tictactoe;


import java.util.Random;

public class Player {
	private ActionFigure figure;
	public Player(ActionFigure figure) {
		this.figure = figure;
	}

	public Move turn(Board board) {
		Move move = new Move();
		Random rnd = new Random();
		int x = rnd.nextInt(3);
		int y = rnd.nextInt(3);
		while(!board.isFree(x,y)){
			x = rnd.nextInt(3);
			y = rnd.nextInt(3);
		}

		move.setFigure(this.figure);
		move.setX(x);
		move.setY(y);

		return move;
	}

}
