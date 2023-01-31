import java.util.Scanner;

public class StepTracker
{
    Scanner scanner;
    MonthData[] monthToData;

    Converter converter = new Converter();

    int goalByStepsPerDay = 10000;

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;
        monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++)
        {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {

        // Как тут сделать break c меткой, чтобы в случае ввода неправильного значения месяца, дня и
        // количества шагов программа заставляла нас заново их ввести?

        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month >= 0 && month <= 11) {
            System.out.println("Введите номер дня");
            int day = scanner.nextInt();
            if (day >= 1 && day <= 30) {
                System.out.println("Введите количество шагов");
                int step = scanner.nextInt();
                if (step > 0) {
                    monthToData[month].days[day - 1] = step;
                    return;
                } else {
                    System.out.println("Количество шагов должно быть положительным числом!");
                    return;
                }
            } else {

                System.out.println("Введите номер дня от 1 до 30 включительно");
                return;
            }

        } else {
            System.out.println("Введите номер месяца от 0 до 11 включительно");
            return;

        }

    }




    void goalByStepsPerDay() {
        int stepsOfUser = scanner.nextInt();
        if (stepsOfUser > 0)
        {
            goalByStepsPerDay = stepsOfUser;
            return;

        } else {
            System.out.println("Количество шагов должно быть больше 0!");
        }

    }


    void printStatistic()
    {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if (monthNumber >= 0 && monthNumber <= 11)
        {
            monthToData[monthNumber].printDaysAndStepsFromMonth();
            System.out.println("Сумма шагов за месяц: " + monthToData[monthNumber].sumStepsFromMonth());
            System.out.println("Максимальное кол-во шагов за месяц: " + monthToData[monthNumber].maxSteps());
            System.out.println("Среднее кол-во шагов за месяц: " + ((monthToData[monthNumber].sumStepsFromMonth()) / 30));
            System.out.println("Пройденная дистанция в км: " + converter.convertToKm(monthToData[monthNumber].sumStepsFromMonth()));
            System.out.println("Сколько ккал вы сожгли: " +converter.convertStepsToKilocalories(monthToData[monthNumber].sumStepsFromMonth()));
            System.out.println("Самая долгая серия дней, где поставленная цель по шагам была достигнута: " + monthToData[monthNumber].bestSeries(goalByStepsPerDay));
            return;
        } else {
            System.out.println("Введите, пожалуйста, номер месяца в интервале от 0 до 11 включительно!");
            return;

        }

    }
}