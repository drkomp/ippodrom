import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by drkomp on 22.09.2016.
 */
public class Racing {
    public static void main(String[] args) {
        int finish = 500;
        Scanner input = new Scanner(System.in);
        String[] horsesName = {"Pops", "Mops", "Fast", "Hero", "Sasha"};
        ArrayList<Horse> horses = new ArrayList<>();
        int horsesNum = 0;
        for (String hn : horsesName) {
            horses.add(new Horse(hn, ++horsesNum));
        }
        ArrayList<Bet> bets = new ArrayList<>();
        HorsesRun hR = new HorsesRun(horses, finish);
        hR.start();
        String gamersName;
        int bet;
        int horseNum;
        do {
            showResults(horses);
            System.out.print("Gamer name: ");
            gamersName = input.next();
            System.out.print("Horse num: ");
            horseNum = input.nextInt();
            System.out.print("Your bet: ");
            bet = input.nextInt();
            bets.add(new Bet(horseNum, gamersName, bet));
//            try {
//                Thread.sleep(500);
//            }
//            catch (InterruptedException e){
//                System.out.println("Some interrupt... ooops");
//            }
        } while (!hR.isHaveWinner());
        showResults(horses);
        System.out.println("Winner is: " + hR.getWinner());
        int totalSum = 0;
        int winnersSum = 0;
        ArrayList<Bet> winnersBets = new ArrayList<>();
        for (Bet b : bets) {
            totalSum += b.getBet();
            if (b.getNumHorse() == hR.getWinner().getNum()) {
                winnersSum += b.getBet();
                winnersBets.add(b);
            }
        }
        double k = 0;
        if (winnersBets.size() > 0) {
            System.out.println("Winner gamers:");
            k = (totalSum * 0.9) / winnersSum;
        }
        for (Bet b : winnersBets
                ) {
            System.out.println(b.toString() + "His prize is " + (k * b.getBet())+" USD");


        }

    }

    public static void showResults(ArrayList<Horse> horses) {
        for (Horse h : horses) {
            System.out.println(h);
        }
    }

}
