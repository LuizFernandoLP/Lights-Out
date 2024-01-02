package com.mobileapp.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;


public class SettingsFragment extends Fragment {
    RadioGroup rgColor;
    String strColor;
    Button buttonChange;
    View getView;
    public SettingsFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        getView = view;
        rgColor = view.findViewById(R.id.radioGroup);

        rgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonRed:
                        strColor = "#FF0000";
                        break;
                    case R.id.radioButtonBlue:
                        strColor = "#FF03A9F4";
                        break;
                    case R.id.radioButtonOrange:
                        strColor = "#FFFF5722";
                        break;
                    case R.id.radioButtonYellow:
                        strColor = "#FFFFEB3B";
                        break;
                    case R.id.radioButtonPink:
                        strColor = "#FFED35C5";
                        break;
                }
            }
        });


        buttonChange = view.findViewById(R.id.buttonChange);

        buttonChange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NavDirections action = SettingsFragmentDirections.actionSettingsFragmentToGameFragment().setColorString(strColor);
                Navigation.findNavController(getView).navigate(action);
            }
        });

        return view;
    }
}