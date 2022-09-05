package week_03.day_11_0818.middle;

abstract public class Member {
    private int id;
    private String name;
    private int point;
    public Member() {
    }

    public Member(int id, String name, int point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    abstract public double getBonus();
    abstract  public String getType();
}