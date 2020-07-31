import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        double errorMargin = 1;
        List<double[]> inputs = new ArrayList<>();
        List<Double> outputs = new ArrayList<>();

        inputs.add(new double[]{3500, 300});
        inputs.add(new double[]{3400, 250});
        inputs.add(new double[]{3800, 240});
        inputs.add(new double[]{3600, 250});
        inputs.add(new double[]{4000, 400});
        inputs.add(new double[]{4150, 600});
        inputs.add(new double[]{3400, 300});
        inputs.add(new double[]{2000, 600});
        inputs.add(new double[]{3100, 180});
        inputs.add(new double[]{3200, 200});
        inputs.add(new double[]{4400, 650});

        outputs.add(165.0);
        outputs.add(158.0);
        outputs.add(155.0);
        outputs.add(140.0);
        outputs.add(170.0);
        outputs.add(170.0);
        outputs.add(168.0);
        outputs.add(200.0);
        outputs.add(135.0);
        outputs.add(140.0);
        outputs.add(169.0);

        Neuron neuron = new Neuron(inputs, outputs);
        neuron.train(errorMargin);
    }
}
