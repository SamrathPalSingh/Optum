package com.example.alarm.ui.meeting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MeetingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MeetingViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("This is Meeting fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}