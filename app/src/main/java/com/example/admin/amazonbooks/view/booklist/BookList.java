package com.example.admin.amazonbooks.view.booklist;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.amazonbooks.R;
import com.example.admin.amazonbooks.model.BooksRecyclerAdapter;
import com.example.admin.amazonbooks.remote.RemoteDataSource;

//import com.example.admin.amazonbooks.di.booklist.DaggerRepoListComponent;
import com.example.admin.amazonbooks.model.Book;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BookList extends AppCompatActivity implements BookListContract.View{

    private static final String TAG = "MainActivityTag";
    private RecyclerView recyclerView;
    @Inject
    BookListPresenter presenter;
    List<Book> booksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DaggerRepoListComponent
        //DaggerBookListComponent.create().inject(this);

        presenter = new BookListPresenter();
        presenter.attachView(this);

         presenter.getBooks();
        Log.d(TAG, "onCreate: our books list is size: " + booksList.size());
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.rvMain);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setLayoutManager(layoutManager); //need layoutManager
        recyclerView.setItemAnimator(itemAnimator); //don't need this but it allows animation for each item


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: our books list is size: " + booksList.size());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: our books list is size: " + booksList.size());
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void setBooks(List<Book> books) {
        Log.d(TAG, "setBooks: books size is " + books.size() );
        booksList = books;
        Log.d(TAG, "setBooks: booksList now is size " + books.size() );
        BooksRecyclerAdapter ra = new BooksRecyclerAdapter(booksList);
        recyclerView.setAdapter(ra); //need adapter

    }

    @Override
    public void showProgress(String progress) {

        Toast.makeText(this, progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
