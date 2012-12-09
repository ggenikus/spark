package ggenikus;

import org.junit.Test;

import static ggenikus.Spark.sparkString;
import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

/**
 * Author: ggenikus
 * Date: 12/8/12 11:47 PM
 */
public class SparkTest {
    @Test
    public void testSparkString() throws Exception {
        assertEquals("▁▂▃▅▂▇", sparkString(asList(0, 30, 55, 80, 33, 150), true));
        assertEquals("▇▁▅", sparkString(asList(1000,990,995), true));
        assertEquals("▇▇▇", sparkString(asList(1000,990,995), false));
        assertEquals("▇▃▁▁▃▇", sparkString(asList(10, 3, 0, 0, 3, 10), true));
    }



}
