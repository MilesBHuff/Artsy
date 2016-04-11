package p2                            ;
import  effects.Artsy                 ;
import  java.awt.image.BufferedImage  ;
import  java.net.URL                  ;
import  javax.imageio.ImageIO         ;
import  javafx.application.Application;
import  javafx.geometry.Insets        ;
import  javafx.scene.Scene            ;
import  javafx.scene.control.Button   ;
import  javafx.scene.control.Label    ;
import  javafx.scene.control.Menu     ;
import  javafx.scene.control.MenuBar  ;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import  javafx.scene.image.Image      ;
import  javafx.scene.image.ImageView  ;
import  javafx.scene.layout.GridPane  ;
import  javafx.scene.shape.Rectangle  ;
import  javafx.stage.Stage            ;
@SuppressWarnings("restriction")

/** This is the runner for this application.
 * @author Miles B Huff
**/
public class Driver extends Application
{ //+class
	////////////////////////////////////////////////////////////////////////
	/** Creates a GUI for the application.
	 * @param stage $Description
	**/
	@Override
	public void start(Stage stgRoot)
	{ //+method
		// DATA
		String sBtnChecker = "Checker"            ;
		String sBtnOpen    = ""                   ;
		String sBtnReset   = ""                   ;
		String sBtnRotate  = ""                   ;
		String sBtnSave    = ""                   ;
		String sBtnStripeH = "Stripe horizontally";
		String sBtnStripeV = "Stripe vertically"  ;
		String sBtnUrl     = ""                   ;
		String sLblFX      = "Effects:"           ;
		String sLblImg1    = "Image 1:  "         ;
		String sLblImg2    = "Image 2:  "         ;
		String sLblImg3    = "Result:"            ;
		
		// RESOURCES
		Image img1       = new Image("file:res/default.png"      );
		Image img2       = new Image("file:res/default.png"      );
		Image img3       = new Image("file:res/default.png"      );
		Image imgChecker = new Image("file:res/icons/checker.png");
		Image imgOpen    = new Image("file:res/icons/open.png"   );
		Image imgReset   = new Image("file:res/icons/reset.png"  );
		Image imgRotate  = new Image("file:res/icons/rotate.png" );
		Image imgSave    = new Image("file:res/icons/save.png"   );
		Image imgStripeH = new Image("file:res/icons/stripeH.png");
		Image imgStripeV = new Image("file:res/icons/stripeV.png");
		Image imgUrl     = new Image("file:res/icons/url.png"    );

		// IMG1 BUTTONS
		GridPane gpImg1Btns = new GridPane(          );
		Button  btnRotate1  = new Button  (sBtnRotate); gpImg1Btns.add(btnRotate1, 0, 0);
		Button  btnReset1   = new Button  (sBtnReset ); gpImg1Btns.add(btnReset1 , 1, 0);
		Button  btnUrl1     = new Button  (sBtnUrl   ); gpImg1Btns.add(btnUrl1   , 2, 0);
		Button  btnOpen1    = new Button  (sBtnOpen  ); gpImg1Btns.add(btnOpen1  , 3, 0);
		Button  btnSave1    = new Button  (sBtnSave  ); gpImg1Btns.add(btnSave1  , 4, 0);
		
		// IMG2 BUTTONS
		GridPane gpImg2Btns = new GridPane(          );
		Button  btnRotate2  = new Button  (sBtnRotate); gpImg2Btns.add(btnRotate2, 0, 0);
		Button  btnReset2   = new Button  (sBtnReset ); gpImg2Btns.add(btnReset2 , 1, 0);
		Button  btnUrl2     = new Button  (sBtnUrl   ); gpImg2Btns.add(btnUrl2   , 2, 0);
		Button  btnOpen2    = new Button  (sBtnOpen  ); gpImg2Btns.add(btnOpen2  , 3, 0);
		Button  btnSave2    = new Button  (sBtnSave  ); gpImg2Btns.add(btnSave2  , 4, 0);
		
		// IMG3 BUTTONS
		GridPane gpImg3Btns = new GridPane(          );
		Button  btnRotate3  = new Button  (sBtnRotate); gpImg3Btns.add(btnRotate3, 0, 0);
		Button  btnReset3   = new Button  (sBtnReset ); gpImg3Btns.add(btnReset3 , 1, 0);
		Button  btnSave3    = new Button  (sBtnSave  ); gpImg3Btns.add(btnSave3  , 2, 0);

		// FX BUTTONS
		GridPane gpFXBtns  = new GridPane(           );
		Button  btnChecker = new Button  (sBtnChecker); gpFXBtns.add(btnChecker, 0, 0);
		Button  btnStripeH = new Button  (sBtnStripeH); gpFXBtns.add(btnStripeH, 0, 1);
		Button  btnStripeV = new Button  (sBtnStripeV); gpFXBtns.add(btnStripeV, 0, 2);

		// MAIN PANE
		GridPane  gpMain = new GridPane (        );
		Label    lblImg1 = new Label    (sLblImg1); gpMain.add(lblImg1    , 0, 1      );
		ImageView ivImg1 = new ImageView(        ); gpMain.add( ivImg1    , 0, 2      );
		                                            gpMain.add( gpImg1Btns, 0, 3      );
		Label    lblImg2 = new Label    (sLblImg2); gpMain.add(lblImg2    , 0, 4      );
		ImageView ivImg2 = new ImageView(        ); gpMain.add( ivImg2    , 0, 5      );
                                                            gpMain.add( gpImg2Btns, 0, 6      );
		Label    lblFX   = new Label    (sLblFX  ); gpMain.add(lblFX      , 1, 1      );
                                                            gpMain.add( gpFXBtns  , 1, 2, 1, 2);
		Label    lblImg3 = new Label    (sLblImg3); gpMain.add(lblImg3    , 1, 4      );
		ImageView ivImg3 = new ImageView(        ); gpMain.add( ivImg3    , 1, 5      );
		                                            gpMain.add( gpImg3Btns, 1, 6      );
		
		// ROOT PANE
		GridPane gpRoot = new GridPane(); gpRoot.add( gpMain, 0, 1);
		MenuBar mbrRoot = new MenuBar (); gpRoot.add(mbrRoot, 0, 0);
		
		// MENUBAR
	        Menu     menFile           = new          Menu    ("File"                                                                       );
	        Menu     menFileOpen       = new          Menu    ("Open from file"     , new ImageView(new Image("file:res/icons/open.png"   )));
	        MenuItem menFileOpenImg1   = new          MenuItem("Image 1"                                                                    );
	        MenuItem menFileOpenImg2   = new          MenuItem("Image 2"                                                                    );
	        Menu     menFileUrl        = new          Menu    ("Open from URL"      , new ImageView(new Image("file:res/icons/url.png"    )));
	        MenuItem menFileUrlImg1    = new          MenuItem("Image 1"                                                                    );
	        MenuItem menFileUrlImg2    = new          MenuItem("Image 2"                                                                    );
		MenuItem menFileSeparator  = new SeparatorMenuItem(                                                                             );
	        Menu     menFileReset      = new          Menu    ("Reset"              , new ImageView(new Image("file:res/icons/reset.png"  )));
	        MenuItem menFileResetImg1  = new          MenuItem("Image 1"                                                                    );
	        MenuItem menFileResetImg2  = new          MenuItem("Image 2"                                                                    );
	        MenuItem menFileResetImg3  = new          MenuItem("Image 3"                                                                    );
	        Menu     menFileSave       = new          Menu    ("Save"               , new ImageView(new Image("file:res/icons/save.png"   )));
	        MenuItem menFileSaveImg1   = new          MenuItem("Image 1"                                                                    );
	        MenuItem menFileSaveImg2   = new          MenuItem("Image 2"                                                                    );
	        MenuItem menFileSaveImg3   = new          MenuItem("Image 3"                                                                    );
	        Menu     menEdit           = new          Menu    ("Edit"                                                                       );
	        Menu     menEditRotate     = new          Menu    ("Rotate"             , new ImageView(new Image("file:res/icons/rotate.png" )));
	        MenuItem menEditRotateImg1 = new          MenuItem("Image 1"                                                                    );
	        MenuItem menEditRotateImg2 = new          MenuItem("Image 2"                                                                    );
	        MenuItem menEditRotateImg3 = new          MenuItem("Image 3"                                                                    );
		MenuItem menEditSeparator  = new SeparatorMenuItem(                                                                             );
	        MenuItem menEditChecker    = new          MenuItem("Checker"            , new ImageView(new Image("file:res/icons/checker.png")));
	        MenuItem menEditStripeH    = new          MenuItem("Stripe horizontally", new ImageView(new Image("file:res/icons/stripeH.png")));
	        MenuItem menEditStripeV    = new          MenuItem("Stripe vertically"  , new ImageView(new Image("file:res/icons/stripeV.png")));
	        mbrRoot      .getMenus().addAll(menFile          , menEdit                                                             );
	        menFile      .getItems().addAll(menFileOpen      , menFileUrl       , menFileSeparator , menFileReset  , menFileSave   );
	        menFileOpen  .getItems().addAll(menFileOpenImg1  , menFileOpenImg2                                                     );
	        menFileUrl   .getItems().addAll(menFileUrlImg1   , menFileUrlImg2                                                      );
	        menFileReset .getItems().addAll(menFileResetImg1 , menFileResetImg2 , menFileResetImg3                                 );
	        menFileSave  .getItems().addAll(menFileSaveImg1  , menFileSaveImg2  , menFileSaveImg3                                  );
	        menEdit      .getItems().addAll(menEditRotate    , menEditSeparator , menEditChecker   , menEditStripeH, menEditStripeV);
	        menEditRotate.getItems().addAll(menEditRotateImg1, menEditRotateImg2, menEditRotateImg3                                );
	        
		// SPACING
		gpFXBtns  .setHgap   (10);
		gpFXBtns  .setVgap   (10);
		gpImg1Btns.setHgap   (10);
		gpImg1Btns.setVgap   (10);
		gpImg2Btns.setHgap   (10);
		gpImg2Btns.setVgap   (10);
		gpImg3Btns.setHgap   (10);
		gpImg3Btns.setVgap   (10);
		gpMain    .setHgap   (10);
		gpMain    .setPadding(new Insets(0, 25, 25, 25));
		gpMain    .setVgap   (10);
		gpRoot    .setHgap   (10);
		gpRoot    .setVgap   (10);
	        
	        // IMAGES
		btnChecker.setGraphic(new ImageView(imgChecker));
		btnOpen1  .setGraphic(new ImageView(imgOpen   ));
		btnOpen2  .setGraphic(new ImageView(imgOpen   ));
		btnReset1 .setGraphic(new ImageView(imgReset  ));
		btnReset2 .setGraphic(new ImageView(imgReset  ));
		btnReset3 .setGraphic(new ImageView(imgReset  ));
		btnRotate1.setGraphic(new ImageView(imgRotate ));
		btnRotate2.setGraphic(new ImageView(imgRotate ));
		btnRotate3.setGraphic(new ImageView(imgRotate ));
		btnSave1  .setGraphic(new ImageView(imgSave   ));
		btnSave2  .setGraphic(new ImageView(imgSave   ));
		btnSave3  .setGraphic(new ImageView(imgSave   ));
		btnUrl1   .setGraphic(new ImageView(imgUrl    ));
		btnUrl2   .setGraphic(new ImageView(imgUrl    ));
		btnStripeH.setGraphic(new ImageView(imgStripeH));
		btnStripeV.setGraphic(new ImageView(imgStripeV));
		 ivImg1   .setImage  (    img1                 );
		 ivImg2   .setImage  (    img2                 );
		 ivImg3   .setImage  (    img3                 );
		
		// IMAGEVIEW-SETTINGS
		ivImg1.setFitWidth(300); ivImg1.setPreserveRatio(true); ivImg1.setSmooth(true); ivImg1.setCache(true);
		ivImg2.setFitWidth(300); ivImg2.setPreserveRatio(true); ivImg2.setSmooth(true); ivImg2.setCache(true);
		ivImg3.setFitWidth(300); ivImg3.setPreserveRatio(true); ivImg3.setSmooth(true); ivImg3.setCache(true);
		
		// ACTIONS
		//TODO:  btnChecker
		//TODO:  btnOpen1
		//TODO:  btnOpen2
		//TODO:  btnReset1
		//TODO:  btnReset2
		//TODO:  btnReset3
		//TODO:  btnRotate1
		//TODO:  btnRotate2
		//TODO:  btnRotate3
		//TODO:  btnSave1
		//TODO:  btnSave2
		//TODO:  btnSave3
		//TODO:  btnStripeH
		//TODO:  btnStripeV
		//TODO:  btnUrl1
		//TODO:  btnUrl2

		// SET THE STAGE
		Scene sceRoot = new Scene(gpRoot);
		stgRoot.setScene   (sceRoot );
		stgRoot.setTitle   ("Artsy!");
	        stgRoot.sizeToScene(        );
		stgRoot.show       (        );
	} //-method

	////////////////////////////////////////////////////////////////////////
	/** The default, 'main', method.  Runs when the programme is executed.
	 * @param saArgs The arguments provided to the programme
	**/
	public static void main(String[] saArgs)
	{ //+method
		launch(saArgs);
	} //-method
} //-class
