import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // 2D Array
    String[][] Summer = {   
      {"Alaska", "Thailand Market"},
      {"Glacier", "Thailand"}
    };

    ImageFilter[][] images = {
      { new ImageFilter("Screenshot-2025-01-30-084118.png"), new ImageFilter("Screenshot-2025-01-30-084132.png") },
      { new ImageFilter("Screenshot-2025-01-30-084152.png"), new ImageFilter("Screenshot-2025-01-30-084140.png") }
    };

    // MyStory object
    MyStory scene = new MyStory(Summer, images);
    
    // Call drawScene
    scene.drawScene();
    
    // Play scene in Theater
    Theater.playScenes(scene);
    
  }
}