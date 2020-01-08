package com.example.bmicalculator.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.example.bmicalculator.R;

public class ResultFragment extends Fragment {
    private static final String TAG = "ResultFragment";
    private AppCompatTextView mResultTv, mResultTextTv, mDescriptionResultTv, mYourResultTv;
    private AppCompatButton mRecalculateBtn;

//    public static ResultFragment newInstance(){
//        return new ResultFragment();
//    }

    public static ResultFragment newInstance(double data) {
        Bundle bundle = new Bundle();
        ResultFragment resultFragment = new ResultFragment();
        bundle.putDouble("index", data);
        resultFragment.setArguments(bundle);
        return resultFragment;
        //return new ResultFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_fragment, container, false);
        mResultTv = view.findViewById(R.id.tv_result_number);
        mResultTextTv = view.findViewById(R.id.tv_result_text);
        mDescriptionResultTv = view.findViewById(R.id.tv_description_result);
        mRecalculateBtn = view.findViewById(R.id.btn_recalculate);
        mYourResultTv = view.findViewById(R.id.you_result);

        Bundle bundle = this.getArguments();
        double data = bundle.getDouble("index");
        Log.d(TAG, "data: " + data);

        String[] arrayResult = checkResult(data);

        try {
            mResultTv.setText(String.valueOf(data).substring(0, 4));
        }catch (Exception e){
            mResultTv.setText(String.valueOf(data));
        }

        mResultTextTv.setText(arrayResult[0]);
        mDescriptionResultTv.setText(arrayResult[1]);

        //load animation
        Animation bottomAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.button_animation);
        Animation leftAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.left_animation);
        Animation rightAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.right_anim);
        Animation topAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.top_animation);

        //Start Animation
        mRecalculateBtn.startAnimation(bottomAnim);
        mResultTv.startAnimation(leftAnim);
        mYourResultTv.startAnimation(topAnim);
        mDescriptionResultTv.startAnimation(rightAnim);
        mResultTextTv.startAnimation(rightAnim);


        mRecalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }

    private String[] checkResult(double result) {
        String[] your_result = {"NaN", "NaN"};
        if (result < 15) {
            your_result[0] = getResources().getString(R.string.very_underweight);
            mResultTextTv.setTextColor(getResources().getColor(R.color.blue));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.very_underweight).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 15 && result <= 16) {
            your_result[0] = getResources().getString(R.string.severely_underweight);
            mResultTextTv.setTextColor(getResources().getColor(R.color.blue));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.severely_underweight).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 16 && result <= 18.5) {
            your_result[0] = getResources().getString(R.string.underweight);
            mResultTextTv.setTextColor(getResources().getColor(R.color.blue));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.underweight).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 18.5 && result <= 25) {
            your_result[0] = getResources().getString(R.string.normal);
            mResultTextTv.setTextColor(getResources().getColor(R.color.green));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.normal).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 25 && result <= 30) {
            your_result[0] = getResources().getString(R.string.over_weight);
            mResultTextTv.setTextColor(getResources().getColor(R.color.yellow));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.over_weight).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 30 && result <= 35) {
            your_result[0] = getResources().getString(R.string.obese_class_1);
            mResultTextTv.setTextColor(getResources().getColor(R.color.yellow));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.obese_class_1).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 35 && result <= 40) {
            your_result[0] = getResources().getString(R.string.obese_class_2);
            mResultTextTv.setTextColor(getResources().getColor(R.color.red));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.obese_class_2).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 40 && result <= 45) {
            your_result[0] = getResources().getString(R.string.obese_class_3);
            mResultTextTv.setTextColor(getResources().getColor(R.color.red));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.obese_class_3).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 45 && result <= 50) {
            your_result[0] = getResources().getString(R.string.obese_class_4);
            mResultTextTv.setTextColor(getResources().getColor(R.color.red));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.obese_class_4).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 50 && result <= 60) {
            your_result[0] = getResources().getString(R.string.obese_class_5);
            mResultTextTv.setTextColor(getResources().getColor(R.color.red));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.obese_class_5).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        } else if (result > 60) {
            your_result[0] = getResources().getString(R.string.obese_class_6);
            mResultTextTv.setTextColor(getResources().getColor(R.color.red));
            your_result[1] = getResources().getString(R.string.you_have_a) + " " + getResources().getString(R.string.obese_class_6).toLowerCase() + " " + getResources().getString(R.string.body_weight);
        }
        return your_result;
    }
}
