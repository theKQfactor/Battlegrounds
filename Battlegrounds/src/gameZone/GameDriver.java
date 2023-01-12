package gameZone;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.Timer;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

public class GameDriver extends Application {
	private int x = 50;
	
	@Override
	public void start(Stage stage) throws FileNotFoundException {         
	      //Creating an image 
	      Image image = new Image(new FileInputStream("C:/Users/335187183/Downloads/barbarianCOC.png"));  
	      
	      //Setting the image view 
	      ImageView imageView = new ImageView(image); 
	      
	      //Setting the position of the image 
	      imageView.setX(x); 
	      imageView.setY(200); 
	      
	      //setting the fit height and width of the image view 
	      imageView.setFitHeight(200); 
	      imageView.setFitWidth(200); 
	      
	      //Setting the preserve ratio of the image view 
	      imageView.setPreserveRatio(true);  
	      
	      //Creating a Group object  
	      Group root = new Group(imageView);  
	      
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 500);  
	      
	      //Setting title to the Stage 
	      stage.setTitle("Loading an image");  
	      
	      //Adding scene to the stage 
	      stage.setScene(scene);
	      
	      //Displaying the contents of the stage 
	      stage.show();
	      
	}
	

	public void step() {
		move();
		
	}
	
	public void move() {
		x += 1;
	}
	
	public static void main(String[] args) {
		launch(args);


	}
	

}
