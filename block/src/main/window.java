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



public class window extends JPanel {
	private BufferedImage myImage;
	private Graphics myBuffer;
//	private block[] I;
	public static final int FRAMEx = 150;
	public static final int FRAMEy = 100;

	public static final int xFRAME = 600;
	public static final int yFRAME = 800;
	public static final int xground = 300;
	public static final int yground = 600;
	private Terblock Tblock;
	private int BlockType=0;
	private int nextBlockType=0;

	private int BlockRotateType = 0;
	private int Blockcontent[][][] = new int [4][4][4];
	private int map[][]=new int [10][20];
	private int reserveBlock ;
	private int x=5,y=0;
	public window() {
		myImage = new BufferedImage(xFRAME, yFRAME, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		addKeyListener(new Key());
		addMouseListener(new Mouse());
		addMouseMotionListener(new Mouse1());
		setFocusable(true);
		Timer clockTimer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Tblock.setY(Tblock.getX()+Tblock.getW());
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
				myBuffer.fillRect(Tblock.getX(), Tblock.getY(), 10, 10);
				Tblock.draw(myBuffer);
				repaint();
			}
		});
		initial();
		tesTimer.start();
	}

	private class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				rotate(Tblock);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if(Tblock.getY()+Tblock.getH()==FRAMEy+yground) {
					Tblock.setY(Tblock.getY());
				}
				else {
					Tblock.setY(Tblock.getY()+Tblock.getW());
				}
				System.out.println("H="+Tblock.getH());
				
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(Tblock.getX()==FRAMEx) {
					Tblock.setX(Tblock.getX());
				}else {
					Tblock.setX(Tblock.getX()-Tblock.getW());
				}
				
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(Tblock.getX()+Tblock.getlen()==FRAMEx+xground) {
					Tblock.setX(Tblock.getX());
				}else {
					Tblock.setX(Tblock.getX()+Tblock.getW());
				}
				System.out.println("len="+Tblock.getlen());
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
	public  boolean collison(Terblock a,int x,int y,int Blocktype,int BlockRotateType) {
		
		return true;
	}
	public void rotate(Terblock a) {
		
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
	private void intoMap(Terblock a,int x,int y,int blocktype,int blockRotateType) {
		for(int i =0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Blockcontent[blockRotateType][i][j]==1) {
//				map[x][y+j]=Blockcontent[blockRotateType][i][j];
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
		Tblock= new Terblock(BlockType);
		Blockcontent=Tblock.getcontent();
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
	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
	}
}
