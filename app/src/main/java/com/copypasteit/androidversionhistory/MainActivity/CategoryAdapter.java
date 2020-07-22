package com.copypasteit.androidversionhistory.MainActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.copypasteit.androidversionhistory.R;
import com.copypasteit.androidversionhistory.ReadActivity.ReadActivity;
import com.copypasteit.androidversionhistory.main.model.Post;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<ViewHolder> {

    MainActivity mainActivity;
    public List<Post> posts;

    public CategoryAdapter(MainActivity mainActivity, List<Post> posts) {
        this.mainActivity = mainActivity;
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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        //post_title, post_author, post_details, post_image, post_category;
        String url = post.getPostImageUrl();
        String post_category = post.getCategoryName();
        String reliase_date = post.getPostAuthor();

        holder.reliase_date.setText(reliase_date);
        holder.post_category.setText(post_category);
        Glide
                .with(mainActivity)
                .load(url)
                .override(80, 80)
                .centerCrop()
                .placeholder(R.drawable.loading_spinner)
                .into(holder.post_image);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
