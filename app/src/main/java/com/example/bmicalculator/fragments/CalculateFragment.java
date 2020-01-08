package com.example.bmicalculator.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.bmicalculator.R;
import com.example.bmicalculator.activity.ResultActivity;

public class CalculateFragment extends Fragment {
    private AppCompatButton mCalculateBtn;
    private SeekBar mSeekBar;
    private AppCompatTextView mHeightTv, mAgeTv, mWeightTv;
    private AppCompatImageButton mAddWeightBtn, mMinusWeightBtn, mAddAge, mMinusAge;

    private CardView mMaleCard, mFemaleCard, mWeightCard, mAgeCard;

    private static final String TAG = "CalculateFragment";
    private int weight = 50;
    private int age = 20;
    private int height = 130;

    public static CalculateFragment newInstancw() {
        return new CalculateFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculate_fragment, container, false);
        mCalculateBtn = view.findViewById(R.id.btn_calculate);
        mSeekBar = view.findViewById(R.id.seekBar);
        mHeightTv = view.findViewById(R.id.height_tv);

        mAddWeightBtn = view.findViewById(R.id.btn_plus_weight);
        mMinusWeightBtn = view.findViewById(R.id.btn_decreed_weight);
        mAddAge = view.findViewById(R.id.btn_plus_age);
        mMinusAge = view.findViewById(R.id.btn_decreed_age);

        mAgeTv = view.findViewById(R.id.age_tv);
        mWeightTv = view.findViewById(R.id.weight_tv);


        //load animation
        Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.button_animation);
        Animation leftAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.left_animation);

        //start animation
        mCalculateBtn.startAnimation(animation);
        //mFemaleCard.startAnimation(leftAnim);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mHeightTv.setText(progress + "cm");
                height = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mAddWeightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight++;
                mWeightTv.setText(String.valueOf(weight));
            }
        });

        mMinusWeightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight--;
                mWeightTv.setText(String.valueOf(weight));
            }
        });

        mAddAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age++;
                mAgeTv.setText(String.valueOf(age));
            }
        });

        mMinusAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age--;
                mAgeTv.setText(String.valueOf(age));
            }
        });

        mCalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onCreateView: " + calculate(height, weight));
//                Intent startResultActivityIntent = new Intent(getActivity(), ResultActivity.class);
//                startResultActivityIntent.putExtra("index",calculate(height, weight));
//                startActivity(startResultActivityIntent);
                Intent intent = ResultActivity.newIntent(getActivity(), calculate(height, weight));
                startActivity(intent);
            }
        });


        return view;
    }

    private double calculate(int height, int weight) {
        return weight / (((double) height / 100) * ((double) height / 100));
    }
}
