package util.prototypePattern.entity;

import util.prototypePattern.interfaces.PrototypeCapable;

public class Doc implements PrototypeCapable
{
    private String name = null;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Movie clone() throws CloneNotSupportedException {
        System.out.println("Cloning Movie object..");
        return (Movie) super.clone();
    }
    
    @Override
    public String toString() {
        return "Movie";
    }
}