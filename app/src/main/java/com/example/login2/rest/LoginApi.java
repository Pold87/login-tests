package com.example.login2.rest;

import com.example.login2.model.Credential;
import com.example.login2.model.CredentialWrapper;
import com.example.login2.model.PostResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by pold on 3/24/15.
 */
public interface LoginApi {

    @GET("/classes/Credential")
    CredentialWrapper getCredential();

    @POST("/classes/Credential")
    void postNewAct(@Body Credential credential, Callback<PostResponse> callback);

}
