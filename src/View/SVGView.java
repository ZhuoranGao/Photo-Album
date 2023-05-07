package View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import Model.IShape;
import Model.Snapshot;

import static Controller.reading_command.frameHeight;
import static Controller.reading_command.frameWidth;

/**
 * Build the class: SVGView.
 */
public class SVGView {
  private StringBuilder svgBody;
  private LinkedHashMap<String, Snapshot> map;
  private String idOfHtml;

  /**
   * Build the class: SVGView.
   */
  public SVGView(LinkedHashMap<String, Snapshot> map, String idOfHtml) {
    this.map = map;
    this.svgBody = new StringBuilder();
    this.idOfHtml = idOfHtml;
  }

  /**
   * Build the class: createSVGBody.
   */
  public void createSVGBody(){
    this.svgBody.append("<!DOCTYPE html>\n <html>\n <body>\n <h1>HTML with SVG for the Afternoon!!</h1>\n <div>");
    for(Map.Entry<String, Snapshot> eachSnapshot : map.entrySet()){
      this.svgBody.append("\n<h2>").append(eachSnapshot.getKey()).append("</h2>\n");
      this.svgBody.append("\n<h2>").append(eachSnapshot.getValue().getDescription()).append("</h2>\n");
      this.svgBody.append("<svg ").append("width= \"").append(frameWidth).append("\"height= \"").append(frameHeight).append("\">");
      for(Map.Entry<String,IShape> eachShape: eachSnapshot.getValue().getShapeList().entrySet()){
        if(eachShape.getValue().getType().equals("rectangle")){
          this.svgBody.append("\n<rect id=\"").append(eachShape.getValue().getId()).append("\" x=\"").append(eachShape.getValue().getLocation().getX()).append("\" y=\"").append(eachShape.getValue().getLocation().getY());
          this.svgBody.append("\" width=\"").append(eachShape.getValue().getWidthOrXRadius()).append("\" height=\"").append(eachShape.getValue().getHeightOrYRadius());
          this.svgBody.append("\" fill=\"").append("rgb").append(eachShape.getValue().getColor().toString()).append("\" visibility=\"visible").append("\">\n</rect>");
        }else if(eachShape.getValue().getType().equals("oval")){
          this.svgBody.append("\n<ellipse id=\"").append(eachShape.getValue().getId()).append("\" cx=\"").append(eachShape.getValue().getLocation().getX()).append("\" cy=\"").append(eachShape.getValue().getLocation().getY());
          this.svgBody.append("\" rx=\"").append(eachShape.getValue().getWidthOrXRadius()).append("\" ry=\"").append(eachShape.getValue().getHeightOrYRadius());
          this.svgBody.append("\" fill=\"").append("rgb").append(eachShape.getValue().getColor().toString()).append("\" visibility=\"visible").append("\">\n</ellipse>\n");
        }
      }
      this.svgBody.append("</svg>\n</div>\n</div>\n");
    }
    this.svgBody.append("</body>\n</html>\n");
  }

  /**
   * Build the method: paint.
   * Create html file according to nae and svg body.
   */
  public void paint() throws IOException {
    FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+"/resources/"+this.idOfHtml);
    fileWriter.write(this.svgBody.toString());
    fileWriter.close();
  }

}
