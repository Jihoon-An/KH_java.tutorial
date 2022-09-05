package week_04.day_12_0822.studentManager;

import java.util.ArrayList;

public class Manager {
    private ArrayList<Student> students = new ArrayList<Student>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void delStudent(int id){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId()==id) {
                students.remove(i);
                break;
            }
        }
    }

    public String searchStudentId(int id) {
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                return String.valueOf(i);
            }
        }
        return "없음";
    }

    public ArrayList<Integer> searchStudentName(String name){
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().equals(name)) {
                indexs.add(i);
            }
        }
        return indexs;
    }

    public int getSize(){
        return students.size();
    }
}
