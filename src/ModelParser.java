import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ModelParser {

    public static double[] weights;
    public static double intercept;

    public static void read(String modelPath) {
        Path path = Paths.get(modelPath);
        try {
            List<String> lines = Files.readAllLines(path);
            String[] raw = lines.get(0).split(",");
            intercept = Double.valueOf(raw[raw.length - 1]);
            weights = new double[raw.length - 1];
            for (int i = 0; i < raw.length - 1; i++) {
                weights[i] = Double.valueOf(raw[i]);
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
    }

    public static double[] getWeights() {
        return weights;
    }
}