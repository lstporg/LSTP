import java.io.File;
import java.io.FileWriter;

public class Model_IO {

    private static double[] weights;
    private static double intercept;

    //Constructor:
    public Model_IO(double[] passedWeights, double passedIntercept) {
        weights = new double[passedWeights.length];
        for (int i = 0; i < passedWeights.length; i++) {
            weights[i] = passedWeights[i];
        }
        intercept = passedIntercept;
    }

    //Creates the model:
    public static void cacheModel(String filePath) {
        try {
            File file = new File(filePath);
            file.createNewFile();
            FileWriter fw = new FileWriter(filePath);
            for (int i = 0; i < weights.length; i++) {
                fw.write(weights[i] + ",");
            }
            fw.write(String.valueOf(intercept));
            fw.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
    }
}