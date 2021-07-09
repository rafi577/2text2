package com.example.a2text;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity implements View.OnClickListener {

    private EditText signUpEmailText,signUpPasswordText;
    private Button sUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        signUpEmailText = findViewById(R.id.signUpEmail);
        signUpPasswordText = findViewById(R.id.signUpPassword);
        sUp = findViewById(R.id.signUpId);

        sUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signUpId:
                userRegistration();
                break;
        }
    }

    private void userRegistration() {
        String e = signUpEmailText.getText().toString().trim();
        String p = signUpPasswordText.getText().toString().trim();

        if(e.isEmpty()){
            //signUpEmailText.setError("enter an email");
            //signUpEmailText.requestFocus();
            Toast.makeText(signUp.this,"Enter an Email", Toast.LENGTH_SHORT).show();
        }
        else if(p.isEmpty()){
            signUpPasswordText.setError("enter a password");
            signUpPasswordText.requestFocus();
        }
        else if(p.length()<6){
            signUpPasswordText.setError("length must be more then 5");
        }
        else{
            //Toast.makeText(signUp.this,"sign up clicked",Toast.LENGTH_SHORT).show();
            reg(e,p);
        }
    }
    private  void reg(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(signUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(signUp.this,"Loading",Toast.LENGTH_SHORT).show();
                        if (task.isSuccessful()) {
                            Toast.makeText(signUp.this,"sign up success",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(signUp.this,"sign up not success",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}