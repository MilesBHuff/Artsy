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
		String sChecker = "Checker"            ;
		String sOpen    = ""                   ;
		String sReset   = ""                   ;
		String sRotate  = ""                   ;
		String sSave    = ""                   ;
		String sStripeH = "Stripe horizontally";
		String sStripeV = "Stripe vertically"  ;
		String sUrl     = ""                   ;
		String sFX      = "Effects:"           ;
		String sImg1    = "Image 1:  "         ;
		String sImg2    = "Image 2:  "         ;
		String sImg3    = "Result:"            ;
		
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
		GridPane gpImg1Btns = new GridPane(       );
		Button  btnRotate1  = new Button  (sRotate); gpImg1Btns.add(btnRotate1, 0, 0);
		Button  btnReset1   = new Button  (sReset ); gpImg1Btns.add(btnReset1 , 1, 0);
		Button  btnUrl1     = new Button  (sUrl   ); gpImg1Btns.add(btnUrl1   , 2, 0);
		Button  btnOpen1    = new Button  (sOpen  ); gpImg1Btns.add(btnOpen1  , 3, 0);
		Button  btnSave1    = new Button  (sSave  ); gpImg1Btns.add(btnSave1  , 4, 0);
		
		// IMG2 BUTTONS
		GridPane gpImg2Btns = new GridPane(       );
		Button  btnRotate2  = new Button  (sRotate); gpImg2Btns.add(btnRotate2, 0, 0);
		Button  btnReset2   = new Button  (sReset ); gpImg2Btns.add(btnReset2 , 1, 0);
		Button  btnUrl2     = new Button  (sUrl   ); gpImg2Btns.add(btnUrl2   , 2, 0);
		Button  btnOpen2    = new Button  (sOpen  ); gpImg2Btns.add(btnOpen2  , 3, 0);
		Button  btnSave2    = new Button  (sSave  ); gpImg2Btns.add(btnSave2  , 4, 0);
		
		// IMG3 BUTTONS
		GridPane gpImg3Btns = new GridPane(       );
		Button  btnRotate3  = new Button  (sRotate); gpImg3Btns.add(btnRotate3, 0, 0);
		Button  btnReset3   = new Button  (sReset ); gpImg3Btns.add(btnReset3 , 1, 0);
		Button  btnSave3    = new Button  (sSave  ); gpImg3Btns.add(btnSave3  , 2, 0);

		// FX BUTTONS
		GridPane gpFXBtns  = new GridPane(        );
		Button  btnChecker = new Button  (sChecker); gpFXBtns.add(btnChecker, 0, 0);
		Button  btnStripeH = new Button  (sStripeH); gpFXBtns.add(btnStripeH, 0, 1);
		Button  btnStripeV = new Button  (sStripeV); gpFXBtns.add(btnStripeV, 0, 2);

		// MAIN PANE
		GridPane  gpMain = new GridPane (     );
		Label    lblImg1 = new Label    (sImg1); gpMain.add(lblImg1    , 0, 1      );
		ImageView ivImg1 = new ImageView(     ); gpMain.add( ivImg1    , 0, 2      );
		                                         gpMain.add( gpImg1Btns, 0, 3      );
		Label    lblImg2 = new Label    (sImg2); gpMain.add(lblImg2    , 0, 4      );
		ImageView ivImg2 = new ImageView(     ); gpMain.add( ivImg2    , 0, 5      );
                                                         gpMain.add( gpImg2Btns, 0, 6      );
		Label    lblFX   = new Label    (sFX  ); gpMain.add(lblFX      , 1, 1      );
                                                         gpMain.add( gpFXBtns  , 1, 2, 1, 2);
		Label    lblImg3 = new Label    (sImg3); gpMain.add(lblImg3    , 1, 4      );
		ImageView ivImg3 = new ImageView(     ); gpMain.add( ivImg3    , 1, 5      );
		                                         gpMain.add( gpImg3Btns, 1, 6      );
		
		// MENUBAR
		GridPane gpRoot = new GridPane (      ); gpRoot.add( gpMain, 0, 1);
		MenuBar mbrRoot = new MenuBar  (      ); gpRoot.add(mbrRoot, 0, 0);
	        Menu    menFile = new Menu     ("File");
	        Menu    menHelp = new Menu     ("Help");
	        mbrRoot.getMenus().addAll(menFile, menHelp);

		// SPACING
		gpFXBtns  .setHgap   (10);
		gpFXBtns  .setVgap   (10);
		gpImg1Btns.setHgap   (10);
		gpImg1Btns.setVgap   (10);
		gpImg2Btns.setHgap   (10);
		gpImg2Btns.setVgap   (10);
		gpImg3Btns.setHgap   (10);
		gpImg3Btns.setVgap   (10);
		gpMain    .setPadding(new Insets(0, 25, 25, 25));
		gpMain    .setHgap   (10);
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
		
		// IMAGE-SETTINGS
		ivImg1.setFitWidth(300); ivImg1.setPreserveRatio(true); ivImg1.setSmooth(true); ivImg1.setCache(true);
		ivImg2.setFitWidth(300); ivImg2.setPreserveRatio(true); ivImg2.setSmooth(true); ivImg2.setCache(true);
		ivImg3.setFitWidth(300); ivImg3.setPreserveRatio(true); ivImg3.setSmooth(true); ivImg3.setCache(true);
		
		// ACTIONS
		//TODO
		
		//URL           url   = new URL         ("" );
		//BufferedImage image =     ImageIO.read(url);

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
