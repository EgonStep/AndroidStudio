package com.example.listopet;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {

    private int resourceId;

    public CourseAdapter(Context context, int resource, List<Course> courses) {
        super(context, resource, courses);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View myView = currentView;

        myView = inflateView(myView);

        TextView textCourse = myView.findViewById(R.id.textCourse);
        TextView textScore = myView.findViewById(R.id.textScore);

        Course course = getItem(position);

        setScoreColor(textScore, course);

        textCourse.setText(course.getName());
        textScore.setText(String.valueOf(course.getScore()));

        return myView;
    }

    private View inflateView(View myView) {
        if (myView == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(resourceId, null);
        }
        return myView;
    }

    private void setScoreColor(TextView textScore, Course course) {
        if (course.getScore() >= 7.0)
            textScore.setTextColor(Color.BLUE);
        else if (course.getScore() >= 4.0 && course.getScore() < 7)
            textScore.setTextColor(Color.MAGENTA);
        else
            textScore.setTextColor(Color.RED);
    }
}
