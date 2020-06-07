package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.magiclen.media.AudioPlayer;
public class window extends JPanel {

	private static final ImageIcon backmenu = new ImageIcon("./image/backmenu.gif");
	private static final ImageIcon card = new ImageIcon("./image/card.png");
	private static final ImageIcon hanged = new ImageIcon("./image/hanged.png");
	private static final ImageIcon death = new ImageIcon("./image/death.png");
	private static final ImageIcon devil = new ImageIcon("./image/devil.png");
	private static final ImageIcon fortune = new ImageIcon("./image/fortune.png");
	private static final ImageIcon win = new ImageIcon("./image/win.png");
	private static final ImageIcon loss = new ImageIcon("./image/loss.png");

	
	private BufferedImage myImage;
	private Graphics2D myBuffer;
//	private block[] I;
	public static final int FRAMEx = 150;
	public static final int xFRAME = 600;
	public static final int yFRAME = 800;
	public static final int xground = 300;
	public static int FRAMEy;
	public static int yground;

	public static final int Xnextblock = 460;
	public static final int XResblock = 40;
	public static final int Ynextblock = 100;
	public static final int Yscore = 250;

	private Terblock Tblock;
	private int cardnumber = 0;
	private int difficulty = 0;
	private int score = 0;
	private int BlockType = 0;
	private int nextBlockType = 0;

