package week_04.day_13_0823.quiz1;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.Socket;
////////////////try with resource 를 이용한 신식 코드!!////////////////////
public class QuizClient {
    public static void main(String[] args) {
        while (true) {
            try (
                    Socket client = new Socket("192.168.50.16", 25000);
                    DataInputStream dis = new DataInputStream(client.getInputStream());
                    DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            ) {
                while (true) {
// 메세지 받기
//            String msg = dis.readUTF();
//            System.out.println("서버로부터 전송받은 메세지 : " + msg);

// 메세지 입력하고 전송
                    dos.writeUTF(JOptionPane.showInputDialog("메세지 입력"));
                    dos.flush();

// 메세지 받기
                    String msg = dis.readUTF();
                    System.out.println("서버로부터 전송받은 메세지 : " + msg);
                }
            } catch (Exception e) {
                System.out.println("서버와 연결 종료");
            }
        }
    }
}
