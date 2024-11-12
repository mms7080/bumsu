package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic; // 더블버퍼링 
	
	private Image introBackground;
	
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT);// 게임 사이즈 불러오기
		setResizable(false); //사용자가 임의로 사이즈를 변경할수없게 설정
		setLocationRelativeTo(null); // 실행했을떄 게임창이 모니터 정중앙에 위치하도록
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창을 종료하면 프로그램 종료하도록
		setVisible(true); //  우리 눈에 게임창 나오도록
		
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		//백그라운드 이미지 파일 받아오기
		
	}
	
	public void paint(Graphics g) { // paint = 하나의 약속된 메소드
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT); //프로그램화면만큼 이미지 생성
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage,0,0,null); // 게임창에 스크린이미지 드로우
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint(); // 이미지를 계속 반복시켜 계속 출력되도록 설정
	}
	
	
}
