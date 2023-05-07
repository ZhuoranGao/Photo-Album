package Model;

/**
 * Build the class: Model.abstractShape.
 */
public abstract class abstractShape implements IShape{
  protected String id;
  protected Location location;
  protected Color color;
  protected int widthOrXRadius;
  protected int heightOrYRadius;

  /**
   * Build the class: Model.abstractShape.
   * @param location the location of the shape.
   * @param color the color of the shape.
   * @param widthOrXRadius size of the shape.
   * @param heightOrYRadius size of the shape.
   */
  public abstractShape(String id,Location location, Color color, int widthOrXRadius, int heightOrYRadius) {
    this.id = id;

    Location location1 = new Location(location.getX(),location.getY());
    this.location = location1;
    Color color1 = new Color(color.getR(),color.getG(),color.getB());
    this.color = color1;
    this.widthOrXRadius = widthOrXRadius;
    this.heightOrYRadius = heightOrYRadius;
  }

  /**
   * Build the class: getLocation.
   * @return the location of shape.
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Build the class: getColor.
   * Return the color of the shape.
   */
  public Color getColor() {
    return color;
  }

  /**
   * Build the class: setSize.
   * Set the size of the shape.
   * @param widthOrXRadius size of the shape.
   * @param heightOrYRadius size of the shape.
   */
  @Override
  public void setSize(int widthOrXRadius, int heightOrYRadius) {
    this.heightOrYRadius = heightOrYRadius;
    this.widthOrXRadius = widthOrXRadius;
  }

  /**
   * Build the method: getType.
   * This method get the type of corresponding shape in model.
   */
  @Override
  public abstract String getType();

  /**
   * Build the method: copy.
   * This method get the copy of corresponding shape in model.
   */
  @Override
  public abstract IShape copy() ;

}
