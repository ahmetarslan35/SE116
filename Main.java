import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean flag = true,inGame = true ;



         while (flag){
             System.out.println("-----HERO OF THE DUNGEON------");
             Hero hero = new Hero();
             System.out.println("Enter name :");
             String name = GameLogic.scanner.nextLine();
             hero.setName(name);
            while(inGame){
                GameLogic.printOptions(hero);
                String action =GameLogic.scanner.nextLine();

                String[]actions = action.toLowerCase().split(" ",5) ;


                if(actions[0].equals("move") && actions[1].contains("r")){
                    hero.move(actions[1]);

                }
                else if(actions[0].equals("attack")){
                    hero.getHealthPoint();


                }
                else if(actions[1].equals("up")){
                    hero.moveUpperLevel();
                }
                else if(actions[1].equals("down")){
                    hero.moveLowerLevel();
                }
                else if(actions[0].equals("rescue")){

                }
                else if(actions[0].equals("exit")){
                    inGame =false ;
                    flag = false ;
                    break ;


                }






            }


        }















    }
}
