package com.example.rajithaperera.mercari;

/**
 * Created by rajithaperera on 12/12/17.
 */

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Item> mDataset;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_second;
        public ImageView img_first;
        public TextView price;
        public TextView like_count;
        public TextView comment_count;
        public TextView name;

        public MyViewHolder(View v) {
            super(v);

            img_first = (ImageView) v.findViewById(R.id.img_first);
            img_second = (ImageView) v.findViewById(R.id.img_second);
            price = (TextView) v.findViewById(R.id.price);
            like_count = (TextView) v.findViewById(R.id.likes_count);
            comment_count = (TextView) v.findViewById(R.id.comments_count);
            name = (TextView) v.findViewById(R.id.name);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Item> myDataset, Context context) {
        this.mDataset = myDataset;
        this.context=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.price.setText(String.valueOf(mDataset.get(position).getPrice()));
        holder.like_count.setText(String.valueOf(mDataset.get(position).getNum_likes()));
        holder.comment_count.setText(String.valueOf(mDataset.get(position).getNum_comments()));
        holder.name.setText(mDataset.get(position).getName());

        if(mDataset.get(position).getStatus().equals("on_sale"))
        {
            holder.img_second.setVisibility(View.GONE);
        }
        else
        {
            holder.img_second.setVisibility(View.VISIBLE);
        }

Log.e("image",mDataset.get(position).getPhoto());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
               Log.e("exception",exception.getMessage());
            }
        });
        builder.downloader(new OkHttpDownloader(context));
        builder.build().load(mDataset.get(position).getPhoto()).into(holder.img_first);
     //   Glide.with(context).load("http://dummyimage.com/400x400/000/fff?text=men11").into(holder.img_first);
       // Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").resize(218, 192).centerCrop().into(holder.img_first);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
