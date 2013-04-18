package childout_javier;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class PanelRecogeFirma extends javax.swing.JPanel {

    private ArrayList<TrazoManoAlzada> listaTrazos = new ArrayList();
    TrazoManoAlzada trazoActual;
    
    public PanelRecogeFirma() {
        initComponents();
        this.setBackground(Color.WHITE);
                
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        URL pathToImageCursor = getClass().getClassLoader().getResource("img/pencil.gif");
        Image imageCursor = new ImageIcon(pathToImageCursor).getImage();
        Point hotSpot = new Point(0,0);
        Cursor cursor = toolkit.createCustomCursor(imageCursor, hotSpot, "Pencil");
        this.setCursor(cursor);
    }

    protected void limpiar() {
        listaTrazos.clear();
        trazoActual = null;
        repaint();
    }
    
    private Point getTopLeftCorner() {
        int marginLeft = 0;
        if(listaTrazos.size()>0) {
            marginLeft = listaTrazos.get(0).getTopLeftCorner().x;
            for(TrazoManoAlzada t:listaTrazos) {
                if(t.getTopLeftCorner().x < marginLeft) {
                    marginLeft = t.getTopLeftCorner().x;
                }
            }
        }    
        int marginTop = 0;
        if(listaTrazos.size()>0) {
            marginTop = listaTrazos.get(0).getTopLeftCorner().y;
            for(TrazoManoAlzada t:listaTrazos) {
                if(t.getTopLeftCorner().y < marginTop) {
                    marginTop = t.getTopLeftCorner().y;
                }
            }
        }           
        return new Point(marginLeft, marginTop);
    }    
    
    private Point getBottomRightCorner() {
        int maxRight = 0;
        if(listaTrazos.size()>0) {
            maxRight = listaTrazos.get(0).getBottomRightCorner().x;
            for(TrazoManoAlzada t:listaTrazos) {
                if(t.getBottomRightCorner().x > maxRight) {
                    maxRight = t.getBottomRightCorner().x;
                }
            }
        }    
        int maxBottom = 0;
        if(listaTrazos.size()>0) {
            maxBottom = listaTrazos.get(0).getBottomRightCorner().y;
            for(TrazoManoAlzada t:listaTrazos) {
                if(t.getBottomRightCorner().y > maxBottom) {
                    maxBottom = t.getBottomRightCorner().y;
                }
            }
        }           
        return new Point(maxRight, maxBottom);
    }  
    
    /**
     * 
     * @return Dimensión de la firma
     */
    protected Dimension moverFirmaOrigen() {
        Point topLeftCorner = getTopLeftCorner();
        int incX = 0 - topLeftCorner.x;
        int incY = 0 - topLeftCorner.y;
        if(listaTrazos.size()>0) {
            for(int i=0; i<listaTrazos.size(); i++) {
                TrazoManoAlzada t = listaTrazos.get(i);
                t.mover(incX, incY);
                listaTrazos.set(i, t);
            }
        }
        Point bottomRightCorner = getBottomRightCorner();
        Dimension dim = new Dimension(bottomRightCorner.x+1, bottomRightCorner.y+1);
        return dim;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(listaTrazos.size()>0) {
            for(TrazoManoAlzada t:listaTrazos) {
                t.draw(g);
            }
        }
        if(trazoActual!=null) {
            trazoActual.draw(g);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        trazoActual.addPoint(evt.getX(), evt.getY());
        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        trazoActual = new TrazoManoAlzada(evt.getX(), evt.getY());
        repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        listaTrazos.add(trazoActual);
        repaint();
    }//GEN-LAST:event_formMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
