import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene{
  
  //Instance Variables 
  private String [][] travel;
  private ImageFilter [][] travelPlaces;
  
  public MyStory(String[][] travel) {
    this.travel = travel;
    
  }
  //Constructors 
  public MyStory(String[][] travel, ImageFilter[][] travelPlaces) {
    this.travel = travel;
    this.travelPlaces = travelPlaces;
    
  }
  
  public void drawScene(){
    drawIntroScene();
    drawTravelScene();
    drawTravelImage();
    
  }
  //Main drawScene method 
  public void drawIntroScene(){
    clear("white");
    
    setTextHeight(24);
    setTextColor("black");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawText("Where I Traveled In Summer",0, 30);

    
    
    ImageFilter summer = new ImageFilter("Screenshot-2025-01-30-084101.png");
    summer.colorShift(100);
    drawImage (summer, 100, 100, summer.getWidth());
    pause(2.0);
  }

  public void drawTravelScene(){
    clear("white");
    
    setTextHeight(22);
    setTextColor("black");
    setTextStyle(Font.MONO, FontStyle.BOLD);

    drawText("Four Places I Visited",0, 30);
    
    drawText(travel[0][0], 0, 100);
    pause(0.5);
    drawText(travel[0][1], 220, 100);
    pause(0.5);
    drawText(travel[1][0], 0, 300);
    pause(0.5);
    drawText(travel[1][1], 220, 300);
    pause(0.5);
  }

    
    public void drawTravelImage(){
    clear("white");
/*
Sepia filter
*/
    String[] filters = {"saturate", "colorShift", "makeSepia", "saturate"};
    int[] filterValues = {1, 25, 0, 0};

    int index = 0;
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            ImageFilter currentImage = travelPlaces[i][j];
            
            if (filters[index].equals("saturate")) {
                currentImage.saturate(filterValues[index]);
            } else if (filters[index].equals("colorShift")) {
                currentImage.colorShift(filterValues[index]);
            } else if (filters[index].equals("makeSepia")) {
                currentImage.makeSepia();
            }

            pause(1.5);

            if (i == 0 && j == 0) {
                drawImage(currentImage, 0, 0, 200);
            } else if (i == 0 && j == 1) {
                drawImage(currentImage, 200, 0, 200);
            } else if (i == 1 && j == 0) {
                drawImage(currentImage, 0, 200, 200);
            } else if (i == 1 && j == 1) {
                drawImage(currentImage, 200, 200, 200);
            }

            index++;
  /*
  Adds "yay" sound
  */
          playSound("yay.wav");
        }
    }
}
}