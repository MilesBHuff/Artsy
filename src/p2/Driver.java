package src.p2                        ;
import  javafx.application.Application;
import  javafx.scene.Scene            ;
import  javafx.scene.layout.FlowPane  ;
import  javafx.stage.Stage            ;
import  src.effects.Artsy             ;

/** This is the runner for this application.
 * @author Miles B Huff
**/
public class Driver extends Application
{ //class
	////////////////////////////////////////////////////////////////////////
	/** Description
	 * @param stage Description
	**/
	@Override
	public void start(Stage oStage)
	{ //method
		// DATA
		String sLbl1 = "Image 1:  ";
		String sLbl2 = "Image 2:  ";
		String sLbl3 = "Effects:"  ;
		String sLbl4 = "Result:"   ;

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
		Label oLbl1 = new Label(sLbl1); oRoot.add(oLbl1, 0, 1)
		// Img1 (0, 2)
		// Img1 buttons (0, 3)
		Label oLbl2 = new Label(sLbl2); oRoot.add(oLbl2, 0, 4)
		// Img2 (0, 5)
		// Img2 buttons (0, 6)

		// SECOND COLUMN
		Label oLbl3 = new Label(sLbl3); oRoot.add(oLbl3, 1, 1)
		// Effects buttons (1, 2, 1, 2)
		Label oLbl4 = new Label(sLbl4); oRoot.add(oLbl4, 1, 4)
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
