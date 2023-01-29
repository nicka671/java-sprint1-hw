import java.util.Scanner;

public class Main
{
    public static void hello()
    {
        System.out.println("Программа StepTracker");
    }



    public static void printMenu()
    {
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("0 - выйти");
    }

    public static void main(String[] args)
    {


        Scanner scanner = new Scanner(System.in);

        String username = "";

        StepTracker stepTracker = new StepTracker(scanner);
        String doYouWantMenu;


        Main.hello();


        {
            if (username.equals("")) {
                System.out.println("Добро пожаловать, введите имя!");
                username = scanner.nextLine();
                System.out.println("Добро пожаловать, " + username + "!");
                System.out.println("Вы хотите прочитать меню? Введите ДА или НЕТ");
                doYouWantMenu = scanner.nextLine().toLowerCase();
                if (doYouWantMenu.equals("да"))
                {
                    Main.printMenu();
                }

            } else if (!username.equals("")) {
                System.out.println("Добро пожаловать, " + username + "!");
                System.out.println("Вы хотите прочитать меню? Введите ДА или НЕТ");
                doYouWantMenu = scanner.nextLine().toLowerCase();
                if (doYouWantMenu.equals("да"))
                {
                    Main.printMenu();
                }
            }
        }


        int number = scanner.nextInt();


        while (true)
        {
            if (number == 1)
            {
                System.out.println("Выполняется команда 1");
                stepTracker.addNewNumberStepsPerDay();
                break;


            } else if (number == 2)
            {
                System.out.println("Выполняется команда 2");
                System.out.println("Введите число шагов, которое является целью");
                stepTracker.goalByStepsPerDay();
                break;

            } else if (number == 3)
            {
                System.out.println("Выполняется команда 3");
                stepTracker.printStatistic();
                break;

            } else if ( number == 0) {
                return;

            } else {
                System.out.println("Такой команды нет");
                return;
            }
        }



    }

}