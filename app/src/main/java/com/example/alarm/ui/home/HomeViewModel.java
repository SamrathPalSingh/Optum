package com.example.alarm.ui.home;

import android.view.View;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private ToggleButton toggle;
    private MutableLiveData<String> mText;
    private Switch s;
    public HomeViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("This is Home fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}