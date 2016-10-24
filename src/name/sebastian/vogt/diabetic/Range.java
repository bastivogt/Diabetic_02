package name.sebastian.vogt.diabetic;

/**
 * Created by sebastian on 24.10.16.
 */
public class Range {

    protected double start;
    protected double stop;

    public Range(double start, double stop) {
        if(start >= stop) {
            throw new IllegalArgumentException("start must be smaller than stop!");
        }
        this.start = start;
        this.stop = stop;
    }

    public double getStart() {
        return this.start;
    }

    public void setStart(double value) {
        this.start = value;
    }

    public double getStop() {
        return this.stop;
    }

    public void setStop(double value) {
        this.stop = value;
    }

    public boolean inRange(double value) {
        if(this.start < this.stop) {
            if(value > this.start && value < this.stop) {
                return true;
            }
        }

        return false;
    }

    public double getAverage() {
        return (this.start + this.stop) / 2;
    }

}
