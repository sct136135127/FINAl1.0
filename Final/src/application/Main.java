package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project3.FileControler;
import project3.Space;
import javafx.scene.DepthTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;


public class Main extends Application {
	public static Space space = new Space();
	public static FileControler fc = new FileControler();
	public static boolean saveflag = true;
	
	public ObservableList<String> strList = FXCollections.observableArrayList();
	public static BorderPane root = new BorderPane();
	public static Scene scene = new Scene(root,840,730);
	
	@Override
	public void start(Stage primaryStage) {
		try {	
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			ImageView image = new ImageView("file:/Users/mylifefile/Desktop/hulushan.jpg");
			image.setFitHeight(730);
			image.setFitWidth(840);
			root.getChildren().add(image);
			
			MenuBar menuBar = new MenuBar();
		    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		    root.setTop(menuBar);
		    root.setDepthTest(DepthTest.ENABLE);
		    
		    Menu optionMenu = new Menu("Option");
		    MenuItem initMenuItem = new MenuItem("INIT");
		    initMenuItem.setOnAction((ActionEvent t) ->
		    {
		    	Main.fc.recorder.clear();
		    	space.init();
		    });
		    MenuItem startMenuItem = new MenuItem("START");
		    startMenuItem.setOnAction((ActionEvent t) ->
		    {
		    	saveflag = true;
		    	Main.fc.recorder.clear();
		    	space.start();
		    });
		    MenuItem openMenuItem = new MenuItem("OPEN");
		    openMenuItem.setOnAction((ActionEvent t) ->
		    {
		    	saveflag = false;
		    	Main.fc.recorder.clear();
		    	FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open Resource File");
				fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
				File file = fileChooser.showOpenDialog(primaryStage);
				System.out.println(file);
				
				if(file != null)
					fc.openfile(file);
		    });
		    optionMenu.getItems().addAll(initMenuItem,startMenuItem,openMenuItem);
		    
		    menuBar.getMenus().addAll(optionMenu);
	        
			for(int i = 0;i<13;++i)
			{
				Line line = new Line();
				line.setStartX(70*i);
				line.setStartY(30);
				line.setEndX(70*i);
				line.setEndY(730);
				
				root.getChildren().add(line);
			}
			
			for(int i = 0;i<11;++i)
			{
				Line line = new Line();
				line.setStartX(0);
				line.setStartY(70*i+30);
				line.setEndX(840);
				line.setEndY(70*i+30);
				
				root.getChildren().add(line);
			}
			
			scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		    	 
	            public void handle(KeyEvent event) {
	                if(event.getCode() == KeyCode.SPACE)
	                {
	                	Main.fc.recorder.clear();
	    		    	space.init();
	    		    	saveflag = true;
	    		    	space.start();
	                }
	                else if(event.getCode() == KeyCode.L)
	                {
	                	if(space.goodguys<=0||space.badguys<=0)
	                	{
	                		saveflag = false;
	        		    	Main.fc.recorder.clear();
	        		    	FileChooser fileChooser = new FileChooser();
	        				fileChooser.setTitle("Open Resource File");
	        				fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
	        				File file = fileChooser.showOpenDialog(primaryStage);
	        				System.out.println(file);
	        				
	        				if(file != null)
	        					fc.openfile(file);
	                	}
	                }
	            }
	        });
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);	
	}
}
