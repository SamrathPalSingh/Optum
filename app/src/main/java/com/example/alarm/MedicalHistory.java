package com.example.alarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MedicalHistory extends AppCompatActivity {
    EditText eTxtMedCond,eTxtStDt,eTxtEndDt,eTxtMedDevice,eTxtReport,eTxtBodySite,eTxtImmun,eTxtMed,eTxtStMed,eTxtMedRep;
    Button btnSubmit;
    MedHistory medHistory;
    void init(){
        eTxtMedCond=findViewById(R.id.MedCondition);
        eTxtStDt=findViewById(R.id.StartDate);
        eTxtEndDt=findViewById(R.id.EndDate);
        eTxtMedDevice=findViewById(R.id.DeviceSpecification);
        eTxtReport=findViewById(R.id.Modality);
        eTxtBodySite=findViewById(R.id.BodySite);
        eTxtImmun=findViewById(R.id.ImmunDescription);
        eTxtMed=findViewById(R.id.DescribeMedicalReports);
        eTxtStMed=findViewById(R.id.DescribeDuration);
        eTxtMedRep=findViewById(R.id.DescribeMedicalReports);
        btnSubmit=findViewById(R.id.ButtonSubmitMed);
        medHistory=new MedHistory();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medHistory.MedCond=eTxtMedCond.getText().toString();
                medHistory.MedCondStDate=eTxtStMed.getText().toString();
                medHistory.MedCondEndDate=eTxtEndDt.getText().toString();
                medHistory.RadioReport=eTxtReport.getText().toString();
                medHistory.device=eTxtMedDevice.getText().toString();
                medHistory.BodySite=eTxtBodySite.getText().toString();
                medHistory.Vaccination=eTxtImmun.getText().toString();
                medHistory.Med=eTxtMed.getText().toString();
                medHistory.Duration=eTxtStMed.getText().toString();
                medHistory.MedReport=eTxtMedRep.getText().toString();
//                addDataToFirebase();
                Intent intent=new Intent(MedicalHistory.this, MenuPatient.class);
                startActivity(intent);
                finish();
            }
        });

    }
    void addDataToFirebase(){
        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        String uid=firebaseUser.getUid();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("users").document(uid).collection("medHistory").add(medHistory)
                .addOnCompleteListener(this, new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if(task.isComplete()){
                            Log.i("Test","Complete");
                        }else{
                            Log.i("Testttt","Not Complete");
                        }
                    }
                });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,101,1,"Home").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,201,1,"Scheduler").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,301,1,"Meet with Doctor").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,401,1,"Edit Personal Information").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,501,1,"Take Reading").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(1,601,1,"Log Out").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==101){
            Log.i("Info1","101");
            Intent intent=new Intent(MedicalHistory.this,MenuPatient.class);
            startActivity(intent);
        }
        if(item.getItemId()==201){
            Log.i("Info2","102");
            Intent intent=new Intent(MedicalHistory.this,Scheduler.class);
            startActivity(intent);
        }
        if(item.getItemId()==301){
            Log.i("Info3","103");
            Intent intent=new Intent(MedicalHistory.this,DocDept.class);
            startActivity(intent);
        }
        if(item.getItemId()==401){
            Log.i("Info4","104");
            Intent intent=new Intent(MedicalHistory.this,MedicalDetails.class);
            startActivity(intent);
        }
        if(item.getItemId()==501){
            Log.i("Info5","105");
            Intent intent=new Intent(MedicalHistory.this,GlucoseReading.class);
            startActivity(intent);
        }
        if(item.getItemId()==601){
            Log.i("Info5","105");
            Intent intent=new Intent(MedicalHistory.this,LoginPatient.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_history);
        init();
    }
}