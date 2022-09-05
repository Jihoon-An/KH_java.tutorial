package week_04.day_13_0823.networkTutorial;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket client = new Socket("192.168.50.50", 25000);
        InputStream is = client.getInputStream();
//        is.read();                                    // String 을 받아올 수 없음.
        DataInputStream dis = new DataInputStream(is);
        while (true) {
// 메세지 받기
            String msg = dis.readUTF();
            System.out.println("서버로부터 전송 된 메세지 : " + msg);

            OutputStream os = client.getOutputStream();         // OutputStream 생성
            DataOutputStream dos = new DataOutputStream(os);    // DataOutputStream(업그레이드 된 Stream)으로 업그레이드

// 메세지 보내기
            dos.writeUTF("메세지 받기 대기중");
            dos.flush();
//        System.out.print("클라이언트가 서버에게 보내고 싶은 메세지 : ");
            Scanner scanner = new Scanner(System.in);
//            os.write();                                       // String 을 보내 수 없음.
            dos.writeUTF(JOptionPane.showInputDialog("메세지 입력"));                         // 데이터 버퍼에 넣기,writeUTF 가 최적화가 잘 되어있다.
            dos.flush();                                        // 데이터 전송
        }
    }
}
