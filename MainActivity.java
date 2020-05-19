package sg.edu.np.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */
    final String TAG = "Whack-A-Mole!";
    Button btn1;
    Button btn2;
    Button btn3;
    int randomLocation, Score;
    TextView textScore;


    List<Button> buttonList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        textScore = (TextView) findViewById(R.id.textScore);
        buttonList.add(btn1);
        buttonList.add(btn2);
        buttonList.add(btn3);


        Log.v(TAG, "Finished Pre-Initialisation!");
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG, "Button Left clicked!");
                if (btn1.getText() == "*"){
                    Score++;
                    Log.v(TAG, "Hit Score added!");
                }
                else{
                    Score--;
                    Log.v(TAG, "Missed, score deducted!");
                }
                textScore.setText(Integer.toString(Score));
                setNewMole();
            }

        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG, "Button Middle clicked!");
                if (btn2.getText() == "*"){
                    Score++;
                    Log.v(TAG, "Hit Score added!");
                }
                else{
                    Score--;
                    Log.v(TAG, "Missed, score deducted!");
                }
                textScore.setText(Integer.toString(Score));
                setNewMole();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v(TAG, "Button Right clicked!");
                if (btn3.getText() == "*"){
                    Score++;
                    Log.v(TAG, "Hit Score added!");
                }
                else{
                    Score--;
                    Log.v(TAG, "Missed, score deducted!");
                }
                textScore.setText(Integer.toString(Score));
                setNewMole();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        btn1.setText("O");
        btn2.setText("O");
        btn3.setText("O");
        buttonList.get(randomLocation).setText("*");
    }

}
