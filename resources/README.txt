Design change:
1, I add a linked hashmap in to class: snapshot, so that I can input the information
   from model to view.
2, I add copy function to shape because sometimes the data of shape is pass by reference.
3, I add some helper function like setter and getter.

Design:
Controller:
There are two files in the controller :
1, controller: in this file, I read each line in txt file and call corresponding method.
2, reading_command: in this file, I read the command input by user.

Model:
I design shape and store information of shape in file: abstractShape, Color, IShape, Location
Oval, Rectangle.
I design the album and snapshot in file: AlbumModel and Snapshot.

View:
I draw svg view in file: SVGView.
I draw graphical view in file: GraphicalView.
I draw the middle panel of graphical view in file:DrawingCanvas.
