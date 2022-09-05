package week_04.day_13_0823.teacherQuiz1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class QClient {
	public static void main(String[] args) {

		try (Socket socket=new Socket("192.168.50.65",15000);   //통신을 위해서 사용이 필요한 논리적인 단말기로 생각하면 됩니다.
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				){
						
			while(true) {
				dos.writeUTF(JOptionPane.showInputDialog("전송할 메세지를 입력해주세요"));
				dos.flush();

				String result = dis.readUTF();
				System.out.println("결과 : " + result);
			}
		}catch(Exception e) {
			System.out.println("서버와의 연결이 해제 되었습니다.");
		}

	}
}
