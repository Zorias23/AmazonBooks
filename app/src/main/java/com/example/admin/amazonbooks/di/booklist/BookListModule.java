package com.example.admin.amazonbooks.di.booklist;

import com.example.admin.amazonbooks.view.booklist.BookListPresenter;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 11/29/2017.
 */
@Module
public class BookListModule {
    @Provides
    @Singleton
    BookListPresenter providesRepoListPresenter()
    {
        return new BookListPresenter();
    }
}
