package Model;

import java.util.HashMap;

public interface IAlbumModel {
  /**
   * Build the class: move.
   * This method change the location of shape.
   */
  void move(String name, int x, int y);

  /**
   * Build the class: remove.
   * This method remove the shape from map.
   */
  void remove(String name);

  /**
   * Build the class: resize.
   * This method resize the shape.
   */
  void resize(String name, int widthOrXRadius, int heightOrYRadius);

  /**
   * Build the class: changeColor.
   * This method change the color of shape.
   */
  void changeColor(String name,int r, int g, int b);

  /**
   * Build the class: getMap.
   * This method get the map.
   */
  HashMap getMap();

  /**
   * Build the class: printShape.
   * This method print the string of each shape.
   */
  String printShape();

  /**
   * Build the class: snapShot.
   * This method print the string of each snapshot.
   * @param description the object of snapshot.
   */
  String snapShot(String description);

  /**
   * Build the class: printAllSnapshot.
   * This method print the string of all snapshots.
   */
  String printAllSnapshot();

  /**
   * Build the class: getShape.
   * This method get shape from map.
   * @param name the name of the shape.
   */
  IShape getShape(String name);


}
