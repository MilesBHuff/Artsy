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
	/** Lays out the base GUI.  
	 * @param stage $Description
	**/
	@Override
	public void start(Stage stgRoot)
	{ //method
		// DATA
		String sBtnChecker = "Checker"            ;
	        String sBtnOpen    = ""                   ;
	        String sBtnReset   = ""                   ;
	        String sBtnRotate  = ""                   ;
	        String sBtnSave    = ""                   ;
		String sBtnStripeH = "Stripe horizontally";
		String sBtnStripeV = "Stripe vertically"  ;
		String sLblFX      = "Effects:"           ;
		String sLblImg1    = "Image 1:  "         ;
		String sLblImg2    = "Image 2:  "         ;
		String sLblImg3    = "Result:"            ;
		
		// RESOURCES
		Image img1       = new Image(getClass().getResourceAsStream("null.png"));
		Image img2       = new Image(getClass().getResourceAsStream("null.png"));
		Image img3       = new Image(getClass().getResourceAsStream("null.png"));
		Image imgChecker = new Image(getClass().getResourceAsStream("null.png"));
		Image imgOpen    = new Image(getClass().getResourceAsStream("null.png"));
		Image imgReset   = new Image(getClass().getResourceAsStream("null.png"));
		Image imgRotate  = new Image(getClass().getResourceAsStream("null.png"));
		Image imgSave    = new Image(getClass().getResourceAsStream("null.png"));
		Image imgStripeH = new Image(getClass().getResourceAsStream("null.png"));
		Image imgStripeV = new Image(getClass().getResourceAsStream("null.png"));

		// IMG1 BUTTONS
		GridPane gpImg1Btns = new GridPane(          );
		Button  btnRotate1  = new Button  (sBtnRotate); gpImg1Btns.add(btnRotate1, 0, 0);
		Button  btnReset1   = new Button  (sBtnReset ); gpImg1Btns.add(btnReset1 , 1, 0);
		Button  btnOpen1    = new Button  (sBtnOpen  ); gpImg1Btns.add(btnOpen1  , 2, 0);
		Button  btnSave1    = new Button  (sBtnSave  ); gpImg1Btns.add(btnSave1  , 3, 0);
		
		// IMG2 BUTTONS
		GridPane gpImg2Btns = new GridPane(          );
		Button  btnRotate2  = new Button  (sBtnRotate); gpImg2Btns.add(btnRotate2, 0, 0);
		Button  btnReset2   = new Button  (sBtnReset ); gpImg2Btns.add(btnReset2 , 1, 0);
		Button  btnOpen2    = new Button  (sBtnOpen  ); gpImg2Btns.add(btnOpen2  , 2, 0);
		Button  btnSave2    = new Button  (sBtnSave  ); gpImg2Btns.add(btnSave2  , 3, 0);
		
		// IMG3 BUTTONS
		GridPane gpImg3Btns = new GridPane(          );
		Button  btnRotate3  = new Button  (sBtnRotate); gpImg3Btns.add(btnRotate3, 0, 0);
		Button  btnReset3   = new Button  (sBtnReset ); gpImg3Btns.add(btnReset3 , 1, 0);
		Button  btnOpen3    = new Button  (sBtnOpen  ); gpImg3Btns.add(btnOpen3  , 2, 0);
		Button  btnSave3    = new Button  (sBtnSave  ); gpImg3Btns.add(btnSave3  , 3, 0);

		// FX BUTTONS
		GridPane gpFXBtns  = new GridPane(           );
		Button  btnChecker = new Button  (sBtnChecker); gpEffectBtns.add(btnChecker, 0, 0);
		Button  btnStripeH = new Button  (sBtnStripeH); gpEffectBtns.add(btnStripeH, 0, 1);
		Button  btnStripeV = new Button  (sBtnStripeV); gpEffectBtns.add(btnStripeV, 0, 2);

		// MAIN PANE
		GridPane gpRoot = new GridPane (              );
		Label   lblImg1 = new Label    (sLblImg1      ); gpRoot.add(lblImg1    , 0, 1      );
		Rectangle rImg1 = new Rectangle(0, 0, 300, 300); gpRoot.add(  rImg1    , 0, 2      );
		                                                 gpRoot.add( gpImg1Btns, 0, 3      );
		Label   lblImg2 = new Label    (sLblImg2      ); gpRoot.add(lblImg2    , 0, 4      );
		Rectangle rImg2 = new Rectangle(0, 0, 300, 300); gpRoot.add(  rImg2    , 0, 5      );
		                                                 gpRoot.add( gpImg2Btns, 0, 6      );
		Label   lblFX   = new Label    (sLblFX        ); gpRoot.add(lblFX      , 1, 1      );
		                                                 gpRoot.add( gpFXBtns  , 1, 2, 1, 2);
		Label   lblImg3 = new Label    (sLblImg3      ); gpRoot.add(lblImg3    , 1, 4      );
		Rectangle rImg3 = new Rectangle(0, 0, 300, 300); gpRoot.add(  rImg3    , 1, 5      );
		                                                 gpRoot.add(gpImg3Btns , 1, 6      );
		
		// MENUBAR
		MenuBar mbrRoot = new MenuBar(      ); gpRoot.add(mbrRoot, 0, 0, 2, 1);
	        Menu    menFile = new Menu   ("File");
	        Menu    menHelp = new Menu   ("Help");
	        mbrRoot.getMenus().addAll(menFile, menHelp);
	        
	        // IMAGES
		btnChecker.setGraphic(new ImageView(imgChecker));
		btnOpen1  .setGraphic(new ImageView(imgOpen   ));
		btnOpen2  .setGraphic(new ImageView(imgOpen   ));
		btnOpen3  .setGraphic(new ImageView(imgOpen   ));
		btnReset1 .setGraphic(new ImageView(imgReset  ));
		btnReset2 .setGraphic(new ImageView(imgReset  ));
		btnReset3 .setGraphic(new ImageView(imgReset  ));
		btnRotate1.setGraphic(new ImageView(imgRotate ));
		btnRotate2.setGraphic(new ImageView(imgRotate ));
		btnRotate3.setGraphic(new ImageView(imgRotate ));
		btnSave1  .setGraphic(new ImageView(imgSave   ));
		btnSave2  .setGraphic(new ImageView(imgSave   ));
		btnSave3  .setGraphic(new ImageView(imgSave   ));
		btnStripeH.setGraphic(new ImageView(imgStripeH));
		btnStripeV.setGraphic(new ImageView(imgStripeV));
		rImg1     .setGraphic(new ImageView(img1      ));
		rImg2     .setGraphic(new ImageView(img2      ));
		rImg3     .setGraphic(new ImageView(img3      ));

		// SPACING
		gpFXBtns  .setHgap   (           10 );
		gpFXBtns  .setVgap   (           10 );
		gpImg1Btns.setHgap   (           10 );
		gpImg1Btns.setVgap   (           10 );
		gpImg2Btns.setHgap   (           10 );
		gpImg2Btns.setVgap   (           10 );
		gpImg3Btns.setHgap   (           10 );
		gpImg3Btns.setVgap   (           10 );
		gpRoot    .setPadding(new Insets(25));
		gpRoot    .setHgap   (           10 );
		gpRoot    .setVgap   (           10 );
		
		// SET THE STAGE
		Scene sceRoot = new Scene(gpRoot);
		stgRoot.setScene   (sceRoot );
		stgRoot.setTitle   ("Artsy!");
	        stgRoot.sizeToScene(        );
		stgRoot.show       (        );
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
