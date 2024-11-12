package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT);// 게임 사이즈 불러오기
		setResizable(false); //사용자가 임의로 사이즈를 변경할수없게 설정
		setLocationRelativeTo(null); // 실행했을떄 게임창이 모니터 정중앙에 위치하도록
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창을 종료하면 프로그램 종료하도록
		setVisible(true); //  우리 눈에 게임창 나오도록
	}
	
}
