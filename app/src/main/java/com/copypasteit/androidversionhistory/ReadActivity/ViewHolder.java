package com.copypasteit.androidversionhistory.ReadActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.copypasteit.androidversionhistory.R;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class ViewHolder extends RecyclerView.ViewHolder  {
    TextView post_title, post_author, post_category, post_date;
    HtmlTextView post_details;
    Context context;
    View mView;
    ImageView post_image;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        post_title = itemView.findViewById(R.id.post_title);
        post_author = itemView.findViewById(R.id.post_author);
        post_image = itemView.findViewById(R.id.post_image);
        post_category = itemView.findViewById(R.id.post_category);
        post_date = itemView.findViewById(R.id.post_date);
        post_details = (HtmlTextView) itemView.findViewById(R.id.html_text);





    }


}
