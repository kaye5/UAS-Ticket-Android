package com.kaye.ticket.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kaye.ticket.R;
import com.kaye.ticket.ui.login.LoginActivity;

public class Register extends AppCompatActivity {

    TextView login;
    Button register;
    EditText email,password,confirmPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPass = findViewById(R.id.confirmPassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isInputValidate()){
                    registerDone(email.getText().toString());
                    Intent register= new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(register);
                    finish();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private Boolean isInputValidate(){
        String pass = password.getText().toString();
        String cPass = confirmPass.getText().toString();
        if(!isValidEmail(email.getText())){
            email.setError(("Invalid Email"));
            registerError("Invalid Email");
            return false;
        }
        else if(!pass.equals(cPass)){
            confirmPass.setError("Password not match");
            registerError("Password not match");
            return false;
        } else if(pass.length() < 5){
            confirmPass.setError("Password length must be > 5");
        }
        return true;
    }

    private void registerDone(String username){
        String msg = "Verification has been sent to " + username;
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private void registerError(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

}