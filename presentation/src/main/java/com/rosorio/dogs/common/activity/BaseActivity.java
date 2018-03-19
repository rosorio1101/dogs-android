package com.rosorio.dogs.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rosorio.dogs.common.presenter.Presenter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public abstract class BaseActivity<P extends Presenter>
        extends AppCompatActivity implements Presenter.View {
    private static final String ARG_FIRST_INIT = "ARG_FIRST_INIT";

    @Inject
    P presenter;

    private boolean isFirstInit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            isFirstInit = true;
        } else {
            isFirstInit = savedInstanceState.getBoolean(ARG_FIRST_INIT);
        }
        if (presenter != null) presenter.onViewAttached(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) presenter.onStart(isFirstInit);
        isFirstInit = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ARG_FIRST_INIT, isFirstInit);
    }

    protected P getPresenter() {
        return presenter;
    }
}
