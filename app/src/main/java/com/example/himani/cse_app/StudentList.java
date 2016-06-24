package com.example.himani.cse_app;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentList extends Activity {
    private ArrayAdapter<String> listAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        ListView mainListView = (ListView) findViewById(R.id.list_student);



// Create and populate a List of planet names.
        String[] menu = new String[] { "Profile","Attendance","TimeTable","Feedback","Extras"};




        ArrayList<String> menuList = new ArrayList<String>();
        menuList.addAll( Arrays.asList(menu) );




// Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simple_list, menuList);
        mainListView.setAdapter(listAdapter);
    }
}
