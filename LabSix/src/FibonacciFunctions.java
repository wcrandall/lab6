import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class FibonacciFunctions {

    public static final double phi = 1.61803399;

    public static MyBigInteger fiboLoop(long x)
    {
        //initializing first values of fibonacci sequence
        MyBigInteger valueNMinusOne = new MyBigInteger("1");
        MyBigInteger valueNMinusTwo = new MyBigInteger("0");
        MyBigInteger value = new MyBigInteger("0");

        // if it is one of the first two values in fibonacci sequence (i.e 0 or one return 1)
        // this is because we're starting at 1 rather than 0 in the sequence as the instructions indicate
        if(x <= 1)
        {
            return new MyBigInteger("1");
        }
        else {
            /* if the value entered into this function is not 0 or 1
             * we will loop x times to get the xth term
             * the loop calculates the new value from the previous two values
             * we have that the previous two values at the start are 0 and 1 since the 0th term = 1
             * we then move valueNMinus one to valueNMinusTwo and store the new value in it
             * this prepares us for finding the next value */
            for (long i = 0; i < x; i++) {
                value = valueNMinusOne.plus(valueNMinusTwo);
                valueNMinusTwo = valueNMinusOne;
                valueNMinusOne = value;
            }
        }

        System.out.println(value.getIntegerOfUnlimitedSize());
        return value;
    }






    public static void matrixMult(MyBigInteger[][] base, MyBigInteger[][] factor)
    {
        /*
         * [[0][0]][[0][1]]
         * [[1][0]][[1][1]]
         *  is the starting matrix */

        //finding the top left corner
        MyBigInteger hold = base[0][0].times(factor[0][0]);
        MyBigInteger hold2 = base[0][1] .times(factor[1][0]);
        MyBigInteger topLeft = hold.plus(hold2);

        //finding the top right corner
        hold = base[0][0].times(factor[0][1]);
        hold2 = base[0][1].times(factor[1][1]);
        MyBigInteger topRight = hold.plus(hold2);

        // finding the bottom left of the matrix
        hold = base[1][0].times(factor[0][0]);
        hold2 = base[1][1].times(factor[1][0]);
        MyBigInteger bottomLeft = hold.plus(hold2);

        //finding the bottom right of the matrix
        hold = base[1][0].times(factor[0][1]);
        hold2 = base[1][1].times(factor[1][1]);
        MyBigInteger bottomRight = hold.plus(hold2);


        // putting all values in matrix
        base[0][0] = topLeft;
        base[0][1] = topRight;
        base[1][0] = bottomLeft;
        base[1][1] = bottomRight;

    }

    // simple double for loop to do the operation matrix = matrixTwo (i. e. matrix <- matrixTwo)
    static void equalizeMatrix(MyBigInteger[][] matrix, MyBigInteger[][] matrixTwo)
    {
        for(int i = 0; i < matrix.length;i++)
        {
            for(int j = 0; j < matrix.length;j++)
            {
                matrix[i][j] = matrixTwo[i][j];
            }

        }
    }

    public static MyBigInteger fiboMatrixFunction(long x)
    {
        // base cases
        if(x == 0 || x == 1)
        {
            return new MyBigInteger("1");
        }

        // the base matrix
        MyBigInteger[][] base = {{new MyBigInteger("1"), new MyBigInteger("1")}, {new MyBigInteger("1"), new MyBigInteger("0")}};

        // make an an array to store result
        MyBigInteger[][] result = new MyBigInteger[2][2];

        // setting index to x
        long i = x;

        // create varaible to use in if statement
        // like the log(n) pow function the first time through result must = base but there's not
        // an equivalent of 1 * base in matrices atleast that I know of so I made this variable to set result = base the first time there is an odd
        // the rest of the times through it matrix multiplies result by base to keep track of the odd powers
        long j = 0;
        // a loop to do arithmetic in
        while (i > 0)
        {
            // if i is even we multiply the base * base
            // j = i/2;  base = x ** j
            // (x**i/2) * (x**i/2) = x**i
            // using basic algebra we easily cut out half of the steps
            if (i % 2 ==0)
            {
                matrixMult(base, base);
                i = i/2;
            }
            else
            {

                if(j == 0)
                {
                    equalizeMatrix(result, base);
                    i--;
                }
                else {
                    matrixMult(result, base);
                    i--;
                }
                j++;

                // if i is greater than 1 after the decrement we multiply base * base and divide i by 2
                if (i > 1) {
                    matrixMult(base,base);
                    i = i / 2;
                }
            }
        }

        return result[0][0];
    }

    public static long fibFormula(long x)
    {
        x++;
        long fibNumber = Math.round((Math.pow(phi,x)-Math.pow(phi,-x))/(Math.sqrt(5)));
        return fibNumber;
    }

    public static BigInteger fibFormulaBigInteger(long x)
    {

        x++;
        BigDecimal one = new BigDecimal(1);
        int y = (int)(x - (x * 2));
        BigDecimal squareRootOfFive = new BigDecimal(Math.sqrt(5));
        BigDecimal bigDecPhi = new BigDecimal(phi);
        BigDecimal fibNumber = bigDecPhi.pow((int)x);
        BigDecimal hold = one.divide(fibNumber, 100, RoundingMode.HALF_UP);
        fibNumber = fibNumber.subtract(hold);
        fibNumber = fibNumber.divide(squareRootOfFive,100, RoundingMode.HALF_UP);
        BigInteger fibNumberInt = fibNumber.toBigInteger();
        return fibNumberInt;
    }
}
