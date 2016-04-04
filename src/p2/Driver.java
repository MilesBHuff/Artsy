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
		String sBtnChecker = "Checker"            ;
		String sBtnStripeH = "Stripe horizontally";
		String sBtnStripeH = "Stripe vertically"  ;
		String oLblImage1  = "Image 1:  "         ;
		String oLblImage2  = "Image 2:  "         ;
		String sLblEffect  = "Effects:"           ;
		String sLblResult  = "Result:"            ;

		// IMG BUTTONS
		GridPane oImageBtns = new GridPane();
		oImageBtns.setHgap(10);
		oImageBtns.setVgap(10);
		// Close (0, 0)
		// Open (0, 0)
		// Save (0, 0)
		// Rotate (0, 0)

		// EFFECTS BUTTONS
		GridPane oEffectBtns = new GridPane();
		oEffectBtns.setHgap(10);
		oEffectBtns.setVgap(10);
		Button oBtnChecker = new Button(sBtnChecker); oEffectBtns.add(oBtnChecker, 0, 0);
		Button oBtnStripeH = new Button(sBtnStripeH); oEffectBtns.add(oBtnStripeH, 0, 1);
		Button oBtnStripeV = new Button(sBtnStripeV); oEffectBtns.add(oBtnStripeV, 0, 2);

		// MAIN PANE
		GridPane oRoot = new GridPane();
		oRoot.setHgap(10);
		oRoot.setVgap(10);
		oRoot.setPadding(new Insets(25, 25, 25, 25));
		// Menubar (0, 0, 2, 1)
		Label oLblImage1 = new Label(sLblImage1); oRoot.add(oLblImage1, 0, 1);
		// Img1 (0, 2)
		// Img1 buttons (0, 3)
		Label oLblImage2 = new Label(sLblImage2); oRoot.add(oLblImage2, 0, 4);
		// Img2 (0, 5)
		// Img2 buttons (0, 6)
		Label oLblEffect = new Label(sLblEffect); oRoot.add(oLblEffect, 1, 1);
		// Effects buttons (1, 2, 1, 2)
		Label oLblResult = new Label(sLblResult); oRoot.add(oLblResult, 1, 4);
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
