package cs1302.p3                                      ;
import  cs1302.effects.Artsy                           ;
import  java.awt.image.BufferedImage                   ;
import  java.io.File                                   ;
import  java.net.URL                                   ;
import  javax.imageio.ImageIO                          ;
import  javax.swing.JFileChooser                       ;
import  javax.swing.filechooser.FileNameExtensionFilter;
import  javafx.application.Application                 ;
import  javafx.embed.swing.SwingFXUtils                ;
import  javafx.geometry.Insets                         ;
import  javafx.scene.Scene                             ;
import  javafx.scene.control.Button                    ;
import  javafx.scene.control.Label                     ;
import  javafx.scene.control.Menu                      ;
import  javafx.scene.control.MenuBar                   ;
import  javafx.scene.control.MenuItem                  ;
import  javafx.scene.control.SeparatorMenuItem         ;
import  javafx.scene.control.TextInputDialog           ;
import  javafx.scene.image.Image                       ;
import  javafx.scene.image.ImageView                   ;
import javafx.scene.layout.FlowPane;
import  javafx.scene.layout.GridPane                   ;
import  javafx.stage.Stage                             ;

/** This is the runner for this application.
 * @author Miles B Huff
 * @author Preston Sheppard
**/
public class Driver extends Application
{ //+class
	// RESOURCES -----------------------------------------
	Image img1  = new Image("file:res/images/default.png");
	Image img10 = new Image("file:res/images/default.png");
	Image img2  = new Image("file:res/images/default.png");
	Image img20 = new Image("file:res/images/default.png");
	Image img3  = new Image("file:res/images/default.png");
	
