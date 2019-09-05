package com.example.listopet;

import android.content.Context;
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

        if (myView == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(resourceId, null);
        }

        TextView textCourse = myView.findViewById(R.id.textCourse);
        TextView textScore = myView.findViewById(R.id.textScore);

        Course course = getItem(position);

        textCourse.setText(course.getName());
        textScore.setText(String.valueOf(course.getScore()));

        return myView;
    }
}
