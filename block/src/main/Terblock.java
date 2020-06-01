package main;

import java.awt.*;

import javax.swing.ImageIcon;

public class Terblock {
	private int[][][] shapecontent = new int[4][4][4];
	// case 1
	private final static int[][][] Tshape = new int[][][] {
			{ { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 } } };
	// case 2
	private final static int[][][] Lshape = new int[][][] {
			{ { 2, 0, 0, 0 }, { 2, 0, 0, 0 }, { 2, 2, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 2, 2, 2, 0 }, { 2, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 2, 2, 0, 0 }, { 0, 2, 0, 0 }, { 0, 2, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 2, 0 }, { 2, 2, 2, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } } };
	// case 3
	private final static int[][][] Sshape = new int[][][] {
			{ { 0, 3, 3, 0 }, { 3, 3, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 3, 0, 0, 0 }, { 3, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 3, 3, 0 }, { 3, 3, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 3, 0, 0, 0 }, { 3, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 0, 0, 0 } } };
	// case 4
	private final static int[][][] Jshape = new int[][][] {
			{ { 0, 4, 0, 0 }, { 0, 4, 0, 0 }, { 4, 4, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 4, 0, 0, 0 }, { 4, 4, 4, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 4, 4, 0, 0 }, { 4, 0, 0, 0 }, { 4, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 4, 4, 4, 0 }, { 0, 0, 4, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } } };
	// case 5
	private final static int[][][] Zshape = new int[][][] {
			{ { 5, 5, 0, 0 }, { 0, 5, 5, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 5, 0, 0 }, { 5, 5, 0, 0 }, { 5, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 5, 5, 0, 0 }, { 0, 5, 5, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 5, 0, 0 }, { 5, 5, 0, 0 }, { 5, 0, 0, 0 }, { 0, 0, 0, 0 } } };
	// case 6
	private final static int[][][] Ishape = new int[][][] {
			{ { 6, 0, 0, 0 }, { 6, 0, 0, 0 }, { 6, 0, 0, 0 }, { 6, 0, 0, 0 } },
			{ { 6, 6, 6, 6 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 6, 0, 0, 0 }, { 6, 0, 0, 0 }, { 6, 0, 0, 0 }, { 6, 0, 0, 0 } },
			{ { 6, 6, 6, 6 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			};
	// case 7
	private final static int[][][] Oshape = new int[][][] {
			{ { 7, 7, 0, 0 }, { 7, 7, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 7, 7, 0, 0 }, { 7, 7, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 7, 7, 0, 0 }, { 7, 7, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 7, 7, 0, 0 }, { 7, 7, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } } };
	private int shape;
	private Color color;
	private int Rotatetype = 0;
	private int initialx = 5;
	private int initialy = 0;
	private int myX, myY;
	private int width = 30;
	private int len, hight;
	private int mapX, mapY;

	// constructor
	public Terblock(int shap) {
		System.out.print(window.FRAMEx);
		shape = shap;
		myX = window.FRAMEx + initialx * getW();
		myY = window.FRAMEy + initialy * getW();
		switch (shap) {
		// T
		case 1:
			shapecontent = Tshape;
			color = Color.PINK;

			break;
		// L
		case 2:
			shapecontent = Lshape;
			color = Color.BLUE;
			break;
		// S
		case 3:
			shapecontent = Sshape;
			color = Color.GREEN;
			break;
		// J
		case 4:
			shapecontent = Jshape;
			color = Color.ORANGE;

			break;
		// Z
		case 5:
			shapecontent = Zshape;
			color = Color.RED;
			break;
		// I
		case 6:
			shapecontent = Ishape;
			color = Color.CYAN;
			break;
		// O
		case 7:
			shapecontent = Oshape;
			color = Color.YELLOW;
			break;
		default:
			break;
		}
	}

	public void setX(int x) {
		myX = x;
//		
	}

	public void setY(int y) {
		myY = y;
//		
	}

	public int getW() {
		return width;
	}

	public int getX() {
		return myX;
	}

	public int getY() {
		return myY;
	}

	public int getlen() {
		int k = 0;
		for (int i = 3; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (shapecontent[Rotatetype][j][i] >= 1) {
					k += 1;
				}
			}
			if (k >= 1) {
				len = (i + 1) * width;
				break;
			}
		}
		return len;
	}

	public int getH() {
		int k = 0;
		for (int i = 3; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (shapecontent[Rotatetype][i][j] >= 1) {
					k += 1;
				}
			}
			if (k >= 1) {
				hight = (i + 1) * width;
				break;
			}
		}
		return hight;
	}

	public void draw(Graphics myBuffer) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (shapecontent[Rotatetype][j][i] >= 1) {
					myBuffer.setColor(color);
					myBuffer.fillRect(myX + i * getW(), myY + j * getW(), getW(), getW());
				}
			}
		}

	}

	public int getmapX() {
		mapX = (myX - window.FRAMEx) / width;
		return mapX;
	}

	public int getmapY() {
		mapY = (myY - window.FRAMEy) / width;
		return mapY;
	}

	public int getshape() {
		return shape;
	}

	public static int[][][] getcontent(int shape) {
		int[][][] content = new int[4][4][4];
		switch (shape) {
		case 1:
			content = Tshape;
			break;
		case 2:
			content = Lshape;
			break;
		case 3:
			content = Sshape;
			break;
		case 4:
			content = Jshape;
			break;
		case 5:
			content = Zshape;
			break;
		case 6:
			content = Ishape;
			break;
		case 7:
			content = Oshape;
			break;
		default:
//			content = null;
			break;
		}
		return content;
	}

	public int[][][] getcontent() {
		return shapecontent;
	}

	public int getRotatetype() {
		return Rotatetype;
	}

	public void setRotatetype(int type) {
		Rotatetype = type;
	}

}