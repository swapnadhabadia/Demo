package com.app.tickledmedia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SappiKaran on 24/02/18.
 */

public class QuestionFragment extends Fragment implements MainInterface  {
    public static final String TAG ="" ;


    private MainActivityPresenter mainActivityPresenter;
    private ListView mListView;
    private View mQuestionListView;

    public static QuestionFragment newInstance() {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void getQuestionList(List<Response> response) {
        QuestionListAdapter adapter = new QuestionListAdapter(getActivity(), response);
        mListView.setAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        mQuestionListView = inflater.inflate(R.layout.list_question, container, false);
        mListView = (ListView) mQuestionListView.findViewById(R.id.card_listView);

        mainActivityPresenter = new MainActivityPresenter(getActivity(),this);

        mainActivityPresenter.callListApi();



        return mQuestionListView;
    }


}
