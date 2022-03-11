package frc.robot;

import frc.robot.util.Interpolable;
import frc.robot.util.InterpolatingDouble;
import frc.robot.util.InterpolatingTreeMap;
import frc.robot.util.distanceRPMPoint;


class Main{
  public static void main(String[] args) {
    InterpolatingTreeMap<InterpolatingDouble, InterpolatingDouble> m_interpolatingSpeeds_top = new InterpolatingTreeMap<InterpolatingDouble, InterpolatingDouble>();
    InterpolatingTreeMap<InterpolatingDouble, InterpolatingDouble> m_interpolatingSpeeds_bot = new InterpolatingTreeMap<InterpolatingDouble, InterpolatingDouble>();

    distanceRPMPoint[] distanceRPMlist = {
      new distanceRPMPoint(8, 2050, 2200),
      new distanceRPMPoint(9, 2100, 2250),
      new distanceRPMPoint(10, 2300, 2400),
      new distanceRPMPoint(11, 2350, 2450),
      new distanceRPMPoint(12, 2550, 2550),
      new distanceRPMPoint(13, 2600, 2650),
      new distanceRPMPoint(14, 2670, 2720),
      new distanceRPMPoint(15, 3300, 2300),
      new distanceRPMPoint(16, 3400, 2400),
      new distanceRPMPoint(17, 3480, 2480),
      new distanceRPMPoint(18, 3565, 2565),
      new distanceRPMPoint(19, 3900, 2550),
      new distanceRPMPoint(20, 4100, 2350),
      new distanceRPMPoint(21, 4300, 2400),
      new distanceRPMPoint(22, 5200, 2200),
      new distanceRPMPoint(23, 5500, 2400),
    };

    for (distanceRPMPoint point : distanceRPMlist) {
      m_interpolatingSpeeds_bot.put(new InterpolatingDouble(point.distance),
          new InterpolatingDouble(point.botRPM));
      m_interpolatingSpeeds_top.put(new InterpolatingDouble(point.distance),
          new InterpolatingDouble(point.topRPM));
    }

    int i;
    double botspeed,topspeed;
    for (i=8;i<=23;i++){
      double d=i+0.5;
      botspeed = m_interpolatingSpeeds_bot.getInterpolated(new InterpolatingDouble(d)).value;
      topspeed = m_interpolatingSpeeds_top.getInterpolated(new InterpolatingDouble(d)).value;
      System.out.printf("distance=%.1f, topspeed=%.2f,botspeed=%.2f \n",d,topspeed,botspeed);
    }
  }
}


