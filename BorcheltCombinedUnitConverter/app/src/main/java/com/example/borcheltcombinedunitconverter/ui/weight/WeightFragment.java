package com.example.borcheltcombinedunitconverter.ui.weight;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.borcheltcombinedunitconverter.R;

public class WeightFragment extends Fragment {

    private WeightViewModel galleryViewModel;
    private TextView editView;
    private int n=0;
    private String[] pickerVals = {"Microgram", "Milligram", "Gram", "Kilogram", "Metric ton"}; // sets values on the number picker

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(WeightViewModel.class);
        //this line loads in the xml file to the screen
        View root = inflater.inflate(R.layout.fragment_weight, container, false);
        //create the textViews and number pickers on the screen
        final TextView textView = root.findViewById(R.id.text_gallery);
        final TextView editView = root.findViewById(R.id.edit_gallery);
        final NumberPicker numberPicker= root.findViewById(R.id.picker);
        final NumberPicker numberPicker2 = root.findViewById(R.id.picker2);
        // sets how many values are in the number picker and sets the array of strings above to display in it
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(4);
        numberPicker.setDisplayedValues(pickerVals);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(4);
        numberPicker2.setDisplayedValues(pickerVals);
        // When one of the number picker change it runs this code
        numberPicker.setOnValueChangedListener((new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                //set the editView into a variable and converts it to double
                CharSequence number = (editView.getText());
                double conversionUnit = Integer.parseInt(number.toString());
                double conversionYouDesire = 0;
                //gets index of number pickers
                int originalUnit = numberPicker.getValue();
                int finalUnit = numberPicker2.getValue();
                //depending on the indexes of the number pickers it uses that to determine what conversion to use
                if ((originalUnit - finalUnit) == 1) {
                    conversionYouDesire = conversionUnit * 1000;
                } else if ((originalUnit - finalUnit) == 2) {
                    conversionYouDesire = conversionUnit * 1000 * 1000;
                } else if ((originalUnit - finalUnit) == 3) {
                    conversionYouDesire = conversionUnit * 1000 * 1000 * 1000;
                } else if ((originalUnit - finalUnit) == 4) {
                    conversionYouDesire = conversionUnit * 1000 * 1000 * 1000 * 1000;
                } else if ((originalUnit - finalUnit) == -1) {
                    conversionYouDesire = conversionUnit / 1000;
                } else if ((originalUnit - finalUnit) == -2) {
                    conversionYouDesire = conversionUnit / 1000 / 1000;
                } else if ((originalUnit - finalUnit) == -3) {
                    conversionYouDesire = conversionUnit / 1000 / 1000 / 1000;
                } else if ((originalUnit - finalUnit) == -4) {
                    conversionYouDesire = conversionUnit / 1000 / 1000 / 1000 / 1000;
                } else if ((originalUnit - finalUnit) == 0) {
                    conversionYouDesire = conversionUnit;
                }
                //converts conversion to string and displays it on screen
                String stringdouble = Double.toString(conversionYouDesire);
                textView.setText(stringdouble);
            }


        }));
        numberPicker2.setOnValueChangedListener((new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker2, int i, int i1) {
                CharSequence number = (editView.getText());
                double conversionUnit = Integer.parseInt(number.toString());
                double conversionYouDesire = 0;
                int originalUnit = numberPicker.getValue();
                int finalUnit = numberPicker2.getValue();
                if ((originalUnit - finalUnit) == 1) {
                    conversionYouDesire = conversionUnit * 1000;
                } else if ((originalUnit - finalUnit) == 2) {
                    conversionYouDesire = conversionUnit * 1000 * 1000;
                } else if ((originalUnit - finalUnit) == 3) {
                    conversionYouDesire = conversionUnit * 1000 * 1000 * 1000;
                } else if ((originalUnit - finalUnit) == 4) {
                    conversionYouDesire = conversionUnit * 1000 * 1000 * 1000 * 1000;
                } else if ((originalUnit - finalUnit) == -1) {
                    conversionYouDesire = conversionUnit / 1000;
                } else if ((originalUnit - finalUnit) == -2) {
                    conversionYouDesire = conversionUnit / 1000 / 1000;
                } else if ((originalUnit - finalUnit) == -3) {
                    conversionYouDesire = conversionUnit / 1000 / 1000 / 1000;
                } else if ((originalUnit - finalUnit) == -4) {
                    conversionYouDesire = conversionUnit / 1000 / 1000 / 1000 / 1000;
                } else if ((originalUnit - finalUnit) == 0) {
                    conversionYouDesire = conversionUnit;
                }
                String stringdouble = Double.toString(conversionYouDesire);
                textView.setText(stringdouble);
            }


        }));
        /*
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */



        return root;
    }
}