package model;

public class FreeUser extends User{

    public FreeUser(String name){
        super(name);
    }

    @Override
    public String ads(){
        return "Free User: With commercials, not able to download songs.";
    }
}
