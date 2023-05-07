package Model;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Build the class: Model.AlbumModel.
 */
public class AlbumModel implements IAlbumModel {
  static int sizeForId = 0;
  private LinkedHashMap<String,Snapshot> snapshots;
  private LinkedHashMap<String, IShape> map;
  private List<String> snapShotHistory;
  private List<List<String>> shapeList;
  private List<String> snapShotId;

  /**
   * Build the class: Model.AlbumModel.
   * Store id in the snapshots
   * Store ID and shape in map.
   * Store the string of snapshot in snapShotHistory.
   */
  public AlbumModel(){
    this.snapshots = new LinkedHashMap<>();
    this.map = new LinkedHashMap<>();
    this.snapShotHistory = new ArrayList<>();
    this.shapeList = new ArrayList<>();
    this.snapShotId = new ArrayList<>();
  }

  /**
   * Build the method: createShape.
   * This method create instance of shape and
   * add the shape in to map.
   * @param ID ID of shape.
   * @param Type shape in album.
   * @param x x of the location of the shape.
   * @param y y of the location of the shape.
   * @param widthOrXRadius size of the shape.
   * @param heightOrYRadius size of the shape.
   * @param colorR r of the color.
   * @param colorG g of the color.
   * @param colorB b of the color.
   * @return the instance of the shape.
   */
  public IShape createShape(String ID, String Type, int x, int y,
                            int widthOrXRadius, int heightOrYRadius,
                            int colorR, int colorG, int colorB){
    if(Type.equalsIgnoreCase("rectangle")){
      Location locationR = new Location(x,y);
      Color colorRe = new Color(colorR,colorG,colorB);
      Rectangle rectangle = new Rectangle(ID,locationR, colorRe, widthOrXRadius,
              heightOrYRadius);
      map.put(ID, rectangle);
      return rectangle;
    }else if(Type.equalsIgnoreCase("oval")){
      Location locationO = new Location(x,y);
      Color colorO = new Color(colorR,colorG,colorB);
      Oval oval = new Oval(ID,locationO, colorO, widthOrXRadius, heightOrYRadius);
      map.put(ID, oval);
      return oval;
    }
    return null;
  }

  /**
   * This method move shape to location(x, y).
   * @param x the location that move to.
   * @param y the location that move to.
   * @return Model.Location.
   */
  public void move(String ID, int x, int y){
    map.get(ID).getLocation().locationChange(x, y);
  }

  /**
   * Build the method: remove.
   * This method remove the shape from map.
   * @param ID the ID of the shape.
   */
  public void remove(String ID){
    map.remove(ID);
  }

  /**
   * Build the method: resize.
   * This method resize the shape from map.
   * @param ID ID of shape.
   * @param widthOrXRadius size of the shape.
   * @param heightOrYRadius size of the shape.
   */
  public void resize(String ID, int widthOrXRadius, int heightOrYRadius){
    map.get(ID).setSize(widthOrXRadius, heightOrYRadius);
  }

  /**
   * Build the method: changeColor.
   * This method change the color of the shape from map.
   * @param ID ID of shape.
   * @param r r of the color.
   * @param g g of the color.
   * @param b b of the color.
   */
  public void changeColor(String ID,int r, int g, int b){
    map.get(ID).getColor().colorChange(r,g,b);
  }

  /**
   * Build the class: getMap.
   * @return the map of shape.
   */
  public HashMap getMap(){
    return this.map;
  }

  /**
   * Build the class: printShape.
   * This method print the string of each shape.
   * @return string.
   */
  public String printShape(){
    String s = "";
    for(Object value: map.values()){
       s = s+value.toString();
    }
    return s;
  }

  /**
   * Build the class: snapShot.
   * This method print the string of each snapshot.
   * @param description the object of snapshot.
   * @return string.
   */
  public String snapShot(String description){
    Snapshot snapshot = new Snapshot(description);

    snapShotId.add(snapshot.getId());
    sizeForId = snapShotId.size();
    System.out.println(snapshot.getId());
    String s = snapshot.toString();
    for(IShape value: map.values()){
      s = s+value.toString();
      snapshot.addShape(value.getId(),value.copy());
    }
    snapshots.put(snapshot.getId(),snapshot);
    snapShotHistory.add(s);
    return s;
  }

  /**
   * Build the class: printAllSnapshot.
   * This method print the string of all snapshots.
   * @return string.
   */
  public String printAllSnapshot(){
    String s = "Printing Snapshots";
    for(String value: snapShotHistory){
       s = s + value;
    }
    System.out.println(s);
    return s;
  }

  /**
   * Build the class: getShape.
   * This method get shape from map.
   * @param ID the ID of the shape.
   * @return the shape.
   */
  public IShape getShape(String ID){
    return this.map.get(ID);
  }

  /**
   * Build the method: getSnapShotId.
   * This method get the SnapShotId in model.
   */
  public List<String> getSnapShotId() {
    return snapShotId;
  }

  /**
   * Build the method: getSnapShotId.
   * This method get the snapshots in model.
   */
  public LinkedHashMap<String, Snapshot> getSnapshots() {
    return snapshots;
  }
}
