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
        out.println(p.x==1 && p.y==2 && p.z==3);
        Point p2 = new Point(1, 2, 2);
        out.println(p.distance(p2)==1);
        out.println(p.distance(new Point(p)) == 0);
        out.println(new Point(0, 0, 0).distance(new Point(1, 0, 0)) == 1);

        // Triangle uses Points!

        Triangle t = new Triangle(new Point(0, 0, 0), new Point(0, 1, 0), new Point(1, 0, 0));
        out.println(t.pointA.x==0 && t.pointB.y==1 && t.pointC.z==0);
        out.println(abs(t.area() - 0.5) < 0.000001);
        //*/
    }

    // ---------- Write your classes below this line ----------------------------

    // A class for points in 3D

    public class Point{
        int x;
        int y;
        int z;

        Point(int first, int second, int third){
            x=first;
            y=second;
            z=third;
        }
        Point(Point p){
            x=p.x;
            y=p.y;
            z=p.z;
        }
        public double distance(Point other){
            double x_sub =((other.x - this.x));
            int distance_x = (int)Math.pow(x_sub, 2);
            double y_sub = (other.y - this.y);
            int distance_y =(int)Math.pow(y_sub, 2);
            double z_sub = (other.z - this.z);
            int distance_z = (int)Math.pow(z_sub, 2);
            double result = Math.sqrt(distance_x + distance_y + distance_z);
            return result;
        }

    }

    // A class for a Triangle in 3D

    public class Triangle{
        Point pointA;
        Point pointB;
        Point pointC;

        Triangle(Point p1, Point p2, Point p3){
            pointA = p1;
            pointB = p2;
            pointC = p3;
        }
        public double area(){

            double distanceA = pointA.distance(pointB);
            double distanceB = pointB.distance(pointC);
            double distanceC = pointC.distance(pointA);
            int div = 2;
            double semiperimeter = ((double)(distanceA +distanceB + distanceC)/div);

            double areaABC =Math.sqrt(semiperimeter * (semiperimeter - distanceA) * (semiperimeter - distanceB) * (semiperimeter - distanceC));

            return areaABC;
        }







    }


}
