package week_03.day_11_0818.middle;

public class Silver extends Member{
    private String type = "Silver";

    public Silver() {}

    public Silver(int id, String name, int point) {
        super(id, name, point);
    }

    @Override
    public double getBonus() {
        return this.getPoint()*0.3;
    }
    public String getType(){
        return type;
    }
}
