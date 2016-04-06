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
	public void start(Stage oStage)
	{ //method
		// DATA
		String sBtnRotate  = "Rotate"             ;
		String sBtnClose   = "Close"              ;
		String sBtnOpen    = "Open"               ;
		String sBtnSave    = "Save"               ;
		String sBtnChecker = "Checker"            ;
		String sBtnStripeH = "Stripe horizontally";
		String sBtnStripeH = "Stripe vertically"  ;
		String sLblImage1  = "Image 1:  "         ;
		String sLblImage2  = "Image 2:  "         ;
		String sLblEffect  = "Effects:"           ;
		String sLblResult  = "Result:"            ;

		// IMG1 BUTTONS
		GridPane oImage1Btns = new GridPane();
		oImageBtns.setHgap(10);
		oImageBtns.setVgap(10);
		Button oBtnRotate1 = new Button(sBtnRotate); oEffectBtns.add(oBtnRotate1, 0, 0);
		Button oBtnClose1  = new Button(sBtnClose) ; oEffectBtns.add(oBtnClose1 , 1, 0);
		Button oBtnOpen1   = new Button(sBtnOpen)  ; oEffectBtns.add(sBtnOpen1  , 2, 0);
		Button oBtnSave1   = new Button(sBtnSave)  ; oEffectBtns.add(oBtnSave1  , 3, 0);
		
		// IMG2 BUTTONS
		GridPane oImage2Btns = new GridPane();
		oImageBtns.setHgap(10);
		oImageBtns.setVgap(10);
		Button oBtnRotate2 = new Button(sBtnRotate); oEffectBtns.add(oBtnRotate2, 0, 0);
		Button oBtnClose2  = new Button(sBtnClose) ; oEffectBtns.add(oBtnClose2 , 1, 0);
		Button oBtnOpen2   = new Button(sBtnOpen)  ; oEffectBtns.add(sBtnOpen2  , 2, 0);
		Button oBtnSave2   = new Button(sBtnSave)  ; oEffectBtns.add(oBtnSave2  , 3, 0);
		
		// IMG3 BUTTONS
		GridPane oImage3Btns = new GridPane();
		oImageBtns.setHgap(10);
		oImageBtns.setVgap(10);
		Button oBtnRotate3 = new Button(sBtnRotate); oEffectBtns.add(oBtnRotate3, 0, 0);
		Button oBtnClose3  = new Button(sBtnClose) ; oEffectBtns.add(oBtnClose3 , 1, 0);
		Button oBtnOpen3   = new Button(sBtnOpen)  ; oEffectBtns.add(sBtnOpen3  , 2, 0);
		Button oBtnSave3   = new Button(sBtnSave)  ; oEffectBtns.add(oBtnSave3  , 3, 0);

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
		
		// MENUBAR
		MenuBar mbrMenu = new MenuBar()   ; oRoot.add(mbrMenu, 0, 0, 2, 1);
	        Menu    menFile = new Menu("File");
	        Menu    menHelp = new Menu("Help");
	        menuBar.getMenus().addAll(menFile, menHelp, menuView);
	        
	        // OTHER ITEMS ON THE MAIN PANE
		Label lblImage1 = new Label(sLblImage1); oRoot.add(lblImage1  , 0, 1      );
		// Img1 (0, 2)
		                                         oRoot.add(img1Btns   , 0, 3      );
		Label lblImage2 = new Label(sLblImage2); oRoot.add(lblImage2  , 0, 4      );
		// Img2 (0, 5)
		                                         oRoot.add(img2Btns   , 0, 6      );
		Label lblEffect = new Label(sLblEffect); oRoot.add(lblEffect  , 1, 1      );
		                                         oRoot.add(oEffectBtns, 1, 2, 1, 2);
		Label lblResult = new Label(sLblResult); oRoot.add(lblResult  , 1, 4      );
		// Img3 (1, 5)
		                                         oRoot.add(oImage3Btns, 1, 6      );

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
