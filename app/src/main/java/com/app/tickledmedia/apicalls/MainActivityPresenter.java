package com.app.tickledmedia.apicalls;


import android.content.Context;

import com.app.tickledmedia.models.Response;

import java.util.List;

public class MainActivityPresenter  {
    private final MainInterface mainInterface;
    Context context;
    private final MainActivityInteractor mainActivityInteractor;

    public MainActivityPresenter(Context context, MainInterface mainInterface) {

this.mainInterface=mainInterface;
        mainActivityInteractor = new MainActivityInteractor(context,this);
        this.context = context;
    }


    public void callListApi(String answer) {
        mainActivityInteractor.callNetworkListApi(context,answer,"tag");

    }


    public void getQuesList(List<Response> response, String type) {
        mainInterface.getQuestionList(response,type);
    }


    public void showProgressDialog(String message, boolean indeterminate, boolean isCancelable) {
        if (mainInterface != null) {
            mainInterface.showProgressDialog(message, indeterminate, isCancelable);
        }
    }


    public void hideProgressDialog() {
        if (mainInterface != null) {
            mainInterface.hideProgressDialog();
        }
    }
}
