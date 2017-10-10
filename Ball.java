package pong.model;
import java.util.Random;
/**
 * A Ball for the Pong game
 *
 * A model class
 */
public class Ball {

    private final double radius;
    private double x;     // Upper left corner in enclosing square
    private double y;
    private double dx;    // Speed
    private double dy;    // Speed
    private final Random rand = new Random();
    public Ball(double x, double y, double radius, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
    }
    // TODO Methods
    public void moveBall(){
        x = x + dx;
        y = y + dy;
    }
    public void bounceY(){
        dy=-dy;
    }
    public void bounceX(){
        dx=-dx;
    }
    public void resetBall(){
        int[] dirs = {1, 2, 3 - 1, -2, -3};
        int dx = dirs[rand.nextInt(dirs.length)];
        int dy = dirs[rand.nextInt(dirs.length)];
        this.dx=dx;
        this.dy=dy;
        x = Pong.WIDTH/2;
        y = Pong.HEIGHT/2;
    }

    // Utilities
    public double getMinX() {
        return x;
    }

    public double getMaxX() {
        return x + 2 * radius;
    }

    public double getMinY() {
        return y;
    }

    public double getMaxY() {
        return y + 2 * radius;
    }

    public double getRadius() {
        return radius;
    }
}
