package com.example.myapplication.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_time, container, false);

        final TextView output = root.findViewById(R.id.textView2);

        Button button = root.findViewById(R.id.button);

        final EditText eTN = root.findViewById(R.id.editTextNumber);

        final int[] start = {1};
        final int[] end = {1};

        final Spinner spinner = root.findViewById(R.id.spinner);

        List<String> list = new ArrayList<>();
        list.add("sec");
        list.add("min");
        list.add("hour");
        list.add("day");
        list.add("week");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition(position).toString();

                start[0] = spinner.getSelectedItemPosition();                                       //MAKES SECS 0 WEEKS 4

                Toast.makeText(getActivity(), "Selected " + itemvalue, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final Spinner spinner2 = root.findViewById(R.id.spinner2);

        List<String> list2 = new ArrayList<>();
        list2.add("sec");
        list2.add("min");
        list2.add("hour");
        list2.add("day");
        list2.add("week");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list2);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition(position).toString();

                end[0] = spinner2.getSelectedItemPosition();

                Toast.makeText(getActivity(), "Selected " + itemvalue, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double[] unitAmount = {1, 60, 3600, 86400, 604800};
                String origInput = eTN.getText().toString();    //Taking Before I need it to
                if (origInput.matches("")) {
                    Toast.makeText(getActivity(), "You did not enter a number", Toast.LENGTH_SHORT).show();
                }
                else {
                    int input = Integer.parseInt(origInput);
                    double conversionToMM = input * unitAmount[(start[0])];
                    double conversionToDesired = conversionToMM / unitAmount[(end[0])];
                    String finalResult = new Double(conversionToDesired).toString();
                    output.setText("Output: " + finalResult);
        }
        }});

        return root;
    }
}