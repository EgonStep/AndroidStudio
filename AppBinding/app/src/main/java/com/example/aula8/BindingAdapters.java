package com.example.aula8;

import android.content.Context;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    @BindingAdapter("app:changeColor")
    public static void changeTextColor(TextView view, Integer likes) {
        Context context = view.getContext();
        int color = 0;

        if (likes < 10)
            color = context.getColor(R.color.low);
        else if (likes < 25)
            color = context.getColor(R.color.medium);
        else
            color = context.getColor(R.color.high);

        view.setTextColor(color);
    }
}
