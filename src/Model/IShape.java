package Model;

public interface IShape {
  /**
   * Build the class: getLocation.
   */
  Location getLocation();

  /**
   * Build the class: getColor.
   */
  Color getColor();

  /**
   * Build the class: setSize.
   * @param WidthOrXRadius size of the shape.
   * @param HeightOrYRadius size of the shape.
   */
  void setSize(int WidthOrXRadius, int HeightOrYRadius);

  /**
   * Build the class: getType.
   */
  String getType();

  /**
   * Build the class: getWidthOrXRadius.
   */
  int getWidthOrXRadius();

  /**
   * Build the class: getHeightOrYRadius.
   */
  int getHeightOrYRadius();

  /**
   * Build the class: getId.
   */
  String getId();

  /**
   * Build the class: copy.
   */
  IShape copy();
}
