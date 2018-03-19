package com.rosorio.dogs.breeds.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rosorio.dogs.R;
import com.rosorio.dogs.breeds.adapter.BreedListAdapter;
import com.rosorio.dogs.breeds.presenter.BreedListPresenter;
import com.rosorio.dogs.common.activity.BaseActivity;
import com.rosorio.dogs.common.fragment.LoadingFragment;
import com.rosorio.dogs.images.activity.BreedImagesActivity;
import com.rosorio.domain.model.BreedModel;

import java.util.List;

import javax.inject.Inject;

public class BreedListActivity extends BaseActivity<BreedListPresenter> implements
        BreedListPresenter.View, BreedListAdapter.OnBreedSelected {


    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    RecyclerView rvBreedList;

    BreedListAdapter adapter;

    @Inject
    LoadingFragment loadingFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_list);

        coordinatorLayout = findViewById(R.id.root_view);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Dogs");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Dogs");

        rvBreedList = findViewById(R.id.rv_breed_list);

        adapter = new BreedListAdapter();
        adapter.setOnBreedSelected(this);

        rvBreedList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvBreedList.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.loading_root, loadingFragment)
                .commit();
    }

    @Override
    public void hideLoading() {
        getSupportFragmentManager()
                .beginTransaction()
                .remove(loadingFragment)
                .commit();
    }

    @Override
    public void showError(String error) {
        Snackbar.make(coordinatorLayout, error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showBreeds(List<BreedModel> breedModels) {
        adapter.setData(breedModels);
    }

    @Override
    public void onSelected(View view, BreedModel model) {
        Intent intent = new Intent(this, BreedImagesActivity.class);
        intent.putExtra(BreedImagesActivity.ARG_BREED_NAME, model.getName());
        startActivity(intent);
    }
}
