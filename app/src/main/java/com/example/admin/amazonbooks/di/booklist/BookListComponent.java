package com.example.admin.amazonbooks.di.booklist;

import com.example.admin.amazonbooks.view.booklist.BookList;


import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Admin on 11/29/2017.
 */

@Component(modules = BookListModule.class)
@Singleton
public interface BookListComponent {

    void inject(BookList repoList);



}
