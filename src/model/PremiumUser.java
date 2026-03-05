package model;

public class PremiumUser extends User {

    public PremiumUser(String title) {
        super(title);
    }

    @Override
    public String ads() {
        return "No ads";
    }
}
