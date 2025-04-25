package lambda;

import javax.swing.*;

public class Main {

    public static void printNr(int Nr) {

        System.out.println(Nr);
    }

    public static void main(String[] args) {

        // ArrayList<Integer> numbers = new ArrayList<>();
        // numbers.add(34);
        // numbers.add(22);
        // numbers.add(87);
        // numbers.add(53);

        // // // Integer arr = new Integer();
        // // // numbers.toArray();

        // numbers.forEach((n) -> {
        // System.out.println(n);
        // });

        // Anonymous inner class
        Runnable d = new Runnable() {
            @Override
            public void run() {
                System.out.println("i can print something");
            }
        };
        d.run();
        Runnable r = () -> System.out.println("print hello");
        r.run();

        Runnable messageBox = () -> JOptionPane.showMessageDialog(null, " Print this in the Box");
        messageBox.run();

        String inputString = JOptionPane.showInputDialog("Enter your name: ");
        JOptionPane.showMessageDialog(null, "Hello, " + inputString);

        System.exit(0);

    }
}
