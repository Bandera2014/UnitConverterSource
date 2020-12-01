package com.example.borcheltcombinedunitconverter.ui.volume;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VolumeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VolumeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}