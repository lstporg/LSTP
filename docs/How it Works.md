<h1>How it Works</h1>
<h3>Training:</h3>
<ul>
  <li>Before the instance of the training neuron has been created, the program initializes an autotrain error margin, and input and output outlier margins.</li>
  <li>The program takes input and output CSV training data filepaths.</li>
  <li>The program removes any data that does not fall between <code>mean ± outlier margin</code></li>
  <li>The program initializes the neuron with the scanned data, a baseline intercept is initialized, and a baseline weight is initialized.</li>
  <li>The program trains and uses a weight correction formula to correct a weight proportional to the input and error size.</li>
  <li>When the program's prediction falls between <code>± autotrain error margin</code> of a real value, training stops.</li>
  <li>A trained model CSV containing the baseline intercept and final weights is cached for future predictions.</li>
</ul>

<h3>Predictions:</h3>
<ul>
  <li>The program takes in an input CSV file and a cached model file.</li>
  <li>The program iterates through every line of the input CSV and uses the model data to make a prediction.</li>
  <li>The predictions corresponding to each input is displayed on the terminal window.</li>
</ul>
