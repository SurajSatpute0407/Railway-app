package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.net.URL;

public class login extends AppCompatActivity {
    ImageView google, facebook, twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
//        google=findViewById(R.id.google);
        setContentView(R.layout.activity_login);
        TextView mobileno =(TextView) findViewById(R.id.mobileno);
        TextView password =(TextView) findViewById(R.id.password);


        MaterialButton log1 = (MaterialButton) findViewById(R.id.log1);

        log1=findViewById(R.id.log1);
        log1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mobileno.getText().toString().equals("") && password.getText().toString().equals("")){
                    //correct
                    Toast.makeText(login.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent in=new Intent(login.this,railway.class);
                    startActivity(in);
                }else
                    //incorrect
                    Toast.makeText(login.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });
        google=findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://accounts.google.com/v3/signin/identifier?dsh=S118339366%3A1677817798675769&authuser=0&continue=https%3A%2F%2Fmail.google.com&ec=GAlAFw&hl=en-GB&service=mail&flowName=GlifWebSignIn&flowEntry=AddSession");
            }
        });

        facebook=findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.facebook.com/login/");
            }
        });


        twitter=findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://twitter.com/i/flow/login?input_flow_data=%7B%22requested_variant%22%3A%22eyJsYW5nIjoiZW4ifQ%3D%3D%22%7D");
            }
        });
    }



    private void goLink(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}