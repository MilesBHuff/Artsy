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
                	if(que.toString().equals("[1, 1, 2, 2, 3, 4, 3, 4, A, B]")) return true;
                } //-if
        	return false;
        } //-method
} //-class
