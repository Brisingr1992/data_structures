package dataStructures.util;

import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Arrays;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private Queue<String> resultQueue;
    private FileProcessor filep;

    public Results(String filename) {
        MyLogger.writeMessage("Initializing Results constructor.", MyLogger.DebugLevel.CONSTRUCTOR);

        filep = new FileProcessor(filename, 1);
        resultQueue = new LinkedList<String>();
    }

    public void addResult(String result) {
        MyLogger.writeMessage("[RESULTS]: addResult method", MyLogger.DebugLevel.RESULTS);

        if (result.length() != 0)
            resultQueue.add(result);
    }

	public void writeToFile(String s) {
        MyLogger.writeMessage("[RESULTS]: writeToFile method", MyLogger.DebugLevel.RESULTS);

        if (filep == null) {
            System.err.println("[Err]: Cannot write to empty file.");
            return;
        }

        filep.writeLine(s);
	}

	public void writeToStdout(String s) {
        MyLogger.writeMessage("[RESULTS]: writeToStdout method", MyLogger.DebugLevel.RESULTS);

        System.out.println(s); 
	}

    public void dumpToFile() {
        MyLogger.writeMessage("[RESULTS]: dumpToFile method", MyLogger.DebugLevel.RESULTS);

        this.writeToStdout("Writing to output.txt ...");

        String result = "";
        while (result != null) {
            result = resultQueue.poll();
            if (result != null) {
                // writeToStdout(result);
                this.writeToFile(result);
            }
        }
    }

    public void writeStateResults(String[] raceStates) {
        MyLogger.writeMessage("[RESULTS]: writeStateResults method", MyLogger.DebugLevel.RESULTS);

        // Write to stdoutput
        this.writeToStdout(Arrays.toString(raceStates));

        // Form a line of the result
        String driverStates = "";
        for (int i = 0; i < raceStates.length; i++) {
            driverStates += raceStates[i] + " ";
        }

        this.addResult(driverStates);
    }

    public void closeIO() {
        MyLogger.writeMessage("[RESULTS]: closeIO method", MyLogger.DebugLevel.RESULTS);
        
        filep.closeFile();
    }
}
