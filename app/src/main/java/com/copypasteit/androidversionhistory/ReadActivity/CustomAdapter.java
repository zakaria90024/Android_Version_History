package com.copypasteit.androidversionhistory.ReadActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.copypasteit.androidversionhistory.MainActivity.MainActivity;
import com.copypasteit.androidversionhistory.R;
import com.copypasteit.androidversionhistory.main.model.Post;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    ReadActivity readActivity;
    public List<Post> posts;
    Context context;


    public CustomAdapter(ReadActivity readActivity, List<Post> posts) {
        this.readActivity = readActivity;
        this.posts = posts;
    }

    public void setData(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //for passing/inflate layoute
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        //post_title, post_author, post_details, post_image, post_category;
        String post_title = post.getPostTitle();
        String post_author = post.getPostAuthor();
        String post_details = post.getPostDetails();
        String url = post.getPostImageUrl();
        String post_category = post.getCategoryName();
        String post_date = post.getCreatedAt();


//        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", Context.MODE_PRIVATE);
//
//        //Creating editor to store values to shared preferences
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        //Adding values to editor
//        editor.putString("post_title", post_title);
//        editor.putString("post_author", post_author);
//        editor.putString("post_details", post_details);
//        editor.putString("post_category", post_category);
//        editor.putString("post_date", post_date);
//        editor.commit();


        holder.post_title.setText(post_title);
        holder.post_author.setText(post_author);
        holder.post_details.setText(post_details);
        //holder.post_image.setText("TAKA: "+post_image);
        holder.post_category.setText(post_category);
        holder.post_details.setHtml(""+post_details);
        holder.post_date.setText(post_date);




//        htmlTextView.setHtml("<h2>Hello wold</h2><ul><li>cats</li><li>dogs</li></ul><img src=\"cat_pic\"/>",
//                new HtmlResImageGetter(htmlTextView));

        //String gd = holder.groupname.getText().toString();

//        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
//        holder.post_title.setText(sharedPreferences.getString("post_title","Not Available"));
//        holder.post_author.setText(sharedPreferences.getString("post_author","Not Available"));





        Glide
                .with(readActivity)
                .load(url)
                .override(320, 480)
                .centerCrop()
                .placeholder(R.drawable.loading_spinner)
                .into(holder.post_image);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
