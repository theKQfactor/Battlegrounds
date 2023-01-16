package gameZone;


import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.input.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.stage.Stage;


public class GameDriver extends Application {
	private int enemyX = 200;
	private int enemyY = 200;
	Player player = new Player();
	
	
	@Override
	public void start(Stage stage) throws FileNotFoundException {   
	      //Creating an image 
	      Image image = new Image("barbarianCOC.png");  
	      
	      //Setting the image view 
	      ImageView imageView = new ImageView(image);
	      
	      Image enemy1 = new Image("goblinCOC.png");
	      ImageView viewEnemy1 = new ImageView(enemy1);
	      
	      viewEnemy1.setX(enemyX);
	      viewEnemy1.setY(enemyY);
	      
	      //Setting the position of the image 
	      imageView.setX(player.getX()); 
	      imageView.setY(player.getY()); 
	      
	      startTimer(imageView, viewEnemy1);
	      
	      
	      viewEnemy1.setFitHeight(94);
	      viewEnemy1.setFitWidth(167);
	      
	      //setting the fit height and width of the image view 
	      imageView.setFitHeight(100); 
	      imageView.setFitWidth(100); 
	      
	      //Setting the preserve ratio of the image view 
	      imageView.setPreserveRatio(true);  
	      
	      //Creating a Group object  
	      Group root = new Group(imageView, viewEnemy1);  
	      
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 500);  
	      
	      //Setting title to the Stage 
	      stage.setTitle("Loading an image");  
	      
	      //Adding scene to the stage 
	      stage.setScene(scene);
	      

	      
	      scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP: 	player.addY(-player.getMaxSpeed());		break;
				case DOWN: 	player.addY(player.getMaxSpeed());		break;
				case LEFT: 	player.addX(-player.getMaxSpeed());		break;
				case RIGHT: player.addX(player.getMaxSpeed());		break;
			}
	      }
	      
	});
	      
	      //Displaying the contents of the stage 
	      stage.show();
	}
	      
	
	
	public void startTimer(ImageView imageView, ImageView viewEnemy1) {
		Timer timer = new Timer("Timer");
		TimerTask task = new TimerTask() {
	        public void run() {
	        	
		            step(imageView, viewEnemy1);

	        }
	    };
		long delay = 50L;
		timer.scheduleAtFixedRate(task, delay, delay);
	}
	
	
	public void step(ImageView imageView, ImageView viewEnemy1) {
		move(imageView, viewEnemy1);

		
	}
	
	public void move(ImageView imageView, ImageView viewEnemy1) {
		imageView.setX(player.getX()); 
		imageView.setY(player.getY());
		if (player.getY() > enemyY) {
			enemyY += 3;
		}
		if (player.getY() < enemyY){
			enemyY -= 3;
		}
		
		if (player.getX() > enemyX) {
			enemyX += 3;
		}
		if (player.getX() < enemyX) {
			enemyX -= 3;
		}
		
		viewEnemy1.setY(enemyY);
		viewEnemy1.setX(enemyX);
	}

	     
	
	public static void main(String[] args) {
		launch(args);


	}}
