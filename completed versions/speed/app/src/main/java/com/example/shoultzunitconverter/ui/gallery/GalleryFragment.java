package com.example.shoultzunitconverter.ui.gallery;

import android.os.Bundle;
import android.text.Editable;
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
import androidx.lifecycle.ViewModelProviders;

import com.example.shoultzunitconverter.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.textOutput);
        //bring in the text picker from the xml
        final NumberPicker pickerIn = root.findViewById(R.id.pickerIn);
        final NumberPicker pickerOut = root.findViewById(R.id.pickerOut);
        textView.setText("Num: ");
        //set up the values in the picker
        pickerIn.setMaxValue(4);
        pickerIn.setMinValue(0);
        pickerOut.setMinValue(0);
        pickerOut.setMaxValue(4);
        final String[] unitsIn = {"f/s", "m/s", "kph", "mph", "mach"};
        pickerIn.setDisplayedValues(unitsIn);
        pickerOut.setDisplayedValues(unitsIn);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        //Button calculate = root.findViewById(R.id.buttonCalc);
        final EditText numIn = root.findViewById(R.id.enterNumber);
        //final EditText origUnit = root.findViewById(R.id.enterOrigUnit);
        //final EditText finalUnit = root.findViewById(R.id.enterFinalUnit);
        //causes the program to update when the first picker is changed
        pickerIn.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                //takes in the input then calls the function to calculate the numbers
                String numString = numIn.getText().toString();
                int num = Integer.parseInt(numString);
                textView.setText(calculateNumbers(pickerIn, pickerOut, num));
            }
        });

        //causes the picker to update when the second picker is changed
        pickerOut.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                //takes in the input then calls the function to calculate the numbers
                String numString = numIn.getText().toString();
                int num = Integer.parseInt(numString);
                textView.setText(calculateNumbers(pickerIn, pickerOut, num));
            }
        });

        return root;
    }

    //function to find the index of the unit conversion in the slider
    public static int findIndexInStringArray(String[] a, String s){
        for(int index = 0; index<a.length; index++){
            if(a[index].equals(s)){
                return index;
            }
        }
        return -1;
    }

    public static String calculateNumbers(NumberPicker pickerIn, NumberPicker pickerOut, int num){
        //finds the original number then converts it to a string
        String[] unitsIn = {"f/s", "m/s", "kph", "mph", "mach"};
        double[] unitAmount = {1,.30 ,.91, 1.46, 1125.33};

        String origString = unitsIn[pickerIn.getValue()];
        String finalString = unitsIn[pickerOut.getValue()];

        //arrays to hold the conversions in the units

        //converts the input value to feet per second then converts the feet per second to the second desired output
        double conversionToFPS = Double.valueOf(num)*unitAmount[findIndexInStringArray(unitsIn, origString)];
        double conversionYouDesire = conversionToFPS/unitAmount[findIndexInStringArray(unitsIn, finalString)];
        String printString = "Num: " + conversionYouDesire;
        return printString;
    }


}