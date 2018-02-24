package com.app.tickledmedia.apicalls;

import com.app.tickledmedia.models.Response;

import java.util.List;


public interface MainInterface {


    void getQuestionList(List<Response> response, String type);

    void showProgressDialog(String message, boolean indeterminate, boolean isCancelable);

    void hideProgressDialog();
}
