package com.app.tickledmedia;



import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SappiKaran on 24/02/18.
 */

public class AnswerFragment extends Fragment implements MainInterface  {
    public static final String TAG ="answer" ;


    private MainActivityPresenter mainActivityPresenter;
    private ListView mListView;
    private View mQuestionListView;
    private ContentLoadingProgressBar mProgressBar;
    private ProgressDialog progressDialog;
    private TextView mquestion;
    private String question;


    public static AnswerFragment newInstance(String question) {
        AnswerFragment fragment = new AnswerFragment();
        Bundle args = new Bundle();
        args.putString("answer", question);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = getArguments().getString("answer");

        }
    }

    @Override
    public void getQuestionList(List<Response> response, String type) {
        QuestionListAdapter adapter = new QuestionListAdapter(getActivity(), response, "answer");
        mListView.setAdapter(adapter);

    }

    @Override
    public void showProgressDialog(String message, boolean indeterminate, boolean isCancelable) {
        if (progressDialog != null) {
            progressDialog.setMessage(message);
            progressDialog.setIndeterminate(indeterminate);
            progressDialog.setCancelable(isCancelable);
            progressDialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        Log.i(TAG, "hideProgressDialog: ");
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);

        mQuestionListView = inflater.inflate(R.layout.list_question, container, false);
        mListView = (ListView) mQuestionListView.findViewById(R.id.card_listView);
        mquestion=(TextView)mQuestionListView.findViewById(R.id.ques);
        mquestion.setVisibility(View.VISIBLE);
        mquestion.setText(question);
        progressDialog = new ProgressDialog(getActivity());
        mainActivityPresenter = new MainActivityPresenter(getActivity(),this);

        mainActivityPresenter.callListApi("answer");



        return mQuestionListView;
    }


}
