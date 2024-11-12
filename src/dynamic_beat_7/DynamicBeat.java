package dynamic_beat_7;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic; // 더블버퍼링 
	

	// exit 버튼이미지
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../images/exit.png"));
	private ImageIcon exitButtonImage2 = new ImageIcon(Main.class.getResource("../images/exit2.png"));
	// 시작하기 버튼이미지
	private ImageIcon StartButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon StartButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	// 종료하기 버튼이미지
	private ImageIcon QuitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon QuitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	
	
	// 왼쪽으로이동 버튼이미지
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftBasic.png"));
	// 오른쪽으로이동 버튼이미지
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightBasic.png"));
	
	
	// 모드 버튼 이미지
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	// 모드 버튼이미지
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	
	
	
	//인트로 백그라운드 이미지 파일 
	private Image Background = new ImageIcon(Main.class.getResource("../images/introbackground.jpg")).getImage();
	
	//메뉴바 이미지
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	
	//메뉴바 버튼이미지 변수주기
	private JButton exitButton = new JButton(exitButtonImage2);
	private JButton startButton = new JButton(StartButtonBasicImage);
	private JButton quitButton = new JButton(QuitButtonBasicImage);
	//이동바 버튼이미지 변수주기
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	//모드 버튼이미지 변수주기
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	
	
	
	
	
	private ImageIcon title = new ImageIcon(Main.class.getResource("../images/title.png"));
	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image SelectedImage; // 앨범 이미지
	private Image titleImage; // 앨범 이미지
	private Music selectedMusic; // 앨범 노래
	private int nowSelected = 0; // 노래번호 idx 0부터 선택하도록
	
	
	
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
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start(); //백그라운드 bgm 실행
		
		
		//노래 추가하기 (0.노래제목이미지 1.앨범이미지 2.게임입장후 배경 3.음악 하이라이트 4.음악)
		trackList.add(new Track("rozetitle.png","roze.png","game_background.jpg","apt.mp3","apm.mp3"));
		trackList.add(new Track("powertitle.png","power.png","game_background.jpg","power.mp3","power.mp3"));
		trackList.add(new Track("aespatitle.png","aespa.png","game_background.jpg","aespa.mp3","aespa.mp3"));
		
		
		
		
		
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
		
		
		startButton.setBounds(780,200,400,100); // start 버튼 위치
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
				introMusic.close();
				selectTrack(0);
//				Music selectedMusic = new Music("apt.mp3",true); 
//				selectedMusic.start(); //메인음악 종료 뒤 해당음악 실행
				
				startButton.setVisible(false); // 버튼지우기
				quitButton.setVisible(false);
				leftButton.setVisible(true); // 화면넘어왔을때 보이게할라면 true
				rightButton.setVisible(true);
				easyButton.setVisible(true);
				hardButton.setVisible(true);
				
				
				
				Background = new ImageIcon(Main.class.getResource("../images/main_background.jpg")).getImage();
	
				isMainScreen = true;
				
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
		
		
		
		leftButton.setVisible(false); // 첫 메인화면에 출력안되게하기
		leftButton.setBounds(140,310,60,60); //  버튼 위치
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 손가락 마우스커서 추가
				Music buttonEnterMusic = new Music("buttonEnterMusic.mp3",false);
				buttonEnterMusic.start(); //마우스 올라갔을 때 소리
			} // 마우스 올라갔을때 이미지 변경
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 떨어졌을때 손가락 마우스커서 제거
			} // 마우스가 떨어지면 이미지 변경
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("left.mp3",false);
				buttonPressedMusic.start(); //마우스 올라갔을 때 소리
				selectedLeft();
			} 
		});
		
		add(leftButton);
		
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080,310,60,60); //  버튼 위치
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 손가락 마우스커서 추가
				Music buttonEnterMusic = new Music("buttonEnterMusic.mp3",false);
				buttonEnterMusic.start(); //마우스 올라갔을 때 소리
			} // 마우스 올라갔을때 이미지 변경
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 떨어졌을때 손가락 마우스커서 제거
			} // 마우스가 떨어지면 이미지 변경
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("left.mp3",false);
				buttonPressedMusic.start(); //마우스 올라갔을 때 소리
				selectedRight();
			} 
		});
		
		add(rightButton);
		
		
		
		
		
		easyButton.setVisible(false);
		easyButton.setBounds(375,580,250,67); //  버튼 위치
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 손가락 마우스커서 추가
				Music buttonEnterMusic = new Music("buttonEnterMusic.mp3",false);
				buttonEnterMusic.start(); //마우스 올라갔을 때 소리
			} // 마우스 올라갔을때 이미지 변경
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 떨어졌을때 손가락 마우스커서 제거
			} // 마우스가 떨어지면 이미지 변경
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("left.mp3",false);
				buttonPressedMusic.start(); //마우스 올라갔을 때 소리
				gameStart(nowSelected, "easy");
			} 
		});
		
		add(easyButton);
		
		
		
		hardButton.setVisible(false);
		hardButton.setBounds(655,580,250,67); //  버튼 위치
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스가 올라갔을때 손가락 마우스커서 추가
				Music buttonEnterMusic = new Music("buttonEnterMusic.mp3",false);
				buttonEnterMusic.start(); //마우스 올라갔을 때 소리
			} // 마우스 올라갔을때 이미지 변경
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스가 떨어졌을때 손가락 마우스커서 제거
			} // 마우스가 떨어지면 이미지 변경
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("left.mp3",false);
				buttonPressedMusic.start(); //마우스 올라갔을 때 소리
				gameStart(nowSelected, "hard");
			} 
		});
		
		add(hardButton);
		
		
		
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
		
		
		
		

		
	}
	
	public void paint(Graphics g) { // paint = 하나의 약속된 메소드
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT); //프로그램화면만큼 이미지 생성
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage,0,0,null); // 게임창에 스크린이미지 드로우
		
	}
	

	
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(SelectedImage,340,100,null);
			g.drawImage(titleImage,340,70,null);
		}
		paintComponents(g); //JLabel 메뉴바 이미지는 고정이미지라 paintComponents 이용
		this.repaint(); // 이미지를 계속 반복시켜 계속 출력되도록 설정
	}
	
	public void selectTrack(int nowSelected) { 
		if(selectedMusic !=null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		SelectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
		selectedMusic.start();
		
	}
	
	
	public void selectedLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectedRight() {
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic !=null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage() ))
				.getImage();
		
		
		
	}
	
	
}
