package array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ergebnisse = new int[10];
        for(int i= 0; i< ergebnisse.length; i++){
            ergebnisse[i] = wuerfeln();
        }
        System.out.println(Arrays.toString(ergebnisse));
    }

    static int wuerfeln() {
        int n = (int) (Math.random() * 6 + 1);
       // System.out.println(n);
        return n;
    }

}
