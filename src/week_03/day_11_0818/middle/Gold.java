package week_03.day_11_0818.middle;

public class Gold extends Member{
    private String type = "Gold";

    public Gold() {}

    public Gold(int id, String name, int point) {
        super(id, name, point);
    }

    @Override
    public double getBonus(){
        return this.getPoint()*0.3;
    }
    public String getType(){
        return type;
    }
}