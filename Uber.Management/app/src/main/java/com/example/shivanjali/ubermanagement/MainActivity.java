package com.example.shivanjali.ubermanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    public static String username,password;
    Button bLogin;
    EditText etUserName,etPassword;
    TextView tvRegister=null;


    private static final String TAG ="MainActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=(EditText)findViewById(R.id.etUserName);
        etPassword=(EditText)findViewById(R.id.etPassword);
        bLogin =(Button)findViewById(R.id.bLogin);
        tvRegister=(TextView)findViewById(R.id.tvRegisterHere);

        Context context = getApplicationContext();

        bLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

    }//end of onCreate function

    @Override
    public void onClick(View v) {
      switch (v.getId())
      {

          case R.id.bLogin:
              username=etUserName.getText().toString().trim();
              System.out.println("Username:"+username);
              password=etPassword.getText().toString().trim();
              System.out.println("Password:"+password);
              String method="Login";
              Background bk=new Background(this);
              bk.execute(method,username,password);
              break;
          case R.id.bCancel:
              break;
          case R.id.tvRegisterHere:
              startActivity(new Intent(this,Registration.class));
              break;


      }//end of switch

    }
}
