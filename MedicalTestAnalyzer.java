import java.util.*;

class MedicalTestResult {
    private String patientName;
    private double resultValue;

    public MedicalTestResult(String patientName, double resultValue) {
        this.patientName = patientName;
        this.resultValue = resultValue;
    }

    public double getResultValue() {
        return resultValue;
    }
}

public class MedicalTestAnalyzer {
    public static void main(String[] args) {
        List<MedicalTestResult> testResults = new ArrayList<>();
        testResults.add(new MedicalTestResult("Patient1", 120));
        testResults.add(new MedicalTestResult("Patient2", 90));
        testResults.add(new MedicalTestResult("Patient3", 140));
        testResults.add(new MedicalTestResult("Patient4", 80));
        testResults.add(new MedicalTestResult("Patient5", 110));
        testResults.add(new MedicalTestResult("Patient6", 160));
        testResults.add(new MedicalTestResult("Patient7", 100));
        double[] rangeBounds = {0, 100, 150, Double.MAX_VALUE};
        String[] categories = {"Normal", "Borderline", "High"};
        int[] patientCount = new int[categories.length];
        double[] resultTotal = new double[categories.length];
        for (MedicalTestResult result : testResults) {
            double value = result.getResultValue();
            int categoryIndex = getCategoryIndex(value, rangeBounds);
            patientCount[categoryIndex]++;
            resultTotal[categoryIndex] += value;
        }

        System.out.println("Result Range\t\tPatients Count\t\tAverage Value");
        for (int i = 0; i < categories.length; i++) {
            double averageValue = patientCount[i] > 0 ? resultTotal[i] / patientCount[i] : 0;
            System.out.printf("%s\t\t\t\t%d\t\t\t\t%.2f\n", categories[i], patientCount[i], averageValue);
        }
    }
    private static int getCategoryIndex(double value, double[] rangeBounds) {
        for (int i = 0; i < rangeBounds.length - 1; i++) {
            if (value >= rangeBounds[i] && value < rangeBounds[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}