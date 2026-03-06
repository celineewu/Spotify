package model;

public class PremiumUser extends User {

    public PremiumUser(String name){
        super(name);
    }

    @Override
    public String ads(){
        return "Premium User: No commercials, able to download songs.";
    }
}
