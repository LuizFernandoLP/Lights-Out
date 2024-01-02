package com.mobileapp.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class gameOverFragment extends Fragment {
    TextView numberOfMoves;

    public gameOverFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_over, container, false);

        numberOfMoves = view.findViewById(R.id.movesWinScreen);
        String moves = gameOverFragmentArgs.fromBundle(requireArguments()).getMovesString();
        numberOfMoves.setText(moves);


        return view;
    }
}