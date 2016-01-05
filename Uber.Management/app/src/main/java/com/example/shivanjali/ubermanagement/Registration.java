package com.example.shivanjali.ubermanagement;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends Activity implements View.OnClickListener{

    DataHandler myDB;
    Button bRegister;
    EditText etName,etEmailId,etContactNo,etInputUserName,etPassInput;
    String name,mailid,username,password,method,conno;


    private static final String TAG ="RegistrationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_registration);

          bRegister =(Button)findViewById(R.id.bRegister);
          bRegister.setOnClickListener(this);
     }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bRegister:
                etName = (EditText)findViewById(R.id.etName);
                etEmailId=(EditText)findViewById(R.id.etEmailID);
                etContactNo=(EditText)findViewById(R.id.etContactNo);
                etInputUserName=(EditText)findViewById(R.id.etInputUserName);
                etPassInput=(EditText)findViewById(R.id.etPassInput);
                name=etName.getText().toString();
                System.out.println("Name:"+name);
                mailid=etEmailId.getText().toString();
                System.out.println("EmailId:"+mailid);
                conno=etContactNo.getText().toString();
                System.out.println("ConNo:"+conno);
                username=etInputUserName.getText().toString();
                System.out.println("Username:"+username);
                password=etPassInput.getText().toString();
                System.out.println("Password:"+password);
                method="Register";
                Background b=new Background(this);
                b.execute(method,name,conno,mailid,username,password);

                break;
        }//end of switch
    }
}
