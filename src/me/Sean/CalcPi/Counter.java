package me.Sean.CalcPi;

public class Counter extends Thread{

    @Override
    public void run() {

        double percentageInitial = 0;
        while(Main.flag) {
            final double percentage = Main.percentDone;
            final double percentageLeft = 100 - percentage*100;
            final double changeInPercentage = percentage-percentageInitial;
            final int latency = 1;
            double expectedTime = percentageLeft*(latency/changeInPercentage);
            double estimatedTime = (Math.round((expectedTime/60) * 100.0))/100.0;

            if(estimatedTime < 1.0) {
                System.out.println("Expected finish: " + estimatedTime*60 + " seconds Percentage Complete: " + Math.round(percentage*100)+"%");
            } else {
                System.out.println("Expected finish: " + Math.round(estimatedTime) + " minutes Percentage Complete: " + Math.round(percentage*100)+"%");
            }

                try {
                    Counter.sleep(latency*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
