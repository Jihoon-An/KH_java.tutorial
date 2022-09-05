//package week_03.day_10_0817;
//
//import it.sauronsoftware.ftp4j.FTPClient;
//
//import java.io.File;
//import java.util.Scanner;
//
//
//public class Main2 {
//    public static void main(String[] args) throws Exception {
//        String my_share_File_name = "C:/study/kh/공유파일/";
//        String url;
//        int port;
//        String id;
//        String password;
//        String fileName;
//        FTPClient client = new FTPClient();
//        while (true) {
//            // 메인메뉴 출력
//            System.out.println("=== FTP Client Program ===\n" +
//                    "1. Connect FTP\n" +
//                    "2. Exit Program");
//            int main_menu_input = inputInt(1, 2);
//
//            // 메인메뉴 분기
//            if (main_menu_input == 1) {// Connect FTP Server
//                // URL입력
//                while (true) {
//                    System.out.println("URL을 입력하세요.");
//                    url = inputStr();
//                    String[] url_arr = url.split("\\.");
//                    // URL 입력 검수
//                    if (url_arr.length == 4) {
//                        try {
//                            for (int i = 0; i < 4; i++) {
//                                int test = Integer.parseInt(url_arr[i]);
//                            }
//                            break;
//                        } catch (Exception e) {
//                            System.out.println("유효하지 않은 url입니다(주소값에 숫자가 아닌 값이 있습니다.) \n다시 입력하세요.");
//                        }
//                    } else {
//                        System.out.println("유효하지 않은 url입니다(.의 개수가 다릅니다.)\n다시 입력하세요.");
//                    }
//                }
//                // port 입력
//                System.out.println("port번호를 입력하세요.");
//                port = inputInt(0, 9999);
//
//                // connect
//                try {
//                    client.connect(url, port);
//                    System.out.println("연결에 성공하였습니다.");
//                } catch (Exception e) {
//                    System.out.println("연결에 실패하였습니다." +
//                            "\n 메인 화면으로 돌아갑니다.");
//                    continue;
//                }
//
//                // login
//                while (true) {
//                    try {
//                        System.out.println("id를 입력하세요.");
//                        id = inputStr();
//                        System.out.println("password를 입력하세요.");
//                        password = inputStr();
//                        client.login(id, password);
//                        System.out.println("Login Success!!!");
//                        break;
//                    } catch (Exception e) {
//                        System.out.println("잘못된 입력입니다. 다시 입력하세요.");
//                        continue;
//                    }
//                }
//                while (true) {
//                    // 메뉴입력
//                    System.out.println("=====================" +
//                            "\n1. Upload File" +
//                            "\n2. Download File" +
//                            "\n3. Disconnect FTP Server" +
//                            "\n4. Delete File");
//                    int ftpMenu = inputInt(1, 4);
//
//                    if (ftpMenu == 1) {// Upload File
//                        File shareFile = new File(my_share_File_name);
//                        String[] fileList = shareFile.list();
//                        if (fileList.length == 0) {
//                            System.out.println("업로드할 파일이 없습니다.");
//                            continue;
//                        }
//                        System.out.println("------File List------");
//                        for(int i = 0; i < fileList.length; i++) {
//                            System.out.println("[" + (i+1) + "] " + fileList[i]);
//                        }
//                        System.out.println("리스트에서 업로드 파일을 선택하세요.(숫자로)");
//                        int index = inputInt(1, fileList.length) - 1;
//                        File upFile = new File(my_share_File_name + fileList[index]);
//                        client.upload(upFile);
//                        continue;
//                    } else if (ftpMenu == 2) {// Download File
//                        String[] fileNames = client.listNames();
//                        if (fileNames.length == 0) {
//                            //다운로드 할 파일이 없음.
//                            System.out.println("다운로드 할 파일이 없습니다.");
//                            continue;
//                        } else {// 다운로드
//                            //리스트 보여주기
//                            for (String name : fileNames) {
//                                System.out.println(name);
//                            }
//                            fileName = inputStr();
//                            File downFile = new File(my_share_File_name + fileName);
//                            try {
//                                client.download(fileName, downFile);
//                                System.out.println("다운로드 완료");
//                            } catch (Exception e) {
//                                System.out.println("파일이 없습니다.");
//                            }
//                        }
//                        continue;
//                    } else if (ftpMenu == 3) {// Disconnect FTP Server
//                        client.disconnect(true);
//                        System.out.println("FTP 연결을 종료하였습니다." +
//                                "\n메인 메뉴로 돌아갑니다.");
//                        break;
//                    } else { // Delete File
//                        String[] fileList = client.listNames();
//                        if (fileList.length == 0) {
//                            System.out.println("지울 파일이 없습니다.");
//                            continue;
//                        }
//                        System.out.println("------File List------");
//                        for(int i = 0; i < fileList.length; i++) {
//                            System.out.println("[" + (i+1) + "] " + fileList[i]);
//                        }
//                        System.out.println("리스트에서 지울 파일을 선택하세요.(숫자로)");
//                        int index = inputInt(1, fileList.length) - 1;
//                        String delFile = fileList[index];
//                        try{
//                            client.deleteFile(delFile);
//                            System.out.println("선택하신 파일를 제거하였습니다.");
//                        }catch (Exception e){
//                            client.deleteDirectory(delFile);
//                            System.out.println("선택하신 폴더를 제거하였습니다.");
//                        }
//                        continue;
//                    }
//                }
//            } else if (main_menu_input == 2) {// Exit Program
//                System.exit(0);
//            }
//        }
//    }
//
//    static int inputInt() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            try {
//                System.out.print(">>> ");
//                return Integer.parseInt(scanner.nextLine());
//            } catch (Exception e) {
//                System.out.println("잘못된 입력입니다, 정수를 입력하세요.");
//            }
//        }
//    }
//
//    static int inputInt(int min, int max) {
//        int input_num = inputInt();
//        while (true) {
//            if (min <= input_num && input_num <= max) {
//                return input_num;
//            } else {
//                System.out.println("범위 밖의 입력입니다.");
//            }
//        }
//    }
//
//    static String inputStr() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print(">>>");
//        return scanner.nextLine();
//    }
//}
