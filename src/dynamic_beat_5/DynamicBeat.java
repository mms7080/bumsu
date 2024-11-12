package dynamic_beat_5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic; // 더블버퍼링 
	
	private Image newImage = new ImageIcon(Main.class.getResource("../images/title.png")).getImage(); // 새 이미지 추가

	
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../images/exit.png"));
	private ImageIcon exitButtonImage2 = new ImageIcon(Main.class.getResource("../images/exit2.png"));
	// exit 버튼이미지
	private ImageIcon StartButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon StartButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	// 시작하기 버튼이미지
	private ImageIcon QuitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon QuitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	// 종료하기 버튼이미지
	private Image Background = new ImageIcon(Main.class.getResource("../images/introbackground.jpg")).getImage();
	//백그라운드 이미지 파일 받아오기
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	//메뉴바 이미지
	
	
	private JButton exitButton = new JButton(exitButtonImage2);
	private JButton startButton = new JButton(StartButtonBasicImage);
	private JButton quitButton = new JButton(QuitButtonBasicImage);
	//메뉴바 버튼이미지
	
	private ImageIcon title = new ImageIcon(Main.class.getResource("../images/title.png"));
	
	
	private int mouseX, mouseY;
	
	
	
	public DynamicBeat() {
		setUndecorated(true); // 실행 시 
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT);// 게임 사이즈 불러오기
		setResizable(false); //사용자가 임의로 사이즈를 변경할수없게 설정
		setLocationRelativeTo(null); // 실행했을떄 게임창이 모니터 정중앙에 위치하도록
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창을 종료하면 프로그램 종료하도록
		setVisible(true); //  우리 눈에 게임창 나오도록
		setBackground(new Color(0, 0,0,0));
		setLayout(null);
		
		
		
		
		
		exitButton.setBounds(1245,0,30,30); // exit 버튼 위치
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 손가락 마우스커서 추가
				Music buttonEnterMusic = new Music("buttonEnterMusic.mp3",false);
				buttonEnterMusic.start(); //마우스 올라갔을 때 소리
			} // 마우스 올라갔을때 이미지 변경
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonImage2);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 떨어졌을때 손가락 마우스커서 제거
			} // 마우스가 떨어지면 이미지 변경
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start(); //마우스 올라갔을 때 소리
				try {
					Thread.sleep(1000);
				}catch (InterruptedException ex) {
					ex.printStackTrace();
				} // 종료 시 바로 꺼지지않고 1초동안 브금나오게하기
				System.exit(0);
			} // 클릭 시 시스템 종료
		});
		
		add(exitButton);
		
		
		startButton.setBounds(780,200,400,100); // exit 버튼 위치
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(StartButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 손가락 마우스커서 추가
				Music buttonEnterMusic = new Music("buttonEnterMusic.mp3",false);
				buttonEnterMusic.start(); //마우스 올라갔을 때 소리
			} // 마우스 올라갔을때 이미지 변경
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(StartButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 떨어졌을때 손가락 마우스커서 제거
			} // 마우스가 떨어지면 이미지 변경
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("StartPresedMusic.mp3",false);
				buttonPressedMusic.start(); //마우스 눌렀을 때 소리
				
				startButton.setVisible(false); // 버튼지우기
				quitButton.setVisible(false);
				Background = new ImageIcon(Main.class.getResource("../images/main_Bakground.jpg")).getImage();
				
			} // 시작하기 누르면 다음으로 넘어가기
		});
		
		add(startButton);
		
		
		quitButton.setBounds(780,330,400,100); // exit 버튼 위치
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(QuitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 손가락 마우스커서 추가
				Music buttonEnterMusic = new Music("buttonEnterMusic.mp3",false);
				buttonEnterMusic.start(); //마우스 올라갔을 때 소리
			} // 마우스 올라갔을때 이미지 변경
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(QuitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 떨어졌을때 손가락 마우스커서 제거
			} // 마우스가 떨어지면 이미지 변경
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start(); //마우스 올라갔을 때 소리
				try {
					Thread.sleep(1000);
				}catch (InterruptedException ex) {
					ex.printStackTrace();
				} // 종료 시 바로 꺼지지않고 1초동안 브금나오게하기
				System.exit(0);
			} 
		});
		
		add(quitButton);
		
		
		menuBar.setBounds(0,0,1280,30); //메뉴 위치
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
//		메뉴바 마우스클릭시 위치를 마음대로 이동할 수 있게끔 동작
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		
		
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start(); //백그라운드 bgm 실행
		
	}
	
	public void paint(Graphics g) { // paint = 하나의 약속된 메소드
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT); //프로그램화면만큼 이미지 생성
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage,0,0,null); // 게임창에 스크린이미지 드로우
		
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);
		paintComponents(g); //JLabel 메뉴바 이미지는 고정이미지라 paintComponents 이용
		this.repaint(); // 이미지를 계속 반복시켜 계속 출력되도록 설정
	}
	
	
	
	
	
}
