package com.app.tickledmedia;

import android.content.Context;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.app.tickledmedia.models.QuestionList;
import com.app.tickledmedia.networking.APIRequest;
import com.app.tickledmedia.networking.VolleyUtil;


/**
 * Created by SappiKaran on 24/02/18.
 */

class MainActivityInteractor {
    private final MainActivityPresenter mainActivityPresenter;
    private final Context context;
    private String TAG="sapna";

    public MainActivityInteractor(Context context, MainActivityPresenter mainActivityPresenter) {
this.context=context;
        this.mainActivityPresenter = mainActivityPresenter;

    }

    public void callNetworkListApi(final Context con, final String answer, String tag) {

        try {

            Log.i(TAG, "callNetworkListApi: "+ "interactor");
            mainActivityPresenter.showProgressDialog(context.getResources().getString(R.string.loading), true, false);
            String BASE_URL;
            if(answer.equals("answer"))
            {
                 BASE_URL = "https://api.myjson.com/bins/19i7wt";
            }
            else
            {
                BASE_URL = "https://api.myjson.com/bins/vt8zx";
            }
           /* if (Connectivity.isConnected(context)) {*/
              final  APIRequest.Builder<QuestionList> builder = new APIRequest.Builder<>(context, Request.Method.GET,
                        QuestionList.class, BASE_URL,
                        new Response.Listener<QuestionList>() {
                            @Override
                            public void onResponse(QuestionList response) {

                                if (response != null) {
                                    if (response.status== true) {
                                        if (response.message.equals("success")) {
                                            Log.i(TAG, "callNetworkListApi: "+response.response);
                                            mainActivityPresenter.getQuesList(response.response,answer);
                                        mainActivityPresenter.hideProgressDialog();
                                        }
                                    }
                                }
                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error.networkResponse == null) {

                        }

                    }
                });
                APIRequest request = builder.build();
                request.setTag(tag);
                VolleyUtil.getInstance(context).addToRequestQueue(request);
            /*} else {
                DialogUtil.showNoNetworkAlert(context);
            }*/
        } catch (Exception e) {
            //Log.e(TAG, e.toString());
        }

    }
}
