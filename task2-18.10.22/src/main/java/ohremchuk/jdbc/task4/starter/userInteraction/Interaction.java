package ohremchuk.jdbc.task4.starter.userInteraction;

import lombok.SneakyThrows;
import ohremchuk.jdbc.task4.starter.dataAccess.CostsInfoImpl;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.exit;

public class Interaction {
    @SneakyThrows
    public void displayInConsole() {
        Scanner scanner = new Scanner(System.in);
        CostsInfoImpl costsInfo = new CostsInfoImpl();
        while (true) {
            showMethods();
            int select = scanner.nextInt();
            switch (select) {
                case 1: {
                    costsInfo.readAllFromDb();
                    break;
                }
                case 2: {
                    Scanner in = new Scanner(System.in).useLocale(Locale.ENGLISH);
                    int id;
                    double value;
                    System.out.println("Enter id:");
                    id = in.nextInt();
                    System.out.println("Enter cost value:");
                    value = in.nextDouble();
                    costsInfo.addExpensesToDb(id, value);
                    break;
                }
                case 3: {
                    costsInfo.deleteRecordsFromDb();
                    break;
                }
                case 4:{
                    exit(1);
                }
                default:
                    System.out.println("Incorrect input!");
            }
        }
    }
    private static void showMethods() {
        System.out.println("--- Select: ---");
        System.out.println("1. Show data in database");
        System.out.println("2. Add cost data");
        System.out.println("3. Delete data from database");
        System.out.println("4. Exit");
    }
}
