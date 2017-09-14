import javafx.animation.AnimationTimer;

import javafx.application.Application;

import javafx.scene.Group;

import javafx.scene.Scene;

import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

import javafx.stage.Stage;



import java.util.Arrays;

import java.util.Random;



import static java.lang.Math.round;

import static java.lang.Math.sqrt;

import static java.lang.System.*;



/*

 *  Program to simulate segregation.

 *  See : http://nifty.stanford.edu/2014/mccown-schelling-model-segregation/

 *

 * NOTE:

 * - JavaFX first calls method init() and then method start() far below.

 * - To test uncomment call to test() first in init() method!

 *

 */

// Extends Application because of JavaFX (just accept for now)

public class Neighbours extends Application {



    // Enumeration type for the Actors

    enum Actor {

        BLUE, NONE, RED   // Type only has 3 values, NONEs are white

    }



    // Enumeration type for the state of an Actor

    enum State {

        UNSATISFIED,

        NA,        // Not applicable (NA), used for NONEs

        SATISFIED

    }



    // Below is the *only* accepted instance variable (i.e. variables outside any method)

    // This variable is accessible from any method

    Actor[][] world;              // The world is a square matrix of Actors

    final Random rand = new Random();

    // This is the method called by the timer to update the world approx each 1/60 sec.

    void updateWorld() {

        // % of surrounding neighbours that are like me

        final double threshold = 0.7;



        // TODO add methods

    }



    // This method initializes the world variable with a random distribution of Actors

    // Method automatically called by JavaFX runtime

    // That's why we must have "@Override" and "public" (just accept for now)

    @Override

    public void init(){

        test();    // <---------------- Uncomment to TEST!

        // %-distribution of RED, BLUE and NONE

        int nLocations = 900;

        Actor[] arr = generateDistribution(nLocations,0.25,0.25);

        arr = shuffle(arr);

        //out.print(Arrays.toString(arr));

        Actor[][] world = ArraytoMatrix(arr);

        //out.print(Arrays.toString(world[0]));

        plotMatrix(world);



        //double[] dist = {0.25, 0.25, 0.50};

        // Number of locations (places) in world (square)

        // TODO find methods that does the job

        // ...

        // world =           // Finally set world variable

    }



    // Check if inside world

    boolean isValidLocation(int size, int row, int col) {
        if (row < 0 || col < 0 || row > (size - 1) || col > (size - 1)) {
            return false;
        }else{
            return true;
        }
    }


    // ----------- Utility methods -----------------

    Actor [] generateDistribution (int elements, double red, double blue){

        Actor [] arr = new Actor[elements];

        int numberofRed = (int)Math.round(red*elements);

        int numberofBlue = (int)Math.round(blue*elements);

        int numberofNone = (int)Math.round((1-red-blue)*elements);

        for (int i=0; i<elements;i++){

            if (i<numberofRed){

                arr[i]=Actor.RED;

            }else if (i < (numberofRed + numberofBlue)){

                arr[i]=Actor.BLUE;

            }else{

                arr[i]=Actor.NONE;

            }

        }return arr;

    }

    Actor[]shuffle(Actor[] arr){

        for(int i=0; i < arr.length;i++){

            int slapdash = rand.nextInt(arr.length);

            arr[i] = arr[slapdash];

        }return arr;

    }

    Actor[][]ArraytoMatrix(Actor[] array){

        //Actor[] arr = array;

        int size = (int)sqrt(array.length);

        int arrayIndex=0;

        Actor [][] toReturn = new Actor[size][size];

        for ( int row =0; row < size; row++){

            for (int col = 0; col < size; col++){

                toReturn[row][col]=array[arrayIndex];

                arrayIndex++;

            }

        }  return toReturn;

    }

    void plotMatrix(Actor[][] world){
        for ( int row = 0; row < world.length;row++){

            out.println(Arrays.toString(world[row]));
        }
    }
    void plotMatrix(State[][] states){
        for (int row = 0; row < states.length; row++){
            out.println(Arrays.toString(states[row]));
        }



    }

