package week_04.day_12_0822.studentManager;

public class Student {
    // Member Field
    private int id;
    private String name;
    private double kor;
    private double eng;
    private double math;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKor() {
        return kor;
    }

    public void setKor(double kor) {
        this.kor = kor;
    }

    public double getEng() {
        return eng;
    }

    public void setEng(double eng) {
        this.eng = eng;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public Student() {
    }

    public Student(int id, String name, double kor, double eng, double math) {
        this.id = id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public double getTotal(){
        return (this.eng + this.kor + this.math);
    }

    public double getAverage(){
        return (this.eng + this.kor + this.math)/3;
    }
}
