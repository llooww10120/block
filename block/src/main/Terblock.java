package main;


import java.awt.*;

import javax.swing.ImageIcon;


class block{
	private int myX;
	private int myY;
	private int width;
	private ImageIcon image;
	private int hight;
	private boolean col;
	private Color color;
	private   int  blockSpeed = 10;
	
	public block() {
		myX=100;
		myY=100;
		width=20;
		hight=20;
		this.color = color.black;
	}
	public block(int x,int y,Color color) {
		myX=x;
		myY=y;
		width=20;
		hight=20;
		this.color = color;
		
	}
	public int getX() {
		return myX;
	}

	public int getY() {
		return myY;
	}

	public int getH() {
		return hight;
	}

	public int getW() {
		return width;
	}
	public void setX(int x) {
		myX = x;
	}
	public void setY(int y) {
		myY = y;
	}
	public Color getc() {
		return this.color;
		
	}
	public void draw(Graphics myBuffer) {
		myBuffer.setColor(color);
		myBuffer.fillRect(myX, myY, width, hight);
				
	}
	public  int getBlockSpeed() {
		return blockSpeed;
	}
	public  void setBlockSpeed(int blockSpeed) {
		blockSpeed = blockSpeed;
	}
}


public class Terblock extends block{
	private int [][][]shapecontent =new int[4][4][4];
//	private final int[][] Ishape= new int [][] {
//		{ 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
//        { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }
//	}; 
//	private final int[][] Lshape = new int[][] {
//		{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
//        { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
//        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
//	};
//	private final int[][] Jshape = new int[][] {
//		{ 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
//        { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
//        { 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
//	};
//	private final int[][] Sshape = new int[][] {
//		{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
//        { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }
//	};
//	private final int[][] Zshape = new int[][] {
//		{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
//        { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }
//	};
//	private final int[][] Tshape = new int[][] {
//		{ 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
//        { 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 }
//	};
//	private final int[][] Oshape = new int[][] {
//		{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//        { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
//	};
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
	private int width=10;
	private int hight=10;
	private block blockshape[]= {new block(),new block(),new block(),new block()};
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
//			blockshape[0]=new block(window.FRAMEx+10*initialx,window.FRAMEy+10*initialy,Color.PINK);
//			blockshape[1]=new block(blockshape[0].getX()-blockshape[0].getW(),blockshape[0].getY(),Color.PINK);
//			blockshape[2]=new block(blockshape[0].getX(),blockshape[0].getY()-blockshape[0].getH(),Color.PINK);
//			blockshape[3]=new block(blockshape[0].getX()+blockshape[0].getW(),blockshape[0].getY(),Color.PINK);
			break;
		//L
		case 2:
			shapecontent=Lshape;
			color = Color.BLUE;
//			blockshape[0]=new block(100,100,Color.BLUE);
//			blockshape[1]=new block(blockshape[0].getX(),blockshape[0].getY()-2*blockshape[0].getH(),Color.BLUE);
//			blockshape[2]=new block(blockshape[0].getX(),blockshape[0].getY()-blockshape[0].getH(),Color.BLUE);
//			blockshape[3]=new block(blockshape[0].getX()+blockshape[0].getW(),blockshape[0].getY(),Color.BLUE);
			break;
		//S
		case 3:
			shapecontent=Sshape;
			color = Color.GREEN;
//			blockshape[0]=new block(100,100,Color.GREEN);
//			blockshape[1]=new block(blockshape[0].getX()+blockshape[0].getW(),blockshape[0].getY()-blockshape[0].getH(),Color.GREEN);
//			blockshape[2]=new block(blockshape[0].getX(),blockshape[0].getY()-blockshape[0].getH(),Color.GREEN);
//			blockshape[3]=new block(blockshape[0].getX()-blockshape[0].getW(),blockshape[0].getY(),Color.GREEN);
			break;
		//J
		case 4:
			shapecontent=Jshape;
			color = Color.ORANGE;
//			blockshape[0]=new block(100,100,Color.ORANGE);
//			blockshape[1]=new block(blockshape[0].getX()-blockshape[0].getW(),blockshape[0].getY(),Color.ORANGE);
//			blockshape[2]=new block(blockshape[0].getX(),blockshape[0].getY()+blockshape[0].getH(),Color.ORANGE);
//			blockshape[3]=new block(blockshape[0].getX(),blockshape[0].getY()+2*blockshape[0].getH(),Color.ORANGE);
			break;
		//Z
		case 5:
			shapecontent=Zshape;
			color = Color.RED;
//			blockshape[0]=new block(100,100,Color.RED);
//			blockshape[1]=new block(blockshape[0].getX()-blockshape[0].getW(),blockshape[0].getY()-blockshape[0].getH(),Color.RED);
//			blockshape[2]=new block(blockshape[0].getX(),blockshape[0].getY()-blockshape[0].getH(),Color.RED);
//			blockshape[3]=new block(blockshape[0].getX()+blockshape[0].getW(),blockshape[0].getY(),Color.RED);
			break;
		//I
		case 6:
			shapecontent=Ishape;
			color = Color.CYAN;
//			blockshape[0]=new block(100,100,Color.CYAN);
//			blockshape[1]=new block(blockshape[0].getX(),blockshape[0].getY()-blockshape[0].getH(),Color.CYAN);
//			blockshape[2]=new block(blockshape[0].getX(),blockshape[0].getY()+blockshape[0].getH(),Color.CYAN);
//			blockshape[3]=new block(blockshape[0].getX(),blockshape[0].getY()+2*blockshape[0].getH(),Color.CYAN);
			break;
		//O
		case 7:
			shapecontent=Oshape;
			color = Color.YELLOW;
//			blockshape[0]=new block(100,100,Color.YELLOW);
//			blockshape[1]=new block(blockshape[0].getX()+blockshape[0].getW(),blockshape[0].getY(),Color.YELLOW);
//			blockshape[2]=new block(blockshape[0].getX(),blockshape[0].getY()+blockshape[0].getH(),Color.YELLOW);
//			blockshape[3]=new block(blockshape[0].getX()+blockshape[0].getW(),blockshape[0].getY()+blockshape[0].getH(),Color.YELLOW);
			break;
		default:
			break;
		}
	}

	public void setX(int x) {
		myX=(x);
//		switch (shape) {
//		//T
//		case 1:
//			blockshape[0].setX(window.FRAMEx+x*(getW()));
//			blockshape[1].setX(blockshape[0].getX()-blockshape[0].getW());
//			blockshape[2].setX(blockshape[0].getX());
//			blockshape[3].setX(blockshape[0].getX()+blockshape[0].getW());
//			break;
//		//L
//		case 2:
//			blockshape[0].setX(window.FRAMEx+x*(getW()));
//			blockshape[1].setX(blockshape[0].getX());
//			blockshape[2].setX(blockshape[0].getX());
//			blockshape[3].setX(blockshape[0].getX()+blockshape[0].getW());
//			break;
//		//S
//		case 3:
//			blockshape[0].setX(window.FRAMEx+x*(getW()));
//			blockshape[1].setX(blockshape[0].getX()+blockshape[0].getW());
//			blockshape[2].setX(blockshape[0].getX());
//			blockshape[3].setX(blockshape[0].getX()-blockshape[0].getW());
//			break;
//		//J
//		case 4:
//			blockshape[0].setX(window.FRAMEx+x*(getW()));
//			blockshape[1].setX(blockshape[0].getX()-blockshape[0].getW());
//			blockshape[2].setX(blockshape[0].getX());
//			blockshape[3].setX(blockshape[0].getX());
//			break;
//		//Z
//		case 5:
//			blockshape[0].setX(window.FRAMEx+x*(getW()));
//			blockshape[1].setX(blockshape[0].getX()-blockshape[0].getW());
//			blockshape[2].setX(blockshape[0].getX());
//			blockshape[3].setX(blockshape[0].getX()+blockshape[0].getW());
//			break;
//		//I
//		case 6:
//			blockshape[0].setX(window.FRAMEx+x*(getW()));
//			blockshape[1].setX(blockshape[0].getX());
//			blockshape[2].setX(blockshape[0].getX());
//			blockshape[3].setX(blockshape[0].getX());
//			break;
//		//O
//		case 7:
//			blockshape[0].setX(window.FRAMEx+x*(getW()));
//			blockshape[1].setX(blockshape[0].getX()+blockshape[0].getW());
//			blockshape[2].setX(blockshape[0].getX());
//			blockshape[3].setX(blockshape[0].getX()+blockshape[0].getW());
//			break;
//		default:
//			break;
//		}
	}
	public void setY(int y) {
		myY=(y);
//		switch (shape) {
//		//T
//		case 1:
//			blockshape[0].setY(window.FRAMEy+y*(getW()));
//			blockshape[1].setY(blockshape[0].getY());
//			blockshape[2].setY(blockshape[0].getY()-blockshape[0].getH());
//			blockshape[3].setY(blockshape[0].getY());
//			break;
//		//L
//		case 2:
//			blockshape[0].setY(window.FRAMEy+y*(getW()));
//			blockshape[1].setY(blockshape[0].getY()-2*blockshape[0].getH());
//			blockshape[2].setY(blockshape[0].getY()-blockshape[0].getH());
//			blockshape[3].setY(blockshape[0].getY());
//			break;
//		//S
//		case 3:
//			blockshape[0].setY(window.FRAMEy+y*(getW()));
//			blockshape[1].setY(blockshape[0].getY());
//			blockshape[2].setY(blockshape[0].getY()+blockshape[0].getH());
//			blockshape[3].setY(blockshape[0].getY());
//			break;
//		//J
//		case 4:
//			blockshape[0].setY(window.FRAMEy+y*(getW()));
//			blockshape[1].setY(blockshape[0].getY());
//			blockshape[2].setY(blockshape[0].getY()-blockshape[0].getH());
//			blockshape[3].setY(blockshape[0].getY()+2*blockshape[0].getH());
//			break;
//		//Z
//		case 5:
//			blockshape[0].setY(window.FRAMEy+y*(getW()));
//			blockshape[1].setY(blockshape[0].getY()-blockshape[0].getH());
//			blockshape[2].setY(blockshape[0].getY()-blockshape[0].getH());
//			blockshape[3].setY(blockshape[0].getY());
//			break;
//		//I
//		case 6:
//			setY(window.FRAMEy+y*(getW()));
//			blockshape[0].setY(window.FRAMEy+y*(getW()));
//			blockshape[1].setY(blockshape[0].getY()-blockshape[0].getH());
//			blockshape[2].setY(blockshape[0].getY()+blockshape[0].getH());
//			blockshape[3].setY(blockshape[0].getY()+2*blockshape[0].getH());
//			break;
//		//O
//		case 7:
//			blockshape[0].setY(window.FRAMEy+y*(getW()));
//			blockshape[1].setY(blockshape[0].getY());
//			blockshape[2].setY(blockshape[0].getY()+blockshape[0].getH());
//			blockshape[3].setY(blockshape[0].getY()+blockshape[0].getH());
//			break;
//		default:
//			
//			break;
//		}
	}
	public int getH() {
		return hight;
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
//			blockshape[i].draw(myBuffer);
			for(int j=0;j<4;j++) {
				
	
				if(shapecontent[Rotatetype][i][j]==1) {
					myBuffer.setColor(color);
					myBuffer.fillRect(myX+i*getW(), myY+j*getH(), getW(), getH());
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
// 	public void move(boolean up, boolean down, boolean left, boolean right) {
//		if (down == true) {
//			setY(getY()+10);
//		}
//		if (left == true) {
//			setX(getX()-10);
//		}
//		if (right == true) {
//			setX(getX()+10);
//		}
//	}
	
}