<h1>Runtime and Performance Benchmarks</h1>
<p>These benchmarks were made on a Windows 10 machine with specs as follows:</p>
<pre>
AMD Ryzen 3 1200 @ 3.1 GHz (boost clock to 3.4 GHz)
16 GB DDR4 @ 2933 MHz
</pre>
<p>
  The graphics performance on a system does not affect runtime as the training process is not GPU accelerated.<br/>
  Below are graphs and logs of autotraining error margins, epochs completed, and training runtimes.<br/>
  Assume no outliers in the datasets.
</p>
<br/>
<img src="https://raw.githubusercontent.com/hershyz/LSTP/master/assets/errormargin.png"/>
<img src="https://raw.githubusercontent.com/hershyz/LSTP/master/assets/epochs.png"/>
<pre>

<strong>Trial 1:</strong>
Error Margin:      10
Epochs:            26
Training Runtime:  6 ms

<strong>Trial 2:</strong>
Error Margin:      7.5
Epochs:            26
Training Runtime:  6 ms

<strong>Trial 3:</strong>
Error Margin:      5
Epochs:            866
Training Runtime:  7 ms

<strong>Trial 4:</strong>
Error Margin:      4
Epochs:            2086
Training Runtime:  9 ms

<strong>Trial 5:</strong>
Error Margin:      3
Epochs:            3346
Training Runtime:  10 ms

<strong>Trial 6:</strong>
Error Margin:      2
Epochs:            4273
Training Runtime:  12 ms

<strong>Trial 7:</strong>
Error Margin:      1
Epochs:            4673
Training Runtime:  11 ms

<strong>Trial 8:</strong>
Error Margin:      0.8
Epochs:            4753
Training Runtime:  11 ms

<strong>Trial 9:</strong>
Error Margin:      0.6
Epochs:            4833
Training Runtime:  11 ms

<strong>Trial 10:</strong>
Error Margin:      0.4
Epochs:            4893
Training Runtime:  11 ms

<strong>Trial 11:</strong>
Error Margin:      0.2
Epochs:            4973
Training Runtime:  12 ms

<strong>Trial 12:</strong>
Error Margin:      0.1
Epochs:            5013
Training Runtime:  11 ms

<strong>Trial 13:</strong>
Error Margin:      0.01
Epochs:            5053
Training Runtime:  12 ms

<strong>Trial 14:</strong>
Error Margin:      0.000889
Epochs:            5053
Training Runtime:  11 ms
</pre>
<p>
  It can be seen that the neuron determines weights very quickly and does not need to go through a large amount of epochs to make accurate predictions.<br/>
  The error margin in these trials started at 10, and ended at 0.000889. This was the lowest error margin the program could calculate weights around.<br/>
  The training runtime only increased by 5-6 milliseconds in these trials even though the error margin become more than 10,000 times more precise.<br/>
  Below is the input and output data that these benchmarks were achieved on.
</p>
<pre>
<strong>Inputs:                 Outputs:</strong>
300,1500,4              180
225,1025,0              167
180,1500,1              145
174,1000,3              150
500,1200,3              200
800,1700,4              230
710,1544,5              240
602,2040,7              210
620,1324,8              210
620,1300,0              234
711,1025,1              200
810,1720,4              250
198,2000,4              123
140,1000,0              141
900,2000,4              273
620,1762,1              210
180,1000,0              143
502,1200,7              198
290,1200,0              170
710,2000,5              199
</pre>
