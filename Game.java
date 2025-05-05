import java.util.Scanner;

public class Game {
    private Level levelOne = new Level(); 
    private Level levelTwo = new Level(); 
    private Level levelThree = new Level(); 
    private boolean bonus; 

    public Game(){

    }

    public boolean isBonus(){
        return bonus; 
    }

    public void makeBonus(){
        bonus = true; 
    }

    public Level getLevel(int i){
        if (i == 1){
            return levelOne; 
        }
        else if (i == 2){
            return levelTwo; 
        }
        else if (i == 3){
            return levelThree; 
        }
        else{
            return null; 
        }
    }

    public void play(){
        System.out.println("Enter the number of points: ");
        Scanner s = new Scanner(System.in); 
        levelOne.setPoints(s.nextInt());
        levelOne.reachGoal();
    }

    public int getScore(){
        int points = 0; 
        if (levelOne.goalReached()){
            points += levelOne.getPoints(); 
            if (levelTwo.goalReached()){
                points += levelTwo.getPoints(); 
                if(levelThree.goalReached()){
                    points += levelThree.getPoints(); 
                } 
            }
        }
        if (isBonus()) {
            points *= 3; 
        }
        return points; 
    }

    public int playManyTimes(int num){
        int max = 0; 
        while(num>0){
            play(); 
            int score = getScore(); 
            if (score > max){
                max = score; 
            }
            num--; 
        }
        return max; 
    }
}
