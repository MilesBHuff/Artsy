package src.p2;
import  src.effects.Artsy;
import  javafx.application.Application;
import  javafx.stage.Stage;
import  javafx.scene.Scene;
import  javafx.scene.layout.FlowPane;

/** This is the driver for this application. **/
public class Driver extends Application
{ //class
	////////////////////////////////////////////////////////////////////////
	/** Description
	 * @param stage Description
	**/
	@Override
	public void start(Stage stage)
	{ //method
		FlowPane root  = new FlowPane(    );
		Scene    scene = new    Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("Artsy!");
		stage.sizeToScene();
		stage.show();
	} //method

	////////////////////////////////////////////////////////////////////////
	/** The default, 'main', method.  Runs when the programme is executed.
	 * @param args The arguments provided to the programme
	**/
	public static void main(String[] args)
	{ //method
		launch(args);
	} //method
} //class
