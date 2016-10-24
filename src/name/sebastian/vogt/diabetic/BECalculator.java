package name.sebastian.vogt.diabetic;

/**
 * Created by sebastian on 24.10.16.
 */
public class BECalculator {

    public static final int BE = 12;
    public static final int KHE = 10;

    protected double value;
    protected double carbonProValue;
    protected double valueEat;
    protected int measure;


    public BECalculator(double value, double carbonProValue, double valueEat, int measure) {
        if(value <= 0) {
            throw new IllegalArgumentException("value must be greater than 0!");
        }
        if(valueEat <= 0) {
            throw new IllegalArgumentException("valueEat must be greater than 0!");
        }
        this.value = value;
        this.carbonProValue = carbonProValue;
        this.valueEat = valueEat;
        this.measure = measure;
    }




    public double compute() {
        return (this.valueEat * this.carbonProValue / value) / this.measure;

    }

}