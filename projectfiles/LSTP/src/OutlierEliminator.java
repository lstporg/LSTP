import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutlierEliminator {

    public static List<double[]> inputs = new ArrayList<>();
    public static List<Double> outputs = new ArrayList<>();
    public static double input_outlier_margin;
    public static double output_outlier_margin;

    public static List<double[]> newInputs = new ArrayList<>();
    public static List<Double> newOutputs = new ArrayList<>();

    //Constructor:
    public OutlierEliminator(List<double[]> passedInputs, List<Double> passedOutputs, double passedInputOutlierMargin, double passedOutputOutlierMargin) {

        //Fills inputs:
        for (int i = 0; i < passedInputs.size(); i++) {
            inputs.add(passedInputs.get(i));
        }

        //Fills outputs:
        for (int i = 0; i < passedOutputs.size(); i++) {
            outputs.add(passedOutputs.get(i));
        }

        //Sets margins:
        input_outlier_margin = passedInputOutlierMargin;
        output_outlier_margin = passedOutputOutlierMargin;
    }

    //Remove outliers:
    public static void removeOutliers() {

        List<Integer> removalIndexes = new ArrayList<>();

        //Removes input outliers:
        //Calculates input means:
        double[] inputAverages = new double[inputs.get(0).length];
        Arrays.fill(inputAverages, 0);
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < inputs.get(i).length; j++) {
                inputAverages[j] = inputAverages[j] + inputs.get(i)[j];
            }
        }
        for (int i = 0; i < inputAverages.length; i++) {
            inputAverages[i] = inputAverages[i] / inputs.size();
        }
        //Compares inputs with input means:
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < inputs.get(i).length; j++) {
                double current = inputs.get(i)[j];
                double max = inputAverages[j] + input_outlier_margin;
                double min = inputAverages[j] - input_outlier_margin;
                if ((current > max) || (current < min)) {
                    removalIndexes.add(i);
                }
            }
        }

        //Removes output outliers:
        //Calculates output mean:
        double outputAverage = 0;
        for (int i = 0; i < outputs.size(); i++) {
            outputAverage = outputAverage + outputs.get(i);
        }
        outputAverage = outputAverage / outputs.size();
        //Compares outputs with output mean:
        for (int i = 0; i < outputs.size(); i++) {
            double current = outputs.get(i);
            double max = outputAverage + output_outlier_margin;
            double min = outputAverage - output_outlier_margin;
            if ((current > max) || (current < min)) {
                removalIndexes.add(i);
            }
        }

        //Initializes new input and output lists according to removal indexes:
        for (int i = 0; i < inputs.size(); i++) {
            if (!removalIndexes.contains(i)) {
                newInputs.add(inputs.get(i));
                newOutputs.add(outputs.get(i));
            }
        }
    }

    //Get new inputs:
    public static List<double[]> getNewInputs() {
        return newInputs;
    }

    //Get new outputs:
    public static List<Double> getNewOutputs() {
        return newOutputs;
    }
}