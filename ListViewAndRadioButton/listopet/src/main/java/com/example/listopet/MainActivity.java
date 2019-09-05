package com.example.listopet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Course> courses;
    private ListView listCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCourse = findViewById(R.id.listExample);
    }

    @Override
    protected void onStart() {
        super.onStart();
        courses = new ArrayList<>();
        courses.add(new Course("Algorithm", 8.8));
        courses.add(new Course("Database", 6.8));
        courses.add(new Course("DevOps", 8.3));

        ArrayAdapter adapter = new CourseAdapter(getApplicationContext(),
                R.layout.list_item, courses);
        listCourse.setAdapter(adapter);
    }
}
