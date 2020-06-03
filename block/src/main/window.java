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
import java.util.concurrent.TimeUnit;

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
	public static final int Xnextblock = 460;
	public static final int XResblock = 40;
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
	private int nextblockW;
	private boolean nodelay=false;
	private boolean down;
	private Timer clockTimer,gameTimer;
	private boolean Res = true;
	public window() {
		myImage = new BufferedImage(xFRAME, yFRAME, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		addKeyListener(new Key());
		addMouseListener(new Mouse());
		addMouseMotionListener(new Mouse1());
		setFocusable(true);
		clockTimer = new Timer(downspeed, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(verticalcol()) {
					Tblock.setY(Tblock.getY() + Tblock.getW());
				}
			}
		});
		gameTimer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myBuffer.setColor(Color.black);
				myBuffer.fillRect(0, 0, xFRAME, yFRAME);
				myBuffer.setColor(Color.WHITE);
				myBuffer.fillRect(Xnextblock, Ynextblock, 100, 100);
				myBuffer.fillRect(XResblock, Ynextblock, 100, 100);
				myBuffer.fillRect(FRAMEx, FRAMEy, xground, yground);
				myBuffer.setColor(Color.black);
				myBuffer.fillRect(Tblock.getX(), Tblock.getY(), 10, 10);
				Tblock.draw(myBuffer);
				bot(Tblock);
				drawNextBlock(myBuffer);
				drawReserveBlock(myBuffer);
				draw(myBuffer);
				vanish();
				repaint();
			}
		});
		initial();
		gameTimer.start();
		clockTimer.start();
	}

	private class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				rotate(Tblock);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				nodelay=true;
				if (verticalcol()) {
					if (Tblock.getY() + Tblock.getH() == FRAMEy + yground) {
						Tblock.setY(Tblock.getY());
					} else {
						Tblock.setY(Tblock.getY() + Tblock.getW());
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
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
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_C) {
				reserveBlock();
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				downtobot();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				nodelay = false;
			}
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
	public void downtobot() {
		if(verticalcol()&&!bot(Tblock)) {
			Tblock.setY(Tblock.getY()+Tblock.getW());
			downtobot();
		}
		
	}
	// TODO
	public boolean verticalcol() {
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (Blockcontent[Tblock.getRotatetype()][j][i] >= 1) {
					if (Tblock.getmapX() + i < 10 && Tblock.getmapY() + j  < 20) {
						try {
							if (map[Tblock.getmapX() + i][Tblock.getmapY() + j + 1] >= 1) {
								if(nodelay) {
									TimeUnit.SECONDS.sleep((long) 0.5);
								}
								intoMap(Tblock, Tblock.getmapX(), Tblock.getmapY(), Tblock.getshape(),
										Tblock.getRotatetype());
								newblock();
								Res=true;
								return false;
							}
						}catch (Exception e) {
							// TODO: handle exception
							System.out.println("IndexOutofRange");
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

	public boolean mapcol() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Tblock.getcontent()[((BlockRotateType + 1) % 4)][j][i] >= 1) {
					try {
						if (map[Tblock.getmapX() + i][Tblock.getmapY() + j] >= 1) {
							return true;
						}
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("IndexOutOfRange");
					}
				}
			}
		}
		return false;
	}

	public boolean bot(Terblock a) {
		if (a.getY() + a.getH() >= FRAMEy + yground) {
			if(nodelay) {
				try {
					TimeUnit.SECONDS.sleep((long) 0.5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Tblock.setY(FRAMEy+yground-Tblock.getH());
			intoMap(a, a.getmapX(), a.getmapY(), a.getshape(), a.getRotatetype());
			newblock();
			Res=true;
			return true;
		}
		return false;
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
		if (!mapcol()) {
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
	public void gameover() {
		for(int i=0;i<10;i++) {
			if(map[i][0]>=1) {
				if(clockTimer.isRunning()&&gameTimer.isRunning()) {
					clockTimer.stop();
					gameTimer.stop();
					return;
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
		gameover();
		BlockType = nextBlockType;
		Tblock = new Terblock(BlockType);
		Blockcontent = Tblock.getcontent();
		nextBlockType = (int) (Math.random() * 7 + 1);
	}
	public void newblock(int blocktype) {
		gameover();
		Tblock = new Terblock(blocktype);
		Blockcontent = Tblock.getcontent();
	}
	public void nextblock() {
		nextBlockType = (int) (Math.random() * 7 + 1);
	}

	public void reserveBlock() {
		if(Res) {
			Res = false;
			if (reserveBlock == 0) {
				reserveBlock = BlockType;
				newblock();
			} else {
				int temp = 0;
				temp = reserveBlock;
				reserveBlock = BlockType;
				BlockType = temp;
				newblock(BlockType);
			}
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
		nextblockW = Tblock.getW() - 10;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Terblock.getcontent(nextBlockType)[0][j][i] >= 1) {
					switch (nextBlockType) {
					case 1:
						g.setColor(Color.PINK);
						g.fillRect(Xnextblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 2:
						g.setColor(Color.BLUE);
						g.fillRect(Xnextblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 3:
						g.setColor(Color.GREEN);
						g.fillRect(Xnextblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 4:
						g.setColor(Color.ORANGE);
						g.fillRect(Xnextblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 5:
						g.setColor(Color.RED);
						g.fillRect(Xnextblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 6:
						g.setColor(Color.CYAN);
						g.fillRect(Xnextblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 7:
						g.setColor(Color.YELLOW);
						g.fillRect(Xnextblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;

					default:
//						g.setColor(Color.WHITE);
						break;
					}

				}
			}
		}
	}
	public void drawReserveBlock(Graphics g) {
		nextblockW = Tblock.getW() - 10;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Terblock.getcontent(reserveBlock)[0][j][i] >= 1) {
					switch (reserveBlock) {
					case 1:
						g.setColor(Color.PINK);
						g.fillRect(XResblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 2:
						g.setColor(Color.BLUE);
						g.fillRect(XResblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 3:
						g.setColor(Color.GREEN);
						g.fillRect(XResblock + i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 4:
						g.setColor(Color.ORANGE);
						g.fillRect(XResblock+ i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 5:
						g.setColor(Color.RED);
						g.fillRect(XResblock+ i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 6:
						g.setColor(Color.CYAN);
						g.fillRect(XResblock+ i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

						break;
					case 7:
						g.setColor(Color.YELLOW);
						g.fillRect(XResblock+ i * nextblockW + 10, Ynextblock + j * nextblockW + 10, nextblockW,
								nextblockW);

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
