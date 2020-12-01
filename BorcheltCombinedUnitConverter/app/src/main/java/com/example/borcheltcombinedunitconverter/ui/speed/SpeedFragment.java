package com.example.borcheltcombinedunitconverter.ui.speed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.borcheltcombinedunitconverter.R;

public class SpeedFragment extends Fragment {

    private SpeedViewModel speedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        speedViewModel =
                ViewModelProviders.of(this).get(SpeedViewModel.class);
        View root = inflater.inflate(R.layout.fragment_speed, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        speedViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}