	////////////////////////////////////////////////////////////////////////
	/** Creates a GUI for the application.  (yes, we did this by hand.)
	 * @author Miles B Huff (everything else)
	 * @author Preston Sheppard (events)
	 * @param stage The window on which to display
	**/
	@Override
	public void start(Stage stgRoot)
	{ //+method
		// SPLASH ----------------------------------
		FlowPane fpSplash  = new FlowPane(        );
		Scene   sceSplash  = new Scene   (fpSplash);
		stgRoot.setScene   (sceSplash);
		stgRoot.setTitle   ("Artsy!" );
		stgRoot.sizeToScene(         );
		stgRoot.show       (         );
		
		// DATA -----------------------------------
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
		
		// RESOURCES -------------------------------------------------
		Artsy art        = new MyArtsy(                             );
		Image img0       = new Image  ("file:res/images/default.png");
		Image imgChecker = new Image  ("file:res/icons/checker.png" );
		Image imgOpen    = new Image  ("file:res/icons/open.png"    );
		Image imgReset   = new Image  ("file:res/icons/reset.png"   );
		Image imgRotate  = new Image  ("file:res/icons/rotate.png"  );
		Image imgSave    = new Image  ("file:res/icons/save.png"    );
		Image imgStripeH = new Image  ("file:res/icons/stripeH.png" );
		Image imgStripeV = new Image  ("file:res/icons/stripeV.png" );
		Image imgUrl     = new Image  ("file:res/icons/url.png"     );
		
		// IMG1 BUTTONS -----------------------------------------------------------------
		GridPane gpImg1Btns = new GridPane(          );
		Button  btnRotate1  = new Button  (sBtnRotate); gpImg1Btns.add(btnRotate1, 0, 0);
		Button  btnReset1   = new Button  (sBtnReset ); gpImg1Btns.add(btnReset1 , 1, 0);
		Button  btnUrl1     = new Button  (sBtnUrl   ); gpImg1Btns.add(btnUrl1   , 2, 0);
		Button  btnOpen1    = new Button  (sBtnOpen  ); gpImg1Btns.add(btnOpen1  , 3, 0);
		Button  btnSave1    = new Button  (sBtnSave  ); gpImg1Btns.add(btnSave1  , 4, 0);
		
		// IMG2 BUTTONS -----------------------------------------------------------------
		GridPane gpImg2Btns = new GridPane(          );
		Button  btnRotate2  = new Button  (sBtnRotate); gpImg2Btns.add(btnRotate2, 0, 0);
		Button  btnReset2   = new Button  (sBtnReset ); gpImg2Btns.add(btnReset2 , 1, 0);
		Button  btnUrl2     = new Button  (sBtnUrl   ); gpImg2Btns.add(btnUrl2   , 2, 0);
		Button  btnOpen2    = new Button  (sBtnOpen  ); gpImg2Btns.add(btnOpen2  , 3, 0);
		Button  btnSave2    = new Button  (sBtnSave  ); gpImg2Btns.add(btnSave2  , 4, 0);
		
		// IMG3 BUTTONS -----------------------------------------------------------------
		GridPane gpImg3Btns = new GridPane(          );
		Button  btnRotate3  = new Button  (sBtnRotate); gpImg3Btns.add(btnRotate3, 0, 0);
		Button  btnReset3   = new Button  (sBtnReset ); gpImg3Btns.add(btnReset3 , 1, 0);
		Button  btnSave3    = new Button  (sBtnSave  ); gpImg3Btns.add(btnSave3  , 2, 0);

		// FX BUTTONS -----------------------------------------------------------------
		GridPane gpFXBtns  = new GridPane(           );
		Button  btnChecker = new Button  (sBtnChecker); gpFXBtns.add(btnChecker, 0, 0);
		Button  btnStripeH = new Button  (sBtnStripeH); gpFXBtns.add(btnStripeH, 0, 1);
		Button  btnStripeV = new Button  (sBtnStripeV); gpFXBtns.add(btnStripeV, 0, 2);

		// MAIN PANE -------------------------------------------------------------------
		GridPane  gpMain = new GridPane (        );
		Label    lblImg1 = new Label    (sLblImg1); gpMain.add(lblImg1    , 0, 0      );
		ImageView ivImg1 = new ImageView(        ); gpMain.add( ivImg1    , 0, 1      );
		                                            gpMain.add( gpImg1Btns, 0, 2      );
		Label    lblImg2 = new Label    (sLblImg2); gpMain.add(lblImg2    , 1, 0      );
		ImageView ivImg2 = new ImageView(        ); gpMain.add( ivImg2    , 1, 1      );
                                                            gpMain.add( gpImg2Btns, 1, 2      );
		Label    lblImg3 = new Label    (sLblImg3); gpMain.add(lblImg3    , 2, 0      );
		ImageView ivImg3 = new ImageView(        ); gpMain.add( ivImg3    , 2, 1      );
		                                            gpMain.add( gpImg3Btns, 2, 2      );
		Label    lblFX   = new Label    (sLblFX  ); gpMain.add(lblFX      , 3, 0      );
                                                            gpMain.add( gpFXBtns  , 3, 1, 1, 2);
		
		// ROOT PANE -----------------------------------------------
		GridPane gpRoot = new GridPane(); gpRoot.add( gpMain, 0, 1);
		MenuBar mbrRoot = new MenuBar (); gpRoot.add(mbrRoot, 0, 0);
		
		// MENUBAR-INSTANTIATION ---------------------------------------------------------------------------------------------------------
		Menu     menFile           = new          Menu    ("File"                                                                       );
		Menu     menFileOpen       = new          Menu    ("Open from file"     , new ImageView(new Image("file:res/icons/open.png"   )));
		MenuItem menFileOpenImg1   = new          MenuItem("Image 1"                                                                    );
		MenuItem menFileOpenImg2   = new          MenuItem("Image 2"                                                                    );
		Menu     menFileUrl        = new          Menu    ("Open from URL"      , new ImageView(new Image("file:res/icons/url.png"    )));
		MenuItem menFileUrlImg1    = new          MenuItem("Image 1"                                                                    );
		MenuItem menFileUrlImg2    = new          MenuItem("Image 2"                                                                    );
		MenuItem menFileSeparator1 = new SeparatorMenuItem(                                                                             );
		Menu     menFileReset      = new          Menu    ("Reset"              , new ImageView(new Image("file:res/icons/reset.png"  )));
		MenuItem menFileResetImg1  = new          MenuItem("Image 1"                                                                    );
		MenuItem menFileResetImg2  = new          MenuItem("Image 2"                                                                    );
		MenuItem menFileResetImg3  = new          MenuItem("Image 3"                                                                    );
		Menu     menFileSave       = new          Menu    ("Save"               , new ImageView(new Image("file:res/icons/save.png"   )));
		MenuItem menFileSaveImg1   = new          MenuItem("Image 1"                                                                    );
		MenuItem menFileSaveImg2   = new          MenuItem("Image 2"                                                                    );
		MenuItem menFileSaveImg3   = new          MenuItem("Image 3"                                                                    );
		MenuItem menFileClose      = new          MenuItem("Close"                                                                      );
		MenuItem menFileSeparator2 = new SeparatorMenuItem(                                                                             );
		Menu     menEdit           = new          Menu    ("Edit"                                                                       );
		Menu     menEditRotate     = new          Menu    ("Rotate"             , new ImageView(new Image("file:res/icons/rotate.png" )));
		MenuItem menEditRotateImg1 = new          MenuItem("Image 1"                                                                    );
		MenuItem menEditRotateImg2 = new          MenuItem("Image 2"                                                                    );
		MenuItem menEditRotateImg3 = new          MenuItem("Image 3"                                                                    );
		MenuItem menEditSeparator  = new SeparatorMenuItem(                                                                             );
		MenuItem menEditChecker    = new          MenuItem("Checker"            , new ImageView(new Image("file:res/icons/checker.png")));
		MenuItem menEditStripeH    = new          MenuItem("Stripe horizontally", new ImageView(new Image("file:res/icons/stripeH.png")));
		MenuItem menEditStripeV    = new          MenuItem("Stripe vertically"  , new ImageView(new Image("file:res/icons/stripeV.png")));
	        
		// MENUBAR-FINALIZATION ----------------------------------------------------------------------------------------------------------------------------------
		mbrRoot      .getMenus().addAll(menFile          , menEdit                                                                                              );
		menFile      .getItems().addAll(menFileOpen      , menFileUrl       , menFileSeparator1, menFileReset  , menFileSave   , menFileSeparator2, menFileClose);
		menFileOpen  .getItems().addAll(menFileOpenImg1  , menFileOpenImg2                                                                                      );
		menFileUrl   .getItems().addAll(menFileUrlImg1   , menFileUrlImg2                                                                                       );
		menFileReset .getItems().addAll(menFileResetImg1 , menFileResetImg2 , menFileResetImg3                                                                  );
		menFileSave  .getItems().addAll(menFileSaveImg1  , menFileSaveImg2  , menFileSaveImg3                                                                   );
		menEdit      .getItems().addAll(menEditRotate    , menEditSeparator , menEditChecker   , menEditStripeH, menEditStripeV                                 );
		menEditRotate.getItems().addAll(menEditRotateImg1, menEditRotateImg2, menEditRotateImg3                                                                 );
	        
		// IMAGES ---------------------------------------
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

		// IMAGEVIEW-SETTINGS --------------------------------------------------------------------------------
		ivImg1.setFitWidth(300); ivImg1.setPreserveRatio(true); ivImg1.setSmooth(true); ivImg1.setCache(true);
		ivImg2.setFitWidth(300); ivImg2.setPreserveRatio(true); ivImg2.setSmooth(true); ivImg2.setCache(true);
		ivImg3.setFitWidth(300); ivImg3.setPreserveRatio(true); ivImg3.setSmooth(true); ivImg3.setCache(true);

		// SPACING --------------------------------------
		gpFXBtns  .setHgap   (    10                   );
		gpFXBtns  .setVgap   (    10                   );
		gpImg1Btns.setHgap   (    10                   );
		gpImg1Btns.setVgap   (    10                   );
		gpImg2Btns.setHgap   (    10                   );
		gpImg2Btns.setVgap   (    10                   );
		gpImg3Btns.setHgap   (    10                   );
		gpImg3Btns.setVgap   (    10                   );
		gpMain    .setHgap   (    10                   );
		gpMain    .setPadding(new Insets(0, 25, 25, 25));
		gpMain    .setVgap   (    10                   );
		gpRoot    .setHgap   (    10                   );
		gpRoot    .setVgap   (    10                   );

		// DIALOG-INSTANTIATION ---------------------------
		TextInputDialog diaChecker = new TextInputDialog();
		TextInputDialog diaRotate  = new TextInputDialog();
		TextInputDialog diaStripeH = new TextInputDialog();
		TextInputDialog diaStripeV = new TextInputDialog();
		TextInputDialog diaUrl     = new TextInputDialog();

		// DIALOG-TITLING ---------------------
		diaChecker.setTitle("Checker options");
		diaStripeH.setTitle("Stripe options" );
		diaStripeV.setTitle("Stripe options" );
		diaRotate .setTitle("Rotate options" );
		diaUrl    .setTitle("Open from URL"  );

		// DIALOG-HEADERS -------------------------------------------------------------------------------------------
		diaChecker.setHeaderText("Please enter the width of each checker:"                                         );
		diaStripeH.setHeaderText("Please enter the height of each stripe:"                                         );
		diaStripeV.setHeaderText("Please enter the width of each stripe:"                                          );
		diaRotate .setHeaderText("Please enter the number of degrees by which you would like to rotate this image:");
		diaUrl    .setHeaderText("Please enter the URL from which you'd like to load an image:"                    );

		// FILE-DIALOG --------------------------------------------------------------------
		JFileChooser            chooser = new JFileChooser           (                   );
		FileNameExtensionFilter filter  = new FileNameExtensionFilter("PNG Images", "png");
		chooser.setFileFilter(filter);

		// EFFECTS-ACTIONS ----------------------------------
		btnChecker.setOnAction(event -> {
			diaChecker.showAndWait();
			String s = diaChecker.getResult();
			System.out.println(s);
			int i = Integer.parseInt(s);
			img3 = art.doCheckers(img1,img2, i);
			ivImg3.setImage(img3);
		});
		menEditChecker.setOnAction(btnChecker.getOnAction());
		btnStripeH.setOnAction(event -> {
			diaStripeH.showAndWait();
			String s = diaStripeH.getResult();
			int i = Integer.parseInt(s);
			img3 = art.doStripesHorizontal(img1,img2, i);
			ivImg3.setImage(img3);
		});
		menEditStripeH.setOnAction(btnStripeH.getOnAction());
		btnStripeV.setOnAction(event -> {
			diaStripeV.showAndWait();
			String s = diaStripeV.getResult();
			System.out.println(s);
			int i = Integer.parseInt(s);
			img3 = art.doStripesVertical(img1,img2, i);
			ivImg3.setImage(img3);
		});
		menEditStripeV.setOnAction(btnStripeV.getOnAction());
		
		// OPEN-ACTIONS ---------------------------------------------------------
		btnOpen1.setOnAction(event -> {
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{ //+if
				lblImg1.setText(sLblImg1 + chooser.getSelectedFile().getName ());
				img1 = new Image("file:" + chooser.getSelectedFile().toString());
			} //-if
			img10 = img1;
			ivImg1.setImage(img1);
		});
		menFileOpenImg1.setOnAction(btnOpen1.getOnAction());
		btnOpen2.setOnAction(event -> {
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{ //+if
				lblImg2.setText(sLblImg2 + chooser.getSelectedFile().getName ());
				img2 = new Image("file:" + chooser.getSelectedFile().toString());
			} //-if
			img20 = img2;
			ivImg2.setImage(img2);
		});
		menFileOpenImg2.setOnAction(btnOpen2.getOnAction());
		
		// RESET-ACTIONS -------------------------------------
		btnReset1.setOnAction(event -> {
			img1 = img10;
			ivImg1.setImage(img1);
		});
		menFileResetImg1.setOnAction(btnReset1.getOnAction());
		btnReset2.setOnAction(event -> {
			img2 = img20;
			ivImg2.setImage(img2);
		});
		menFileResetImg2.setOnAction(btnReset2.getOnAction());
		btnReset3.setOnAction(event -> {
			img3 = img0;
			ivImg3.setImage(img3);
		});
		menFileResetImg3.setOnAction(btnReset3.getOnAction());
		
		// ROTATE-ACTIONS --------------------------------------
		btnRotate1.setOnAction(event -> {
			diaRotate.showAndWait();
			String s = diaRotate.getResult();
			System.out.println(s);
			int i = Integer.parseInt(s);
			img1=art.doRotate(img1, i);
			ivImg1.setImage(img1);
		});
		menEditRotateImg1.setOnAction(btnRotate1.getOnAction());
		btnRotate2.setOnAction(event -> {
			diaRotate.showAndWait();
			String s = diaRotate.getResult();
			System.out.println(s);
			int i = Integer.parseInt(s);
			img2=art.doRotate(img2, i);
			ivImg2.setImage(img2);
		});
		menEditRotateImg2.setOnAction(btnRotate3.getOnAction());
		btnRotate3.setOnAction(event -> {
			diaRotate.showAndWait();
			String s = diaRotate.getResult();
			System.out.println(s);
			int i = Integer.parseInt(s);
			img3 = art.doRotate(img3, i);
			ivImg3.setImage(img3);
		});
		menEditRotateImg3.setOnAction(btnRotate3.getOnAction());

		// SAVE-ACTIONS ---------------------------------------------------------------------------------
		//TODO:  btnSave1
		menFileSaveImg1.setOnAction(event -> {
			int returnVal = chooser.showSaveDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{ //+if
				File          filImg1 = new File("file:" + chooser.getSelectedFile().toString());
				BufferedImage bImg1   =     SwingFXUtils.fromFXImage(img1, null);
				try {ImageIO.write(bImg1, ".png", filImg1);}
				catch (Exception e) {e.printStackTrace();}
			} //-if
		});
		menFileSaveImg1.setOnAction(btnSave1.getOnAction());
		//TODO:  btnSave2
		menFileSaveImg2.setOnAction(btnSave2.getOnAction());
		//TODO:  btnSave3
		menFileSaveImg3.setOnAction(btnSave3.getOnAction());

		// URL-ACTIONS ---------------------------------------
		//TODO:  Doesn't work yet.
		btnUrl1.setOnAction(event -> {
			diaUrl.showAndWait();
			lblImg1.setText(sLblImg1);
			try
			{ //+try
				URL url = new URL(diaUrl.getResult());
				//img1 = new Image(url);
				ivImg1.setImage(img1);
			} //-try
			catch(Exception exc) {exc.printStackTrace();}
			lblImg1.setText(sLblImg1 + "(web)");
		});
		menFileUrlImg1.setOnAction(btnUrl1.getOnAction());
		btnUrl2.setOnAction(event -> {
			lblImg2.setText(sLblImg2);
			try
			{ //+try
				URL url = new URL(diaUrl.getResult());
				//img2 = new Image(url);
				ivImg2.setImage(img2);
			} //-try
			catch(Exception exc) {exc.printStackTrace();}
			lblImg1.setText(sLblImg2 + "(web)");
		});
		menFileUrlImg2.setOnAction(btnUrl2.getOnAction());

		// OTHER ACTIONS ----------------------------------------------------
		menFileClose.setOnAction(event -> {stgRoot.hide(); System.exit(0);});
		
		// KONAMI-STAGE -----------------------------------------------------
		Image    imgKonami = new Image    ("file:res/images/xtrakr3d1t.png");
		FlowPane  fpKonami = new FlowPane (                                );
		ImageView ivKonami = new ImageView(imgKonami                       );
		 fpKonami.getChildren().add(ivKonami);
		Scene    sceKonami = new Scene    (fpKonami                        );
		Stage    stgKonami = new Stage    (                                );
		stgKonami.setScene   (sceKonami   );
		stgKonami.setTitle   ("Easter-Egg");
		stgKonami.sizeToScene(            );

		// SET THE STAGE -----------------
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
