import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Random rand =new Random();


    public static void printOptions(Hero hero){
        System.out.println(hero.getCurrentLevel().getName()+" "+hero.getName()+" "+hero.getCurrentRoom().getName());
        System.out.println();
        System.out.println("OPTIONS:");
        for (int i = 0; i < hero.getCurrentRoom().arrayList.size(); i++) {
            System.out.println(hero.getCurrentRoom().arrayList.get(i).getName()+"(r"+hero.getCurrentRoom().arrayList.get(i).getId()+")");
        }
        if(hero.getCurrentRoom().hasAMonster()){
            System.out.println("Attack Monster");
        }

        if(hero.getCurrentRoom().hasAUpstairs()){
            System.out.println("Upper Level(move up)");
        }
        if(hero.getCurrentRoom().hasADownStairs()){
            System.out.println("Lower Level(move down)");
        }
        if(hero.getCurrentRoom().hasATownsPeople()){
            System.out.println("Rescue Townspeople(rescue tp)");
        }
    }


}
