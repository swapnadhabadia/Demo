package com.app.tickledmedia.views;

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

import com.app.tickledmedia.apicalls.MainActivityPresenter;
import com.app.tickledmedia.apicalls.MainInterface;
import com.app.tickledmedia.R;
import com.app.tickledmedia.models.Response;

import java.util.List;


public class QuestionFragment extends Fragment implements MainInterface {
    public static final String TAG ="" ;


    private MainActivityPresenter mainActivityPresenter;
    private ListView mListView;
    private View mQuestionListView;
    private ContentLoadingProgressBar mProgressBar;
    private ProgressDialog progressDialog;


    public static QuestionFragment newInstance() {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void getQuestionList(List<Response> response, String type) {
        QuestionListAdapter adapter = new QuestionListAdapter(getActivity(), response,"answer");
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
        progressDialog = new ProgressDialog(getActivity());
        mainActivityPresenter = new MainActivityPresenter(getActivity(),this);

        mainActivityPresenter.callListApi("ques");



        return mQuestionListView;
    }


}
