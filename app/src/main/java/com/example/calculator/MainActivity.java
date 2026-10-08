package com.example.calculator;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText num1,num2;
    private Button button,backBtn;

    private RadioButton addRadio,subRadio,divideRadio,multiplyRadio;
    int result;
    private Spinner spinner;

    ImageView playerImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);

        addRadio=findViewById(R.id.addRadio);
        subRadio=findViewById(R.id.subradio);
        divideRadio=findViewById(R.id.divideRadio);
        multiplyRadio=findViewById(R.id.multiplyRadio);

        button=findViewById(R.id.resultBtn);

        button.setOnClickListener(this);


        spinner=findViewById(R.id.spinnerId);
        playerImage=findViewById(R.id.playerImage);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.players_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


        String userName=getIntent().getStringExtra("username");
        Toast.makeText(MainActivity.this,"Profile : " +userName,Toast.LENGTH_SHORT).show();


        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(a -> {

            Intent intent = new Intent(MainActivity.this, LoginPage.class);
            startActivity(intent);
            finish();
            Toast.makeText(
                    MainActivity.this,
                    "Back button clicked",
                    Toast.LENGTH_SHORT
            ).show();
        });


        Log.d("MainActivity","-------------------App created!!-------------------");
    }

    @Override
    public void onClick(View v) {
        if(num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
            Toast.makeText(this,"Please enter both numbers!",Toast.LENGTH_SHORT).show();
            return;

        }
        int firstNum = Integer.parseInt(num1.getText().toString());
        int secondNum = Integer.parseInt(num2.getText().toString());
        if (addRadio.isChecked()) {

                result = firstNum + secondNum;
            } else if (subRadio.isChecked()) {
                result = secondNum - firstNum;
            } else if (divideRadio.isChecked()) {
                result = firstNum / secondNum;

            } else if(multiplyRadio.isChecked()){
                result = firstNum * secondNum;
            }
        else{
            Toast.makeText(this,"Select an operator",Toast.LENGTH_SHORT).show();
        }

            Toast.makeText(MainActivity.this, "Result is : " + result, Toast.LENGTH_LONG).show();



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0: playerImage.setImageResource(R.drawable.messi);
            break;

            case 1: playerImage.setImageResource(R.drawable.ronaldo);
            break;

            case 2: playerImage.setImageResource(R.drawable.neymar);
            break;

            case 3: playerImage.setImageResource(R.drawable.pele);
            break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




    @Override
    public void onStart(){
        super.onStart();
        Log.d("MainActivity","...................Application Started............");
    }


    @Override
    public void onRestart(){
        super.onRestart();
        Log.d("MainActivity","...................Application Restarted.................");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("MainActivity","..............Application paused.............");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("MainActivity","...................Application resumed.................");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("MainActivity","...............Application stopped...............");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MainActivity","----------------Application destroyed!!-------------");
    }
}