package model;

public class FreeUser extends User {

    public FreeUser (String title) {
        super(title);
    }

    @Override
    public String ads() {
        return "An ads is playing.";
    }
}
