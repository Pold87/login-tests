package com.example.login2.rest;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.RealmObject;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by pold on 3/24/15.
 */
public class RestProvider {

    public static LoginApi setupRestClient(){

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("X-Parse-Application-Id", "DwFeCKUMcBfM7GnF61Llv9dkE8WEgZbTpDwfBlMm");
                request.addHeader("X-Parse-REST-API-Key", "gnxIUgk1HXLjN7gR7twBFNSUVZSyIqdOw5lzWTUE");
            }
        };

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss.SSS'Z'")
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        String root = "https://api.parse.com/1";
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setRequestInterceptor(requestInterceptor)
                .setConverter(new GsonConverter(gson))
                .setEndpoint(root)
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        return restAdapter.create(LoginApi.class);
    };


}
