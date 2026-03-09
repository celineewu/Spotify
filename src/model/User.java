package model;

/*
 Abstract superclass.
 Encapsulates shared state and enforces polymorphic behavior.
*/

public abstract class User {

    private String name;

    public User(String name) {
        this.name = name;

    }

    // Getters and setters (encapsulation principle)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /*
     Polymorphic method.
     Each subclass decides formatting behavior.
    */
    public abstract String ads();

    @Override
    public String toString() {
        return name;
    }

}