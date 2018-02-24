package com.app.tickledmedia;

import com.app.tickledmedia.models.Response;

import java.util.List;

/**
 * Created by SappiKaran on 24/02/18.
 */

public interface MainInterface {


    void getQuestionList(List<Response> response, String type);

    void showProgressDialog(String message, boolean indeterminate, boolean isCancelable);

    void hideProgressDialog();
}
