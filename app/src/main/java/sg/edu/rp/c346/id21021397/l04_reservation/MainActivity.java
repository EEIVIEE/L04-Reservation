package sg.edu.rp.c346.id21021397.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText phone;
    DatePicker dp;
    TimePicker tp;
    ToggleButton btnSmoke;
    Button btnReserve;
    Button btnReset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        phone = findViewById(R.id.editTextPhone);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnSmoke = findViewById(R.id.toggleSmoke);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);

        tp.setCurrentHour(0);
        tp.setCurrentMinute(0);
        dp.updateDate(2020,5,1);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Log.i("TimePicker", "Inside onClick()");
                hourOfDay = view.getCurrentHour();
                if(hourOfDay <= 20 && hourOfDay >= 8){

                }else if(hourOfDay > 20){
                    view.setCurrentHour(20);
                }else{
                    view.setCurrentHour(8);
                }
            }
        });




        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Reserve", "Inside onClick()");
                if(name.length() != 0 && phone.length() != 0){
                    Toast.makeText(getApplicationContext(),"Name: " + name.getText() + "\n" +
                            "Phone: " + phone.getText() + "\n"+
                            "Date: "+ dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear() + "\n" +
                            "Time: "+tp.getCurrentHour() +":"+ tp.getCurrentMinute() + "\n"+
                            "Table: " + btnSmoke.getText(),Toast.LENGTH_SHORT ).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Please Fill all the fields",Toast.LENGTH_SHORT ).show();
                }


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Reset", "Inside onClick()");
                name.setText("");
                phone.setText("");
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020,5,1);
                btnSmoke.setChecked(true);
            }
        });
    }
}