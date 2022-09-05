package week_04.day_13_0823.quiz1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

////////////////try catch 옛날식//////////////////
public class QuizServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(25000);
        while (true) {
            System.out.println("신호 대기....");

            Socket socket = server.accept();

            System.out.println("success!!");
            System.out.println("ip : " + socket.getInetAddress());

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            while (true) {
                try {
//메세지 보내기
//                    dos.writeUTF("메세지를 입력하세요.");
//                    dos.flush();
//메세지 입력하라고 하는거 받기
                    String msg = dis.readUTF();
                    System.out.println("클라이언트로부터 받은 메세지 : " + msg);
//메세지 보내기
                    if (msg.equals("date")) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        String sendMsg = sdf.format(System.currentTimeMillis());
                        System.out.println(sendMsg);
                        dos.writeUTF(sendMsg);
                        dos.flush();
                    } else if (msg.equals("Date")) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                        String sendMsg = sdf.format(System.currentTimeMillis());
                        System.out.println(sendMsg);
                        dos.writeUTF(sendMsg);
                        dos.flush();
                    } else if (msg.equals("lotto")) {
                        int[] arr = new int[45];
                        for (int i = 0; i < 45; i++) {
                            arr[i] = i + 1;
                        }
                        for (int j = 0; j < 100; j++) {
                            int a = (int) ((Math.random() * 44) + 1);
                            int b = (int) ((Math.random() * 44) + 1);
                            int tmp = arr[a];
                            arr[a] = arr[b];
                            arr[b] = tmp;
                        }
                        String lotto = arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5];
                        dos.writeUTF(lotto);
                        dos.flush();
                    } else if (msg.equals("wiseword")) {
                        String[] wiseArr = new String[]{
                                "이 세상에 열정없이 이루어진 위대한 것은 없다.",
                                "작은 기회로부터 종종 위대한 없적이 시작된다.",
                                "네트워크는 필요 없다고 하셨는데 이게 제일 어렵다."
                        };
                        int wiseIndex = (int) (Math.random() * wiseArr.length + 1);
                        dos.writeUTF(wiseArr[wiseIndex]);
                        dos.flush();
                    } else {
                        dos.writeUTF("그런 명령은 없습니다.");
                        dos.flush();
                    }
                } catch (Exception e) {
                    System.out.println("서버와의 연결이 해제되었습니다.");
                    dis.close();
                    dos.close();
                    break;
                }
            }
        }
    }
}
