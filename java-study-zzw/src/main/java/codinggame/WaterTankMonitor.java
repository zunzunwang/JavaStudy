package codinggame;

/**
 * https://github.com/janosgyerik/java-practice/blob/master/src/test/java/com/janosgyerik/practice/oj/codingame/misc/test1/watertank/WaterTankMonitor.java
 */
class WaterTankMonitor {

    WaterTank tank;

    WaterTankMonitor(WaterTank tank) {
        this.tank = tank;
    }

    synchronized void empty() throws InterruptedException {
        while (tank.isEmpty()) {
            wait();
        }

        tank.setEmpty(true);
        notifyAll();
    }

    synchronized void fill() throws InterruptedException {
        while (!tank.isEmpty()) {
            wait();
        }

        tank.setEmpty(false);
        notifyAll();
    }
}
