package src.p2                        ;
import  javafx.application.Application;
import  javafx.scene.Scene            ;
import  javafx.scene.layout.FlowPane  ;
import  javafx.stage.Stage            ;
import  src.effects.Artsy             ;

/** This is the driver for this application. **/
public class Driver extends Application
{ //class
	////////////////////////////////////////////////////////////////////////
	/** Description
	 * @param stage Description
	**/
	@Override
	public void start(Stage oStage)
	{ //method

		// IMG BUTTONS
		// Close (0, 0)
		// Open (0, 0)
		// Save (0, 0)
		// Rotate (0, 0)

		// EFFECTS BUTTONS
		// Checker (0, 0)
		// Stripe H (0, 1)
		// Stripe V (0, 2)

		GridPane oRoot = new GridPane();
		oRoot.setHgap(10);
		oRoot.setVgap(10);
		oRoot.setPadding(new Insets(25, 25, 25, 25));

		// Menubar (0, 0, 2, 1)

		// FIRST COLUMN
		Label oImg1 = new Label(0, 1);
		// Img1 (0, 2)
		// Img1 buttons (0, 3)
		Label oImg2 = new Label(0, 4);
		// Img2 (0, 5)
		// Img2 buttons (0, 6)

		// SECOND COLUMN
		Label oEffects = new Label(1, 1);
		// Effects buttons (1, 2, 1, 2)
		Label oImg3 = new Label(1, 4);
		// Img3 (1, 5)
		// Img3 buttons (1, 6)

		Scene oScene = new Scene(oRoot);

		oStage.setScene(oScene);
		oStage.setTitle("Artsy!");
	        oStage.sizeToScene();
		oStage.show();
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
