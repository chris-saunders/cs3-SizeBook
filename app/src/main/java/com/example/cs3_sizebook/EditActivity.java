
package com.example.cs3_sizebook;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

/**
 * EditActivity handles creating and editing person objects
 */
public class EditActivity extends AppCompatActivity {
    //Text fields for the data of a Person
    EditText name;
    EditText date;
    EditText neck;
    EditText bust;
    EditText chest;
    EditText waist;
    EditText hip;
    EditText inseam;
    EditText comment;

    DatePickerDialog datePickerDialog;
    Intent intent;
    Button saveButton;
    Button cancleButton;
    Person person;
    boolean old;

    /**
     * setString gets the text from a EditText field
     * if the field is empty it returns an empty string to prevent errors
     * @param text the text field in question
     * @return a string of the text
     */
    private String setString(EditText text){
        String toString;
        try{
            toString = text.getText().toString();
        }
        catch (NumberFormatException e){
            toString = "";
        }
        return toString;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //Gets the fields for all the measurements
        name = (EditText) findViewById(R.id.nameField);
        date = (EditText) findViewById(R.id.date);
        neck = (EditText) findViewById(R.id.neck);
        bust = (EditText) findViewById(R.id.bust);
        chest = (EditText) findViewById(R.id.chest);
        waist = (EditText) findViewById(R.id.waist);
        hip = (EditText) findViewById(R.id.hip);
        inseam = (EditText) findViewById(R.id.inseam);
        comment = (EditText) findViewById(R.id.commentField);

        //Sets up the save and cancle buttons
        saveButton = (Button) findViewById(R.id.save);
        cancleButton = (Button) findViewById(R.id.cancle);

        try{
            person = (Person)getIntent().getSerializableExtra("person");
            Log.d("Test", person.toString());
            old = true;
            name.setText(person.getName());
            date.setText(person.getDate());
            neck.setText(person.getNeck().toString());
            bust.setText(person.getBust().toString());
            chest.setText(person.getChest().toString());
            waist.setText(person.getWaist().toString());
            hip.setText(person.getHip().toString());
            inseam.setText(person.getInseam().toString());
            comment.setText(person.getComment());
        }
        catch (Exception e){
            Person person = new Person();
            old = false;
        }
        /**
         * This handles the date spinner in the edit screen
         * This was made using the help of
         * http://abhiandroid.com/ui/datepicker
         * accessed on 2/3/2017
         */
        date.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             // calender class's instance and get current date , month and year from calender
             final Calendar c = Calendar.getInstance();
             int mYear = c.get(Calendar.YEAR); // current year
             int mMonth = c.get(Calendar.MONTH); // current month
             int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
             // date picker dialog
             datePickerDialog = new DatePickerDialog(EditActivity.this,
                 new DatePickerDialog.OnDateSetListener() {

                     @Override
                     public void onDateSet(DatePicker view, int year,
                                           int monthOfYear, int dayOfMonth) {
                         // set day of month , month and year value in the edit text
                         date.setText(year + "/" + (monthOfYear + 1)
                                 + "/" + dayOfMonth);
                     }
                 }, mYear, mMonth, mDay);
             datePickerDialog.show();

         }


        });

        /**
         * When the save button is clicked it commits the data in the person object
         * After it returns to the main screen passing the person object through an intent
         */
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                //If there is no name or the field is equal to
                // "please enter a name" you cannot save the file

                if (name.getText().toString() == null ||
                        name.getText().toString().isEmpty()||
                        name.getText().toString().equals("Please enter a name")){
                    name.setText("Please enter a name");
                }
                else{
                    person.setName(setString(name));
                    person.setDate(setString(date));
                    person.setNeck(setString(neck));
                    person.setBust(setString(bust));
                    person.setChest(setString(chest));
                    person.setWaist(setString(waist));
                    person.setHip(setString(hip));
                    person.setInseam(setString(inseam));
                    person.setComment(setString(comment));

                    Intent intent = new Intent();
                    intent.putExtra("person", person);
                    Log.d("Test", person.toString() + " Side Edit");
                    setResult(RESULT_OK, intent); //Intent passing modified from
                    //http://stackoverflow.com/questions/14292398/how-to-pass-data-from-2nd-activity-to-1st-activity-when-pressed-back-android
                    //Accessed on 2/3/2017

                    finish();

                }





            }
        });

        /**
         * If the cancle button is clicked it discards any changes and returns to the main screen
         */
        cancleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                setResult(RESULT_CANCELED);
                finish();
            }

        });

    }

}
