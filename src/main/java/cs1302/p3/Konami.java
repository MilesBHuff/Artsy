package cs1302.p3                              ;
import  java.util.concurrent.ArrayBlockingQueue;
import  javafx.scene.Scene                     ;
import  javafx.scene.image.Image               ;
import  javafx.scene.image.ImageView           ;
import  javafx.scene.input.KeyEvent            ;
import  javafx.scene.layout.FlowPane           ;
import  javafx.stage.Stage                     ;

/** A class to implement the Konami extra-credit task.
 * @author Miles B Huff
 * @author Preston Sheppard
**/
public class Konami
{ //+class
	static ArrayBlockingQueue<String> que = new ArrayBlockingQueue<String>(10);
	
	/** Adds <code>sArg</code> to <code>que</code> and checks if it matches the Konami code.
	 * @author Miles B Huff
	 * @param  sArg Which key has been pressed
	 * @return <code>true</code> if <code>que</code> matches the Konami code.
	**/
	private static boolean analyze(String sArg)
	{ //+method
		try
		{ //+try
			if(que.size() == 10) que.take();  // Removes the head of the queue
			que.put(sArg);                    // Adds sArg as soon as there's space in que
			System.out.println(que.toString());
			if(que.toString().equals("[1, 1, 2, 2, 3, 4, 3, 4, 5, 6]")) return true;
		} //-try
		catch(InterruptedException exc) {exc.printStackTrace();}
		return false;
	} //-method
	
	/** Takes a <code>KeyEvent</code>, analyzes it, and returns <code>true</code> if it matches the Konami code.
	 * @author Miles B Huff
	 * @param  ke A <code>KeyEvent</code>
	**/
	public static void keyInput(KeyEvent key)
	{ //+method
		String s = key.getCode().toString();
		System.out.println(s);
		switch(s)
		{ //+case
			case "UP":
				if(analyze("1")) showKonami();  // 1: up
				break;
			case "DOWN":
				if(analyze("2")) showKonami();  // 2: down
				break;
			case "LEFT":
				if(analyze("3")) showKonami();  // 3: left
				break;
			case "RIGHT":
				if(analyze("4")) showKonami();  // 4: right
				break;
			case "A":
				if(analyze("5")) showKonami();  // 5: a
				break;
			case "B":
				if(analyze("6")) showKonami();  // 6: b
				break;
			default:
				   analyze("0")              ;  // 0: invalid key
				break;
		} //-case
	} //-method
	
	/** Shows the easter-egg
	 * @author Miles B Huff
	**/
	private static void showKonami()
	{ //+method
		Image    imgKonami = new Image    ("file:res/images/xtrakr3d1t.png");
		FlowPane  fpKonami = new FlowPane (                                );
		ImageView ivKonami = new ImageView(imgKonami                       );
		 fpKonami.getChildren().add(ivKonami);
		Scene    sceKonami = new Scene    (fpKonami                        );
		Stage    stgKonami = new Stage    (                                );
		stgKonami.setScene   (sceKonami   );
		stgKonami.setTitle   ("Easter-Egg");
		stgKonami.sizeToScene(            );
		stgKonami.show       (            );
	} //-method
} //-class
