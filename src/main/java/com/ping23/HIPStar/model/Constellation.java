package main.java.com.ping23.HIPStar.model;

public class Constellation
{
    private int id;
    private String IAU_abbreviation;
    private String name;
    
    public Constellation()
    {
        new Constellation(0, "dummy", "dummy");
    }
    
    public Constellation(int id, String IAU_abbreviation, String name)
    {
        this.id = id;
        this.IAU_abbreviation = IAU_abbreviation;
        this.name = name;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getIAU_abbreviation()
    {
        return IAU_abbreviation;
    }
    
    public String getName()
    {
        return name;
    }

}
