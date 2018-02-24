package com.app.tickledmedia;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.tickledmedia.apicalls.MainActivityPresenter;
import com.app.tickledmedia.views.QuestionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragmentInContainer(QuestionFragment.TAG, QuestionFragment.newInstance());
    }

     public void replaceFragmentInContainer(String tag, Fragment fragment) {
         FragmentManager fragmentManager = getSupportFragmentManager();



         if(tag.equals("answer"))
         {
             fragmentManager.beginTransaction()
                     .replace(R.id.homeContainer, fragment, tag)
                     .addToBackStack(fragment.getClass().getName())
                     .commit();
         }
         else
         {
             fragmentManager.beginTransaction()
                     .replace(R.id.homeContainer, fragment, tag)
                     .addToBackStack(fragment.getClass().getName())
                     .commit();
         }

    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1)
            getSupportFragmentManager().popBackStack();
        else
            finish();
    }

}
