package pong.model;

/**
 * A Paddle for the Pong game
 *
 * A model class
 *
 */
public class Paddle {

    public enum Direction {
        STOP,
        UP,
        DOWN;
    }

    private final double width;
    private final double height;
    private double x;          // Upper left corner in enclosing square
    private double y;
    private double dy;         // Speed

    public Paddle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dy=0;
    }

    // TODO methods
    public void movePaddle(Direction d){
    switch (d){
        case UP:
            dy =  - 2.0;
            break;
        case DOWN:
            dy = + 2.0;
            break;
        case STOP:
            dy = 0;
            break;
    }
    }
    public void move(double windowHeight){
        if (getMinY() < 0){
            y = 0;
        }else if(getMaxY() > windowHeight){
            y = windowHeight - height;
        }else{
            y= y + dy;
        }

    }

    // Utilities
    public double getMinX() {
        return x;
    }

    public double getMaxX() {
        return x + width;
    }

    public double getMinY() {
        return y;
    }

    public double getMaxY() {
        return y + height;
    }

}
