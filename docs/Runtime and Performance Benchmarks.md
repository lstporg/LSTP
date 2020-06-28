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
  The training runtime only increased by 5-6 milliseconds in these trials even though the error margin become more than 10,000 times more precise.
</p>
