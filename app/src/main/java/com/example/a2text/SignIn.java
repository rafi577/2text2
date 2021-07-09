package com.example.a2text;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private EditText signInEmailText,signInPasswordText;
    private Button signIn;
    private TextView signUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInEmailText = findViewById(R.id.signInEmail);
        signInPasswordText = findViewById(R.id.signInPassword);
        signIn = findViewById(R.id.login);
        signUpText = findViewById(R.id.signUpText);

        signIn.setOnClickListener(this);
        signUpText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                break;
            case R.id.signUpText:
                //Intent intent = new Intent(getApplicationContext(),signUp.class);
                //startActivity(intent);
                Toast.makeText(SignIn.this,"success",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignIn.this,signUp.class));
                finish();
                break;
        }
    }
}