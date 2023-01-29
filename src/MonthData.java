public class MonthData
{
    int[] days = new int[30];

    void printDaysAndStepsFromMonth()
    {
        for (int i = 0; i < 30; i++) {
            System.out.println( (i + 1) + " день: " + days[i]);
        }
    }



    int sumStepsFromMonth() {
        int sumDays = 0;
        for (int i = 0; i < 30; i++) {
            sumDays += days[i];
        }

        return sumDays;
    }

    int maxSteps()
    {
        int maxStepsValue = 0;
        for (int i = 0; i < 30; i++) {
            if ( days[i] > maxStepsValue)
            {
                maxStepsValue = days[i];
            }

        }
        return maxStepsValue;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSession = 0;
        int countBest = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] > goalByStepsPerDay && days[i+1] > goalByStepsPerDay)
            {
                countBest += 1;
            } else if (days[i] > goalByStepsPerDay && days[i+1] < goalByStepsPerDay)
            {
                countBest += 1;
                if (bestSession <= countBest)
                {
                    bestSession = countBest;
                    countBest = 0;
                } else {
                    countBest = 0;
                }

            } else if (days[29] > goalByStepsPerDay)
            {
                countBest += 1;

                if (bestSession <= countBest)
                {
                    bestSession = countBest;
                }
            }
        }
        return bestSession;
    }


}
