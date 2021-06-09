import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice ;
        Boolean flag = true ;
        int x ;


        Hero hero1 = new Hero();
        x =hero1.printOptions();
        choice = GameLogic.getOption("Which Room.\n"+hero1.getCurrentRoom().arrayList,x);
        hero1.move(choice);


        System.out.println();
        System.out.println( hero1.getCurrentRoom().getName());
        hero1.getCurrentRoom().printPossibleRooms();

        choice = GameLogic.getOption("Which Room.\n"+hero1.getCurrentRoom().arrayList,hero1.getCurrentRoom().arrayList.size())-1;
        hero1.move(choice);
        hero1.getCurrentRoom().printPossibleRooms();
         /*while (flag){
            while(true){

            }


        }*/















    }
}
