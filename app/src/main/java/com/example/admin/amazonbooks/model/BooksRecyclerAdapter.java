package com.example.admin.amazonbooks.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.amazonbooks.R;
import com.example.admin.amazonbooks.view.booklist.BookList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/14/2017.
 */

public class BooksRecyclerAdapter extends RecyclerView.Adapter<BooksRecyclerAdapter.ViewHolder>{

    public static List<Book> bookList = new ArrayList<>();
    Context context;


    public List<Book> getbookList() {
        return bookList;
    }



    public static final String TAG = "booksRecycler";

    @Override
    public BooksRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_recycler_item, null);
        context = parent.getContext();
        return new ViewHolder(view);
    }
    public BooksRecyclerAdapter(List<Book> bookList) {
        this.bookList = bookList;
}

    public BooksRecyclerAdapter()
    {

    }

    @Override
    public void onBindViewHolder(BooksRecyclerAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Book c  = bookList.get(position);
        if (c != null)
        {
            holder.tvTitle.setText(c.getTitle());
            Glide.with(context).load(c.getImageURL()).into(holder.image);

        }

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final ImageView image;




        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            image = itemView.findViewById(R.id.ivImage);
            //itemView.setOnClickListener(this);

        }


    }
}
