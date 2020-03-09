package org.autogenerated.rest.artificial.cs.n5sparsepdshown.service;

import java.util.Arrays;
/** automatically created on 2020-01-14 */
public class Util {
  public static double average(double[] values) {
    double sum = 0;
    for (double v : values) sum += v;
    return sum / values.length;
  }

  public static double medium(double[] values) {
    Arrays.sort(values);
    double median = 0;
    double pos1 = Math.floor((values.length - 1.0) / 2.0);
    double pos2 = Math.ceil((values.length - 1.0) / 2.0);
    if (pos1 == pos2) {
      median = values[(int) pos1];
    } else {
      median = (values[(int) pos1] + values[(int) pos2]) / 2.0;
    }
    return median;
  }
}
