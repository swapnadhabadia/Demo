package com.app.tickledmedia;


import android.content.Context;
import android.support.v4.app.FragmentActivity;

import java.util.List;

class MainActivityPresenter  {
    private final MainInterface mainInterface;
    Context context;
    private final MainActivityInteractor mainActivityInteractor;

    public MainActivityPresenter(Context context, MainInterface mainInterface) {

this.mainInterface=mainInterface;
        mainActivityInteractor = new MainActivityInteractor(context,this);
        this.context = context;
    }


    public void callListApi() {
        mainActivityInteractor.callNetworkListApi(context,"tag");

    }


    public void getQuesList(List<Response> response) {
        mainInterface.getQuestionList(response);
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
