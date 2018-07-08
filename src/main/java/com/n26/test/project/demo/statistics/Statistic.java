package com.n26.test.project.demo.statistics;

public class Statistic {
    double sum;
    double avg;
    double min;
    double max;
    long count;

    public Statistic(double sum, double avg, double min, double max, long count) {
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "sum=" + sum +
                ", avg=" + avg +
                ", min=" + min +
                ", max=" + max +
                ", count=" + count +
                '}';
    }


}
