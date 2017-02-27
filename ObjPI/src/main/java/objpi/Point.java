
package objpi;


public class Point {
    
   double x;
   double y;
   
   Point(double initX, double initY)  {
       x = initX;
       y = initY;       
   }
   
   
   double distFromOrigin() {
       return Math.sqrt(x * x + y * y);
   }   
   
   boolean isInOne() {
       return distFromOrigin() < 1;
   }
   
   @Override
   public String toString() {
       //return "I am the point: " + x + ",  " + y;
       return String.format("[%f,%f]", x,y);
       
   }
    
}
