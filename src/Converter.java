public class Converter
{

    static final double LENGTH_OF_ONE_STEP_IN_KM = 0.00075;
    static final double NUMBER_OF_CALORIES_IN_ONE_STEP = 0.05;

    int convertToKm(int steps)
    {
        return (int) (steps * LENGTH_OF_ONE_STEP_IN_KM);
    }

    int convertStepsToKilocalories(int steps)
    {
        return (int) (steps * NUMBER_OF_CALORIES_IN_ONE_STEP);
    }
}