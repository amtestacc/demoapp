package com.n26.test.project.demo.repository;

class PartialStatistic {
    double sum;
    double min;
    double max;
    long count;

    public PartialStatistic(double sum, double min, double max, long count) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public double getSum() {
        return sum;
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
}
