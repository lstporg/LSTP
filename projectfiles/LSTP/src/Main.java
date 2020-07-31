import java.util.List;
import java.util.Scanner;

public class Main {

    //Imports:
    private static Scanner scn = new Scanner(System.in);
    private static CSVParser csvParser = new CSVParser();
    private static Diagnostics diagnostics = new Diagnostics();
    private static ModelParser modelParser = new ModelParser();

    //Training Properties:
    public static double autotrain_error_margin = -1;
    public static double input_outlier_margin = -1;
    public static double output_outlier_margin = -1;

    //Paths:
    public static String inputPath = "";
    public static String outputPath = "";

    public static void main(String[] args) {

        System.out.println("");
        System.out.println("-------------------------------------------");
        System.out.println("LSTP - Lightweight Self-Training Perceptron");
        System.out.println("-------------------------------------------");
        System.out.println("");

        if (args.length < 1) {
            System.out.println("Supported Comamnds:");
            System.out.println("java -jar LSTP.jar -train");
            System.out.println("java -jar LSTP.jar -predict");
            System.out.println("");
            System.exit(1);
        }

        String test = args[0].trim().toLowerCase();
        if (!test.equals("-train")) {
            if (!test.equals("-predict")) {
                System.out.println("Supported Comamnds:");
                System.out.println("java -jar LSTP.jar -train");
                System.out.println("java -jar LSTP.jar -predict");
                System.out.println("");
                System.exit(1);
            }
        }

        if (args.length > 0) {
            String command = args[0].trim().toLowerCase();

            //Initiate training sequence:
            if (command.equals("-train")) {

                //Set margins:
                System.out.print("AutoTrain Error Margin: ");
                autotrain_error_margin = Double.valueOf(scn.nextLine());
                System.out.print("Input Outlier Margin:   ");
                input_outlier_margin = Double.valueOf(scn.nextLine());
                System.out.print("Output Outlier Margin:  ");
                output_outlier_margin = Double.valueOf(scn.nextLine());

                //Set input and output files:
                System.out.print("Input CSV Path:  ");
                inputPath = scn.nextLine();
                System.out.print("Output CSV Path: ");
                outputPath = scn.nextLine();
                System.out.println("");

                //Get raw inputs and outputs:
                List<double[]> rawInputs = csvParser.parseInputs(inputPath);
                List<Double> rawOutputs = csvParser.parseOutputs(outputPath);

                //Remove outliers from input and output data:
                OutlierEliminator outlierEliminator = new OutlierEliminator(rawInputs, rawOutputs, input_outlier_margin, output_outlier_margin);
                outlierEliminator.removeOutliers();

                //Initialize input and output lists without outliers:
                List<double[]> inputs = outlierEliminator.getNewInputs();
                List<Double> outputs = outlierEliminator.getNewOutputs();

                //Displays training inputs and outputs:
                diagnostics.displayTrainingData(inputs, outputs);

                //Initializes neuron:
                Neuron neuron = new Neuron(inputs, outputs);
                neuron.train(autotrain_error_margin);

                //Gets weights and intercept after training is finished:
                double[] weights = neuron.getWeights();
                double intercept = neuron.getIntercept();

                //Gets desired model path and caches it:
                Model_IO modelio = new Model_IO(weights, intercept);
                System.out.print("Desired Model Location: ");
                String location = scn.nextLine();
                modelio.cacheModel(location);
                System.out.println("Model Successfully Cached: " + location);
            }

            //Initiate predictions sequence:
            if (command.equals("-predict")) {

                //Gets input and model paths:
                System.out.print("Input CSV Path: ");
                String _inputpath = scn.nextLine();
                System.out.print("Model Path:     ");
                String _modelpath = scn.nextLine();

                //Reads model cache file:
                modelParser.read(_modelpath);
                double[] weights = modelParser.getWeights();
                double intercept = modelParser.intercept;

                //Predicts all values of the input file:
                PredictionService.predict(_inputpath, weights, intercept);
            }
        }
    }
}