package com.example.dicegeneral;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView textScore, textSequence, textPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textScore = findViewById(R.id.textScore);
        textSequence = findViewById(R.id.textSequence);
        textPlay = findViewById(R.id.textPlay);
    }

    public void initiateGame(View view) {
        List<Integer> dices = throwDices(5);
        printSequence(dices, textSequence);
        int result = getDicesThrowsResult(dices);
    }

    private List<Integer> throwDices(int unit) {
        List<Integer> dices = new ArrayList<>();
        for (int i = 0; i < unit; i++) {
            int var = (int) (Math.random() * 6) + 1;
            dices.add(var);
        }
        return dices;
    }

    private void printSequence(List<Integer> dices, TextView textSequence) {
        textSequence.setText("");
        for (int i = 0; i < dices.size(); i++) {
            textSequence.append(String.format("Dice %d is %d\n", i+1, dices.get(i)));
        }
    }

    private int getDicesThrowsResult(List<Integer> dices) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer dice : dices) {
            if (countMap.containsKey(dice))
                countMap.put(dice, countMap.get(dice) + 1);
            else
                countMap.put(dice, 1);
        }

        return returnResult(dices, countMap);
    }

    private int returnResult(List<Integer> dices, Map<Integer, Integer> countMap) {
        if (countMap.containsValue(2) && countMap.containsValue(3)) {
            return 25;
        } else if (countMap.containsValue(5)) {
            return 50;
        } else if (countMap.containsValue(3) || countMap.containsValue(4)) {
            int sum = 0;
            for (Integer d : dices)
                sum += d;
            return sum;
        } else {
            return 0;
        }
    }

    private void restartGame() {
        textPlay.setText(String.format("Restarting Game..."));
        textSequence.setText("");
        textScore.setText("");
    }
}
