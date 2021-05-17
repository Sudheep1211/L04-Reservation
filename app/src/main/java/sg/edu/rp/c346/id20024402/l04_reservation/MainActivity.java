package sg.edu.rp.c346.id20024402.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    EditText name;
    EditText mobileNum;
    EditText size;
    RadioGroup area;
    Button btnBook;
    Button btnReset;
    RadioButton smoking;
    RadioButton NonSmoking;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        name = findViewById(R.id.editTextName);
        mobileNum = findViewById(R.id.editTextMobile);
        size = findViewById(R.id.editTextSize);
        area = findViewById(R.id.RgArea);
        btnBook = findViewById(R.id.buttonBook);
        btnReset = findViewById(R.id.buttonReset);
        display = findViewById(R.id.textViewDisplay);


        dp.updateDate(2020, 5, 1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
                message = "Name - " + name.getText() + "\n";
                message += "Mobile Number - " + mobileNum.getText() + "\n";
                message += "Group Size - " + size.getText() + "\n";

                if(tp.getCurrentMinute() < 10){
                    message += "Reservation time - " + tp.getCurrentHour() + ":0" + tp.getCurrentMinute() + "\n";
                } else{
                    message += "Reservation time - " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + "\n";
                }

                message += "Reservation date - " + dp.getDayOfMonth() +"/" + (dp.getMonth() + 1) + "/" + dp.getYear() + "\n";

                if(area.getCheckedRadioButtonId() == R.id.radioButtonSmoking){
                    message += "Table area - Smoking";
                }else{
                    message += "Table area - Non-Smoking";
                }

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                display.setText("Booking Confirmed!");


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                mobileNum.setText("");
                size.setText("");
                area.clearCheck();
                display.setText("");

                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

            }
        });





    }
}