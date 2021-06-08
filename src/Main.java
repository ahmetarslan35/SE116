import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Level lv1 = Level.generateLevel();
        String prompt ;
        Scanner scanner = new Scanner(System.in);

        /*System.out.println(lv1.corridorArrayList.size());
        System.out.println();
        for (int i = 0; i < lv1.allRooms.size(); i++) {
            lv1.allRooms.get(i).printPossibleRooms();
            System.out.println();
        }*/

        Hero hero1 = new Hero(lv1.allRooms.get(0));
        hero1.getCurrentRoom().printPossibleRooms();
        System.out.println("Which room :");
        prompt =scanner.next();
        hero1.move(prompt);
        System.out.println();
        System.out.println( hero1.getCurrentRoom().getName());
        hero1.getCurrentRoom().printPossibleRooms();
        hero1.move(prompt);














    }
}
