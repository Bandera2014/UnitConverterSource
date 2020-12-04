package com.example.borcheltcombinedunitconverter.ui.frequency;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.borcheltcombinedunitconverter.R;

public class FrequencyFragment extends Fragment {

    private FrequencyViewModel galleryViewModel;

    private int n = 0;

    private double num;

    private String oriU;

    private String newU;

    private double inputNumber;

    private NumberPicker picker1;
    private NumberPicker picker2;
    private EditText numberInputText;
    private TextView numberOutputText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                ViewModelProviders.of(this).get(FrequencyViewModel.class);
        //this low below opens and runs the fragment_gallery xml
        final View root = inflater.inflate(R.layout.fragment_frequency, container, false);
        picker1 = (NumberPicker) root.findViewById(R.id.rudolphNumberPickerInput0);
        picker2 = (NumberPicker) root.findViewById(R.id.rudolphNumberPickerInput);
        numberInputText = root.findViewById((R.id.editTextTextPersonName));
        numberOutputText = root.findViewById(R.id.textView2);

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        //Set up number picker and number input box---------------------------------------------

        final String[] options = {"mHz","Hz", "kHz", "MHz", "GHz" };
        long[] numbers = {1, 1000, 1000000, 1000000000};

        picker1.setMinValue(0);
        picker1.setMaxValue(options.length-1);

        picker1.setDisplayedValues(options);

        picker2.setMinValue(0);
        picker2.setMaxValue(options.length-1);

        picker2.setDisplayedValues(options);

        numberInputText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                try {
                    inputNumber = Double.valueOf(numberInputText.getText().toString());
                } catch (NullPointerException | NumberFormatException e) {
                    Log.d("frequency", "Something went wrong" + e);

                }

            }
        });


//----------------------------------------------------------------------------------------------------------------

        //Set up button and have it run code to convert units base on user input-----------------------------------


        Button mb = root.findViewById(R.id.button);






        mb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Double num = Double.valueOf(numberInputText.getText().toString());;
                String u1 = options[picker1.getValue()];
                String u2 = options[picker2.getValue()];
                Double numBase = 0.00;


                //These conditionals take whatever is entered by the user and converts it to Hz

                if(u1.equals("GHz")){
                    numBase = (((num*1000.0)*1000.0)*1000.0);
                }

                else if(u1.equals("MHz")){
                    numBase = (((num)*1000.0)*1000.0);
                }

                else if(u1.equals("kHz")) {
                    numBase = (((num)) * 1000.0);
                }
                else if(u1.equals("mHz")){
                    numBase = (num/1000);
                }


                else{ numBase=num; }


                //These Conditionals take the Hz and Convert them to the desired unit
                if(u2.equals("GHz")){
                    numBase = (((numBase/1000.0)/1000.0)/1000.0);
                }

                else if(u2.equals("MHz")){
                    numBase = (((numBase)/1000.0)/1000.0);
                }

                else if(u2.equals("kHz")){
                    numBase = (((numBase))/1000.0);

                }

                else if(u2.equals("mHz")){
                    numBase = (num);
                }



                //prints out
                TextView output = root.findViewById(R.id.textView2);
                output.setText(String.valueOf(numBase));

            }


        });
//----------------------------------------------------------------------------------------------------------

        return root;
    }
}
















































 /*
                textView.setText("Hey what up");

                if(n%2==0){
                    textView.setText("Hey");
                    textView.append(String.valueOf(n));
                }
                else{
                    textView.setText("bru");
                }
                n++;

                 */

                /*
                String[] vals1 = vals.split(",");
                Double num = Double.valueOf(vals1[0]);
                String u1 = vals1[1];
                String u2 = vals1[2];
                Double numBase = 0.00;


                if(u1.equals("GHz")){
                    numBase = (((num*1000.0)*1000.0)*1000.0);
                }

                else if(u1.equals("MHz")){
                    numBase = (((num)*1000.0)*1000.0);
                }

                else if(u1.equals("KHz")){
                    numBase = (((num))*1000.0);
                }
                else{ numBase=num; }



                if(u2.equals("GHz")){
                    numBase = (((numBase/1000.0)/1000.0)/1000.0);
                }

                else if(u2.equals("MHz")){
                    numBase = (((numBase)/1000.0)/1000.0);
                }

                else if(u2.equals("KHz")){
                    numBase = (((numBase))/1000.0);

                }



                TextView output = root.findViewById(R.id.textView2);

                 */


