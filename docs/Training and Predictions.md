<h1>Training</h1>

<p><strong>Training Command:</strong><br/>
<code>java -jar LSTP.jar -train</code>
</p>

<h3>Numeric Parameters:</h3>
<pre>
AutoTrain Error Margin: 1
Input Outlier Margin:   100
Output Outlier Margin:  100
</pre>

<p><strong>AutoTrain Error Margin:</strong><br/>
This margin determines a threshold for how close a predicted value needs to be to a real value for the program to terminate self training.
</p>

<p><strong>Input Outlier Margin:</strong><br/>
This margin determines a threshold for how far an input needs to be from the average to be eliminated before training.
</p>

<p><strong>Output Outlier Margin:</strong><br/>
This margin determines a threshold for how far an output needs to be from the average to be eliminated before training.
</p>

<h3>Filepath Parameters:</h3>
<pre>
Input CSV Path:          inputs.csv
Output CSV Path:         outputs.csv
Desired Model Location:  model.csv
</pre>

<p><strong>Input CSV Path:</strong><br/>
Numeric only file with input values (same number of inputs per line).
</p>

<p><strong>Output CSV Path:</strong><br/>
Numeric only file with output values (one output per line).
</p>

<p><strong>Desired Model Location:</strong><br/>
Cache file storing weights and intercept gathered from training to make predictions on data in another instance.
</p>

<p><strong>Example Input File:</strong></p>
<pre>
1,0,1
2.5,1,1
8,8,7
</pre>

<p><strong>Example Output File:</strong></p>
<pre>
1.5
1
2
</pre>

<br/>
<br/>

<h1>Predictions</h1>
<p><strong>Prediction Command:</strong><br/>
<code>java -jar LSTP.jar -predict</code>
</p>

<h3>Parameters:</h3>
<pre>
Input CSV Path:  inputs.csv
Model Path:      model.csv
</pre>

<p><strong>Input CSV Path:</strong><br/>
Inputs in which the program will make predictions using a trained model (same format as training input CSV).
</p>

<p><strong>Model Path:</strong><br/>
Cached model file that will be used to make predictions on the inputs CSV.
</p>
