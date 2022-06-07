import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow(1 + y / 12, 12 * d);
        return round(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return round(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period;
        int depositType;
        double futureAmount = 0;
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println(
            "Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        if (depositType == 1) {
            futureAmount = calculateSimplePercent(depositAmount, 0.06, period);
        } else if (depositType == 2) {
            futureAmount = calculateComplexPercent(depositAmount, 0.06, period);
        }

        System.out.println("Результат вклада: " + depositAmount + " за " + period
            + " лет превратятся в " + futureAmount);
    }
}
