package week_04.day_12_0822.studentManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manager students = new Manager();

        while (true) {
            //메인 화면
            System.out.println("<< 학생관리시스템 >>");
            System.out.println("1. 신규 정보 입력"); // MemberField : 학번/이름/국어/영어/수학
            System.out.println("2. 학생 목록 출력"); // (학번/이름/국어/영어/수학/합계/평균)
            System.out.println("3. 학생 정보 검색"); // 이름으로 검색
            System.out.println("4. 학생 정보 삭제"); // 학번으로 삭제
            System.out.println("5. 학생 정보 수정"); // 학번으로 수정
            System.out.println("0. 프로그램 종료");

            int choiceMain = Input._integer_(0, 5);

            switch (choiceMain) {
                case (1):// 신규 정보 입력
                    System.out.println("학생의 학번을 입력하세요.");
                    int id = Input._integer_();
                    String searchId_case1 = students.searchStudentId(id);
                    if (!searchId_case1.equals("없음")) {
                        System.out.println("이미 있는 학번입니다.");
                        break;
                    }
                    System.out.println("학생의 이름을 입력하세요.");
                    String name = Input._string_();
                    System.out.println("학생의 국어 점수를 입력하세요.");
                    double kor = Input._double_(0, 100);
                    System.out.println("학생의 영어 점수를 입력하세요.");
                    double eng = Input._double_(0, 100);
                    System.out.println("학생의 수학 점수를 입력하세요.");
                    double math = Input._double_(0, 100);

                    students.addStudent(new Student(id, name, kor, eng, math));
                    System.out.println("정상적으로 추가되었습니다.");

                    break;
                case (2): // 학생 목록 출력
                    if (students.getSize() == 0) {
                        System.out.println("출력할 학생이 없습니다.");
                        break;
                    }

                    System.out.println("--------------------------------------------------------------------" +
                            "\n학번\t\t\t이름\t\t국어\t\t영어\t\t수학\t\t합계\t\t평균");

                    for (Student student : students.getStudents()) {
                        System.out.println(student.getId() + "\t" +
                                student.getName() + "\t" +
                                student.getKor() + "\t" +
                                student.getEng() + "\t" +
                                student.getMath() + "\t" +
                                student.getTotal() + "\t" +
                                String.format("%.3f", student.getAverage()));
                    }
                    System.out.println("--------------------------------------------------------------------");

                    break;
                case (3): // 학생 정보 검색
                    if (students.getSize() == 0) {
                        System.out.println("검색할 학생이 없습니다.");
                        break;
                    }
                    System.out.println("검색할 학생의 이름을 검색하세요.");
                    ArrayList<Integer> indexs = students.searchStudentName(Input._string_());
                    if (indexs.size() == 0) {
                        System.out.println("검색 결과가 없습니다.");
                        break;
                    }
                    System.out.println("--------------------------------------------------------------------" +
                            "\n학번\t\t\t이름\t\t국어\t\t영어\t\t수학\t\t합계\t\t평균");
                    for (Integer index : indexs) {
                        System.out.println(students.getStudents().get(index).getId() + "\t" +
                                students.getStudents().get(index).getName() + "\t" +
                                students.getStudents().get(index).getKor() + "\t" +
                                students.getStudents().get(index).getEng() + "\t" +
                                students.getStudents().get(index).getMath() + "\t" +
                                students.getStudents().get(index).getTotal() + "\t" +
                                String.format("%.3f", students.getStudents().get(index).getAverage()));
                    }
                    System.out.println("--------------------------------------------------------------------");
                    break;
                case (4): // 학생 정보 삭제
                    if (students.getSize() == 0) {
                        System.out.println("삭제할 학생이 없습니다.");
                        break;
                    }
                    System.out.println("삭제할 학생의 학번을 검색하세요.");
                    try {
                        students.delStudent(Input._integer_());
                        System.out.println("삭제되었습니다!!!!");
                        break;
                    } catch (Exception e) {
                        System.out.println("일치하는 항목이 없습니다.");
                        break;
                    }
                case (5): // 학생 정보 수정
                    if (students.getSize() == 0) {
                        System.out.println("수정할 학생이 없습니다.");
                        break;
                    }
                    System.out.println("수정할 학생의 학번을 입력해세요.");
                    String indexString = students.searchStudentId(Input._integer_());
                    if (indexString.equals("없음")) {
                        System.out.println("검색 항목과 일치하는 결과가 없습니다.");
                        break;
                    }
                    int index = Integer.parseInt(indexString);
                    System.out.println("번경할 이름를 입력하세요.");
                    students.getStudents().get(index).setName(Input._string_());
                    System.out.println("번경할 국어 점수를 입력하세요.");
                    students.getStudents().get(index).setKor(Input._double_(0, 100));
                    System.out.println("번경할 영어 점수를 입력하세요.");
                    students.getStudents().get(index).setEng(Input._double_(0, 100));
                    System.out.println("번경할 수학 점수를 입력하세요.");
                    students.getStudents().get(index).setMath(Input._double_(0, 100));

                    System.out.println("변경되었습니다.");
                    break;
                case (0): // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("오류입니다.");
                    break;
            }
        }

    }
}