package com.example.alarm;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alarm.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginDoctor extends AppCompatActivity {
    EditText eTxtEmail,eTxtPass;
    Button btnLogin;
    ProgressDialog progressDialog;
    TextView t;
    void init(){
        eTxtEmail=findViewById(R.id.LogEmailAddP);
        eTxtPass=findViewById(R.id.LogPasswordP);
        btnLogin=findViewById(R.id.buttonLoginP);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                progressDialog.show();
                Intent intent = new Intent(LoginDoctor.this, Doctor.class);
                startActivity(intent);
//                loginUserFromFirebase();
            }
        });
        t = findViewById(R.id.register);
        String text = "No Account yet? Create One";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(LoginDoctor.this,RegisterDoctor.class);
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan,16,26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(ss);
        t.setMovementMethod(LinkMovementMethod.getInstance());
    }
    void loginUserFromFirebase(){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAdd=eTxtEmail.getText().toString();
        String password=eTxtPass.getText().toString();
        auth.signInWithEmailAndPassword(emailAdd,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){
                            Intent intent=new Intent(LoginDoctor.this, MenuPatient.class);
                            startActivity(intent);
                            finish();
                            progressDialog.dismiss();
                            Toast.makeText(LoginDoctor.this,"Welcome !",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(LoginDoctor.this,"Please check your Email and password",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);
        init();
    }
}