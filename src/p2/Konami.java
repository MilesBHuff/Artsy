public class Konami()
{
        Queue queue = new ArrayBlockingQueue<String>(6);
        public static boolean analyze(String sArg)
        {
        	queue.add(sArg);
        	if(queue.toString().equals("11223434AB")) return true;
        	return false;
        }
}
