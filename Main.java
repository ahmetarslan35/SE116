import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int choice ;
        boolean flag = true,inGame = true ;
        int x ;




         while (flag){
             System.out.println("-----HERO OF THE DUNGEON------");
             Hero hero = new Hero();
             System.out.println("Enter name :");
             String name = GameLogic.scanner.next();
             hero.setName(name);
            while(inGame){
                x =GameLogic.printAndGetOptions(hero);
                if(x==0){
                    System.out.println("Invalid");
                }
                if(x==1){

                    hero.move();
                }
                if(x==2){}
                if(x==3){}
                if(x==4){}
                if(x==5){}

            }


        }















    }
}
