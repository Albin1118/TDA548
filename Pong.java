package pong.model;


import pong.model.Ball;
import pong.model.Paddle;

import java.util.Random;

import static pong.model.Paddle.Direction.DOWN;
import static pong.model.Paddle.Direction.STOP;
import static pong.model.Paddle.Direction.UP;


/**
 * Logic for the Pong Game
 * Model class representing the "whole" game
 *
 * Nothing visual here
 *
 * See:
 * - week6/samples/catchtherain
 */
public class Pong {

    // Global constants
    public static final int WIDTH = 600;     // Size of window
    public static final int HEIGHT = 400;
    public static final double PADDLE_WIDTH = 10;
    public static final double PADDLE_HEIGHT = 60;
    public static final double BALL_DIAM = 40;
    private static final Random rand = new Random();
    private static final int SPEED = 2;

    private final Paddle lPaddle;
    private final Paddle rPaddle;

    private int pointsLeft;
    private int pointsRight;
    private Ball ball;

    public Pong(Paddle lPaddle, Paddle rPaddle) {
        this.lPaddle = lPaddle;
        this.rPaddle = rPaddle;
    }

    // --------  Game Logic -------------

    // The logic (the game loop)
    public void update() {
        // TODO (As usual: Functional decomposition)
        lPaddle.move(HEIGHT);
        rPaddle.move(HEIGHT);
        ball.moveBall();
        if (ballHitY()){
            ball.bounceY();
        }
        if(ballHitX()){
            ball.resetBall();
        }
        if(intersectLeft()){
            ball.bounceX();
            pointsLeft++;
            ball.speedIncrease();
        }if(intersectRight()){
            ball.bounceX();
            pointsRight++;
            ball.speedIncrease();
        }

    }

    // ----- Utility --------------

    public boolean intersectLeft() {
        if (ball.getSpeedX() > 0){
            return false;
        }
        if (lPaddle.getMaxX() < ball.getMinX()) {
            return false;
        } else if (lPaddle.getMinX() > ball.getMaxX()) {
            return false;
        } else if (lPaddle.getMinY() > ball.getMaxY()) {
            return false;
        } else if (lPaddle.getMaxY() < ball.getMinY()) {
            return false;
        } else {
            return true;
        }
    }
    public boolean intersectRight(){
        if(ball.getSpeedX() < 0){
            return false;
        }
        if (rPaddle.getMaxX() < ball.getMinX()){
            return false;
        }else if (rPaddle.getMinX() > ball.getMaxX()){
            return false;
        }else if(rPaddle.getMinY() > ball.getMaxY()){
            return false;
        }else if(rPaddle.getMaxY() < ball.getMinY()){
            return false;
        }else{
            return true;
        }
    }
    public void newBall(double x, double y, double radius) {
       // ball = new Ball(x, y, radius, 0, 0);

        int[] dirs = {1, 2, 3 - 1, -2, -3};
        int dx = dirs[rand.nextInt(dirs.length)];
        int dy = dirs[rand.nextInt(dirs.length)];
        ball = new Ball(x, y, radius, dx, dy);   // TIP: For debug use dy = 0

    }

    // --- Used by GUI (rendering) ------------------------

    public Ball getBall() {
        return ball;
    }

    public Paddle getLeftPaddle() {
        return lPaddle;
    }

    public Paddle getRightPaddle() {
        return rPaddle;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }

    public int getPointsRight() {
        return pointsRight;
    }

    public boolean ballHitY() {
        return ball.getMinY() < 0 || HEIGHT < ball.getMaxY();
    }

    public boolean ballHitX(){
        return ball.getMaxX() < -75 || WIDTH + 75 < ball.getMinX();
    }




}
