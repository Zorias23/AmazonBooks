package com.example.admin.amazonbooks.view.booklist;

import com.example.admin.amazonbooks.model.Book;

import com.example.admin.amazonbooks.utils.BasePresenter;
import com.example.admin.amazonbooks.utils.BaseView;

import java.util.List;

/**
 * Created by Admin on 11/29/2017.
 */

public interface BookListContract {
    interface View extends BaseView{
        void setBooks(List<Book> books);

        void showProgress(String s);
    }
    interface Presenter extends BasePresenter<View>
    {
        List<Book> getBooks();
    }
}
