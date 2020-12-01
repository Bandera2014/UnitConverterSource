package com.example.borcheltcombinedunitconverter.ui.spaceDistance;

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

public class SpaceFragment extends Fragment {

    private SpaceViewModel spaceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        spaceViewModel =
                ViewModelProviders.of(this).get(SpaceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_space, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        spaceViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}