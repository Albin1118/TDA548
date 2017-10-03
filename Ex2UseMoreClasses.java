package exercises;

import static java.lang.System.*;
import static java.lang.Math.*;

/*
 *  More classes and classes (objects) connected
 *
 *  See
 *  - MoreClasses
 */
public class Ex2UseMoreClasses {

    public static void main(String[] args) {
        new Ex2UseMoreClasses().program();
    }

    void program() {

        // All true
        Point p = new Point(1, 2, 3);
        out.println(p.one==1 && p.two==2 &&p.three==3);
        out.println(p.distance(new Point(p)) == 0);
        out.println(new Point(0, 0, 0).distance(new Point(1, 0, 0)) == 1);

        // Triangle uses Points!
        /*Triangle t = new Triangle(new Point(0, 0, 0), new Point(0, 1, 0), new Point(1, 0, 0));
        out.println(abs(t.area() - 0.5) < 0.000001);
        */
    }

    // ---------- Write your classes below this line ----------------------------

    // A class for points in 3D

    public class Point{
        int one;
        int two;
        int three;

        Point(int first, int second, int third){
            one=first;
            two=second;
            three=third;
        }
        Point(Point p){
            one=p.one;
            two=p.two;
            three=p.three;
        }
        public int distance(Point other){
            double x_sub =((other.one - this.one));
            int distance_x = (int)Math.pow(x_sub, 2);
            double y_sub = (other.two - this.two);
            int distance_y =(int)Math.pow(y_sub, 2);
            double z_sub = (other.three - this.three);
            int distance_z = (int)Math.pow(z_sub, 2);
            int result = (int)Math.round(Math.sqrt(distance_x + distance_y + distance_z));
            return result;
        }

    }

    // A class for a Triangle in 3D

    public class Triangle{
        Point point1;
        Point point2;
        Point point3;

        Triangle(Point p1, Point p2, Point p3){
            point1.one = p1.one;
            point1.two = p1.two;
            point1.three = p1.three;

            point2.one = p2.one;
            point2.two = p2.two;
            point2.three = p2.three;

            point3.one = p3.one;
            point3.two = p3.two;
            point3.three = p3.three;

        }





    }


}
