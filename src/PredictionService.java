import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PredictionService {

    public static void predict(String inputs, double[] weights, double intercept) {
        Path path = Paths.get(inputs);
        try {
            List<String> inputLines = Files.readAllLines(path);
            for (int j = 0; j < inputLines.size(); j++) {
                String[] raw = inputLines.get(j).split(",");
                double[] vals = new double[raw.length];
                for (int k = 0; k < raw.length; k++) {
                    vals[k] = Double.valueOf(raw[k]);
                }
                double prediction = intercept;
                for (int i = 0; i < vals.length; i++) {
                    prediction = prediction + (vals[i] * weights[i]);
                }
                System.out.println("[line " + j + "]: " + prediction);
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
    }
}
