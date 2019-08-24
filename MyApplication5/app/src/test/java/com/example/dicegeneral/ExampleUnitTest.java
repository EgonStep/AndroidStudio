package com.example.dicegeneral;

import android.widget.TextView;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        List<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(5);
        lista.add(5);
        lista.add(5);
        lista.add(5);

        int result = getDicesThrowsResult((lista));

        assertEquals(result, 50);
    }

    private int getDicesThrowsResult(List<Integer> dices) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int sum = 0;

        for (Integer dice : dices) {
            if (countMap.containsKey(dice))
                countMap.put(dice, countMap.get(dice) + 1);
            else
                countMap.put(dice, 1);
        }

        if (countMap.containsValue(2) && countMap.containsValue(3)) {
            return 25;
        } else if (countMap.containsValue(5)) {
            return 50;
        } else if (countMap.containsValue(3) || countMap.containsValue(4)) {
            for (Integer d : dices)
                sum += d;
            return sum;
        } else {
            return 0;
        }
    }
}