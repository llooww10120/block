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
	public static final int FRAMEx = 100;
	public static final int FRAMEy = 100;

	public static final int xFRAME = 600;
	public static final int yFRAME = 800;
	public static final int xground = 300;
	public static final int yground = 600;
	public static final int Xnextblock = 420;
	public static final int Ynextblock = 100;

	private Terblock Tblock;
	private int BlockType = 0;
	private int nextBlockType = 0;

	private int BlockRotateType = 0;
	private int Blockcontent[][][] = new int[4][4][4];
	private int map[][] = new int[10][20];
	private int reserveBlock;
	private int x = 5, y = 0;
	private int downspeed = 1000;
	private int mX, mY;
	private int nextblockW ;
	public window() {
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
				Tblock.setY(Tblock.getY() + Tblock.getW());
				verticalcol();
			}
		});
		Timer tesTimer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myBuffer.setColor(Color.black);
				myBuffer.fillRect(0, 0, xFRAME, yFRAME);
				myBuffer.setColor(Color.WHITE);
				myBuffer.fillRect(Xnextblock, Ynextblock, 100, 100);
				myBuffer.fillRect(FRAMEx, FRAMEy, xground, yground);
				myBuffer.setColor(Color.black);
				myBuffer.fillRect(Tblock.getX(), Tblock.getY(), 10, 10);
				Tblock.draw(myBuffer);
				bot(Tblock);
				drawNextBlock(myBuffer);
				draw(myBuffer);
			
	
				vanish();
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
				rotate(Tblock);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (verticalcol()) {
					if (Tblock.getY() + Tblock.getH() == FRAMEy + yground) {
						Tblock.setY(Tblock.getY());
					} else {
						Tblock.setY(Tblock.getY() + Tblock.getW());
					}
//					for (int i = 0; i < 20; i++) {
//						for (int j = 0; j < 10; j++) {
//							System.out.print(map[j][i]);
//						}
//						System.out.println("");
//					}
//					System.out.println(Tblock.getmapX());
//					System.out.println(Tblock.getmapY());
//					System.out.println("------------------------------------");
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.print(Tblock.getX());

				if (!horizontalcol(-1)) {
					if (Tblock.getX() == FRAMEx) {
						Tblock.setX(Tblock.getX());
					} else {
						Tblock.setX(Tblock.getX() - Tblock.getW());
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (!horizontalcol(1)) {
					if (Tblock.getX() + Tblock.getlen() == FRAMEx + xground) {
						Tblock.setX(Tblock.getX());
					} else {
						Tblock.setX(Tblock.getX() + Tblock.getW());
					}
					System.out.println("len=" + Tblock.getlen());
				}
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

	// TODO
	public boolean verticalcol() {
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (Blockcontent[Tblock.getRotatetype()][j][i] >= 1) {
					if (Tblock.getmapX() + i < 10 && Tblock.getmapY() + j + 1 < 20) {
//						System.out.println("down=" + (map[Tblock.getmapX() + i][Tblock.getmapY() + j + 1]));
//						System.out.println("mapx=" + (Tblock.getmapX() + i) + "mapY=" + (Tblock.getmapY() + j)
//								+ "con=" + Blockcontent[Tblock.getRotatetype()][j][i]);
//						System.out.println("rot=" + Tblock.getRotatetype());

						if (map[Tblock.getmapX() + i][Tblock.getmapY() + j + 1] >= 1) {
							intoMap(Tblock, Tblock.getmapX(), Tblock.getmapY(), Tblock.getshape(),
									Tblock.getRotatetype());
							newblock();
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	public boolean horizontalcol(int k) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Tblock.getmapX() + i + k < 10 && Tblock.getmapY() + j < 20 && Tblock.getmapX() + i + k > 0) {
					if (Blockcontent[Tblock.getRotatetype()][j][i] >= 1) {
						if (map[Tblock.getmapX() + i + k][Tblock.getmapY() + j] >= 1) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public void bot(Terblock a) {
		if (a.getY() + a.getH() == FRAMEy + yground) {
			intoMap(a, a.getmapX(), a.getmapY(), a.getshape(), a.getRotatetype());
			newblock();
		}
	}

	public int mX(int x) {
		mX = FRAMEx + (Tblock.getW() * x);
		return mX;
	}

	public int mY(int y) {
		mY = FRAMEy + (Tblock.getW() * y);
		return mY;
	}

	public void draw(Graphics g) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				switch (map[i][j]) {
				case 1:
					g.setColor(Color.PINK);
					g.fillRect(mX(i), mY(j), Tblock.getW(), Tblock.getW());

					break;
				case 2:
					g.setColor(Color.BLUE);
					g.fillRect(mX(i), mY(j), Tblock.getW(), Tblock.getW());

					break;
				case 3:
					g.setColor(Color.GREEN);
					g.fillRect(mX(i), mY(j), Tblock.getW(), Tblock.getW());

					break;
				case 4:
					g.setColor(Color.ORANGE);
					g.fillRect(mX(i), mY(j), Tblock.getW(), Tblock.getW());

					break;
				case 5:
					g.setColor(Color.RED);
					g.fillRect(mX(i), mY(j), Tblock.getW(), Tblock.getW());

					break;
				case 6:
					g.setColor(Color.CYAN);
					g.fillRect(mX(i), mY(j), Tblock.getW(), Tblock.getW());

					break;
				case 7:
					g.setColor(Color.YELLOW);
					g.fillRect(mX(i), mY(j), Tblock.getW(), Tblock.getW());

					break;

				default:
//					g.setColor(Color.WHITE);
					break;

				}
			}
		}
	}

	public void rotate(Terblock a) {
		
		BlockRotateType = ((BlockRotateType + 1) % 4);
		a.setRotatetype(BlockRotateType);
		if ((a.getX() + a.getlen()) > FRAMEx + xground) {
			a.setX(FRAMEx + xground - a.getlen());
		}
		if ((a.getY() + a.getH()) > FRAMEy + yground) {
			a.setY(FRAMEy + yground - a.getH());
		}
		repaint();
	}

	private void intoMap(Terblock a, int x, int y, int blocktype, int blockRotateType) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Blockcontent[blockRotateType][j][i] >= 1 && y + j < 20) {
					map[x + i][y + j] = Blockcontent[blockRotateType][j][i];
				}
			}
		}
	}

	public void initial() {
		map = new int[10][20];
		myBuffer.setColor(Color.WHITE);
		myBuffer.fillRect(FRAMEx, FRAMEy, xground, yground);
		BlockType = (int) (Math.random() * 7 + 1);
		nextBlockType = (int) (Math.random() * 7 + 1);
		newblock();
	}

	public void newblock() {
		BlockType = nextBlockType;
		Tblock = new Terblock(BlockType);
		Blockcontent = Tblock.getcontent();
		nextBlockType = (int) (Math.random() * 7 + 1);
	}

	public void nextblock() {
		nextBlockType = (int) (Math.random() * 7 + 1);
	}

	public void reserveBlock() {
		if (reserveBlock == 0) {
			reserveBlock = BlockType;
			BlockType = nextBlockType;
		} else {
			int temp = 0;
			temp = reserveBlock;
			reserveBlock = BlockType;
			BlockType = temp;
		}

	}

	public void vanish() {
		for (int i = 0; i < 20; i++) {
			int v = 0;
			for (int k = 0; k < 10; k++) {
				if (map[k][i] >= 1) {
					v += 1;
				}
			}
			if (v == 10) {
				for (int j = i; j > 0; j--) {
					for (int k = 0; k < 10; k++) {
						map[k][j] = map[k][j - 1];
					}
				}
			}
		}

	}

	public void drawNextBlock(Graphics g) {
		nextblockW = Tblock.getW()-10;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Terblock.getcontent(nextBlockType)[0][j][i] >= 1) {
					switch (nextBlockType) {
					case 1:
						g.setColor(Color.PINK);
						g.fillRect(Xnextblock+i*nextblockW+10, Ynextblock+j*nextblockW+10, nextblockW, nextblockW);

						break;
					case 2:
						g.setColor(Color.BLUE);
						g.fillRect(Xnextblock+i*nextblockW+10, Ynextblock+j*nextblockW+10, nextblockW, nextblockW);

						break;
					case 3:
						g.setColor(Color.GREEN);
						g.fillRect(Xnextblock+i*nextblockW+10, Ynextblock+j*nextblockW+10, nextblockW, nextblockW);

						break;
					case 4:
						g.setColor(Color.ORANGE);
						g.fillRect(Xnextblock+i*nextblockW+10, Ynextblock+j*nextblockW+10, nextblockW, nextblockW);

						break;
					case 5:
						g.setColor(Color.RED);
						g.fillRect(Xnextblock+i*nextblockW+10, Ynextblock+j*nextblockW+10, nextblockW, nextblockW);

						break;
					case 6:
						g.setColor(Color.CYAN);
						g.fillRect(Xnextblock+i*nextblockW+10, Ynextblock+j*nextblockW+10, nextblockW, nextblockW);

						break;
					case 7:
						g.setColor(Color.YELLOW);
						g.fillRect(Xnextblock+i*nextblockW+10, Ynextblock+j*nextblockW+10, nextblockW, nextblockW);

						break;

					default:
//						g.setColor(Color.WHITE);
						break;
					}
					
				}
			}
		}
	}

	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
	}
}
