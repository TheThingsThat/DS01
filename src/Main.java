import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyLL<Integer> myList = new MyLL<>();

        for(int i = 0; i < 100; i++) {
            Integer num = (int)(Math.random()*180);
            myList.addFirst(num);
        }
        System.out.println("Done");
    }
}