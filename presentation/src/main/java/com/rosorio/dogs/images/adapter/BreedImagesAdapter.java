package com.rosorio.dogs.images.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rosorio.dogs.R;
import com.rosorio.dogs.images.viewholder.BreedImageViewHolder;
import com.rosorio.domain.model.BreedImageModel;

import java.util.List;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedImagesAdapter extends RecyclerView.Adapter<BreedImageViewHolder> {

    private List<BreedImageModel> data;

    public BreedImagesAdapter() {
    }

    public void setData(List<BreedImageModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public BreedImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_breed_image_item, parent, false);
        return new BreedImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BreedImageViewHolder holder, int position) {
        BreedImageModel model = data.get(position);
        holder.render(model);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}
