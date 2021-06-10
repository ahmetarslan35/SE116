import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Random rand =new Random();

    public static int getOption(String prompt ,String action,Hero hero){
        String[] actions ;
        actions =action.toLowerCase().split(" ");
        System.out.println(actions.toString());
        if(actions[1].equals("move")){
            return 1 ;
        }
        if(actions[1].equals("attack")){
            return 2 ;
        }
        if(actions[3].equals("upper")){
            return 3 ;
        }
        if(actions[3].equals("lower")){
            return 4 ;
        }
        if(actions[1].equals("townspeople")){
            return 5;
        }
        if(action.equals("exit")){
            return 6 ;

        }
        return 0 ;
    } // düzenleme lazım
    public static void printOptions(Hero hero){
        int counter = 1 ;
        System.out.println(hero.getCurrentLevel().getName()+" "+hero.getName()+" "+hero.getCurrentRoom().getName());
        for (int i = 0; i < hero.getCurrentRoom().arrayList.size(); i++) {
            System.out.println("["+(i+1)+"] Move to "+hero.getCurrentRoom().arrayList.get(i).getName());
            counter++ ;
        }
        if(hero.getCurrentRoom().hasAMonster()){
            System.out.println("["+counter+"] Attack Monster");
        }

        if(hero.getCurrentRoom().hasAUpstairs()){
            System.out.println("["+counter+"] Move to Upper Level");
        }
        if(hero.getCurrentRoom().hasADownStairs()){
            System.out.println("["+counter+"] Move to Lower Level");
        }
        if(hero.getCurrentRoom().hasATownsPeople()){
            System.out.println("["+counter+"] Townspeople");
        }
    }


}
