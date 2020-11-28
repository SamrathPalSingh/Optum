package com.example.alarm.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.alarm.R;
public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ToggleButton toggle;
    private TextView t;
    private Switch s;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_doctor_home, container, false);
        s = root.findViewById(R.id.status_switch);
        s.setChecked(false);
        if(s.isChecked()){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://meet.google.com/bcg-dtoe-zxd"));
            startActivity(browserIntent);
        }
        else{
            //Remain offline
        }
//        t = root.findViewById(R.id.textView2);
//        toggle = (ToggleButton) root.findViewById(R.id.togglebutton);
//        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                        setZoomOn();
//                        t.setText("https://meet.google.com/pfs-kavj-man");
//                } else {
//                    setZoomOff();
//                    t.setText("");
//                }
//            }
//        });
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
//    private void setZoomOff() {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Doctor");
//
//        // Write from the database
//        myRef.child("1").child("Status").setValue("1");
//    }
//    private void setZoomOn() {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Doctor");
//
//        // Write from the database
//        myRef.child("1").child("Status").setValue("0");
//    }
}