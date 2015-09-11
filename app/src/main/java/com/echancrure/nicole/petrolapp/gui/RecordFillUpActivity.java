package com.echancrure.nicole.petrolapp.gui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.echancrure.nicole.petrolapp.R;

import java.util.Calendar;

import services.UTCTime;

public class RecordFillUpActivity extends AppCompatActivity {
    private final static String TAG = "RecordFillUpActivity";
    /** time formatter */
    private UTCTime uTCTimeFormatter = new UTCTime();
    /** the UTC date and time of the fill up */
    private long uTCDateTime;
    /** the date picker */
    private DatePicker dateTimeTextView;
    /** the view holding the odometer reading */
    private TextView odometerTextView;
    /** the view holding the price reading */
    private TextView priceTextView;
    /** the view holding the volume reading */
    private TextView volumeTextView;
    /** the odometer value to save */
    private int odometer;
    /** the price to save */
    private int price;
    /** the volume to save */
    private float volume;
    /** the partial indication of the fill up */
    private boolean partial;
    /** the fill up object created */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_fill_up);
        this.uTCDateTime = System.currentTimeMillis();
//        this.dateTimeTextView = (DatePicker) findViewById(R.id.datePicker);
//        this.dateTimeTextView.setMaxDate(this.uTCDateTime); //cannot select a date of fill-up into the future
        this.odometerTextView = (TextView) findViewById(R.id.odometerField);
        this.volumeTextView = (TextView) findViewById(R.id.volumeField);
        this.priceTextView = (TextView) findViewById(R.id.priceField);
    }

    /**
     * handler for all the views on the screen
     * @param view the sender
     */
    public void onClick(View view){
        Log.d(TAG, "onClick received");
        switch (view.getId()) {
            case R.id.submitButton:
                handleSubmitButtonOnClick();
                break;
            case R.id.cancelButton:
                this.finish();
                break;
            case R.id.cameraButton:
                Toast.makeText(RecordFillUpActivity.this, "Camera function not yet implemented", Toast.LENGTH_LONG).show();
                break;
            default:
                Log.d(TAG, "ignored click event on:" + view.getId());
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }
    /**
     * handle a fill-up submit: check that all the fields are in the correct format and send to the controller
     */
    private void handleSubmitButtonOnClick() {
        //TODO
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }
    }
}
