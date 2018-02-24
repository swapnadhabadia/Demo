package com.app.tickledmedia;

import android.content.Context;
import android.provider.SyncStateContract;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;


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

    public void callNetworkListApi(final Context con, String tag) {

        try {

            Log.i(TAG, "callNetworkListApi: "+ "interactor");

           /* if (Connectivity.isConnected(context)) {*/
              final  APIRequest.Builder<QuestionList> builder = new APIRequest.Builder<>(context, Request.Method.GET,
                        QuestionList.class, URLConstants.BASE_URL,
                        new Response.Listener<QuestionList>() {
                            @Override
                            public void onResponse(QuestionList response) {

                                if (response != null) {
                                    if (response.status== true) {
                                        if (response.message=="success") {
                                            Log.i(TAG, "callNetworkListApi: "+response.response);
                                            mainActivityPresenter.getQuesList(response.response);
                                        }
                                    }
                                }
                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error.networkResponse == null) {
                           // homeFragmentPresenterInterface.showUnableToReachServerErrorLayout();
                        }
                        //Log.e(TAG, "onErrorResponse() called with: " + "error = [" + error.getMessage() + "]");
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
