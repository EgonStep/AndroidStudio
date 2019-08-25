package com.example.dicegeneral;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@SuppressLint("DefaultLocale")
public class MainActivity extends AppCompatActivity {

    private TextView textSequence, textPlay;
    private Set<String> sections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSequence = findViewById(R.id.textSequence);
        textPlay = findViewById(R.id.textPlay);

        sections = new HashSet<>();
    }

    public void initiateGame(View view) {
        List<Integer> dices = throwDices(5);
        printSequence(dices, textPlay);

        String resultClassification = getDicesThrowsResult(dices);

        textSequence.setText(String.format("Classification - %s", resultClassification));
    }

    private List<Integer> throwDices(int unit) {
        List<Integer> dices = new ArrayList<>();
        for (int i = 0; i < unit; i++) {
            int dice = (int) (Math.random() * 6) + 1;
            dices.add(dice);
        }
        return dices;
    }

    private void printSequence(List<Integer> dices, TextView textPlay) {
        textPlay.setText("");
        for (int i = 0; i < dices.size(); i++) {
            textPlay.append(String.format("Dice %d is %d\n", i + 1, dices.get(i)));
        }
    }

    private String getDicesThrowsResult(List<Integer> dices) {
        Map<Integer, Integer> countDices = new HashMap<>();

        for (Integer dice : dices) {
            if (countDices.containsKey(dice))
                countDices.put(dice, countDices.get(dice) + 1);
            else
                countDices.put(dice, 1);
        }

        return getClassification(countDices, dices);
    }

    private String getClassification(Map<Integer, Integer> countMap, List<Integer> dices) {
        SortedSet<Integer> sortDices = new TreeSet<>(countMap.keySet());

        if (isFullHouse(countMap))
            return "Full House scored 25 points";
        else if (isYahtzee(countMap))
            return "GREAT! Yahtzee scored 50 points";
        else if (isThreeOfAKind(countMap))
            return String.format("Three Of A Kind scored %d points", getSumFromDices(dices));
        else if (isFourOfAKind(countMap))
            return String.format("Four Of A Kind scored %d points", getSumFromDices(dices));
        else if (isSmallStraight(sortDices))
            return "Small Straight scored 40 points";
        else if (isLargeStraight(sortDices))
            return "Large Straight scored 30 points";
        else
            return isUpperSection(countMap, dices);
    }

    private int getSumFromDices(List<Integer> dices) {
        int sum = 0;
        for (Integer d : dices) {
            sum += d;
        }
        return sum;
    }

    private boolean isFullHouse(Map<Integer, Integer> countMap) {
        return countMap.containsValue(2) && countMap.containsValue(3)
                && sections.add("Full House");
    }

    private boolean isYahtzee(Map<Integer, Integer> countMap) {
        return countMap.containsValue(5) && sections.add("Yahtzee");
    }

    private boolean isThreeOfAKind(Map<Integer, Integer> countMap) {
        return countMap.containsValue(3) && sections.add("Three Of A Kind");
    }

    private boolean isFourOfAKind(Map<Integer, Integer> countMap) {
        return countMap.containsValue(4) && sections.add("Four Of A Kind");
    }

    private boolean isSmallStraight(SortedSet<Integer> sort) {
        return sort.first() == 1 && sort.last() == 5
                && sort.size() == 5 && sections.add("Small Straight");
    }

    private boolean isLargeStraight(SortedSet<Integer> sort) {
        return sort.first() == 2 && sort.last() == 6
                && sort.size() == 5 && sections.add("Large Straight");
    }

    private String isUpperSection(Map<Integer, Integer> countMap, List<Integer> dices) {
        if (countMap.containsKey(6) && sections.add("Sixes"))
            return String.format("Sixes scored %d points", countMap.get(6) * 6);
        else if (countMap.containsKey(5) && sections.add("Fives"))
            return String.format("Fives scored %d points", countMap.get(5) * 5);
        else if (countMap.containsKey(4) && sections.add("Fours"))
            return String.format("Fours scored %d points", countMap.get(4) * 4);
        else if (countMap.containsKey(3) && sections.add("Threes"))
            return String.format("Threes scored %d points", countMap.get(3) * 3);
        else if (countMap.containsKey(2) && sections.add("Twos"))
            return String.format("Twos scored %d points", countMap.get(2) * 2);
        else if (countMap.containsKey(1) && sections.add("Aces"))
            return String.format("Aces scored %d points", countMap.get(1));
        else if (sections.add("Chance"))
            return String.format("Chance scored %d points", getSumFromDices(dices));
        else
            return "Points Already Marked";
    }
}
