package com.example.bmicalculator;

import androidx.fragment.app.Fragment;

import com.example.bmicalculator.activity.SingleFragmentActivity;
import com.example.bmicalculator.fragments.CalculateFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return CalculateFragment.newInstancw();
    }


}