    int numberofNeighbours (Actor [][] world,int row, int col) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (!(r == row && c == col) && isValidLocation(world.length, r, c) && (world[r][c] == Actor.BLUE || world[r][c] == Actor.RED)) {
                    count++;
                }
            }
        }
        return count;
    }
    int sameColour (Actor[][] world, int row, int col){
        int sameColourCount = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (!(r == row && c == col) && isValidLocation(world.length, r, c) && (world[row][col] == world [r][c])){//Actor.BLUE || world[r][c] == Actor.RED)) {
                    sameColourCount++;
                }
            }
        }
        return sameColourCount;
    }
    State[][] CheckSatifaction(Actor[][] world, double threshold) {
        int size = world.length;
        State[][] actorStates = new State[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (world[row][col] == Actor.NONE) {
                    actorStates[row][col] = State.NA;
                } else if (world[row][col] == Actor.RED || world[row][col] == Actor.BLUE) {
                    double num = numberofNeighbours(world, row, col);
                    double color = sameColour(world, row, col);
                    if ((color / num) < threshold) {
                        actorStates[row][col] = State.UNSATISFIED;
                    } else if ((color / num) >= threshold) {
                        actorStates[row][col] = State.SATISFIED;
                    }
                }


            }
        }return actorStates;
    }







    // ------- Testing -------------------------------------



    // Here you run your tests i.e. call your logic methods

    // to see that they really work

    void test(){

        // A small hard coded world for testing

        world = new Actor[][]{

                {Actor.RED, Actor.RED, Actor.NONE},

                {Actor.NONE, Actor.BLUE, Actor.NONE},

                {Actor.RED, Actor.NONE, Actor.BLUE}

        };
        int number = numberofNeighbours(world,1,1);
        out.println(number);
        double th = 0.5;   // Simple threshold used for testing
        int colorNeighbors = sameColour(world,1,1);
        out.println(colorNeighbors);
        State[][] actorStates = CheckSatifaction(world,th);
        plotMatrix(actorStates);
        // A first test!

        int s = world.length;

        out.println(isValidLocation(s, 0, 0));





        /* Move of unsatisfied hard to test because of random */



        exit(0);

    }



    // ---- NOTHING to do below this row, it's JavaFX stuff  ----



    final int width = 400;   // Size for window

    final int height = 400;

    long previousTime = nanoTime();

    final long INTERVAL = 450000000;



    @Override

    public void start(Stage primaryStage) throws Exception {



        // Build a scene graph

        Group root = new Group();

        Canvas canvas = new Canvas(width, height);

        root.getChildren().addAll(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();



        // Create a timer

        AnimationTimer timer = new AnimationTimer() {

            // This method called by FX, parameter is the current time

            public void handle(long currentNanoTime) {

                long elapsedNanos = currentNanoTime - previousTime;

                if (elapsedNanos > INTERVAL) {

                    updateWorld();

                    renderWorld(gc);

                    previousTime = currentNanoTime;

                }

            }

        };



        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Simulation");

        primaryStage.show();



        timer.start();  // Start simulation

    }





    // Render the state of the world to the screen

    public void renderWorld(GraphicsContext g) {

        g.clearRect(0,0, width, height);

        int size = world.length;

        for (int row = 0; row < size; row++) {

            for (int col = 0; col < size; col++) {

                int x = 10 * col + 50;

                int y = 10 * row + 50;



                if (world[row][col] == Actor.RED) {

                    g.setFill(Color.RED);

                } else if (world[row][col] == Actor.BLUE) {

                    g.setFill(Color.BLUE);

                } else {

                    g.setFill(Color.WHITE);

                }

                g.fillOval(x, y, 10, 10);

            }

        }

    }



    public static void main(String[] args) {

        launch(args);

    }



}