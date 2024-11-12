package dynamic_beat_11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
		// 노트이미지
		private Image noteBasicImage= new ImageIcon(Main.class.getResource("../images/noteBasic.jpg")).getImage();
		// 노트라우트 라인
		private Image noteRouteLineImage= new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
		// 노트라인 이미지
		private Image judgmentLineImage= new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
		// 게임 인포 이미지
		private Image gameInfoImage= new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage();
		// 노트세로라인 이미지
//		private Image noteRouteImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		
		private Image noteRouteSImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		private Image noteRouteDImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		private Image noteRouteFImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		private Image noteRouteSpace1Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		private Image noteRouteSpace2Image= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		private Image noteRouteJImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		private Image noteRouteKImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		private Image noteRouteLImage= new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

		
	
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage,228,30,null);
		g.drawImage(noteRouteDImage,332,30,null);
		g.drawImage(noteRouteFImage,436,30,null);
		g.drawImage(noteRouteSpace1Image,540,30,null);
		g.drawImage(noteRouteSpace2Image,640,30,null);
		g.drawImage(noteRouteJImage,744,30,null);
		g.drawImage(noteRouteKImage,848,30,null);
		g.drawImage(noteRouteLImage,952,30,null);
		
		g.drawImage(noteRouteLineImage,224,30,null);
		g.drawImage(noteRouteLineImage,328,30,null);
		g.drawImage(noteRouteLineImage,432,30,null);
		g.drawImage(noteRouteLineImage,536,30,null);
		g.drawImage(noteRouteLineImage,740,30,null);
		g.drawImage(noteRouteLineImage,844,30,null);
		g.drawImage(noteRouteLineImage,948,30,null);
		g.drawImage(noteRouteLineImage,1052,30,null);
		
		g.drawImage(gameInfoImage,0,660,null);
		g.drawImage(judgmentLineImage,0,580,null);
		
		
		
		g.drawImage(noteBasicImage,228,120,null);
		g.drawImage(noteBasicImage,332,580,null);
		g.drawImage(noteBasicImage,436,500,null);
		g.drawImage(noteBasicImage,540,340,null);
		g.drawImage(noteBasicImage,640,340,null);
		g.drawImage(noteBasicImage,744,325,null);
		g.drawImage(noteBasicImage,848,305,null);
		g.drawImage(noteBasicImage,952,305,null);
		
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("A.P.T - Roze,Brono Mars", 20, 702);
		g.drawString("Easy", 1190, 702);
		g.setFont(new Font("Arial",Font.PLAIN,30));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("SpaceBar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		
		g.setFont(new Font("Elphant",Font.BOLD,30));
		g.drawString("00000", 656, 702);
	}
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3",false).start();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	
	@Override 
	public void run() {
		
	}
}