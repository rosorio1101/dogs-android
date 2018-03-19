package com.rosorio.dogs.breeds.viewholder;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rosorio.dogs.R;
import com.rosorio.domain.model.BreedModel;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedListViewHolder extends RecyclerView.ViewHolder{
    private AppCompatTextView tvName;

    public BreedListViewHolder(View itemView) {
        super(itemView);
        this.tvName = itemView.findViewById(R.id.tv_breed_name);
    }

    public void render(BreedModel model) {
        tvName.setText(model.getName());
    }
}
