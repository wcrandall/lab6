

public class main {
    public static void main(String args[]) {

        //System.out.println(runFullExpirament.generateRandomIOUS(5));
        //Verification.verifyAdditionAndMultiplication();
        //VerificAation.verifyFibFunctions( 20);

        String[] test2 = {"fiboLoopXTests", "fiboLoopXDoubleTests", "fiboMatrixXTests", "fiboMatrixXDoubleTests"};
        for(int i = 0; i < 3; i++) {
            runFullExpirament.runFullExperiment("fiboFormulaIOUS" + i + ".txt", "fiboFormulaIOUS");
        }

    }
}
