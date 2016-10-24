package name.sebastian.vogt.diabetic;

public class Main {

    public static BECalculator beCalculator;
    public static InsulinCalculator insulinCalculator;
    public static Range targetRange;
    public static double sugar = 0;
    public static double correctionFactor = 2; // um wieviel mmol/dl wird der Bluzucker mit 1 IE Bolus Insulin gesenkt

    public static void main(String[] args) {

        sugar = 15.9;
        System.out.println("Blutzucker = " + sugar);

        // (gramm auf der Packung z.b. 100, gramm KH, gramm wieviel gegessen, BE oder KHE)
        beCalculator = new BECalculator(
                100,
                11,
                400,
                BECalculator.BE
        );
        System.out.println("BE = " + Helpers.roundDecPlaces(beCalculator.compute(), 2));

        targetRange = new Range(4, 9);
        /*System.out.println(range.inRange(6));
        System.out.println(range.inRange(11));*/

        insulinCalculator = new InsulinCalculator(
                sugar, // aktueller Blutzucker
                1, // Insulinfaktor
                correctionFactor, // Korrekturfaktor (um wieviel wird der Blutzucker mit 1 IE Bolus Insulin gesenkt
                Math.round(targetRange.getAverage()), // Ziel Blutzucker
                beCalculator.compute() // BE oder KHE
        );
        System.out.println("Bolus IE = " + Helpers.roundDecPlaces(insulinCalculator.computeBolusInsulin(), 2));
        System.out.println("Korrektur IE = " + Helpers.roundDecPlaces(insulinCalculator.computeCorrectionInsulin(), 2));
        System.out.println("Gesamt IE = " + Helpers.roundDecPlaces(insulinCalculator.computeTotalInsulin(), 2));


        System.out.println("Average = " + Math.round(targetRange.getAverage()));



    }
}
