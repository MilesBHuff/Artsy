package p2                                     ;
import  java.util.concurrent.ArrayBlockingQueue;

public class Konami
{ //+class
        static ArrayBlockingQueue<String> que = new ArrayBlockingQueue<String>(6);
        
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
        
        /**
         * @param 
        **/
        public static boolean keyInput(KeyEvent ke)
        { //+method
                switch(ke.getKeyCode())
                { //+case
                        case KeyEvent.VK_UP:     // 1: up
                                return analyze(1);
                                break;
                        case KeyEvent.VK_DOWN:   // 2: down
                                return analyze(2);
                                break;
                        case KeyEvent.VK_LEFT:   // 3: left
                                return analyze(3);
                                break;
                        case KeyEvent.VK_RIGHT:  // 4: right
                                return analyze(4);
                                break;
                        case 65:                 // 5: a
                                return analyze(5);
                                break;
                        case 66:                 // 6: b
                                return analyze(6);
                                break;
                } //-case
	} //-method
} //-class
