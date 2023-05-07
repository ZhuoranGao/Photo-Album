package Model;

import java.util.Objects;
/**
 * Build the class: Model.Location.
 */
public class Location {
  private int x, y;

  /**
   * Build the class: Model.Location.
   */
  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Build the class: getX.
   */
  public int getX(){
    return this.x;
  }

  /**
   * Build the class: locationChange.
   * @param x x of the location of the shape.
   * @param y y of the location of the shape.
   */
  public void locationChange(int x, int y){
    this.x = x;
    this.y = y;
  }

  /**
   * Build the class: getY.
   */
  public int getY(){
    return this.y;
  }

  /**
   * Build the class: toString.
   */
  @Override
  public String toString() {
    return "("+this.x+","+this.y+")";
  }

  /**
   * Build the class: equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Location location = (Location) o;
    return x == location.x && y == location.y;
  }

  /**
   * Build the class: hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}


