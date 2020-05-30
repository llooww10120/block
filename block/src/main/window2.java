package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;



public class window2 extends JPanel {
	private BufferedImage myImage;
	private Graphics myBuffer;
//	private block[] I;
	public static final int FRAMEx = 150;
	public static final int FRAMEy = 100;

	public static final int xFRAME = 600;
	public static final int yFRAME = 800;
	public static final int xground = 300;
	public static final int yground = 600;
	private Terblock2 Tblock2;
	private int BlockType=0;
	private int nextBlockType=0;

	private int BlockRotateType = 0;
	private int Blockcontent[][][] = new int [4][4][4];
	private int map[][]=new int [10][20];
	private int reserveBlock ;
	private int x=5,y=0;
	private int downspeed=1000;
	private int mX,mY;
	private int test[]=new int[] {1,1,1,1,1,1,1,1,1,1};
	public window2() {
		myImage = new BufferedImage(xFRAME, yFRAME, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		addKeyListener(new Key());
		addMouseListener(new Mouse());
		addMouseMotionListener(new Mouse1());
		setFocusable(true);
		Timer clockTimer = new Timer(downspeed, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Tblock2.setY(Tblock2.getY()+Tblock2.getW());
			}
		});
		Timer tesTimer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myBuffer.setColor(Color.black);
				myBuffer.fillRect(0, 0, xFRAME, yFRAME);
				myBuffer.setColor(Color.WHITE);
				myBuffer.fillRect(FRAMEx, FRAMEy, xground, yground);
				myBuffer.setColor(Color.black);
				myBuffer.fillRect(Tblock2.getX(), Tblock2.getY(), 10, 10);
				Tblock2.draw(myBuffer);				
				bot(Tblock2);
				draw(myBuffer);
//				vanish();
				repaint();
			}
		});
		initial();
		tesTimer.start();
		clockTimer.start();
	}

	private class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				rotate(Tblock2);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if(Tblock2.getY()+Tblock2.getH()==FRAMEy+yground) {
					Tblock2.setY(Tblock2.getY());
				}
				else {
					Tblock2.setY(Tblock2.getY()+Tblock2.getW());
				}
				System.out.println("H="+Tblock2.getH());
				
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(Tblock2.getX()==FRAMEx) {
					Tblock2.setX(Tblock2.getX());
				}else {
					Tblock2.setX(Tblock2.getX()-Tblock2.getW());
				}
				
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(Tblock2.getX()+Tblock2.getlen()==FRAMEx+xground) {
					Tblock2.setX(Tblock2.getX());
				}else {
					Tblock2.setX(Tblock2.getX()+Tblock2.getW());
				}
				System.out.println("len="+Tblock2.getlen());
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
			
		}

	}

	private class Mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class Mouse1 implements MouseMotionListener {

		public void mouseDragged(MouseEvent e) {

		}

		public void mouseMoved(MouseEvent e) {

		}

	}

	//TODO
	public  boolean collison(Terblock2 a,int x,int y,int Blocktype,int BlockRotateType) {
		
		return true;
	}
	public void bot(Terblock2 a) {
		if(a.getY()+a.getH()==FRAMEy+yground) {
			intoMap(a,a.getmapX(),a.getmapY(),a.getshape(),a.getRotatetype());
			newblock();
		}
	}
	public int mX(int x) {
		mX = FRAMEx + (Tblock2.getW()*x);
		return mX;
	}
	public int mY(int y) {
		mY = FRAMEy + (Tblock2.getW()*y);
		return mY;
	}
	public void draw(Graphics g) {
		for(int i=0;i<10;i++) {
			for(int j=0;j<20;j++) {
				switch (map[i][j]) {
				case 1:
					g.setColor(Color.PINK);
					g.fillRect(mX(i), mY(j), Tblock2.getW(), Tblock2.getW());

					break;
				case 2:
					g.setColor(Color.BLUE);
					g.fillRect(mX(i), mY(j), Tblock2.getW(), Tblock2.getW());

					break;
				case 3:
					g.setColor(Color.GREEN);				
					g.fillRect(mX(i), mY(j), Tblock2.getW(), Tblock2.getW());

					break;
				case 4:
					g.setColor(Color.ORANGE);
					g.fillRect(mX(i), mY(j), Tblock2.getW(), Tblock2.getW());

					break;
				case 5:
					g.setColor(Color.RED);
					g.fillRect(mX(i), mY(j), Tblock2.getW(), Tblock2.getW());

					break;
				case 6:
					g.setColor(Color.CYAN);
					g.fillRect(mX(i), mY(j), Tblock2.getW(), Tblock2.getW());

					break;
				case 7:
					g.setColor(Color.YELLOW);
					g.fillRect(mX(i), mY(j), Tblock2.getW(), Tblock2.getW());

					break;

				default:
//					g.setColor(Color.WHITE);
					break;
				
				}
			}
		}
	}
	public void rotate(Terblock2 a) {
		
		BlockRotateType = ((BlockRotateType+1)%4);
		a.setRotatetype(BlockRotateType);
		if((a.getX()+a.getlen())>FRAMEx+xground) {
			a.setX(FRAMEx+xground-a.getlen() );
		}
		if((a.getY()+a.getH())>FRAMEy+yground) {
			a.setY(FRAMEy+yground-a.getH() );
		}
		repaint();
	}
	private void intoMap(Terblock2 a,int x,int y,int blocktype,int blockRotateType) {
		for(int i =0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Blockcontent[blockRotateType][i][j]>=1) {
					map[x+i][y+j]=Blockcontent[blockRotateType][i][j];
				}
			}
		}
	}
	public void initial() {
		map= new int [10][20];
		myBuffer.setColor(Color.WHITE);
		myBuffer.fillRect(FRAMEx, FRAMEy, xground, yground);
		BlockType = (int)(Math.random()*7+1);
		nextBlockType = (int)(Math.random()*7+1);
		newblock();
	}
	public void newblock() {
		BlockType = nextBlockType;
		Tblock2= new Terblock2(BlockType);
		Blockcontent=Tblock2.getcontent();
		nextBlockType = (int)(Math.random()*7+1);
	}
	
	public void nextblock() {
		nextBlockType = (int)(Math.random()*7+1);
	}
	public void reserveBlock() {
		if(reserveBlock==0) {
			reserveBlock = BlockType;
			BlockType = nextBlockType;
		}
		else {
			int temp=0;
			temp=reserveBlock;
			reserveBlock = BlockType;
			BlockType = temp;
		}
	
	}
//	public void vanish() {
//		for(int i = 19;i>=0;i--) {
//			if(map[i]==test) {
//				for(int j =i;j>0;j--) {
//					map[j]=map[j-1];
//				}
//			}
//		}
//	}
	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
	}
}
