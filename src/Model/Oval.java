package Model;

import java.util.Objects;
/**
 * Build the class: Model.Oval.
 */
public class Oval extends abstractShape implements IShape{
  public Oval(String id,Location location, Color color, int WidthOrXRadius, int HeightOrYRadius) {
    super(id,location, color, WidthOrXRadius, HeightOrYRadius);
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
   * @param WidthOrXRadius size of the shape.
   * @param HeightOrYRadius size of the shape.
   */
  @Override
  public void setSize(int WidthOrXRadius, int HeightOrYRadius) {
    super.setSize(WidthOrXRadius, HeightOrYRadius);
  }

  /**
   * Build the class: getType.
   */
  @Override
  public String getType() {
    return "oval";
  }

  /**
   * Build the class: getWidthOrXRadius.
   */
  @Override
  public int getWidthOrXRadius() {
    return this.widthOrXRadius;
  }

  /**
   * Build the class: getHeightOrYRadius.
   */
  @Override
  public int getHeightOrYRadius() {
    return this.heightOrYRadius;
  }

  /**
   * Build the class: copy.
   */
  @Override
  public IShape copy() {
    Oval o = new Oval(this.getId(),this.getLocation(),this.getColor(),this.widthOrXRadius,this.heightOrYRadius);
    return o;
  }

  /**
   * Build the class: getId.
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * Build the class: toString.
   */
  @Override
  public String toString() {
    return "Name: "+id+"\n"
            +"Type: oval\n"
            +"Min corner: "+this.location.toString()+", X radius: "+this.widthOrXRadius+","+"\n"
            +" Y radius: "+this.heightOrYRadius+", "+"Model.Color: "+color.toString()+"\n";
  }

  /**
   * Override the class: equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Oval that = (Oval) o;
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
