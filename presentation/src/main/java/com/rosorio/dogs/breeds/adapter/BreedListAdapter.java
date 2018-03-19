package com.rosorio.dogs.breeds.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rosorio.dogs.R;
import com.rosorio.dogs.breeds.viewholder.BreedListViewHolder;
import com.rosorio.domain.model.BreedModel;

import java.util.List;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedListAdapter extends RecyclerView.Adapter<BreedListViewHolder> {

    private List<BreedModel> data;
    private OnBreedSelected onBreedSelected;

    public BreedListAdapter() {
    }

    public void setData(List<BreedModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnBreedSelected(OnBreedSelected onBreedSelected) {
        this.onBreedSelected = onBreedSelected;
    }

    @Override
    public BreedListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_breed_item, parent, false);
        return new BreedListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BreedListViewHolder holder, int position) {
        BreedModel model = data.get(position);
        holder.render(model);
        configureListeners(holder.itemView, model);

    }

    private void configureListeners(View itemView, final BreedModel model) {
       if (onBreedSelected != null) {
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   onBreedSelected.onSelected(v, model);
               }
           });
       }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public interface OnBreedSelected {
        void onSelected(View view, BreedModel model);
    }
}
