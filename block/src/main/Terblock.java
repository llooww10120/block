package main;


import java.awt.*;

import javax.swing.ImageIcon;

public class Terblock{
	private int [][][]shapecontent =new int[4][4][4];

	private final int[][][] Ishape= new int [][][] {
		{{ 0, 0, 0, 0},{ 1, 1, 1, 1},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
		{{ 0, 1, 0, 0},{ 0, 1, 0, 0},{ 0, 1, 0, 0},{ 0, 1, 0, 0 }},
		{{ 0, 0, 0, 0},{ 1, 1, 1, 1},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 0, 1, 0, 0},{ 0, 1, 0, 0},{ 0, 1, 0, 0},{ 0, 1, 0, 0 }}
		}; 
	private final int[][][]Lshape = new int[][][] {
		{{ 1, 0, 0, 0},{ 1, 0, 0, 0},{ 1, 1, 0, 0},{ 0, 0, 0, 0}},
        {{ 1, 1, 1, 0},{ 1, 0, 0, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0}},
        {{ 1, 1, 0, 0},{ 0, 1, 0, 0},{ 0, 1, 0, 0},{ 0, 0, 0, 0}},
        {{ 0, 0, 1, 0},{ 1, 1, 1, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0}}
	};
	private final int[][][] Jshape = new int[][][] {
		{{ 0, 1, 0, 0},{ 0, 1, 0, 0},{ 1, 1, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 0, 0, 0},{ 1, 1, 1, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 1, 0, 0},{ 1, 0, 0, 0},{ 1, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 1, 1, 0},{ 0, 0, 1, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }}
	};
	private final int[][][] Sshape = new int[][][] {
		{{ 0, 1, 1, 0},{ 1, 1, 0, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 0, 0, 0},{ 1, 1, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0 }},
        {{ 0, 1, 1, 0},{1, 1, 0, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 0, 0, 0},{ 1, 1, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0 }}
	};
	private final int[][][] Zshape = new int[][][] {
		{{ 1, 1, 0, 0},{ 0, 1, 1, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 0, 1, 0, 0},{ 1, 1, 0, 0},{ 1, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 1, 0, 0},{ 0, 1, 1, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 0, 1, 0, 0},{ 1, 1, 0, 0},{ 1, 0, 0, 0},{ 0, 0, 0, 0 }}
	};
	private final int[][][] Tshape = new int[][][] {
		{{ 0, 1, 0, 0},{ 1, 1, 1, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 0, 1, 0, 0},{ 1, 1, 0, 0},{ 0, 1, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 1, 1, 0},{ 0, 1, 0, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 0, 1, 0, 0},{ 0, 1, 1, 0},{ 0, 1, 0, 0},{ 0, 0, 0, 0 }}
	};
	private final int[][][] Oshape = new int[][][] {
		{{ 1, 1, 0, 0},{ 1, 1, 0, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 1, 0, 0},{ 1, 1, 0, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 1, 0, 0},{ 1, 1, 0, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }},
        {{ 1, 1, 0, 0},{ 1, 1, 0, 0},{ 0, 0, 0, 0},{ 0, 0, 0, 0 }}
	};
	private int shape;
	private Color color;
	private int Rotatetype=0;
	private int initialx = 7;
	private int initialy = 0;
	private int myX;
	private int myY;
	private int width=30;
//	private block blockshape[]= {new block(),new block(),new block(),new block()};
	//constructor
	public Terblock(int shap) {
		shape = shap;
		myX=window.FRAMEx+initialx*getW();
		myY=window.FRAMEy+initialy*getW();
		switch (shap) {
		//T
		case 1:
			shapecontent=Tshape;
			color = Color.PINK;

			break;
		//L
		case 2:
			shapecontent=Lshape;
			color = Color.BLUE;
			break;
		//S
		case 3:
			shapecontent=Sshape;
			color = Color.GREEN;
			break;
		//J
		case 4:
			shapecontent=Jshape;
			color = Color.ORANGE;

			break;
		//Z
		case 5:
			shapecontent=Zshape;
			color = Color.RED;
			break;
		//I
		case 6:
			shapecontent=Ishape;
			color = Color.CYAN;
			break;
		//O
		case 7:
			shapecontent=Oshape;
			color = Color.YELLOW;
			break;
		default:
			break;
		}
	}

	public void setX(int x) {
		myX=(x);
//		
	}
	public void setY(int y) {
		myY=(y);
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

	public void draw(Graphics myBuffer) {
		for(int i =0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(shapecontent[Rotatetype][i][j]==1) {
					myBuffer.setColor(color);
					myBuffer.fillRect(myX+i*getW(), myY+j*getW(), getW(), getW());
				}
			}
		}
		
	}
	public int getshape() {
		return shape;
	}
	public int[][][] getcontent() {
		return shapecontent;
	}
	public int getRotatetype() {
		return Rotatetype;
	}
	public void  setRotatetype(int type) {
		Rotatetype = type;
	}
	
}