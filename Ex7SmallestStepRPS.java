package exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Applying "smallest step tactics" to Rock, paper, scissor game.
 * See https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors
 *
 * Rules:
 *
 *       -----------  Beats -------------
 *       |                              |
 *       V                              |
 *      Rock (1) --> Scissors (2) --> Paper (3)
 *
 * See:
 * - SmallestStepNim
 */
public class Ex7SmallestStepRPS {

    public static void main(String[] args) {
        new Ex7SmallestStepRPS().program();
    }

    final Random rand = new Random();
    final Scanner sc = new Scanner(in);

    void program() {

        int maxRounds = 5;
        int human;          // Outcome for player
        int computer;       // Outcome for computer
        int result;         // Result for this round
        int round = 0;      // Number of rounds
        int total = 0;      // Final result after all rounds


        out.println("Welcome to Rock, Paper and Scissors");

        while(round <= maxRounds){

            out.print("Rock(1), Paper(2) or Scissors(3),enter number for choice: ");
            int weaponNumber = sc.nextInt();
            if (weaponNumber==1){
                out.println("You chose ROCK");
            }else if (weaponNumber==2){
                out.println("You chose PAPER");
            }else if (weaponNumber==3){
                out.println("You chose SCISSORS");
            }else{
                out.println("CHOOSE AGAIN");
                continue;
            }
            int computerWeapon = rand.nextInt(3)+1;
            if (computerWeapon==1){
                out.println("Computer chose ROCK");
            }else if (computerWeapon==2){
                out.println("Computer chose PAPER");
            }else if (computerWeapon==3) {
                out.println("Computer chose SCISSORS");
            }

            if(weaponNumber==1 && computerWeapon==3 || weaponNumber==2 && computerWeapon==1 || weaponNumber==3 &&computerWeapon==2){
                out.println("YOU won the round");
                total = total +1;
            }else if (weaponNumber==1 && computerWeapon==1 || weaponNumber==2 && computerWeapon==2 || weaponNumber==3 && computerWeapon==3){
                out.println("DRAW");
            }else{
                out.println("COMPUTER won");
                total = total -1;
            }
            round++;


        }

        out.println("Game over! ");
        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
    }
}
