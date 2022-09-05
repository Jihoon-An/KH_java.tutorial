package week_04.day_13_0823.networkTutorial;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(25000);
        while (true) {
            System.out.println("신호 대기....");

            Socket socket = server.accept();
            // 통신이 들어오면 허락해라, 신호 입력을 받을 때 까지 대기하다가, 신호가 들어왔을 때Socket을 return한다.

            System.out.println("success!!");
            System.out.println("ip : " + socket.getInetAddress());// 접속자의 IP주소를 받아옴

            OutputStream os = socket.getOutputStream();         // OutputStream 생성
            DataOutputStream dos = new DataOutputStream(os);    // DataOutputStream(업그레이드 된 Stream)으로 업그레이드

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            /*
            output stream으로 데이터를 보내지만 상대방이 받지 않으면 무의미하다.
            client가 input stream으로 받아야한다.
             */
            while (true) {
//메세지 보내기
                dos.writeUTF("메세지 받기 대기중");
                dos.flush();
//            System.out.println("서버가 클라이언트에게 보내고 싶은 메세지 : ");
                Scanner scanner = new Scanner(System.in);
//            os.write();                                       // String 을 보내 수 없음.
                dos.writeUTF(JOptionPane.showInputDialog("메세지 입력"));                         // 데이터 버퍼에 넣기,writeUTF 가 최적화가 잘 되어있다.
                dos.flush();                                        // 데이터 전송

//메세지 받기
                String msg = dis.readUTF();
                System.out.println("클라이언트로부터 받은 메세지 : " + msg);
                if (msg.equals("나가기")) {
                    break;
                }
            }
        }
    }
}
