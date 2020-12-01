package com.example.borcheltcombinedunitconverter.ui.frequency;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FrequencyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FrequencyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}