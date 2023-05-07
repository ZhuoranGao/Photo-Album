package Model;

import java.util.Objects;
/**
 * Build the class: Model.Rectangle.
 */
public class Rectangle extends abstractShape implements IShape {

  /**
   * Build the class: Model.Rectangle.
   */
  public Rectangle(String id,Location location, Color color, int widthOrXRadius, int heightOrYRadius) {
    super(id,location, color, widthOrXRadius, heightOrYRadius);
  }

  /**
   * Build the class: getLocation.
   */
  @Override
  public Location getLocation() {
    return super.getLocation();
  }

  /**
   * Build the class: getColor.
   */
  @Override
  public Color getColor() {
    return super.getColor();
  }

  /**
   * Build the class: setSize.
   */
  @Override
  public void setSize(int widthOrXRadius, int heightOrYRadius) {
    super.setSize(widthOrXRadius, heightOrYRadius);
  }

  /**
   * Build the class: toString.
   */
  @Override
  public String toString() {
    return "Name: "+id+"\n"
            +"Type: rectangle\n"
            +"Min corner: "+this.location.toString()+", Width: "+this.widthOrXRadius+","+"\n"
            +"Height: "+this.heightOrYRadius+", "+"Model.Color: "+color.toString()+"\n";
  }

  /**
   * Build the class: getType.
   */
  @Override
  public String getType(){
    return "rectangle";
  }

  /**
   * Build the class: copy.
   */
  @Override
  public IShape copy() {
    Rectangle r = new Rectangle(this.getId(),this.getLocation(),this.getColor(),this.widthOrXRadius,this.heightOrYRadius);
    return r;
  }

  /**
   * Build the class: getHeightOrYRadius.
   */
  @Override
  public int getHeightOrYRadius() {
    return this.heightOrYRadius;
  }

  /**
   * Build the class: getId.
   */
  @Override
  public String getId() {
    return this.id;
  }

  /**
   * Build the class: getWidthOrXRadius.
   */
  @Override
  public int getWidthOrXRadius() {
    return this.widthOrXRadius;
  }

  /**
   * Override the class: equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Rectangle that = (Rectangle) o;
    return Objects.equals(location, that.location) && Objects.equals(color, that.color)
            && widthOrXRadius == that.widthOrXRadius && heightOrYRadius == that.heightOrYRadius;
  }

  /**
   * Override the class: hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(location, color, widthOrXRadius, heightOrYRadius);
  }
}


