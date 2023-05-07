import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import Model.AlbumModel;
import Model.Color;
import Model.IShape;
import Model.Location;
import Model.Oval;
import Model.Rectangle;
import Model.Snapshot;

import static org.junit.Assert.*;
/**
 * Build the class: AlbumModelTest.
 */
public class AlbumModelTest {
  private Location locationR;
  private Color colorR;
  private Location locationO;
  private Color colorO;
  private Rectangle rectangle;
  private Oval oval;
  private AlbumModel albumModel;
  private Snapshot snapshot;

  /**
   * Build the class: AlbumModelTest.
   */
  @Before
  public void setUp() throws Exception {
    locationR = new Location(1, 1);
    colorR = new Color(1,1,1);
    rectangle = new Rectangle("r",locationR, colorR, 10,10);

    locationO = new Location(1, 1);
    colorO = new Color(1,1,1);
    oval = new Oval("o",locationR, colorR, 5,5);
    snapshot = new Snapshot("Selfie after removing the rectangle from the picture");
    albumModel = new AlbumModel();
    albumModel.createShape("r","rectangle",
            1,1,10,10,
            1,1,1 );
    albumModel.createShape("o","oval",
            1,1,5,5,
            1,1,1 );
  }

  /**
   * Build the class: testCreateShape.
   */
  @Test
  public void testCreateShape() {
    IShape r = albumModel.createShape("r","rectangle",
            1,1,10,10,
            1,1,1 );
    assertEquals(rectangle, r);
  }

  /**
   * Build the class: move.
   */
  @Test
  public void move() {
    Location location = new Location(2,2);
    albumModel.move("r",2,2);
    assertEquals(location,albumModel.getShape("r").getLocation());
  }

  /**
   * Build the class: remove.
   */
  @Test
  public void remove() {
    albumModel.remove("r");
    assertEquals("Name: O\n" +
            "Type: oval\n" +
            "Min corner: (1,1), X radius: 5,\n" +
            " Y radius: 5, Model.Color: (1,1,1)\n",albumModel.printShape());
  }

  /**
   * Build the class: resize.
   */
  @Test
  public void resize() {
    albumModel.resize("o",20, 20);

    Oval oval = new Oval("o",locationO,colorO,20,20);
    assertEquals(oval,albumModel.getShape("o"));
  }

  /**
   * Build the class: changeColor.
   */
  @Test
  public void changeColor() {
    albumModel.changeColor("o",2,2,2);
    Color c = new Color(2,2,2);
    assertEquals(c, albumModel.getShape("o").getColor());
  }

  /**
   * Build the class: getMap.
   */
  @Test
  public void getMap() {
    HashMap<String, IShape> hashMap = new HashMap<>();
    hashMap.put("r", rectangle);
    hashMap.put("o", oval);
    assertEquals(hashMap, albumModel.getMap());
  }

  /**
   * Build the class: printShape.
   */
  @Test
  public void printShape() {
    assertEquals("Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (1,1), Width: 10,\n" +
            "Height: 10, Model.Color: (1,1,1)\n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Min corner: (1,1), X radius: 5,\n" +
            " Y radius: 5, Model.Color: (1,1,1)\n",albumModel.printShape());
  }

  /**
   * Build the class: snapShot.
   */
  @Test
  public void snapShot(){

    assertEquals("\n" +
            "Model.Snapshot ID: " +snapshot.getId()+"\n"+
            "Timestamp: " +snapshot.getTime()+"\n"+
            "Description: Selfie after removing the rectangle from the picture\n" +
            "Shape Information:\n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (1,1), Width: 10,\n" +
            "Height: 10, Model.Color: (1,1,1)\n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Min corner: (1,1), X radius: 5,\n" +
            " Y radius: 5, Model.Color: (1,1,1)\n",albumModel.snapShot(snapshot.getDescription()));
  }

  /**
   * Build the class: printAllSnapshot.
   */
  @Test
  public void printAllSnapshot(){
    albumModel.snapShot(snapshot.getDescription());
    albumModel.remove("o");
    albumModel.move("r",100,100);
    Snapshot snapshot1 = new Snapshot("After remove");
    albumModel.snapShot(snapshot1.getDescription());
    Snapshot snapshot2 = new Snapshot("Model.Snapshot again");
    albumModel.snapShot(snapshot2.getDescription());
    albumModel.createShape("o1111","Oval",111,222,
            10,10,11,12,18);
    Snapshot snapshot3 = new Snapshot("Model.Sn");
    albumModel.snapShot(snapshot3.getDescription());

    assertEquals(albumModel.printAllSnapshot(),"Printing Snapshots\n" +
            "Model.Snapshot ID: " +snapshot.getId()+"\n"+
            "Timestamp: " +snapshot.getTime()+"\n"+
            "Description: Selfie after removing the rectangle from the picture\n" +
            "Shape Information:\n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (1,1), Width: 10,\n" +
            "Height: 10, Model.Color: (1,1,1)\n" +
            "Name: O\n" +
            "Type: oval\n" +
            "Min corner: (1,1), X radius: 5,\n" +
            " Y radius: 5, Model.Color: (1,1,1)\n" +
            "\n" +
            "Model.Snapshot ID: " +snapshot1.getId()+"\n"+
            "Timestamp: " +snapshot1.getTime()+"\n"+
            "Description: After remove\n" +
            "Shape Information:\n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (100,100), Width: 10,\n" +
            "Height: 10, Model.Color: (1,1,1)\n" +
            "\n" +
            "Model.Snapshot ID: " +snapshot2.getId()+"\n"+
            "Timestamp: " +snapshot2.getTime()+"\n"+
            "Description: Model.Snapshot again\n" +
            "Shape Information:\n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (100,100), Width: 10,\n" +
            "Height: 10, Model.Color: (1,1,1)\n");
  }
}