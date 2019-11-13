import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class runFullExpirament {



    /* define constants */

    //static int numberOfTrials = 50;

    //static int MAXNUMDIGITS  = 50;

    static int MINNUMDIGITS  =  1;

    // static int SIZEINCREMENT =  10000000; // not using this since we are doubling the size each time
    static int min = 1;
    static int max = 10;


    static String ResultsFolderPath = "/home/wyatt/Results/lab6/FiboTests/FiboFormula/FiboFormulaIOUS/"; // pathname to results folder

    static FileWriter resultsFile;

    static PrintWriter resultsWriter;

    //function to run full experiment
    static void runFullExperiment(String resultsFileName, String test){


        //trying to write to file and displaying error message if it fails
        try {

            resultsFile = new FileWriter(ResultsFolderPath + resultsFileName);

            resultsWriter = new PrintWriter(resultsFile);

        } catch(Exception e) {

            System.out.println("*****!!!!!  Had a problem opening the results file "+ResultsFolderPath+resultsFileName);

            return; // not very foolproof... but we do expect to be able to create/open the file...

        }


        // instantiating stopwatch class
        threadCpuStopWatch BatchStopwatch = new threadCpuStopWatch(); // for timing an entire set of trials

        threadCpuStopWatch TrialStopwatch = new threadCpuStopWatch(); // for timing an individual trial


        //printing to file
        resultsWriter.println("#HowManyBitsInputSizeIs    AverageTime    "); // # marks a comment in gnuplot data
        //flushing so it immediately goes to file and not a queue
        resultsWriter.flush();

        if(test.contains("XTests")) {
            int MAXNUMDIGITS = 100000;
            int numberOfTrials = 50;
            // start at fib number 0 and goes to the number in the sequence specified by MAXFIBONUMBERSIZE
            for (int numOfDigits = 1; numOfDigits <= MAXNUMDIGITS; numOfDigits *= 2) {

                // progress message...
                System.out.println("Running test for numOfDigits " + numOfDigits + " ... ");

                long batchElapsedTime = 0;

                //forcing garbage collection
                System.gc();

                // run the trials
                for (int trial = 0; trial < numberOfTrials; trial++) {
                    //long rand = ThreadLocalRandom.current().nextLong(min,max);
                    //MyBigInteger x = new MyBigInteger(generateRandomIOUS(numOfDigits));
                    //MyBigInteger y = new MyBigInteger(generateRandomIOUS(numOfDigits));
                    TrialStopwatch.start();
                    FibonacciFunctions.fiboMatrixFunction(numOfDigits);
                    for (int spin = 0; spin < 100000000; spin++) {
                        int count = 0;
                        count++;
                    }
                    batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();

                }

                // calculate the average time per trial in this batch
                double averageTimePerTrialInBatch = (double) batchElapsedTime / (double) numberOfTrials;



                /* print data for this size of input */

                resultsWriter.printf("%12d  %15.2f\n", countBitsLong(numOfDigits), averageTimePerTrialInBatch);
                //using flush so it immediately writes to file and does not go to queue
                resultsWriter.flush();

                System.out.println(" ....done.");
                //min*=10;
                //max*=10;

            }
        }
        else if(test.contains("Formula"))
        {
            int MAXNUMDIGITS = 100000;
            int numberOfTrials = 50;
            // start at fib number 0 and goes to the number in the sequence specified by MAXFIBONUMBERSIZE
            for (int numOfDigits = 1; numOfDigits <= MAXNUMDIGITS; numOfDigits*=2) {

                // progress message...
                System.out.println("Running test for numOfDigits " + numOfDigits + " ... ");

                long batchElapsedTime = 0;

                //forcing garbage collection
                System.gc();

                // run the trials
                for (int trial = 0; trial < numberOfTrials; trial++) {
                    //long rand = ThreadLocalRandom.current().nextLong(min,max);
                    //MyBigInteger x = new MyBigInteger(generateRandomIOUS(numOfDigits));
                    //MyBigInteger y = new MyBigInteger(generateRandomIOUS(numOfDigits));
                    TrialStopwatch.start();
                    FibonacciFunctions.fibFormulaBigInteger(numOfDigits);
                    for (int spin = 0; spin < 100000000; spin++) {
                        int count = 0;
                        count++;
                    }
                    batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();

                }

                // calculate the average time per trial in this batch
                double averageTimePerTrialInBatch = (double) batchElapsedTime / (double) numberOfTrials;



                /* print data for this size of input */

                resultsWriter.printf("%12d  %15.2f\n", countBitsLong(numOfDigits), averageTimePerTrialInBatch);
                //using flush so it immediately writes to file and does not go to queue
                resultsWriter.flush();

                System.out.println(" ....done.");
                //min*=10;
                //max*=10;

            }
        }
        else
        {
            int MAXNUMDIGITS = 50;
            int numberOfTrials = 50;
            // start at fib number 0 and goes to the number in the sequence specified by MAXFIBONUMBERSIZE
            min = 1;
            max = 10;
            for (int numOfDigits = MINNUMDIGITS; numOfDigits <= MAXNUMDIGITS; numOfDigits++) {

                // progress message...
                System.out.println("Running test for numOfDigits " + numOfDigits + " ... ");

                long batchElapsedTime = 0;

                //forcing garbage collection
                System.gc();

                // run the trials
                for (int trial = 0; trial < numberOfTrials; trial++) {
                    //long rand = ThreadLocalRandom.current().nextLong(0,50);
                    //MyBigInteger x = new MyBigInteger(generateRandomIOUS(numOfDigits));
                    //MyBigInteger y = new MyBigInteger(generateRandomIOUS(numOfDigits));
                    TrialStopwatch.start();
                    FibonacciFunctions.fiboLoop(numOfDigits);

                    batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();

                }

                // calculate the average time per trial in this batch
                double averageTimePerTrialInBatch = (double) batchElapsedTime / (double) numberOfTrials;



                /* print data for this size of input */

                resultsWriter.printf("%12d  %15.2f\n", countBitsLong(numOfDigits), averageTimePerTrialInBatch);
                //using flush so it immediately writes to file and does not go to queue
                resultsWriter.flush();

                System.out.println(" ....done.");
                min*=10;
                max*=10;

            }
        }

    }

    public static String generateRandomIOUS(int numDigits)
    {
        StringBuilder bigNum = new StringBuilder("");

        for(int i = 0; i < numDigits; i++) {
            int ranNum = ThreadLocalRandom.current().nextInt(0, 10);
            bigNum.insert(i, ranNum);
        }

        return bigNum.toString();
    }
    // a function to find the amount of bits of x (i. e. find n)
    public static long countBits(String numberToCountBitsOf)
    {
        byte[] toGetBits = numberToCountBitsOf.getBytes();
        int returnValue = toGetBits.length * 8;
        return returnValue;
    }

    public static long countBitsLong(long numberToCountBitsOf)
    {
        if(numberToCountBitsOf == 0)
        {
            return 1;
        }
        return (long)(Math.log(numberToCountBitsOf)/Math.log(2)+1);
    }
}
