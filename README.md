# spark
### sparklines in your Java

See? Here's a graph of your productivity gains after using spark: ▁▂▃▅▇

## install

spark is a [shell script][bin], so drop it somewhere and make sure it's added
to your `$PATH`. It's helpful if you have a super-neat collection of dotfiles.

This is a Java port of the real [spark](https://github.com/holman/spark).

## usage
From console:
    java -jar spark.jar 10 30 10 90 25 3 30
 => ▁▃▁▇▂▁▃

From windows cmd. Use "--cmd" key:

    java -jar spark.jar --cmd 10 30 10 90 25 3 30
 => _▄_█▄_▄

From java code. Use Spark.sparkString(List<Integer> ints, boolean fitMin)
to get spark string form List of Integers:

    Spark.sparkString(Arrays.asList(1000,990,995),true);   =>  ▇▁▅


## ▇▁ ⟦⟧ ▇▁


[bin]:      https://github.com/holman/spark/blob/master/spark
[spark]:     https://github.com/holman/spark
[holman]:   https://twitter.com/holman