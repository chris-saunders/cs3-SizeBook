package com.example.cs3_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * viewActivity is the class that handles displaying a persons values in detail
 * it uses the view activity_view
 */
public class ViewActivity extends AppCompatActivity {

    //All the text fields
    TextView name;
    TextView date;
    TextView neck;
    TextView bust;
    TextView chest;
    TextView waist;
    TextView hip;
    TextView inseam;
    TextView comment;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //Getting all the text fields
        name = (TextView) findViewById(R.id.name);
        date = (TextView) findViewById(R.id.date);
        neck = (TextView) findViewById(R.id.neck);
        bust = (TextView) findViewById(R.id.bust);
        chest = (TextView) findViewById(R.id.chest);
        waist = (TextView) findViewById(R.id.waist);
        hip = (TextView) findViewById(R.id.hip);
        inseam = (TextView) findViewById(R.id.inseam);
        comment = (TextView) findViewById(R.id.comment);

        //Setting all the text fields
        Person person = (Person) getIntent().getSerializableExtra("person");
        name.setText("Name: " + person.getName());
        date.setText("Date: " + person.getDate());
        neck.setText("Neck (Inches): " + person.getNeck());
        bust.setText("Bust (Inches): " + person.getBust());
        chest.setText("Chest (Inches): " + person.getChest());
        waist.setText("Waist (Inches): " + person.getWaist());
        hip.setText("Hip (Inches): " + person.getHip());
        inseam.setText("Inseam (Inches): " + person.getInseam());
        comment.setText(person.getComment());
    }
}
