package com.example.admin.amazonbooks.remote;

import com.example.admin.amazonbooks.model.Book;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 11/29/2017.
 */

public class RemoteDataSource {
    public static final String BASE_URL = "http://de-coding-test.s3.amazonaws.com/";

    public static Retrofit create()
    {
         return  new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    public static io.reactivex.Observable<List<Book>> getBooks()
    {
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getBooks();
    }
}
