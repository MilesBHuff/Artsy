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
	/** Lays out oll the controls
	 * @param stage $Description
	**/
	@Override
	public void start(Stage stgRoot)
	{ //method
		// DATA
		String   sBtnRotate   = "Rotate"                 ;
		String   sBtnClose    = "Close"                  ;
		String   sBtnOpen     = "Open"                   ;
		String   sBtnSave     = "Save"                   ;
		String   sBtnChecker  = "Checker"                ;
		String   sBtnStripeH  = "Stripe horizontally"    ;
		String   sBtnStripeH  = "Stripe vertically"      ;
		String   sLblImage1   = "Image 1:  "             ;
		String   sLblImage2   = "Image 2:  "             ;
		String   sLblEffect   = "Effects:"               ;
		String   sLblResult   = "Result:"                ;

		// IMG1 BUTTONS
		GridPane gpImg1Btns   = new GridPane(           );
		Button   btnRotate1   = new Button  (sBtnRotate ); gpImg1Btns.add(btnRotate1, 0, 0);
		Button   btnClose1    = new Button  (sBtnClose  ); gpImg1Btns.add(btnClose1 , 1, 0);
		Button   btnOpen1     = new Button  (sBtnOpen   ); gpImg1Btns.add(btnOpen1  , 2, 0);
		Button   btnSave1     = new Button  (sBtnSave   ); gpImg1Btns.add(btnSave1  , 3, 0);
		oImageBtns.setHgap(10);
		oImageBtns.setVgap(10);
		
		// IMG2 BUTTONS
		GridPane gpImg2Btns   = new GridPane(           );
		Button   btnRotate2   = new Button  (sBtnRotate ); gpImg2Btns.add(btnRotate2, 0, 0);
		Button   btnClose2    = new Button  (sBtnClose  ); gpImg2Btns.add(btnClose2 , 1, 0);
		Button   btnOpen2     = new Button  (sBtnOpen   ); gpImg2Btns.add(btnOpen2  , 2, 0);
		Button   btnSave2     = new Button  (sBtnSave   ); gpImg2Btns.add(btnSave2  , 3, 0);
		oImageBtns.setHgap(10);
		oImageBtns.setVgap(10);
		
		// IMG3 BUTTONS
		GridPane gpImg3Btns   = new GridPane(           );
		Button   btnRotate3   = new Button  (sBtnRotate ); gpImg3Btns.add(btnRotate3, 0, 0);
		Button   btnClose3    = new Button  (sBtnClose  ); gpImg3Btns.add(btnClose3 , 1, 0);
		Button   btnOpen3     = new Button  (sBtnOpen   ); gpImg3Btns.add(btnOpen3  , 2, 0);
		Button   btnSave3     = new Button  (sBtnSave   ); gpImg3Btns.add(btnSave3  , 3, 0);
		oImageBtns.setHgap(10);
		oImageBtns.setVgap(10);

		// EFFECTS BUTTONS
		GridPane gpEffectBtns = new GridPane(           );
		Button   btnChecker   = new Button  (sBtnChecker); gpEffectBtns.add(btnChecker, 0, 0);
		Button   btnStripeH   = new Button  (sBtnStripeH); gpEffectBtns.add(btnStripeH, 0, 1);
		Button   btnStripeV   = new Button  (sBtnStripeV); gpEffectBtns.add(btnStripeV, 0, 2);
		gpEffectBtns.setHgap(10);
		gpEffectBtns.setVgap(10);

		// MAIN PANE
		GridPane gpRoot       = new GridPane(           );
		gpRoot.setPadding(new Insets(25, 25, 25, 25));
		gpRoot.setHgap(10);
		gpRoot.setVgap(10);
		
		// MENUBAR
		MenuBar mbrRoot       = new MenuBar (           ); gpRoot.add(mbrRoot, 0, 0, 2, 1);
	        Menu    menFile       = new Menu    ("File"     );
	        Menu    menHelp       = new Menu    ("Help"     );
	        mbrRoot.getMenus().addAll(menFile, menHelp);
	        
	        // OTHER ITEMS ON THE MAIN PANE
		Label   lblImage1     = new Label   (sLblImage1 ); gpRoot.add(lblImage1   , 0, 1      );
		// Img1 (0, 2)
		                                                   gpRoot.add(gpImg1Btns  , 0, 3      );
		Label   lblImage2     = new Label   (sLblImage2 ); gpRoot.add(lblImage2   , 0, 4      );
		// Img2 (0, 5)
		                                                   gpRoot.add(gpImg2Btns  , 0, 6      );
		Label   lblEffect     = new Label   (sLblEffect ); gpRoot.add(lblEffect   , 1, 1      );
		                                                   gpRoot.add(gpEffectBtns, 1, 2, 1, 2);
		Label   lblResult     = new Label   (sLblResult ); gpRoot.add(lblResult   , 1, 4      );
		// Img3 (1, 5)
		                                                   gpRoot.add(gpImg3Btns  , 1, 6      );

		Scene   sceRoot       = new Scene   (gpRoot     );
		stgRoot.setScene(sceRoot);
		stgRoot.setTitle("Artsy!");
	        stgRoot.sizeToScene();
		stgRoot.show();
	} //method

	////////////////////////////////////////////////////////////////////////
	/** The default, 'main', method.  Runs when the programme is executed.
	 * @param saArgs The arguments provided to the programme
	**/
	public static void main(String[] saArgs)
	{ //method
		launch(saArgs);
	} //method
} //class
