package com.app.tickledmedia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private MainActivityPresenter mainActivityPresenter;
    private String question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragmentInContainer(QuestionFragment.TAG, QuestionFragment.newInstance());
    }

    



     void replaceFragmentInContainer(String tag, Fragment fragment) {
         FragmentManager fragmentManager = getSupportFragmentManager();
         if(tag.equals("answer"))
         {
             fragmentManager.beginTransaction()
                     .replace(R.id.homeContainer, fragment, tag)
                     .commit();
         }
         else
         {
             fragmentManager.beginTransaction()
                     .replace(R.id.homeContainer, fragment, tag)
                     .commit();
         }


    }


}
