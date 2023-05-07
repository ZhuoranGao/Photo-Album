package Controller;

import java.awt.*;

/**
 * Build the class: reading_command.
 * This class handle the command input by user.
 */
public class reading_command {
  public static String[] inputFile = new String[1];
  public static String[] webViewName = new String[1];
  public static int openWebView = 0;
  public static int openGraphicalView = 0;
  public static int frameWidth = 1000;
  public static int frameHeight = 1000;

  /**
   * Build the method: setInformation.
   * This class handle the command according to -in, -out and -v.
   * @param input the input of command.
   */
  public void setInformation(String[] input){

      for (int i = 0; i < input.length; i++) {
        if (input[i].equalsIgnoreCase("-in")) {
          System.out.println(input[i + 1]);
          inputFile[0] = input[i + 1];
        } else if (input[i].equalsIgnoreCase("-out")) {
          webViewName[0] = input[i + 1];
          openWebView = 1;
        } else if (input[i].equalsIgnoreCase("-v")) {
          if (input[i + 1].equalsIgnoreCase("graphical")) {
            frameWidth = Integer.parseInt(input[i + 2]);
            frameHeight = Integer.parseInt(input[i + 3]);
            System.out.println(frameWidth);
            openGraphicalView = 1;
          } else if (input[i + 1].equalsIgnoreCase("web")) {
            openWebView = 1;
          }else{
            throw new IllegalArgumentException("Invalid word behind -v");
          }
        }

      }
  }
}
