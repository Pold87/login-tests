package com.example.login2.service;

import android.app.IntentService;
import android.content.Intent;

import com.example.login2.model.Credential;
import com.example.login2.rest.LoginApi;
import com.example.login2.rest.RestProvider;
import com.example.login2.ui.activity.MainActivity;

import io.realm.Realm;
import io.realm.RealmChangeListener;

/**
 * Created by pold on 3/24/15.
 */
public class LoginService extends IntentService {

    public LoginService()
    {
        super("LoginService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        LoginApi loginApi = RestProvider.setupRestClient();
        Credential credential = loginApi.getCredential().credential;

        Realm realm = Realm.getInstance(this);

        realm.beginTransaction();
        realm.copyToRealm(credential);

        realm.commitTransaction();
        realm.close();

    }
}
