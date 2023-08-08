import java.util.Random;
import java.util.Scanner;
class Numbergame
{ 
    static int winCount=0;
    
    public static void main(String[] args) 
    {
        nextRound();
    }
    static void nextRound()
    {   
       Random rand=new Random();
       Scanner scan=new Scanner(System.in);
       int randNum=rand.nextInt(100)+1;
       System.out.println("Guess a random number between 1 and 100:");
       System.out.println("You have five chances to guess the number");
       for (int i=0;i<5;i++) {
       int guess=scan.nextInt();
       if(randNum==guess)
       {
            System.out.println("Hurray!You have correctly gussed!");
            winCount+=1;
            break;
       }
       else if ((randNum!=guess) && (i==4))
       {
       System.out.println("sorry! Your chances are over");
       System.out.println("The random number is:"+randNum);
       }
       else if (randNum > guess)
       {
            System.out.println("Your guess is lower, Guess a higher number");
       }
       else if (randNum < guess)
       {
            System.out.println("Your guess is higher, Guess a lower number");
       }
       
       if ((randNum!=guess) && (i==3))
       {
        System.out.println("This is your last chance");
       }
     }
        System.out.println();
        System.out.println("Thank you for playing the game");
        System.out.println("If you want to play another round , please enter '1' otherwise enter any digit ");

        int a=scan.nextInt();
        if (a == 1)
        {
         nextRound();
        }
        else
        {
        System.out.println("You have successfully gussed "+winCount+" times");
        System.out.println("Your score is: "+winCount);
        }
        scan.close();
   }
    

}