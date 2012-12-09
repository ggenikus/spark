package ggenikus;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.round;
import static java.util.Arrays.asList;
import static java.util.Collections.max;
import static java.util.Collections.min;

/**
 * Author: ggenikus
 * Date: 12/8/12 11:31 PM
 */

/**
 * Windows console makes him unhappy.
 *                        ↓
 *                       :-(
 */
/**
 * A port of @holman's spark project for Java.
 */
public class Spark {

    final static String TICKS = "▁▂▃▅▆▇";
    /**Windows console can't print all unicode character.
     * So i use character that can be printed, in order
     * to print something... :-(
     */
    final static String WINDOWS_CMD_TICKS = "_▄█";
    static boolean isToCMD = false;

    public static void main(String... args){
        if(args.length > 1){
            isToCMD = Arrays.binarySearch(args,"--cmd") == -1? false: true;
            List<Integer> ints = new ArrayList<Integer>(args.length);

            for (String i : args) {
                if(i.matches("\\d+")){
                    ints.add(Integer.parseInt(i));
                }
            }

            printSpark(System.out,false,ints);
            System.out.println();
        }else{
            String msg = "spark\n" +
                          "USAGE:\n" +
                          "  java -jar spark.jar 5 2 10 3 21\n" +
                          sparkString(asList(5,2,10,3,21),true)+"\n" +
                          "For cmd use: \n" +
                          "java -jar spark.jar --cmd 5 2 10 3 21";
            System.out.println(msg);
        }


    }

    static void printSpark(OutputStream out, boolean fitMin, List<Integer> ints){
        try {
            String enc = isToCMD? "cp866": "utf-8";
            out.write(sparkString(ints, fitMin).getBytes(enc));
            out.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write to output stream :-(",e);
        }
    }

    /**
     * Return spark string from list of ints.
     * @param ints list witch using for spark string generation
     * @param fitMin As mentioned @kennethreitz's in his python port of spark:
                     "Matches the range of the sparkline to the input integers
                      rather than the default of zero. Useful for large numbers with
                      relatively small differences between the positions"
      Example:
                   =>  Spark.sparkString(Arrays.asList(1000,990,995),true);
                   =>  ▇▁▅
                    ...
                   =>  Spark.sparkString(Arrays.asList(1000,990,995),false);
                   =>  ▇▇▇
     * @return
     */
    static String sparkString(List<Integer> ints, boolean fitMin){
        final int min = fitMin? min(ints):0;
        final int stepRange = max(ints) - min;
        final String ticks = isToCMD? WINDOWS_CMD_TICKS: TICKS;

        float step = stepRange / (float) (ticks.length() - 1);
        step = step == 0 ? 1: step;

        final StringBuffer sb = new StringBuffer();
        for (Integer i : ints) {
            sb.append(ticks.charAt(round((i - min) / step)));
        }
        return sb.toString();
    }
}
