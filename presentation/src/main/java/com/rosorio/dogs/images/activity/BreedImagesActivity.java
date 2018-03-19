package com.rosorio.dogs.images.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.rosorio.dogs.R;
import com.rosorio.dogs.common.activity.BaseActivity;
import com.rosorio.dogs.common.fragment.LoadingFragment;
import com.rosorio.dogs.images.adapter.BreedImagesAdapter;
import com.rosorio.dogs.images.presenter.BreedImagesPresenter;
import com.rosorio.domain.model.BreedImageModel;

import java.util.List;

import javax.inject.Inject;

public class BreedImagesActivity extends BaseActivity<BreedImagesPresenter> implements BreedImagesPresenter.View {

    public static final String ARG_BREED_NAME = "ARG_BREED_NAME";

    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    RecyclerView rvImagesList;

    @Inject
    LoadingFragment loadingFragment;

    private String breedName;
    private BreedImagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_images);

        coordinatorLayout = findViewById(R.id.root_view);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rvImagesList = findViewById(R.id.rv_image_list);

        if (savedInstanceState == null) {
            breedName = getIntent().getStringExtra(ARG_BREED_NAME);
        } else {
            breedName = savedInstanceState.getString(ARG_BREED_NAME);
        }

        getSupportActionBar().setTitle(breedName);

        adapter = new BreedImagesAdapter();
        rvImagesList.setLayoutManager(new GridLayoutManager(this,3));
        rvImagesList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().showImages(breedName);
    }

    @Override
    public void showLoading() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.loading_root, loadingFragment)
                .commit();
    }

    @Override
    public void showBreedImages(List<BreedImageModel> list) {
        adapter.setData(list);
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
}
