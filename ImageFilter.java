import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus{

  public ImageFilter(String filename){
    super(filename);
  }
  
  
  
  public void colorShift(int value) {
      Pixel[][] pixels = getPixelsFromImage();
      
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
        
        int newRed = currentPixel.getRed() + value;
        if (newRed > 255){
          newRed=255;
        }
        currentPixel.setRed(newRed);

        int newBlue = currentPixel.getBlue() + value;
        if (newBlue > 255){
          newBlue=255;
        }
        currentPixel.setBlue(newBlue);

        int newGreen = currentPixel.getGreen() + value;
        if (newGreen > 255){
          newGreen=255;
        }
        currentPixel.setGreen(newGreen);

      
    }
    
  }
  
}
   public void makeSepia() {
    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = (int)((0.393 * currentRed) + (0.769 * currentGreen) + (0.189 * currentBlue));
        int newGreen = (int)((0.349 * currentRed) + (0.686 * currentGreen) + (0.168 * currentBlue));
        int newBlue = (int)((0.272 * currentRed) + (0.534 * currentGreen) + (0.131 * currentBlue));

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }

    public void saturate(int factor) {
  
    Pixel[][] pixels = getPixelsFromImage();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
            int red = currentPixel.getRed();
            int green = currentPixel.getGreen();
            int blue = currentPixel.getBlue();
           int average = (red + green + blue) / 3;

           
            int adjustedGrayscale = average + (average - 255) * factor;

            int newRed = (int)(2 * adjustedGrayscale - red);
            int newGreen = (int)(2 * adjustedGrayscale - green);
            int newBlue = (int)(2 * adjustedGrayscale - blue);

   
            newRed = Math.min(newRed, 255);
            newGreen = Math.min(newGreen, 255);
            newBlue = Math.min(newBlue, 255);

           
            currentPixel.setRed(newRed);
            currentPixel.setGreen(newGreen);
            currentPixel.setBlue(newBlue);
      }
    }
  }

}