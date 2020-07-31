import java.util.List;

public class Diagnostics {

    //Display training data:
    public void displayTrainingData(List<double[]> inputs, List<Double> outputs) {
        System.out.println("Training Inputs:");
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < inputs.get(i).length; j++) {
                System.out.print(inputs.get(i)[j]);
                if (j < inputs.get(i).length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Training Outputs:");
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }
        System.out.println("");
    }
}