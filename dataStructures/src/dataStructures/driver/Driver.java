package dataStructures.driver;

// Import all the classes and interfaces
import dataStructures.util.MyLogger;
import dataStructures.util.Results;
import dataStructures.util.FileProcessor;

public class Driver {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println("You should provide three args to test.");
            System.err.println("(1): -Darg0=<input.txt>");
            System.err.println("(2): -Darg1=put..printlntxt>");
            System.err.println("(3): -Darg2=<data_structure_to_test>");
            System.err.println("(4): -Darg3=<debug_level>");
        }

        MyLogger.writeMessage("Setting the debug level...", MyLogger.DebugLevel.IN_RUN);

        int debug_level = 0;
        try {
			debug_level = Integer.parseInt(args[2]);
			if(debug_level < 0 || debug_level > 4)
				throw new IllegalArgumentException("Debug levels 0-4(inclusive) supported.");
		} catch(Exception e){
			System.err.println("[Exception Caught]: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

        // Set Degug level
        MyLogger.setDebugValue(debug_level);

        String line = "";
        FileProcessor filep = new FileProcessor(args[0], 0);
        Results results = new Results(args[1]);

        MyLogger.writeMessage("Starting the data structures test...", MyLogger.DebugLevel.IN_RUN);
        int test = Integer.parseInt(args[2]);
        switch (test) {
            case 0:
                // Linked List test
                break;
            case 1:
                // Stack test
                StackTestDriver stackTest = new StackTestDriver(filep, results);
                stackTest.run();
                results.dumpToFile();
                results.closeIO();

                break;
            case 2:
                // Queue test
                QueueTestDriver queueTest = new QueueTestDriver(filep, results);
                queueTest.run();
                results.dumpToFile();
                results.closeIO();

                break;
            case 3:
                // Binary Search Tree test
                break;
        }
    }
}