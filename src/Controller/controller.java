package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

import Model.AlbumModel;

/**
 * Build the class: reading_file.
 * This class handle the file input by command line.
 */
public class controller {
  private static AlbumModel albumModel;

  /**
   * Build the class: reading_file.
   * This class handle the file input by command line.
   */
  public controller(AlbumModel albumModel) {
    this.albumModel = albumModel;
  }

  /**
   * Build the method: readFile.
   * This class separate the file line by line and call corresponding method.
   */
  public static void readFile(Readable readable) {
    Scanner s = new Scanner(readable);
    s.useDelimiter(Pattern.compile("(\\n+|#.*)+"));

    while (s.hasNextLine()) {
      String word = s.nextLine();
      String[] line = (word.strip()).split("\\s+");

      switch (line[0].toLowerCase()) {
        case "shape":
          readShape(line);
          break;
        case "move":
          readMove(line);
          break;
        case "color":
          readColorChange(line);
          break;
        case "resize":
          readResize(line);
          break;
        case "remove":
          readRemove(line);
          break;
        case "snapshot":
          readSnapShot(line);
          break;
      }
    }
  }

  /**
   * Build the method: readShape.
   * This method call corresponding method in model.
   */
  private static void readShape(String[] list){
    String id = list[1];
    String Type= list[2];
    String shape;
    int x = Integer.parseInt(list[3]);
    int y = Integer.parseInt(list[4]);
    int widthOrXRadius = Integer.parseInt(list[5]);
    int heightOrYRadius = Integer.parseInt(list[6]);
    int r = Integer.parseInt(list[7]);

    int g = Integer.parseInt(list[8]);

    int b = Integer.parseInt(list[9]);
    albumModel.createShape(id, Type,x,y,widthOrXRadius,heightOrYRadius,r,g,b);
  }

  /**
   * Build the method: readMove.
   * This method call corresponding method in model.
   */
  private static void readMove(String[] list){
    String id = list[1];
    int moveToX = Integer.parseInt(list[2]);
    int moveToY = Integer.parseInt(list[3]);
    albumModel.move(id,moveToX,moveToY);
  }

  /**
   * Build the method: readColorChange.
   * This method call corresponding method in model.
   */
  private static void readColorChange(String[] list){
    String id = list[1];
    int r = Integer.parseInt(list[2]);
    int g = Integer.parseInt(list[3]);
    int b = Integer.parseInt(list[4]);
    albumModel.changeColor(id,r,g,b);
  }

  /**
   * Build the method: readResize.
   * This method call corresponding method in model.
   */
  private static void readResize(String[] list){
    String id = list[1];
    int widthOrXRadius = Integer.parseInt(list[2]);
    int heightOrYRadius = Integer.parseInt(list[3]);
    albumModel.resize(id,widthOrXRadius,heightOrYRadius);
  }

  /**
   * Build the method: readRemove.
   * This method call corresponding method in model.
   */
  private static void readRemove(String[] list){
    String id = list[1];
    albumModel.remove(id);
  }

  /**
   * Build the method: readSnapShot.
   * This method call corresponding method in model.
   */
  private static void readSnapShot(String[] list){
    StringBuilder description = new StringBuilder();
    for (int i = 1; i < list.length; i++) {
      description.append(list[i] + " ");
    }
    albumModel.snapShot(description.toString());
  }

  /**
   * Build the method: inputFile.
   * This method call corresponding method in model.
   */
  public static void inputFile(String fileName) throws FileNotFoundException {
    String CurrDir = System.getProperty("user.dir");
    CurrDir += "/resources/"+fileName;
    File fileToRead = new File(CurrDir);
    FileReader fr = new FileReader(fileToRead);
    controller.readFile(fr);
  }
}

