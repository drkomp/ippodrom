import java.util.ArrayList;
import java.util.Random;

/**
 * Created by drkomp on 22.09.2016.
 */
public class HorsesRun extends Thread {
    private ArrayList<Horse> houseHerd;
    private Random random;
    private boolean isHaveWinner;
    private Horse winner;
    private int finishDistance;

    public HorsesRun(ArrayList<Horse> houseHerd, int finishDistance) {
        this.houseHerd = houseHerd;
        random = new Random(50);
        this.finishDistance = finishDistance;

    }

    public boolean isHaveWinner() {
        return isHaveWinner;
    }

    public Horse getWinner() {
        return winner;
    }

    @Override
    public void run() {
        while (!isHaveWinner) {
            for (Horse horse : houseHerd) {
                horse.oneStep(random.nextInt(10) + 1);
                if (horse.getDistanceDone() >= finishDistance) {
                    isHaveWinner =  true;
                    winner = horse;
                    break;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Some interrupt... ooops");
            }
        }
    }
}
