package com.example.admin.amazonbooks.remote;

import com.example.admin.amazonbooks.model.Book;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Admin on 11/29/2017.
 */

public interface RemoteService {

    @GET("books.json")
    Observable<List<Book>> getBooks();
}
