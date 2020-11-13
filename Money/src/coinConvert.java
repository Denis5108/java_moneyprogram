import java.util.Scanner;

public class coinConvert {
    static Integer promptMoney() {
        Scanner getMoney = new Scanner(System.in);
        System.out.print("Please enter your total savings: $");
        Integer money = getMoney.nextInt();
        return money;
    }

    static Integer addMoney(Integer oldMoney, Integer newMoney) {
        oldMoney += newMoney;
        return oldMoney;
    }
    static Integer subtractMoney(Integer oldMoney, Integer newMoney) {
        if (oldMoney > 0 && newMoney < oldMoney) {
            oldMoney -= newMoney;
        } else {
            System.out.println("Withdraw of '" + newMoney + "$' not accepted. You have exceeded your limit.");
        }
        return oldMoney;
    }
    static int unitedDollars(Integer money)  {
        return money;
    }
    static Integer candianDollars(Integer money) {
        return money * (int)1.33;
    }
    static Integer russianDollars(Integer money) {
        return money * (int)76.15;
    }
    static Integer britishDollars(Integer money) {
        return money * (int)23.5;
    }
    static void checkMoney(Integer moneyOld) {
        System.out.println(
                "Your money           : " + moneyOld                 + '\n' +
                "United States Dollars: " + unitedDollars(moneyOld)  + '\n' +
                "Canadian Dollars     : " + candianDollars(moneyOld) + '\n' +
                "Russian  Dollars     : " + russianDollars(moneyOld) + '\n' +
                "British  Dollars     : " + britishDollars(moneyOld)
        );
    }
    static void menu() {
        Integer money = promptMoney();
        Scanner mode = new Scanner(System.in);
        // Code goes in here
        Boolean done = false;
        while (!done) {
            System.out.println("1. Add Money"     + '\n' +
                    "2. Take Money"               + '\n' +
                    "3. Check balance"            + '\n' +
                    "4. Quit");
            Integer choice = mode.nextInt();
            // add money to your account.
            if (choice == 1) {
                System.out.println("How much do you want to add?");
                money = addMoney(money, mode.nextInt());
            }
            // take money out of your account
            else if (choice == 2) {
                System.out.println("How much do you want to take?");
                money = subtractMoney(money, mode.nextInt());
            }
            // check the money in your account.
            else if (choice == 3) {
                checkMoney(money);
            }
            // quit the program
            else if (choice == 4) {
                done = true;
            } else {
                System.out.println("Response '" + choice + "' not recognized");
            }
        }
    }
    public static void main(String[] args) {
        menu();
        System.out.println("Program closed");
    }
}