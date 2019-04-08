package com.example.comp1661androidjavagit;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    Button btnDatePicker, btnTimePicker, btnAddStorage;
    EditText txtDate, txtTime, txtDimension, txtMonthlyPrice, txtReporter, txtNotes;
    Spinner spinStorageType;

    String date, time, dimension, monthlyPrice, reporter, notes, storageType;

    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);


        txtDimension = (EditText) findViewById(R.id.editTextDimension);
        txtMonthlyPrice = (EditText) findViewById(R.id.editTextMonthlyPrice);
        txtReporter = (EditText) findViewById(R.id.editTextReporter);
        txtNotes = (EditText) findViewById(R.id.editTextNotes);

        spinStorageType = (Spinner) findViewById(R.id.spinnerStorageType);

        btnAddStorage = (Button) findViewById(R.id.btnAdd);
        btnAddStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notes = txtNotes.getText().toString().trim();

                dimension = txtDimension.getText().toString().trim();
                if (dimension.equalsIgnoreCase("")) {
                    txtDimension.setError("This field can not be blank!");
                } else {
                    txtDimension.setError(null);
                }

                date = txtDate.getText().toString().trim();
                if (date.equalsIgnoreCase("")) {
                    txtDate.setError("This field can not be blank!");
                } else {
                    txtDate.setError(null);
                }

                time = txtTime.getText().toString().trim();
                if (time.equalsIgnoreCase("")) {
                    txtTime.setError("This field can not be blank!");
                } else {
                    txtTime.setError(null);
                }

                monthlyPrice = txtMonthlyPrice.getText().toString().trim();
                if (monthlyPrice.equalsIgnoreCase("")) {
                    txtMonthlyPrice.setError("This field can not be blank!");
                } else {
                    txtMonthlyPrice.setError(null);
                }

                reporter = txtReporter.getText().toString().trim();
                if (reporter.equalsIgnoreCase("")) {
                    txtReporter.setError("This field can not be blank!");
                } else {
                    txtReporter.setError(null);
                }

                storageType = spinStorageType.getSelectedItem().toString();
                if (storageType.equalsIgnoreCase("choose option")) {
                    setSpinnerError(spinStorageType, "This field can not be blank!");
                }
            }
        });
    }

    private void setSpinnerError(Spinner spinner, String error) {
        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            spinner.requestFocus();
            TextView selectedTextView = (TextView) selectedView;
            selectedTextView.setError(error); // any name of the error will do
            selectedTextView.setTextColor(Color.RED); //text color in which you want your error message to be displayed
            selectedTextView.setText(error); // actual error message
//            spinner.performClick(); // to open the spinner list if error is found.

        }
    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
