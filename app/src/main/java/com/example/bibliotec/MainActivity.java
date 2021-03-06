package com.example.bibliotec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usr, passwd;
    TextView aqui;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usr = (EditText) findViewById(R.id.username);
        passwd = (EditText) findViewById(R.id.password);
        aqui = (TextView) findViewById(R.id.nuevo);
        aqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });
    }

    public void onClick(View view) {

        String user = usr.getText().toString();
        String password = passwd.getText().toString();

        if (user.isEmpty() || password.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Error: No puedes dejar los campos vacios", Toast.LENGTH_SHORT).show();

        } else {

            background bg = new background(this);
            bg.execute(user, password);
        }
    }

    public void registro(){
        Intent i = new Intent(this, RegistroUsuario.class);
        startActivity(i);
    }
}