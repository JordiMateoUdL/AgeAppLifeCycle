package cat.udl.tidic.amd.ageapplifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import cat.udl.tidic.amd.ageapplifecycle.models.UserModel;

public class MainActivity extends TracerActivity  {


    String TAG = this.getClass().getName();

    private TextView bioTextView;
    private EditText fullNameEditText;
    private DatePicker birthdayDatePicker;
    private Button  updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Associating the activity with the view");
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Linking views to the activity");
        bioTextView = findViewById(R.id.textView_bio);
        fullNameEditText = findViewById(R.id.editText_fullName);
        birthdayDatePicker = findViewById(R.id.datePicker_birthday);
        updateButton = findViewById(R.id.button_update);



    }

    @Override
    protected void onStart() {
        super.onStart();

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fullNameEditText.getText().toString();
                Calendar c = Calendar.getInstance();
                c.set(birthdayDatePicker.getYear(), birthdayDatePicker.getMonth(),
                        birthdayDatePicker.getDayOfMonth());
                Date birthday = new Date(c.getTimeInMillis());
                UserModel u = new UserModel(name,birthday);
                bioTextView.setText(u.toString());
            }
        });



    }


}