	private int BlockRotateType = 0;
	private int Blockcontent[][][] = new int[4][4][4];
//	private int map[][] = new int[10][20];
	private int b;
	private int map[][] = new int[10][b];
	private int reserveBlock;
	private int x = 5, y = 0;
	private int downspeed = 1000;
	private int mX, mY;
	private int nextblockW;
	private boolean nodelay=false;
	private boolean down;
	private Timer gifTimer,resultTimer, clockTimer, clockTimer1,clockTimer2,clockTimer3,clockTimer4,clockTimer5,gameTimer;
	private boolean Res = true;
	private boolean start=false;
	private AudioPlayer backgroundsound;
	public window() {
		myImage = new BufferedImage(xFRAME, yFRAME, BufferedImage.TYPE_INT_RGB);
		myBuffer = (Graphics2D)myImage.getGraphics();

		addKeyListener(new Key());
		addMouseListener(new Mouse());
		addMouseMotionListener(new Mouse1());
		setFocusable(true);
		
		resultTimer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backgroundsound.pause();
				File g = new File("./sound/which.wav");
				backgroundsound = new AudioPlayer(g);
				backgroundsound.setVolume(6);
				backgroundsound.play();
				cardnumber = (int) (Math.random()*100);

				if (0<=cardnumber&&cardnumber<=25) {
					b = 20;
					FRAMEy = 100;
					yground = 600;
					myBuffer.drawImage(fortune.getImage(), 0, 0, xFRAME, yFRAME, null);
					repaint();
					
				}
				else if(25<=cardnumber&&cardnumber<=50) {
					b = 18;
					FRAMEy = 160;
					yground = 540;
					myBuffer.drawImage(hanged.getImage(), 0, 0, xFRAME, yFRAME, null);
					repaint();
				}
				else if(50<=cardnumber&&cardnumber<=75) {
					b = 16;
					FRAMEy = 220;
					yground = 480;
					myBuffer.drawImage(devil.getImage(), 0, 0, xFRAME, yFRAME, null);
					repaint();
				}
				else if(75<=cardnumber&&cardnumber<=100) {
					b = 14;
					FRAMEy = 280;
					yground = 420;
					myBuffer.drawImage(death.getImage(), 0, 0, xFRAME, yFRAME, null);
					repaint();
				}
			}
		});
		gifTimer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myBuffer.drawImage(backmenu.getImage(), 0, 0, xFRAME, yFRAME, null);
				myBuffer.drawImage(card.getImage(), 361, 458, 189, 243, null);
				myBuffer.drawImage(card.getImage(), 280, 356, 161, 207, null);
				myBuffer.drawImage(card.getImage(), 210, 266, 140, 180, null);
				myBuffer.drawImage(card.getImage(), 158, 197, 105, 135, null);
				myBuffer.drawImage(card.getImage(), 123, 152, 70, 90, null);
				myBuffer.drawImage(card.getImage(), 95, 125, 56, 72, null);
				myBuffer.drawImage(card.getImage(), 74, 98, 42, 54, null);
				myBuffer.drawImage(card.getImage(), 60, 80, 28, 36, null);
				myBuffer.setFont(new Font("Serif", Font.ITALIC, 60));
				myBuffer.drawString("What's Your Destiny?", 70, 70);
				repaint();
				
			}
		});
		clockTimer = new Timer(downspeed, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(verticalcol()) {
					Tblock.setY(Tblock.getY() + Tblock.getW());
				}
			}
		});
		clockTimer1 = new Timer(800, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(verticalcol()) {
					Tblock.setY(Tblock.getY() + Tblock.getW());
				}
			}
		});
		clockTimer2 = new Timer(600, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(verticalcol()) {
					Tblock.setY(Tblock.getY() + Tblock.getW());
				}
			}
		});
		clockTimer3 = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(verticalcol()) {
					Tblock.setY(Tblock.getY() + Tblock.getW());
				}
			}
		});
		clockTimer4 = new Timer(400, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(verticalcol()) {
					Tblock.setY(Tblock.getY() + Tblock.getW());
				}
			}
		});
		clockTimer5 = new Timer(300, new ActionListener() {

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
			
				myBuffer.drawImage(backmenu.getImage(), 0, 0, xFRAME, yFRAME, null);
				myBuffer.setColor(Color.WHITE);
				myBuffer.fillRect(Xnextblock, Ynextblock, 100, 100);
				myBuffer.fillRect(XResblock, Ynextblock, 100, 100);
				myBuffer.fillRect(Xnextblock, Yscore, 100, 100);
				myBuffer.fillRect(FRAMEx, FRAMEy, xground, yground);
				myBuffer.setColor(Color.magenta);
				myBuffer.setFont(new Font("Dialog", Font.ITALIC, 35));
				myBuffer.drawString("HOLD", 47, 100);
				myBuffer.drawString("NEXT", 467, 100);
				myBuffer.drawString("SCORE", 462, 250);
				myBuffer.setColor(Color.BLACK);
				myBuffer.drawString(Integer.toString(score), 490, 305);
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
		gifTimer.start();
		File g = new File("./sound/cover.wav");
		backgroundsound = new AudioPlayer(g);
		backgroundsound.setVolume(5);
		backgroundsound.play();

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
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(start) {
					backgroundsound.pause();
					initial();
					gameTimer.start();
					clockTimer.start();
					File a = new File("./sound/main.wav");
					backgroundsound = new AudioPlayer(a);
					backgroundsound.setVolume(6);
					backgroundsound.play();
					start= false;
				}
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
			if(gifTimer.isRunning()) {
				
				gifTimer.stop();
				resultTimer.start();
				start= false;
			}
			else if(resultTimer.isRunning()) {
				backgroundsound.stop();
				resultTimer.stop();
				File d = new File("./sound/devil_laughing.wav");
				backgroundsound = new AudioPlayer(d);
				backgroundsound.setVolume(6);
				backgroundsound.play();

				if (0<=cardnumber&&cardnumber<=25) {
					myBuffer.drawImage(backmenu.getImage(), 0, 0, xFRAME, yFRAME, null);
					myBuffer.drawImage(fortune.getImage(), 150, 200, 300, 400, null);
					repaint();

					
				}
				if (25<=cardnumber&&cardnumber<=50) {
					myBuffer.drawImage(backmenu.getImage(), 0, 0, xFRAME, yFRAME, null);
					myBuffer.drawImage(hanged.getImage(), 150, 200, 300, 400, null);
					repaint();
				}
				if (50<=cardnumber&&cardnumber<=75) {
					myBuffer.drawImage(backmenu.getImage(), 0, 0, xFRAME, yFRAME, null);
					myBuffer.drawImage(devil.getImage(), 150, 200, 300, 400, null);
					repaint();
				}
				if (75<=cardnumber&&cardnumber<=100) {
					myBuffer.drawImage(backmenu.getImage(), 0, 0, xFRAME, yFRAME, null);
					myBuffer.drawImage(death.getImage(), 150, 200, 300, 400, null);
					repaint();
				}
				start = true;
			}
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
					if (Tblock.getmapX() + i < 10 && Tblock.getmapY() + j  < b) {
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
				if (Tblock.getmapX() + i + k < 10 && Tblock.getmapY() + j < b && Tblock.getmapX() + i + k > 0) {
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

	public boolean bot(Terblock e) {
		try {
			if (e.getY() + e.getH() >= FRAMEy +yground) {
				Tblock.setY(FRAMEy+yground-Tblock.getH());
				intoMap(e, e.getmapX(), e.getmapY(), e.getshape(), e.getRotatetype());
				newblock();
				Res=true;
				return true;
			}
		}
		catch (Exception f) {
			// TODO: handle exception
			return false;
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
			g.setColor(Color.BLACK);
			g.drawLine(FRAMEx+i*Tblock.getW(), FRAMEy, FRAMEx+i*Tblock.getW(), FRAMEy+yground);
			for (int j = 0; j < b; j++) {
				g.setColor(Color.BLACK);
				g.drawLine(FRAMEx, FRAMEy+j*Tblock.getW(), FRAMEx+xground, FRAMEy+j*Tblock.getW());
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
				if (Blockcontent[blockRotateType][j][i] >= 1 && y + j < b) {
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
					myBuffer.drawImage(loss.getImage(), 0, 0, xFRAME, yFRAME, null);
					repaint();
					backgroundsound.pause();
					File a = new File("./sound/destruction1.wav");
					backgroundsound = new AudioPlayer(a);
					backgroundsound.setVolume(6);
					backgroundsound.play();
					return;
				}
			}
		}
	}
	public void initial() {
		map = new int[10][b];
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
		for (int i = 0; i < b; i++) {
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
				score += 100;
				if(score<100) {
					speedRefresh();
				}
				else {
					clockTimer.stop();
					gameTimer.stop();
					myBuffer.drawImage(win.getImage(), 0, 0, xFRAME, yFRAME, null);
					repaint();
					backgroundsound.pause();
					File a = new File("./sound/winsong.wav");
					backgroundsound = new AudioPlayer(a);
					backgroundsound.setVolume(6);
					backgroundsound.play();
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
	public void speedRefresh() {
		if(score==100) {
			clockTimer.stop();
			clockTimer1.start();
		}
		if(score==1000) {
			clockTimer1.stop();
			clockTimer2.start();
		}
		if(score==1400) {
			clockTimer2.stop();
			clockTimer3.start();
		}
		if(score==1700) {
			clockTimer3.stop();
			clockTimer4.start();
		}
		if(score==2000) {
			clockTimer4.stop();
			clockTimer5.start();
		}
	}
	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
	}
}