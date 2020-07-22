package com.copypasteit.androidversionhistory.MainActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.copypasteit.androidversionhistory.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView post_category, reliase_date;
    ImageView post_image;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        post_image = itemView.findViewById(R.id.imageid);
        post_category = itemView.findViewById(R.id.categoryid);
        reliase_date = itemView.findViewById(R.id.reliase_date);

    }

}
