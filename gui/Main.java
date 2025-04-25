package gui;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        // Input dialoge, to Take the age and the name from a user

        String name;
        int age;

        name = JOptionPane.showInputDialog("Please enter your name: ");
        String ageAsString = JOptionPane.showInputDialog("Please enter your age: ");
        age = Integer.parseInt(ageAsString);

        // message dialog to print the age and the name

        JOptionPane.showMessageDialog(null, "Hello, " + name + " your age is " + age + "!");
        JOptionPane.showMessageDialog(null, "Press OK to exit!");

        System.exit(0);
    }
}
