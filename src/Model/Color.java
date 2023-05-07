package Model;

import java.util.Objects;

/**
 * Build the class: Model.Color.
 * This class store the color information for shape.
 */
public class Color {
  private int r, g, b;

  /**
   * Build the class: equals.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Color color = (Color) o;
    return r == color.r && g == color.g && b == color.b;
  }

  /**
   * Build the class: hashCode.
   */
  @Override
  public int hashCode() {
    return Objects.hash(r, g, b);
  }

  /**
   * Build the class: Model.Color.
   * @param r r of the color.
   * @param g g of the color.
   * @param b b of the color.
   */
  public Color(int r, int g, int b) {
    if(r<0||g<0||b<0||r>255|g>255|b>255){
      throw new IllegalArgumentException("Invalid input!");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Build the method: toString.
   */
  @Override
  public String toString() {
    return "("+this.r+","+this.g+","+this.b+")";
  }

  /**
   * Build the class: colorChange.
   * This method reset the color of shape.
   * @param r r of the color.
   * @param g g of the color.
   * @param b b of the color.
   */
  public void colorChange(int r, int g, int b){
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Build the class: getR.
   * This method get the r of the color.
   */
  public int getR() {
    return r;
  }

  /**
   * Build the class: getR.
   * This method get the g of the color.
   */
  public int getG() {
    return g;
  }

  /**
   * Build the class: getR.
   * This method get the b of the color.
   */
  public int getB() {
    return b;
  }
}
