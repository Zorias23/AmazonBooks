package com.example.admin.amazonbooks.view.booklist;

import android.util.Log;

import com.example.admin.amazonbooks.model.Book;

import com.example.admin.amazonbooks.remote.RemoteDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 11/29/2017.
 */
//one presenter per activity, since we just have RepoList activity for now, just one presenter
public class BookListPresenter implements BookListContract.Presenter{
    BookListContract.View view;
    List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public void attachView(BookListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public List<Book> getBooks() {
        RemoteDataSource.getBooks().observeOn(AndroidSchedulers.mainThread()) //give me results on main thread
                .subscribeOn(Schedulers.io()) //this is a different thread
                .subscribe(new Observer<List<Book>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        view.showProgress("downloading repos");
                    }

                    @Override
                    public void onNext(List<Book> books) {
                       // Log.d("BookListPresenter", "onNext: " + books.size());
                        bookList.addAll(books);
                        view.setBooks(bookList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        view.showProgress("check your logs");
                       // view.setBooks(bookList);
                        view.showProgress("Downloaded all repos");
                    }
                });
        return bookList;

    }
}
