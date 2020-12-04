package com.example.borcheltcombinedunitconverter.ui.spaceDistance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SpaceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SpaceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}