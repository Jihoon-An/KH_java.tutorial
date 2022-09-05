package week_04.day_13_0823.teacherQuiz1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class QServer {
	public static void main(String[] args) throws Exception{


		try(ServerSocket server = new ServerSocket(15000);
				Socket sock=server.accept();
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
				DataInputStream dis = new DataInputStream(sock.getInputStream());
			){
			String[] wisewords = new String[] {
					"극히 조심한다는 방침이야말로 가장 위험한 것이다.",
					"이 세상에 열정없이 이루어진 위대한 것은 없다.",
					"작은 기회로부터 종종 위대한 업적이 시작된다."
			};
			int[] lottoNum = new int[45];
			for(int i = 0;i < lottoNum.length;i++) {
				lottoNum[i] = i+1;
			}

			while(true) {
				String cmd = dis.readUTF();
				if(cmd.equals("date")) {
					SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 HH시mm분ss초");
					dos.writeUTF(sdf.format(System.currentTimeMillis()));
					dos.flush();
				}else if(cmd.equals("wiseword")) {
					dos.writeUTF(wisewords[(int)(Math.random()*3)]);
					dos.flush();
				}else if(cmd.equals("lotto")) {

					for(int i = 0;i < lottoNum.length*10;i++) {
						int x = (int)(Math.random()*45);
						int y = (int)(Math.random()*45);
						int tmp = lottoNum[x];
						lottoNum[x] = lottoNum[y];
						lottoNum[y] = tmp;
					}
					dos.writeUTF(lottoNum[0]+" "+lottoNum[1]+" "+lottoNum[2]+" "+lottoNum[3]+" "+lottoNum[4]+" "+lottoNum[5]+" ");
					dos.flush();

				}else {
					dos.writeUTF("그런 명령은 없습니다.");
					dos.flush();
				}

			}
		}


		//--------------------------------------------------------------



	}
}





