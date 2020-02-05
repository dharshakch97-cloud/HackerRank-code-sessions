import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Solution {
    
    public static class Point implements Comparable<Point> 
    {
        double x , y;
        public Point(double a,double b) {
            x = a;
            y = b;
        }
        public int compareTo(Point o) {
            return Double.compare(x, o.x);
        }
    }
    
    public static class Line
    {
        double a,b,c;
        public Line(Point p1 , Point p2)
        {
            if (Math.abs(p1.x - p2.x) < 0) {
                a = 1.0;
                b = 0.0;
                c = -p1.x;
            } 
            else {
                a = -(double)(p1.y - p2.y) / (p1.x - p2.x);
                b = 1.0; 
                c = -(double)(a * p1.x) - p1.y;
            } 
        }
    }
    
    public static class Segment
    {
        Point a,b;
        Line l;
        double coef;
        public Segment(Point x,Point y,double c) {
            a = x;
            b = y;
            l = new Line(x,y);
            coef = c;
        }
        
        public boolean contains(double x) {
            return x < Math.max(a.x, b.x) && x > Math.min(a.x, b.x);
        }
    }
    
    static Segment[] arr;
    static Point[] points;
    static double sim(Point a,Point b) {
        double ans = 1;
        double mid = a.x + b.x;mid/=2.0;
        for(Segment s : arr)
            if(s.contains(mid))
                ans *= s.coef;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int t = sc.nextInt();
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        DecimalFormat f = new DecimalFormat("0.000");
        while(t-->0)
        {
            int n = sc.nextInt();
            if (n == 0) {
                int count = 1;
                if(!first)
                    sb.append("\n");
                first = false;
                sb.append(count + "\n");
                sb.append("-inf +inf 1.000");
                sb.append("\n");
                break;
            }
            arr = new Segment[n];
            int ind = 0;
            points = new Point[n<<1];
            for (int i = 0; i < n; i++) {
                Point x = new Point(sc.nextDouble(), sc.nextDouble());
                Point y = new Point(sc.nextDouble(), sc.nextDouble());
                double c = sc.nextDouble();
                arr[i] = new Segment(x, y, c);
                points[ind++] = x;
                points[ind++] = y;
            }
            Arrays.sort(points);
            if(!first)
                sb.append("\n");
            first = false;
            int count = 2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("-inf "+f.format(points[0].x)+" 1.000\n");
            for (int i = 1; i < points.length; i++,count++) 
                sb2.append(f.format(points[i-1].x) + " " + f.format(points[i].x) + " " + f.format(sim(points[i-1], points[i])) + "\n");
            
            sb2.append(f.format(points[points.length-1].x) + " +inf 1.000\n");
            sb.append(count+"\n" + sb2);
        }
        System.out.print(sb);
    }    
}
