package com.app.tickledmedia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        replaceFragmentInContainer(fragmentManager, QuestionFragment.TAG, QuestionFragment.newInstance());

    }



    private void replaceFragmentInContainer(FragmentManager fragmentManager, String tag, QuestionFragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.homeContainer, fragment, tag)
                .commit();

    }
}
