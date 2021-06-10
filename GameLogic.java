import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Random rand =new Random();

    public static int getOption(String prompt ,String action,Hero hero){
        String[] actions =action.toLowerCase().split(" ",4);
        if(actions[0].contains("move")){

            hero.move(actions[2]);


            return 1;
        }
        if(action.toLowerCase().contains("attack")){
            return 2;

        }
        if(action.toLowerCase().contains("move to upper")){
            return 3;


        }
        if(action.toLowerCase().contains("move to lower")){
            return 4;


        }
        if (action.toLowerCase().contains("exit")){
            return 5;
        }


        return 0 ;
    } // düzenleme lazım
    public static int printAndGetOptions(Hero hero){
        int counter = 1 ;
        System.out.println(hero.getCurrentLevel().getName()+" "+hero.getName()+" "+hero.getCurrentRoom().getName());
        for (int i = 0; i < hero.getCurrentRoom().arrayList.size(); i++) {
            System.out.println("["+(i+1)+"]"+"Move to"+hero.getCurrentRoom().arrayList.get(i).getName());
            counter++ ;
        }
        if(hero.getCurrentRoom().isHasAMonster()){
            System.out.println("["+counter+"]"+"Attack Monster");
        }

        if(hero.getCurrentRoom().isHasAUpstairs()){
            System.out.println("["+counter+"]"+" "+"Move to Upper Level");
        }
        if(hero.getCurrentRoom().isHasADownStairs()){
            System.out.println("["+counter+"]"+" "+"Move to Lower Level");
        }
        String action =GameLogic.scanner.next();
        int i = GameLogic.getOption(" ",action,hero);
        return i ;
    }


}
