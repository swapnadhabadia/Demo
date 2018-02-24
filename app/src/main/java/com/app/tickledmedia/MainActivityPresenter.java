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
}
