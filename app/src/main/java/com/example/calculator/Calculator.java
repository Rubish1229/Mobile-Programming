package com.example.calculator;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class Calculator extends AppCompatActivity implements View.OnClickListener{

    private Button fragmentBtn;

    private boolean status=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        fragmentBtn=findViewById(R.id.fragmentButton);
        fragmentBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager=getSupportFragmentManager();

        if(status){
            FirstFragment firstFragment= new FirstFragment();
            fragmentManager.beginTransaction().replace(R.id.fragementContainer,firstFragment)
                    .commit();
            fragmentBtn.setText("Load Second fragment");
            status=false;
        }else{
            SecondFragment secondFragment=new SecondFragment();
            fragmentManager.beginTransaction().replace(R.id.fragementContainer,secondFragment)
                    .commit();
            fragmentBtn.setText("Load First fragment");
            status=true;
        }

    }
}