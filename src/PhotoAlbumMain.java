import java.io.IOException;

import Controller.reading_command;
import Controller.controller;
import Model.AlbumModel;
import View.GraphicalView;
import View.SVGView;

import static Controller.reading_command.frameHeight;
import static Controller.reading_command.frameWidth;
import static Controller.reading_command.inputFile;
import static Controller.reading_command.openGraphicalView;
import static Controller.reading_command.openWebView;
import static Controller.reading_command.webViewName;

public class PhotoAlbumMain {

  public static void main(String[] args) throws IOException  {
    //Handle command.
    reading_command reading_command = new reading_command();
    reading_command.setInformation(args);

    //Read file.
    AlbumModel albumModel = new AlbumModel();
    controller controller = new controller(albumModel);
    controller.inputFile(inputFile[0]);

    //Generate graphical view.
    if(openGraphicalView == 1){
      View.GraphicalView graphicalView = new GraphicalView();
      graphicalView.graphicalView(frameWidth,frameHeight,albumModel.getSnapshots(),albumModel.getSnapShotId());
    }

    //Generate web view.
    if(openWebView == 1){
      SVGView svgView = new SVGView(albumModel.getSnapshots(),webViewName[0]);
      svgView.createSVGBody();
      svgView.paint();
    }

  }
}
