import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Verification {
    public static long[] allTheFibNumbersLongsCanHold = {1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040,1346269,2178309,3524578,5702887,9227465,14930352,24157817,39088169,63245986,102334155,165580141,267914296,433494437,701408733,1134903170,1836311903,2971215073L,4807526976L,7778742049L,12586269025L,20365011074L,32951280099L,53316291173L,86267571272L,139583862445L,225851433717L,365435296162L,591286729879L,956722026041L,1548008755920L,2504730781961L,4052739537881L,6557470319842L,10610209857723L,17167680177565L,27777890035288L,44945570212853L,72723460248141L,117669030460994L,190392490709135L,308061521170129L,498454011879264L,806515533049393L,1304969544928657L,2111485077978050L,3416454622906707L,5527939700884757L,8944394323791464L,14472334024676221L,23416728348467685L,37889062373143906L,61305790721611591L,99194853094755497L,160500643816367088L,259695496911122585L,420196140727489673L,679891637638612258L,1100087778366101931L,1779979416004714189L,2880067194370816120L,4660046610375530309L};

    // Creates an array of random longs
    public static long[] createRandomArray(int amountOfNumbers)
    {
        Random random = new Random();

        long randomNumbersForTests[] = new long[amountOfNumbers];
        for(int i = 0; i < amountOfNumbers; i++)
        {
            randomNumbersForTests[i] = ThreadLocalRandom.current().nextLong(1000000);
        }

        return randomNumbersForTests;
    }

    public static void calculateAnswersWithLongsAddition(long[][] answerWithLongsAddition, long[] randomNumberForTests)
    {
        for(int i = 0; i < randomNumberForTests.length; i++)
        {
            for(int j = 0; j < randomNumberForTests.length; j++)
            {
                answerWithLongsAddition[i][j] = randomNumberForTests[i] + randomNumberForTests[j];
            }
        }
    }

    public static void calculateAnswersWithLongsMultiplication(long[][] answerWithLongsMultiplication, long[] randomNumberForTests)
    {
        for(int i = 0; i < randomNumberForTests.length; i++)
        {
            for(int j = 0; j < randomNumberForTests.length; j++)
            {
                answerWithLongsMultiplication[i][j] = randomNumberForTests[i] * randomNumberForTests[j];
            }
        }
    }

    public static void verifyExtremelyLongNumbersIOUS()
    {
        // 1
        MyBigInteger testOne = new MyBigInteger("999999999999999999999999999999999999999999999999999999");
        MyBigInteger testTwo = new MyBigInteger("1");
        MyBigInteger testAdditionAnswer = testOne.plus(testTwo);
        MyBigInteger testMultAnswer = testOne.times(testTwo);
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " + " + testTwo.getIntegerOfUnlimitedSize() + " = " + testAdditionAnswer.getIntegerOfUnlimitedSize());
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " * " + testTwo.getIntegerOfUnlimitedSize() + " = " + testMultAnswer.getIntegerOfUnlimitedSize());

        // 2
        testOne.setIntegerOfUnlimitedSize("33333333333333333333333333333333333333333333333333");
        testTwo.setIntegerOfUnlimitedSize("3");
        testAdditionAnswer = testOne.plus(testTwo);
        testMultAnswer = testOne.times(testTwo);
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " + " + testTwo.getIntegerOfUnlimitedSize() + " = " + testAdditionAnswer.getIntegerOfUnlimitedSize());
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " * " + testTwo.getIntegerOfUnlimitedSize() + " = " + testMultAnswer.getIntegerOfUnlimitedSize());

        // 3
        testOne.setIntegerOfUnlimitedSize("33333333333333333333333333333333333333333333333333");
        testTwo.setIntegerOfUnlimitedSize("111111111111111111111111111111111111111111111111111");
        testAdditionAnswer = testOne.plus(testTwo);
        testMultAnswer = testOne.times(testTwo);
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " + " + testTwo.getIntegerOfUnlimitedSize() + " = " + testAdditionAnswer.getIntegerOfUnlimitedSize());
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " * " + testTwo.getIntegerOfUnlimitedSize() + " = " + testMultAnswer.getIntegerOfUnlimitedSize());

        // 4
        testOne.setIntegerOfUnlimitedSize("500000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        testTwo.setIntegerOfUnlimitedSize("2");
        testAdditionAnswer = testOne.plus(testTwo);
        testMultAnswer = testOne.times(testTwo);
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " + " + testTwo.getIntegerOfUnlimitedSize() + " = " + testAdditionAnswer.getIntegerOfUnlimitedSize());
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " * " + testTwo.getIntegerOfUnlimitedSize() + " = " + testMultAnswer.getIntegerOfUnlimitedSize());

        // 5
        testOne.setIntegerOfUnlimitedSize("3000000000000000000000000000000000000000000000000000000000000000000000000000");
        testTwo.setIntegerOfUnlimitedSize("1000000000000000000000000000000000000000000000000000000000000000000000000000");
        testAdditionAnswer = testOne.plus(testTwo);
        testMultAnswer = testOne.times(testTwo);
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " + " + testTwo.getIntegerOfUnlimitedSize() + " = " + testAdditionAnswer.getIntegerOfUnlimitedSize());
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " * " + testTwo.getIntegerOfUnlimitedSize() + " = " + testMultAnswer.getIntegerOfUnlimitedSize());

        // 6
        testOne.setIntegerOfUnlimitedSize("5");
        testTwo.setIntegerOfUnlimitedSize("222222222222222222222222222222222222222222222222222222222222222222222222222222");
        testAdditionAnswer = testOne.plus(testTwo);
        testMultAnswer = testOne.times(testTwo);
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " + " + testTwo.getIntegerOfUnlimitedSize() + " = " + testAdditionAnswer.getIntegerOfUnlimitedSize());
        System.out.println("Problem: " + testOne.getIntegerOfUnlimitedSize() + " * " + testTwo.getIntegerOfUnlimitedSize() + " = " + testMultAnswer.getIntegerOfUnlimitedSize());
    }

    // getting and verify the answers
    public static boolean verifyIOUSFuncsGiveEquvalentAnswers(long answerWithLongsAddition[][], long answerWithLongsMultiplication[][], long randomNumbersForTests[])
    {
        boolean isEquivalent = true;
        for(int i = 0; i < randomNumbersForTests.length; i++)
        {
            for (int j = 0; j < randomNumbersForTests.length; j++)
            {
                MyBigInteger bigIntA = new MyBigInteger(Long.toString(randomNumbersForTests[i]));
                MyBigInteger bigIntB = new MyBigInteger(Long.toString(randomNumbersForTests[j]));
                MyBigInteger additionAnswer = bigIntA.plus(bigIntB);
                MyBigInteger multiplicationAnswer = bigIntA.times(bigIntB);

                if(!additionAnswer.getIntegerOfUnlimitedSize().equals(Long.toString(answerWithLongsAddition[i][j])))
                {
                    isEquivalent = false;
                }
                else{
                    System.out.println("Answer from IOUS for Addition: " + randomNumbersForTests[i] + " + " + randomNumbersForTests[j] + " = " + additionAnswer.getIntegerOfUnlimitedSize()
                            + "\nAnswer from long addition: " + answerWithLongsAddition[i][j]);
                }
                if(!multiplicationAnswer.getIntegerOfUnlimitedSize().equals(Long.toString(answerWithLongsMultiplication[i][j])))
                {
                    isEquivalent = false;
                }
                else
                {
                    System.out.println("Answer from IOUS for multiplication " + randomNumbersForTests[i] + " * " + randomNumbersForTests[j] + " = " + multiplicationAnswer.getIntegerOfUnlimitedSize()
                            + "\nAnswer from long multiplication: " + answerWithLongsMultiplication[i][j]);
                };
            }
        }


        return isEquivalent;
    }

    public static void verifyAdditionAndMultiplication()
    {
        int amountOfNumbers = 10;
        long randomNumbersForTests[] = createRandomArray(amountOfNumbers);

        // testing with small numbers
        long answerWithLongsAddition[][] = new long[amountOfNumbers][amountOfNumbers];
        long answerWithLongsMultiplication[][] = new long[amountOfNumbers][amountOfNumbers];

        calculateAnswersWithLongsAddition(answerWithLongsAddition,randomNumbersForTests);
        calculateAnswersWithLongsMultiplication(answerWithLongsMultiplication, randomNumbersForTests);

        boolean isIOUSAnswersEquivalent = verifyIOUSFuncsGiveEquvalentAnswers(answerWithLongsAddition,answerWithLongsMultiplication,randomNumbersForTests);

        if(isIOUSAnswersEquivalent == false)
        {
            System.out.println("Your IOUS functions don't work.");
        }
        else
        {
            System.out.println("Your IOUS functions work.");
        }
        verifyExtremelyLongNumbersIOUS();
    }

    public static void verifyFibFunctions(long x)
    {
        MyBigInteger a = FibonacciFunctions.fiboMatrixFunction(x);
        MyBigInteger b = FibonacciFunctions.fiboLoop(x);
        long c = FibonacciFunctions.fibFormula(x);
        BigInteger d = FibonacciFunctions.fibFormulaBigInteger(x);
        String bigFormulaConvert = d.toString();

        //double check = FibonacciFunctions.fibFormula(90);
        //BigInteger fibNumberHuge = FibonacciFunctions.fibFormulaBigInteger(99);
       // System.out.println(check);
       // System.out.println(fibNumberHuge);
        System.out.println(a.getIntegerOfUnlimitedSize());
        System.out.println(b.getIntegerOfUnlimitedSize());
        System.out.println(c);
        System.out.println(d.toString());
        if(a.getIntegerOfUnlimitedSize().equals(Long.toString(allTheFibNumbersLongsCanHold[(int)x])) && b.getIntegerOfUnlimitedSize().equals(Long.toString(allTheFibNumbersLongsCanHold[(int)x])) && c == allTheFibNumbersLongsCanHold[(int)x] && bigFormulaConvert.equals(Long.toString(allTheFibNumbersLongsCanHold[(int)x]))) {
            System.out.println("they are equal");
        }

    }



}
