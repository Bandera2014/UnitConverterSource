package com.example.forchenavnotes.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.forchenavnotes.R;

import java.math.BigInteger;
import java.util.Scanner;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        EditText givenValue = (EditText) root.findViewById(R.id.givenValue);            //This is the value number the user enters in
        TextView output = (TextView) root.findViewById(R.id.returnValue);               //This is the output for the text
        NumberPicker givenUnit = (NumberPicker) root.findViewById(R.id.givenUnits);     //This is the number picker for the starting unit of the given value
        NumberPicker desiredUnit = (NumberPicker) root.findViewById(R.id.desiredUnits); //This is the desired unit number picker that will be the final unit

        //These max and min values set the length of the spinner
        givenUnit.setMaxValue(4);
        givenUnit.setMinValue(0);
        givenUnit.setDisplayedValues(new String[]{"Astronomical Unit","Light Year","Parsec","Milky Way","Mega Parsec"});    //These are the potions the user can choose from in the number picker

        //These max and min values set the length of the spinner
        desiredUnit.setMaxValue(4);
        desiredUnit.setMinValue(0);
        desiredUnit.setDisplayedValues(new String[]{"Astronomical Unit","Light Year","Parsec","Milky Way","Mega Parsec"});  //These are the potions the user can choose from in the number picker

        String[] unitsIn = {"Astronomical Unit","Light Year","Parsec","Milky Way","Mega Parsec"};


        //This is the function that detects when the spinner is changed
        givenUnit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {   //Scanning to see when the number picker is changed
                //finds the original number then converts it to a string
                String numString = givenValue.getText().toString(); //converting given user value to string
                int num = Integer.parseInt(numString);              //This is converting the numstring into an int(This is the given user value)
                String origString = unitsIn[givenUnit.getValue()];  //This is grabbing the value (number of au's) for the given unit the user selected
                String finalString = unitsIn[desiredUnit.getValue()];   //This is grabbing the value (number of au's) for the desired unit selected by the user
                double[] unitAmount = {1,63241,206265,6324107708L,206264807497L};   //These are the values for each of the units and the Capital L at the
                                                                                        //end of megaparsec is what actually converts that value into a long
                                                                                            //since it is too large to be an integer
                double conversionToAU = Double.valueOf(num)*unitAmount[findIndexInStringArray(unitsIn, origString)];    //This converts the amount of value you entered from the given unit
                                                                                                                            //into au's
                double conversionYouDesire = conversionToAU/unitAmount[findIndexInStringArray(unitsIn, finalString)];   //This converts the au's into the desired unit selected by the user
                String printString = conversionYouDesire+" "+finalString;   //This converts the final value into a printable string
                output.setText(printString);    //this sets the output text box to the final covnerted value
            }
        });


        return root;
    }
    //This function essentially finds the index of the value of au's inside of the array
    public static int findIndexInStringArray(String[] a, String s){
        //itterates through the unit list
        for(int index=0;index<a.length;index++){
            if(a[index].equals(s)){
                return index;
            }
        }
        return -1;
    }
}