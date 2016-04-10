package p2                                     ;
import  java.util.concurrent.ArrayBlockingQueue;

/** A class to implement the Konami extra-credit task.
 * @author Miles B Huff
 * @author Preston Sheppard
**/
public class Konami
{ //+class
        static ArrayBlockingQueue<String> que = new ArrayBlockingQueue<String>(6);
        
        /** Adds <code>sArg</code> to <code>que</code> and checks if it matches the Konami code.
         * @author Miles B Huff
         * @param  sArg Which key has been pressed
         * @return <code>true</code> if <code>que</code> matches the Konami code.
        **/
        public static boolean analyze(String sArg) throws InterruptedException
        { //+method
        	que.put(sArg);  // Adds sArg as soon as there's space in que
                if(que.size() == 6)
                { //+if
                        que.take();  // Removes the head of the queue
                	if(que.toString().equals("[1, 1, 2, 2, 3, 4, 3, 4, 5, 6]")) return true;
                } //-if
        	return false;
        } //-method
        
        /** Takes a <code>KeyEvent</code>, analyzes it, and returns <code>true</code> if it matches the Konami code.
         * @author Preston Sheppard
         * @author Miles B Huff
         * @param  ke A <code>KeyEvent</code>
         * @return <code>true</code> if <code>que</code> matches the Konami code.
        **/
        public static boolean keyInput(KeyEvent ke)
        { //+method
                switch(ke.getKeyCode())
                { //+case
                        case KeyEvent.VK_UP:
                                return analyze(1);
                                break;      // 1: up
                        case KeyEvent.VK_DOWN:
                                return analyze(2);
                                break;      // 2: down
                        case KeyEvent.VK_LEFT:
                                return analyze(3);
                                break;      // 3: left
                        case KeyEvent.VK_RIGHT:
                                return analyze(4);
                                break;      // 4: right
                        case 65:
                                return analyze(5);
                                break;      // 5: a
                        case 66:
                                return analyze(6);
                                break;      // 6: b
                        default:
                        	return false;
                } //-case
	} //-method
} //-class
