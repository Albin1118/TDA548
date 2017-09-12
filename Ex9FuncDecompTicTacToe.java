package exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Program for the TicTacToe Game
 *  - See https://en.wikipedia.org/wiki/Tic-tac-toe.
 *  - Use small step + functional decomposition
 *  - Just use an array for the board (we print it to look square)
 *
 * See:
 * - FuncDecompLCR
 */
public class Ex9FuncDecompTicTacToe {

    public static void main(String[] args) {
        new Ex9FuncDecompTicTacToe().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();
    final char EMPTY = '-';

    void program() {
        //test();       // <--------- Comment out to test

        Player p1 = getPlayer("olle", 'X');
        Player p2 = getPlayer("fia", 'O');
        Player actual;
        Player winner = null;
        char[] board = createBoard();  // alt. { EMPTY, EMPTY, ... }

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);

        if( rand.nextBoolean() ){
            actual = p1;
        }else{
            actual = p2;
        }

        // Write your game code here

        out.println("Game over!");
        plotBoard(board);

        if (winner != null) {
            out.println("Winner is " + actual.name);
        } else {
            out.println("Draw");
        }
    }

    // -----  Methods below this -------------------------------

    char[] createBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = EMPTY;
        }
        return board;
    }

    // TODO add more methods

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    Player getPlayer(String name, char mark){
        Player p = new Player();
        p.name = name;
        p.mark = mark;
        return p;
    }

    // A class (blueprint) for players.
    class Player {
        String name;
        char mark;
    }

    void test() {
        char[] testBoard1 = {'X', 'X', 'X', '0', 'O', 'X', 'O', '0', 'O'};

        // TODO test your methods here

        exit(0);
    }
}