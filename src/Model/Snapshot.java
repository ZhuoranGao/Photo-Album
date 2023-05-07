package Model;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
/**
 * Build the class: Model.Snapshot.
 * This class store the information of snapshot.
 */
public class Snapshot {

  private String id;
  private String time;
  private String description;
  private LinkedHashMap<String,IShape> shapeIdList;

  public String getTime() {
    return time;
  }

  /**
   * Build the class: Model.Snapshot.
   * The "timesOfSnapShot" represent the rank of each snapshot.
   */
  public Snapshot(String description) {
    this.shapeIdList = new LinkedHashMap<>();
    this.description = description;
    this.time = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(LocalDateTime.now());
    this.id =LocalDateTime.now().toString()+String.valueOf(AlbumModel.sizeForId);
  }

  /**
   * Build the class: getId.
   * Get the id of the snapshot.
   * @return the id of the snapshot.
   */
  public String getId() {
    return id;
  }

  /**
   * Build the class: getDescription.
   * Get the description of the snapshot.
   * @return the description of the snapshot.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Build the class: addShape.
   * Add shape created in the list of snapshot object.
   * @param id id of the shape.
   * @param shape shape object.
   */
  public void addShape(String id, IShape shape){
    shapeIdList.put(id,shape);
  }


  /**
   * Build the class: toString.
   */
  public String toString(){
    return "\n\nModel.Snapshot ID: "+this.id+"\n"+"Timestamp: "+this.time+"\n"
            +"Description: "+this.description+"\n"+"Shape Information:\n";
  }

  /**
   * Build the class: getShapeList.
   */
  public LinkedHashMap<String,IShape> getShapeList() {
    return shapeIdList;
  }

  /**
   * Build the class: setId.
   */
  public void setId(String id) {
    this.id = id;
  }
}
