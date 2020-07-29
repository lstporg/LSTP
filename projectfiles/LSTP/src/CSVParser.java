import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    //Parse inputs:
    public static List<double[]> parseInputs(String file) {
        Path path = Paths.get(file);
        List<double[]> inputs = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (int i = 0; i < lines.size(); i++) {
                String[] arr = lines.get(i).split(",");
                double[] vals = new double[arr.length];
                for (int j = 0; j < arr.length; j++) {
                    vals[j] = Double.valueOf(arr[j]);
                }
                inputs.add(vals);
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        return inputs;
    }

    //Parse outputs:
    public static List<Double> parseOutputs(String file) {
        Path path = Paths.get(file);
        List<Double> outputs = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (int i = 0; i < lines.size(); i++) {
                outputs.add(Double.valueOf(lines.get(i)));
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        return outputs;
    }
}