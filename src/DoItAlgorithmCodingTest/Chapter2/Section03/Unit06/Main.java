package DoItAlgorithmCodingTest.Chapter2.Section03.Unit06;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Score> myarr = new ArrayList<>();
        myarr.add(new Score(80, 100));
        myarr.add(new Score(100, 50));
        myarr.add(new Score(70, 100));
        myarr.add(new Score(80, 90));

        Collections.sort(myarr, new ScoreComparator());
        for (Score s : myarr) {
            System.out.println(s.toString());
        }
    }
}
