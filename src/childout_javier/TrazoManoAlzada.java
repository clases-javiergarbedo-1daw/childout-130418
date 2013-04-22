package childout_javier;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class TrazoManoAlzada {
    
    private ArrayList<Point> listPoints;
    
    public TrazoManoAlzada(int x, int y) {
        listPoints = new ArrayList();
        listPoints.add(new Point(x,y));
    }
    
    public void addPoint(int x, int y) {
        listPoints.add(new Point(x,y));
    }
    
    public void draw(Graphics g) {
        if(listPoints.size()>1) {
            for(int i=1; i<listPoints.size(); i++) {
                g.drawLine(listPoints.get(i-1).x, listPoints.get(i-1).y, 
                        listPoints.get(i).x, listPoints.get(i).y);
            }
        } else {
            //Dibuja un único punto
            g.drawLine(listPoints.get(0).x, listPoints.get(0).y, 
                    listPoints.get(0).x, listPoints.get(0).y);
        }
    }
    
    public Point getTopLeftCorner() {
        int minX=0, minY=0;
        if(listPoints.size()>0) {
            minX = listPoints.get(0).x;
            for(Point p:listPoints) {
                if(p.x < minX) {
                    minX = p.x;
                }
            }
            
            minY = listPoints.get(0).y;
            for(Point p:listPoints) {
                if(p.y < minY) {
                    minY = p.y;
                }
            }
        }
        return new Point(minX, minY);
    }

    public Point getBottomRightCorner() {
        int maxX=0, maxY=0;
        if(listPoints.size()>0) {
            maxX = listPoints.get(0).x;
            for(Point p:listPoints) {
                if(p.x > maxX) {
                    maxX = p.x;
                }
            }

            maxY = listPoints.get(0).y;
            for(Point p:listPoints) {
                if(p.y > maxY) {
                    maxY = p.y;
                }
            }
        }        
        return new Point(maxX, maxY);
    }

    public void mover(int incX, int incY) {
        if(listPoints.size()>0) {
            for(int i=0; i<listPoints.size(); i++) {
                Point p = listPoints.get(i);
                p.move(p.x+incX, p.y+incY);
                listPoints.set(i, p);
            }
        }
    }
}
