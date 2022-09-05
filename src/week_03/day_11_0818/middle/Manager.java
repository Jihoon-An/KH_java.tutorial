package week_03.day_11_0818.middle;

import java.util.ArrayList;

// MVC1 중 Model
public class Manager {
    private ArrayList<Member> members = new ArrayList<>();

    public ArrayList<Member> getMembers() {
        return members;
    }

    public int getIndex() {
        return members.size();
    }

    public void addMember(Member member) {
        members.add(member);
    }
}