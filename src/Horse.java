import java.util.Random;

/**
 * Created by drkomp on 22.09.2016.
 */
public class Horse {
    private int distanceDone;
    private String name;
    private int num;
    public Horse(String name, int num){
        distanceDone = 0;
        this.name = name;
        this.num = num;
    }
    public void toStart(){
        distanceDone = 0;
    }
    public void oneStep(int distInct){
        distanceDone = distanceDone + distInct ;
    }

    public int getDistanceDone() {
        return distanceDone;
    }
    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Num:"+num+", "+name+ ", distance done:"+distanceDone ;
    }
}
