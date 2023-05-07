package View;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.*;

import Model.IShape;
import Model.Rectangle;
import Model.Snapshot;

/**
 * Build the class: DrawingCanvas.
 */
public class DrawingCanvas  extends JPanel{
  private final String REST_SHAPE = "rectangle";
  private final String OVAL_SHAPE = "oval";
  private  Snapshot shapeList;

  /**
   * Build the class: DrawingCanvas.
   */
  public DrawingCanvas(Snapshot shapeList) {
    super();
    this.setOpaque(true);
    this.setBackground(Color.GRAY);
    this.shapeList = shapeList;
  }

  /**
   * Build the class: paintComponent.
   */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    LinkedHashMap<String,IShape> shape =  shapeList.getShapeList();
    for(IShape value:shape.values()){
      int x = value.getLocation().getX();
      int y = value.getLocation().getY();
      int widthOrXRadius = value.getWidthOrXRadius();
      int heightOrYRadius = value.getHeightOrYRadius();
      int R = value.getColor().getR();
      int G = value.getColor().getG();
      int B = value.getColor().getB();
      Color myColor = new Color(R,G,B);

      if (value.getType().equals(REST_SHAPE)) {

        g2d.setColor(myColor);

        g2d.drawRect(x, y, widthOrXRadius, heightOrYRadius);
        g2d.fillRect(x, y, widthOrXRadius, heightOrYRadius);
        System.out.println(widthOrXRadius);
      } else if (value.getType().equals(OVAL_SHAPE)) {

        g2d.setColor(myColor);
        g2d.drawOval(x, y, widthOrXRadius, heightOrYRadius);
        g2d.fillOval(x, y, widthOrXRadius, heightOrYRadius);
      }
    }
  }




}
