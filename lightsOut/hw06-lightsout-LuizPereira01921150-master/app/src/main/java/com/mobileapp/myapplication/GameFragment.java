package com.mobileapp.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;


public class GameFragment extends Fragment implements View.OnClickListener {
    int numButtons = 9;
    Button[] buttons = new Button[numButtons];
    View getView;

    int[] OnOffArr = new int[10];
    Random rand = new Random();
    int upperbound = 2;
    String buttonColor;

    TextView moves;
    int numMoves=0;

    Button newGameButton;

    public GameFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        buttons[0] = view.findViewById(R.id.button);
        buttons[1] = view.findViewById(R.id.button2);
        buttons[2] = view.findViewById(R.id.button3);
        buttons[3] = view.findViewById(R.id.button4);
        buttons[4] = view.findViewById(R.id.button5);
        buttons[5] = view.findViewById(R.id.button6);
        buttons[6] = view.findViewById(R.id.button7);
        buttons[7] = view.findViewById(R.id.button8);
        buttons[8] = view.findViewById(R.id.button9);

        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);
        buttons[3].setOnClickListener(this);
        buttons[4].setOnClickListener(this);
        buttons[5].setOnClickListener(this);
        buttons[6].setOnClickListener(this);
        buttons[7].setOnClickListener(this);
        buttons[8].setOnClickListener(this);

        moves = view.findViewById(R.id.movesNUmber);
        newGameButton = view.findViewById(R.id.newGameButton);

        buttonColor = GameFragmentArgs.fromBundle(requireArguments()).getColorString();

        startGame();
        getView = view;

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
                numMoves=0;
                String movesString;
                movesString = String.valueOf(numMoves);
                moves.setText(movesString);
            }
        });


        return view;
    }

    public void onClick(View v) {

        switch (v.getId()){

            // cases applied over different buttons
            case R.id.button:
                changeNumMoves();
                changeColor("013");
                endCondition();

                break;

            case R.id.button2:
                changeNumMoves();
                changeColor("0124");
                endCondition();
                break;

            case R.id.button3:
                changeNumMoves();
                changeColor("125");
                endCondition();
                break;

            case R.id.button4:
                changeNumMoves();
                changeColor("0346");
                endCondition();
                break;
            case R.id.button5:
                changeNumMoves();
                changeColor("13457");
                endCondition();
                break;
            case R.id.button6:
                changeNumMoves();
                changeColor("2458");
                endCondition();
                break;
            case R.id.button7:
                changeNumMoves();
                changeColor("367");
                endCondition();
                break;
            case R.id.button8:
                changeNumMoves();
                changeColor("4678");
                endCondition();
                break;
            case R.id.button9:
                changeNumMoves();
                changeColor("578");
                endCondition();
                break;
        }
    }

    public void startGame(){
        for(int i=0; i<numButtons; i++){
            OnOffArr[i] = rand.nextInt(upperbound);
            buttons[i].setBackgroundColor(Color.parseColor(buttonColor));
        }
        for(int i=0; i<numButtons; i++){
            if(OnOffArr[i] == 0){
                buttons[i].setBackgroundColor(Color.BLACK);
            }
        }
        numMoves=0;
    }
    public void endCondition(){
        if(OnOffArr[0]==0 &&OnOffArr[1]==0 &&OnOffArr[2]==0 &&OnOffArr[3]==0 &&
                OnOffArr[4]==0 &&OnOffArr[5]==0 &&OnOffArr[6]==0 &&OnOffArr[7]==0 &&
                OnOffArr[8]==0){
            System.out.println("GG cabou");
            String movesString;
            movesString = String.valueOf(numMoves);
            NavDirections action = GameFragmentDirections.actionGameFragmentToGameOverFragment(movesString);
            Navigation.findNavController(getView).navigate(action);
        }
    }
    public void changeColor(String str){
        for(int i=0; i<str.length();i++){
            int num = str.charAt(i) - '0';
            if(OnOffArr[num]==1) {
                buttons[num].setBackgroundColor(Color.BLACK);
                OnOffArr[num] = 0;
            }
            else if(OnOffArr[num]==0) {
                buttons[num].setBackgroundColor(Color.parseColor(buttonColor));
                OnOffArr[num] = 1;
            }
        }

    }
    public void changeNumMoves(){
        numMoves++;
        String movesString;
        movesString = String.valueOf(numMoves);
        moves.setText(movesString);
    }

}