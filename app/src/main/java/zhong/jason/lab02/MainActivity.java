package zhong.jason.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton, userButton;
    TextView greetingDisplay;
    EditText enterBut;
    int count = 0;
    String[] planets;
    RadioButton leftRadBut, rightRadBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        planets = getResources().getStringArray(R.array.planets_array);
        leftRadBut = findViewById(R.id.radio_left);
        rightRadBut = findViewById(R.id.radio_right);
        enterBut = findViewById(R.id.userInput);
        userButton = findViewById(R.id.userInputBut);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("incrementing: " + ++count);
//                Log.i("incrementing", "" + count);
//                greetingDisplay.setText(getString(R.string.likes_count,count));
                if(rightRadBut.isChecked()) {
                    count = ++count % planets.length;
                    greetingDisplay.setText(planets[count]);
                }


            }
        });
    }

    public void decrement(View view) {
//        System.out.println("decrementing: " + --count);
//        Log.i("decrementing", "" + count);
//        greetingDisplay.setText(getString(R.string.likes_count,count));
        if (leftRadBut.isChecked()) {
            if (--count < 0) count = planets.length - 1;
            greetingDisplay.setText(planets[count]);
        }
    }
    public void enterMethod(View view){
        Editable dis = enterBut.getText();
        greetingDisplay.setText(dis);
        enterBut.setVisibility(View.INVISIBLE);
        userButton.setVisibility(View.INVISIBLE);
    }
}