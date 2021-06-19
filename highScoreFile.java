import java.io.*;
import java.util.*;


public class highScoreFile {





    public static void readRecords() throws IOException {
        System.out.printf("%-3s%-10s%-10s%-10s%n","#","PLAYER","SCORE","#");
        int counter=1;
        BufferedReader reader = new BufferedReader(new FileReader("HighScores.txt"));
        String currentLine = reader.readLine();
        while(currentLine!=null && counter<6){
            if(!currentLine.equals("")){
                try {

                    String[] split = currentLine.split(" ");
                    System.out.printf("%-3s%-10s%-10s%-6s%n","#",split[0],split[1],"#");


                }
                catch (NoSuchElementException noSuchElementException){
                    System.err.println("File improperly formed");

                    noSuchElementException.getLocalizedMessage();



                }
                catch (IllegalStateException illegalStateException){
                    System.err.println("Error reading from file");

                }
            }
            counter++;
            currentLine =reader.readLine();

        }
        reader.close();

    }


    public static void sortFile() throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"));

        ArrayList<HeroInfo> heroRecords = new ArrayList<>();

        String currentLine = reader.readLine();

        while (currentLine != null)
        {
            if(!currentLine.equals("")){

                String[] heroDetail = currentLine.split(" ");

                String name = heroDetail[1];

                int score = Integer.parseInt(heroDetail[2]);

                heroRecords.add(new HeroInfo(name, score));
            }

            currentLine = reader.readLine();
        }



        heroRecords.sort(new scoreCompare());


        BufferedWriter writer = new BufferedWriter(new FileWriter("HighScores.txt"));

        for (HeroInfo heroInfo : heroRecords)
        {
            writer.write(heroInfo.name);
            writer.write(" "+heroInfo.score);
            writer.newLine();
        }
        reader.close();

        writer.close();
    }


    public static void writeFile(Hero hero) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt", true));
            writer.newLine();

            writer.write("# "+hero.getName()+" "+hero.getScore());
            System.out.println("Your score is saved.");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class scoreCompare implements Comparator<HeroInfo>{
    @Override
    public int compare(HeroInfo o1, HeroInfo o2) {
        return o2.score-o1.score;
    }

}
class HeroInfo {
    String name ;
    int score ;

    public HeroInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

}
