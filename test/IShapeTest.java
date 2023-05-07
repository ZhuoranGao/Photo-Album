import org.junit.Before;
import org.junit.Test;

import Model.Color;
import Model.IShape;
import Model.Location;
import Model.Oval;
import Model.Rectangle;

import static org.junit.Assert.*;
/**
 * Build the class: IShapeTest.
 */
public class IShapeTest {
  private IShape r;
  private IShape o;
  private Location location;
  private Color color;
  private Location location1;
  private Color color1;

  /**
   * Build the class: IShapeTest.
   */
  @Before
  public void setUp() throws Exception {
    location = new Location(1,1);
    color = new Color(1, 1, 1);
    location1 = new Location(15,15);
    color1 = new Color(12, 12, 12);
    r = new Rectangle("r",location,color,10,10);
    o = new Oval("o",location1,color1,11,11);
  }

  /**
   * Build the class: getLocation.
   */
  @Test
  public void getLocation() {
    assertEquals("(1,1)",r.getLocation().toString());
    assertEquals("(15,15)",o.getLocation().toString());
  }

  /**
   * Build the class: getColor.
   */
  @Test
  public void getColor() {
    assertEquals("(1,1,1)",r.getColor().toString());
    assertEquals("(12,12,12)",o.getColor().toString());
  }

  /**
   * Build the class: setSize.
   */
  @Test
  public void setSize() {
    r.setSize(10,10);
    assertEquals("Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (1,1), Width: 10,\n" +
            "Height: 10, Model.Color: (1,1,1)\n",r.toString());
    r.setSize(11,11);
    assertEquals("Name: O\n" +
            "Type: oval\n" +
            "Min corner: (15,15), X radius: 11,\n" +
            " Y radius: 11, Model.Color: (12,12,12)\n",o.toString());
  }
}