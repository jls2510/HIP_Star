package main.java.com.ping23.HIPStar;

public class App
{
    public App()
    {

    }

    public static void main(String[] args)
    {
        // System.out.println("Hello World.");

        App app = new App();
        app.go();

    }

    /**
     * go
     */
    private void go()
    {
        HeavenlyData.printStarData();
    }

}
