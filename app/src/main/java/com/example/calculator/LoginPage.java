package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPage extends AppCompatActivity implements View.OnClickListener{

    EditText username;
    EditText password;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

username=findViewById(R.id.username);
password=findViewById(R.id.password);
loginBtn=findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user=username.getText().toString();
        String pwd=password.getText().toString();

        if(user.equals("rubish")&& pwd.equals("123")){
            Intent intent=new Intent(LoginPage.this,MainActivity.class);
            intent.putExtra("username",user);
            startActivity(intent);
            Toast.makeText(LoginPage.this,"Logged in successful",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(LoginPage.this,"Invalid username or password",Toast.LENGTH_SHORT).show();
        }


    }





}