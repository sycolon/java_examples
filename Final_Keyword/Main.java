package Final_Keyword;

public class Main extends myStrings {

    @Override
    public void myString(String txt) {
        System.out.println("This is the new Override: " + txt);
    }

    public static void main(String[] args) {
        final double pi = 3.14;
        pi = 645.34;
        System.out.println(pi);
        Main tt = new Main();
        tt.myString("test");

    }
}
