package week_04.day_13_0823.quiz2;

import week_04.day_13_0823.networkTutorial.Server;

import java.awt.image.ByteLookupTable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz_2_Server {
    public static void main(String[] args) {
        while(true) {
            try (
                    ServerSocket server = new ServerSocket(25000);
                    Socket socket = server.accept();
                    OutputStream os = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    InputStream is = socket.getInputStream();
                    DataInputStream dis = new DataInputStream(is);

            ) {
                Manager manager = new Manager();
                System.out.println("접속 ip : " + socket.getInetAddress());
                while (true) {
                    String readId = dis.readUTF();
                    String readPw = dis.readUTF();

                    boolean success = manager.loginSuccess(new Account(readId, readPw));

                    dos.writeBoolean(success);
                    dos.flush();
                    if (success) {
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("서버와 연결 종료되었습니다.");
            }
        }
    }
}
