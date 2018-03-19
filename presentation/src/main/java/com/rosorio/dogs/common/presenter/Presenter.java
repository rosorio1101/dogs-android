package com.rosorio.dogs.common.presenter;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public interface Presenter<V extends Presenter.View> {

    void onStart(boolean firstInit);
    void onStop();

    void onViewAttached(V view);
    void onViewDetached();

    void onDestroy();

    interface View {

    }

    interface LoadingView extends View {
        void showLoading();
        void hideLoading();
    }

    interface ErrorView extends View {
        void showError(String error);
    }
}
