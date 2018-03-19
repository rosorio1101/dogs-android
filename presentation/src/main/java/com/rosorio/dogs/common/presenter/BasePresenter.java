package com.rosorio.dogs.common.presenter;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public abstract class BasePresenter<V extends Presenter.View> implements Presenter<V> {

    protected V view;

    @Override
    public void onViewAttached(V view) {
        this.view = view;
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }
}
