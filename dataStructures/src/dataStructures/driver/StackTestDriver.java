package dataStructures.driver;

import dataStructures.myDataStructures.Stack;
import dataStructures.util.Results;
import dataStructures.util.MyLogger;
import dataStructures.util.FileProcessor;

public class StackTestDriver {
    private FileProcessor filep;
    private Results results;

    private String inputFile = "input.txt";
    private String outputFile = "output.txt";

    public StackTestDriver(FileProcessor filep, Results results) {
        this.filep = filep;
        this.results = results;
    }

    public void run() {
        String line = "";
        Stack stack = new Stack(100);

        for (int i = 0; line != null; i++) {
            try {
                MyLogger.writeMessage("Reading line...", MyLogger.DebugLevel.IN_RUN);
                line = filep.readLine();

                if (line == null) break;

                int num = Integer.parseInt(line);
                stack.push(num);
            } catch (Exception e) {
                System.err.println("[Exception Caught]: " + e.getMessage());
                e.printStackTrace();
                System.exit(1);
            }
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            results.writeToFile(Integer.toString(stack.pop()));
        }

        if (!stack.isEmpty())
            stack.peek();
    }
}