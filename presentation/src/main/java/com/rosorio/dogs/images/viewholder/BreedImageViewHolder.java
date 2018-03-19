package com.rosorio.dogs.images.viewholder;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rosorio.dogs.R;
import com.rosorio.domain.model.BreedImageModel;
import com.squareup.picasso.Picasso;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedImageViewHolder extends RecyclerView.ViewHolder {

    AppCompatImageView ivBreedImage;

    public BreedImageViewHolder(View itemView) {
        super(itemView);
        this.ivBreedImage = itemView.findViewById(R.id.iv_breed_image);
    }

    public void render(BreedImageModel model) {
        Picasso.get().load(model.getUrl()).into(ivBreedImage);
    }
}
