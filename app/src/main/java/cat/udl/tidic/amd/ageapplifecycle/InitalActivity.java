package cat.udl.tidic.amd.ageapplifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import cat.udl.tidic.amd.ageapplifecycle.models.UserModel;

public class InitalActivity extends TracerActivity {

    String TAG = this.getClass().getName();
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "Associating the activity with the view");
        setContentView(R.layout.activity_inital);

        Log.d(TAG, "Linking views to the activity");
        startButton = findViewById(R.id.button_start);
    }

    @Override
    protected void onStart() {
        super.onStart();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Starting a new activity");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "Unregister of View click listeners");
        startButton.setOnClickListener(null);
    }


}
