/**
 * Created by drkomp on 25.09.2016.
 */
public class Bet {
    private String gamersName;
    private int numHorse;
    private int bet;

    public int getNumHorse() {
        return numHorse;
    }

    public String getGamersName() {
        return gamersName;
    }

    public int getBet() {
        return bet;
    }

    public Bet(int numHorse, String gamersName, int bet) {
        this.numHorse = numHorse;
        this.gamersName = gamersName;
        this.bet = bet;
    }

    @Override
    public String toString() {
        return gamersName+" has rate "+bet+" USD to "+numHorse+" horse.";
    }
}
