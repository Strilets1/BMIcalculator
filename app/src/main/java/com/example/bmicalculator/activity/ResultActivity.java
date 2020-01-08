package com.example.bmicalculator.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bmicalculator.R;
import com.example.bmicalculator.fragments.ResultFragment;

public class ResultActivity extends SingleFragmentActivity {
    private static final String TAG = "ResultActivity";



    @Override
    protected Fragment createFragment() {
        return ResultFragment.newInstance((Double) getIntent().getSerializableExtra("index"));
    }
    public static Intent newIntent(Context context, double index){
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra("index", index);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Double data = (Double) getIntent().getSerializableExtra("index");
        Log.d(TAG, "onCreate: " + data);

    }
}
